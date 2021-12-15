import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * ClientHandler class to handle clients on the server.
 */
public class ClientHandler implements Runnable {

	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String clientUsername;

	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.clientUsername = bufferedReader.readLine();
			clientHandlers.add(this);
			broadcastMessage("SERVER: " + this.clientUsername + " has entered the chat!");
		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}

	
	/**
	 * Runnable overriden method to start a listener thread for client
	 */
	@Override
	public void run() {
		String messageFromClient;
		
		while (socket.isConnected()){
			try {
				messageFromClient = bufferedReader.readLine();
				broadcastMessage(messageFromClient);
			} catch (IOException e){
				closeEverything(socket, bufferedReader, bufferedWriter);
				break;
			}
		}
	}
	
	/**
	 * Method to send message to server
	 * @param messageToSend
	 */
	private void broadcastMessage(String messageToSend) {
		for (ClientHandler clientHandler : clientHandlers) {
			try {
				if (!clientHandler.clientUsername.equals(clientUsername)){
					clientHandler.bufferedWriter.write(messageToSend);
					clientHandler.bufferedWriter.newLine();
					clientHandler.bufferedWriter.flush();
				}
			} catch (Exception e) {
				closeEverything(socket, bufferedReader, bufferedWriter);
			}
		}		
	}

	/**
	 * Method to remove current clientHandler from arrayList
	 */
	public void removeClientHandler() {
		clientHandlers.remove(this);
		broadcastMessage("SERVER: " + clientUsername + " has left the chat!");
		broadcastMessage("SERVER: " + clientHandlers.size() + " people left in the chat.");
	}
	
	/**
	 * Method to close client socket with it's writer and reader.
	 * @param socket
	 * @param reader
	 * @param writer
	 */
	private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		removeClientHandler();
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