from utils import get_historical_stock_data, csv_to_list

PERIOD = "10y"


def main():
    get_historical_stock_data("TSLA", PERIOD)
    print(csv_to_list())


if __name__ == "__main__":
    main()
