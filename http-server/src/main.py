import socket
import json

HOST = '127.0.0.1'
PORT = 8080

GET = "GET"
POST = "POST"
PUT = "PUT"
DELETE = "DELETE"


def start():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.bind((HOST, PORT))
        server.listen()
        print(f"Server running on http://{HOST}:{PORT}")
        print("Press Ctrl+C to stop the server")

        try:
            while True:
                conn, addr = server.accept()
                with conn:
                    request = conn.recv(1024).decode()
                    print(f"Received request from {addr}: {request}")
                    if not request:
                        continue

                    method, path = parse_request(request)
                    response = handle_request(method, path)
                    
                    conn.sendall(response)
        except KeyboardInterrupt:
                print("\nShutting down server gracefully...")


# Parse Request
def parse_request(request_text):
    lines = request_text.split("\r\n")
    request_line = lines[0]
    method, path, version = request_line.split()
    print(method, path, version)
    return method, path

# Handle Request
def handle_request(method, path):
    if path == "/":
        return build_response(200, json.dumps({"message": "Success!"}))
    elif path == "/hello":
        return build_response(200, json.dumps({"message": "Hello World!"}))
    elif path == "/goodbye":
        return build_response(200, json.dumps({"message": "Goodbye World!"}))
    else:
        return build_response(404, json.dumps({"message": "Not Found!"}))
    

# Build Response
def build_response(status_code, body, content_type="application/json"):
    reason = {
        200: "OK",
        404: "Not Found"
    }[status_code]

    body_bytes = body.encode()
    
    response = (
        f"HTTP/1.1 {status_code} {reason}\r\n"
        f"Content-Type: {content_type}\r\n"
        f"Content-Length: {len(body_bytes)}\r\n"
        f"\r\n"
    ).encode() + body_bytes

    return response


if __name__ == "__main__":
    start()