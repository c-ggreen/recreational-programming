from pathlib import Path
from utils import load_historical_stock_data, csv_to_list, get_todays_date, FILE_SUFFIX

PERIOD = "10y"
TICKER = "NFLX"

def main():
    today = get_todays_date()
    file_path = Path(f"{TICKER}_{today}_{FILE_SUFFIX}")

    # Checking if there is already a file generated today for the stock, 
    # If not create one, else convert the existing CSV to a list of dicts
    if not file_path.is_file():
        load_historical_stock_data(TICKER, PERIOD, today)
        
    csv_to_list(TICKER, today)


if __name__ == "__main__":
    main()
