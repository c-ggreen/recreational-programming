import socket
from utils.http_utils import parse_request, handle_request

HOST = '127.0.0.1'
PORT = 8080


def start():
    # Creates a server by creating a socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        # Sets the host and port of the server
        server.bind((HOST, PORT))
        # Starts the server
        server.listen()
        print(f"Server running on http://{HOST}:{PORT} \r\nPress Ctrl+C to stop the server.")

        try:
            while True:
                # When a request is sent to the server (host and port) the server accepts the request and returns a connection and the address of the client
                conn, addr = server.accept()
                with conn:
                    # 1024 is the buffer size, i.e. the maximum amount of data that can be received at once in bytes. If I want to receive more data than 1024 bytes, I need to increase the buffer size or create a loop to receive the data in chunks
                    request = conn.recv(1024).decode() 
                    # print(f"Received request from {addr}: {request}")
                    if not request:
                        continue

                    method, path = parse_request(request)
                    response = handle_request(method, path)
                    
                    conn.sendall(response)
        except KeyboardInterrupt:
                print("\nShutting down server gracefully...")


if __name__ == "__main__":
    start()