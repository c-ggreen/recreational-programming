import json

from utils.data_utils import fetch_user_data_by_id

def parse_request(request_text: str):
    # HTTP requests are lines of text separated by \r\n, so we split the request as such
    lines: list[str] = request_text.split("\r\n")
    # First line containes the Method, Path, and Version. We only need the Method and Path for simple requests
    request_line: str = lines[0]
    print(f"Request Line: {request_line}\n-----")
    method, path, version = request_line.split()
    return method, path

def parse_qeury_parameters(path: str):
    parameters: dict = {}
    if "?" in path:
        endpoint, query_string = path.split("?")
        query_parameters: list[str] = query_string.split("&")
        for item in query_parameters:
            key, value = item.split("=")
            parameters[key] = value
    return parameters


def handle_request(method: str, path: str):
    if path == "/":
        return build_response(200, json.dumps({"message": "Success!"}))
    elif path.startswith("/users"):
        parameters: dict = parse_qeury_parameters(path=path)
        if method == "GET" and parameters:
            return build_response(200, json.dumps(fetch_user_data_by_id(parameters=parameters)))
    else:
        return build_response(404, json.dumps({"message": "Not Found!"}))
    

def build_response(status_code: int, body: str, content_type="application/json"):
    reason = {
        200: "OK",
        404: "Not Found"
    }[status_code]

    body_bytes = body.encode()
    
    # Format of an HTTP response.
    response = (
        f"HTTP/1.1 {status_code} {reason}\r\n"
        f"Content-Type: {content_type}\r\n"
        f"Content-Length: {len(body_bytes)}\r\n"
        f"\r\n"
    ).encode() + body_bytes

    return response