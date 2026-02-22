import csv
from datetime import datetime as dt
from zoneinfo import ZoneInfo
from decimal import Decimal, ROUND_HALF_UP

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


# TODO: Funcs to calculate: Daily Returns, Cumulative Return, Volatility, Sharpe Ratio


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

        # Calculating the percentage return
        percentage_return = ((current / prev) - 1) * 100
        #Rounding percentage
        decimal_value = Decimal(str(percentage_return)) 
        rounded_decimal = decimal_value.quantize(Decimal('0.01'), rounding=ROUND_HALF_UP)

        # Adding the date and return to the output array
        output.append([date, rounded_decimal])

        # Setting the previous days Close to the current in preparation of the next iteration
        prev = current

    return output


def daily_returns_to_string(data: list[list]) -> None:
    print("Date\t\tPercentage")
    for element in data:
        print(f"{element[0]}\t{element[1]}\r\n")
