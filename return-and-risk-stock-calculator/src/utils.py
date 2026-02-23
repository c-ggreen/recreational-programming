import csv
import math
import statistics

from datetime import datetime as dt
from zoneinfo import ZoneInfo

import yfinance as yf

FILE_SUFFIX = "historical_data.csv"
tz = ZoneInfo("America/New_York")


def load_historical_stock_data(ticker: str, period: str, date: str) -> None:
    print("Getting historical data...")
    # Get historical data for the stock
    history = yf.Ticker(ticker).history(period=period)
    history.to_csv(f"{ticker}_{date}_{FILE_SUFFIX}")
    print("Data retrieved successfully!")


def csv_to_list(ticker: str, date: str) -> list[dict[str, str]]:
    print("Converting CSV to a list of dictionaries...")
    with open(
        f"{ticker}_{date}_{FILE_SUFFIX}", mode="r", newline="", encoding="utf-8"
    ) as f:
        return list(csv.DictReader(f))


def get_todays_date() -> str:
    return str(dt.date(dt.now(tz)))


def calculate_daily_returns(data: list[dict[str, str]]) -> list[list]:
    output: list[list] = []
    prev = 0
    current = 0
    for index, element in enumerate(data):
        # Skip the first Day but save the Close for the next iteration
        if index == 0:
            prev = float(element.get("Close"))
            continue
        # Getting the date and it's Closing value
        date: str = element.get("Date").split()[0]
        current = float(element.get("Close"))
        # Calculating the daily return
        daily_return = (current / prev) - 1
        # Daily return in percentage form
        daily_return_percentage = daily_return * 100
        # Adding the date, return, and percentage to the output array
        output.append([date, daily_return, daily_return_percentage])
        # Setting the previous days Close to the current in preparation of the next iteration
        prev = current
    return output


def daily_returns_to_string(data: list[list]) -> None:
    print("Date\t\tDecimal\tPercentage\t\t")
    for element in data:
        print(f"{element[0]}\t{element[1]:.2f}\t{element[2]:.2f}%\r\n")


def calculate_cumulative_return(daily_return_list: list[list]) -> float:
    gross_return = 0
    for index, element in enumerate(daily_return_list):
        if index == 0:
            gross_return = element[1] + 1.0
            continue
        gross_return = (element[1] + 1.0) * gross_return
    return (gross_return - 1.0) * 100


def calculate_volatility(data: list[dict[str, str]]):
    logs: list = []
    prev = 0
    current = 0
    for index, element in enumerate(data):
        # Skip the first Day but save the Close for the next iteration
        if index == 0:
            prev = float(element.get("Close"))
            continue
        current = float(element.get("Close"))
        # Calculating the logarithms
        logs.append(math.log(current / prev))
        # Setting the previous days Close to the current in preparation of the next iteration
        prev = current
    # Return the product of the standard deviation of all the logs and the square root of all the data points in percent form
    return (math.sqrt(len(data)) * statistics.stdev(logs)) * 100


def calculate_sharpe_ratio(
    daily_return_list: list[list], history: list[dict], risk_free_rate: int = 0.04
):
    daily_risk_free_rate = risk_free_rate / len(history)
    daily_returns: list[float] = []
    for element in daily_return_list:
        # Extracting decimal value from daily returns list
        daily_returns.append(element[1])
    daily_mean = statistics.mean(daily_returns)
    daily_stdev = statistics.stdev(daily_returns)
    daily_sharpe = (daily_mean - daily_risk_free_rate) / daily_stdev
    annualized_sharpe = daily_sharpe * math.sqrt(len(history))
    return daily_sharpe, annualized_sharpe
