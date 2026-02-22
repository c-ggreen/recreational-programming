import yfinance as yf


def get_historical_stock_data(ticker: str, period: str) -> None:
    print("Getting historical data...")
    # Get historical data for the stock
    history = yf.Ticker(ticker).history(period=period)
    history.to_csv("historical_data.csv")
    print("Data retrieved successfully!")

# TODO: Funcs to calculate: Daily Returns, Cumulative Return, Volatility, Sharpe Ratio
