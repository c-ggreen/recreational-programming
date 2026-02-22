from utils import get_historical_stock_data

PERIOD = "10y"


def main():
    get_historical_stock_data("TSLA", PERIOD)


if __name__ == "__main__":
    main()
