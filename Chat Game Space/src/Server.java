import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class to listen for new clients and create a new thread for client.
 */
public class Server {

	private ServerSocket serverSocket;

	public Server(ServerSocket socket) {
		this.serverSocket = socket;
	}

	/**
	 * Method to start the server
	 */
	public void startServer() {
		try {
			while (!serverSocket.isClosed()) {
				Socket socket = serverSocket.accept();
				System.out.println("New Client has connected!");
				ClientHandler clientHandler = new ClientHandler(socket);

				Thread thread = new Thread(clientHandler);
				thread.start();
			}
		} catch (IOException e) {

		}
	}

	/**
	 * Method to close the server
	 */
	public void closeServer() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(1234);
		Server server = new Server(serverSocket);
		server.startServer();
	}
}