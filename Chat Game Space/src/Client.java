import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class to create new clint and join client to Server
 */
public class Client {

	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String username;

	public Client(Socket socket, String username) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.username = username;
		} catch (Exception e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}

	/**
	 * Method to send message to server
	 */
	public void sendMessage() {
		try {
			bufferedWriter.write(username);
			bufferedWriter.newLine();
			bufferedWriter.flush();

			Scanner scanner = new Scanner(System.in);
			while (socket.isConnected()) {
				String messageToSend = scanner.nextLine();
				bufferedWriter.write(username + ": " + messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		} catch (Exception e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}

	/**
	 * Method to create message listener thread
	 */
	public void listenForMessage() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String msgFromGroupChat;

				while (socket.isConnected()) {
					try {
						msgFromGroupChat = bufferedReader.readLine();
						System.out.println(msgFromGroupChat);
					} catch (IOException e) {
						closeEverything(socket, bufferedReader, bufferedWriter);
					}
				}
			}
		}).start();
	}

	/**
	 * Method to close client socket with it's writer and reader.
	 * @param socket
	 * @param reader
	 * @param writer
	 */
	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		try {
			if (bufferedReader != null){
				bufferedReader.close();
			}
			if (bufferedWriter != null){
				bufferedWriter.close();
			}
			if (socket != null){
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}