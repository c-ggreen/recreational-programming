from pathlib import Path
from utils import load_historical_stock_data, csv_to_list, get_todays_date, FILE_SUFFIX, calculate_daily_returns, daily_returns_to_string, calculate_cumulative_return

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

    daily_returns: list[list] = calculate_daily_returns(history)
    daily_returns_to_string(daily_returns)

    cumulative_return = calculate_cumulative_return(daily_returns)
    print(cumulative_return)


if __name__ == "__main__":
    main()
