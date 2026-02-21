from mock_data import mock_data

def fetch_user_data_by_id(parameters: dict) -> dict:
    for user in mock_data:
        if str(user.get("id")) in list(parameters.values()):
            return user
