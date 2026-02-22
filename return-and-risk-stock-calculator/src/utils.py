import csv
from datetime import datetime as dt
from zoneinfo import ZoneInfo

import yfinance as yf

FILE_SUFFIX = "historical_data.csv"
tz = ZoneInfo('America/New_York')


def load_historical_stock_data(ticker: str, period: str, date: str) -> None:
    print("Getting historical data...")
    # Get historical data for the stock
    history = yf.Ticker(ticker).history(period=period)
    history.to_csv(f"{ticker}_{date}_{FILE_SUFFIX}")
    print("Data retrieved successfully!")


def csv_to_list(ticker: str, date: str) -> list[dict[str, str]]:
    print("Converting CSV to a list of dictionaries...")
    with open(f"{ticker}_{date}_{FILE_SUFFIX}", mode="r", newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))


def get_todays_date() -> str:
    return str(dt.date(dt.now(tz)))

# TODO: Funcs to calculate: Daily Returns, Cumulative Return, Volatility, Sharpe Ratio
