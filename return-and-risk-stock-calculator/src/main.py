from pathlib import Path
from utils import load_historical_stock_data, csv_to_list, get_todays_date, FILE_SUFFIX, calculate_daily_returns, daily_returns_to_string

PERIOD = "1y" # y, mo, d, ytd, or max
TICKER = "NFLX"

def main():
    today = get_todays_date()
    file_path = Path(f"{TICKER}_{today}_{FILE_SUFFIX}")

    # Checking if there is already a file generated today for the stock, 
    # If not create one, else convert the existing CSV to a list of dicts
    if not file_path.is_file():
        load_historical_stock_data(TICKER, PERIOD, today)

    history: list[dict[str, str]] = csv_to_list(TICKER, today)

    daily_returns_to_string(calculate_daily_returns(history))


if __name__ == "__main__":
    main()
