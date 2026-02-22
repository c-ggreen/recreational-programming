import csv
import yfinance as yf

FILENAME = "historical_data.csv"


def get_historical_stock_data(ticker: str, period: str) -> None:
    print("Getting historical data...")
    # Get historical data for the stock
    history = yf.Ticker(ticker).history(period=period)
    history.to_csv(FILENAME)
    print("Data retrieved successfully!")


def csv_to_list() -> list[dict[str, str]]:
    with open(FILENAME, mode="r", newline="", encoding="utf-8") as f:
        return list(csv.DictReader(f))


# TODO: Funcs to calculate: Daily Returns, Cumulative Return, Volatility, Sharpe Ratio
