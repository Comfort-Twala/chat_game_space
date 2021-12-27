package games.Uno;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import sockets.*;

/**
 * Main game class with game logic and mechanics which joins server as a Client
 */
public class Uno extends Client {

	private HashMap<String, ArrayList<Card>> players;
	// private Stack<Card> playedDeck;
	private Stack<Card> deck;
	private Setup game;

	/**
	 * Constructor to Set up game and connect Uno class to server with socket
	 * @param socket
	 */
	public Uno(Socket socket) {
		super(socket, "UNO");
		this.players = new HashMap<String, ArrayList<Card>>();
		// this.playedDeck = new Stack<Card>(); 
		this.game = new Setup();
		this.deck = game.newDeck();
	}

	/**
	 * Overriden method to listen for messages from server and execute commands accordingly
	 */
	@Override
	public void listenForMessage() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				String[] msgFromGroupChat;
				String player;
				String command;

				while (socket.isConnected()) {
					try {
						msgFromGroupChat = bufferedReader.readLine().split(" ");
						player = msgFromGroupChat[0].substring(0, msgFromGroupChat[0].length() - 1);						
						command = msgFromGroupChat[1];
						if (!command.startsWith("!"))
							continue;		
						executeCommand(player, command);
					} catch (IOException e) {
						closeEverything(socket, bufferedReader, bufferedWriter);
					}
				}
			}

		}).start();
	}

	/**
	 * Method to execute player command and play the game
	 * @param player
	 * @param command
	 * @throws IOException
	 */
	private void executeCommand(String player, String command) throws IOException {
		switch (command) {
			case "!join":
				boolean new_player = true;
				for (String p : players.keySet()) {
					if (p.equals(player)){
						bufferedWriter.write(player + " already in game");	
						bufferedWriter.newLine();
						bufferedWriter.flush();
						new_player = false;					
						break;
					}
				}
				if (new_player == true){
					players.put(player, game.dealCards());
					System.out.println("Players in game: ");
					players.forEach((k,v) -> {System.out.println("\t" + k);});
					updatePlayer(player);
				}
				break;
			case "!draw":
				if (players.containsKey(player)){
					players.get(player).add(deck.pop());
					updatePlayer(player);
				}
				break;
			default:
				// Card card = players.get(player).get(Integer.valueOf(command.substring(1)));
				break;
		}
	}

	/**
	 * Method to update player on cards status and player specific updates
	 * @param player
	 * @throws IOException
	 */
	private void updatePlayer(String player) throws IOException{
		bufferedWriter.write("UNO: " + player + ": ");
		for (int card = 0; card < players.get(player).size(); card++){
			bufferedWriter.write(players.get(player).get(card).toString());
		}
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 1234);
		Uno game = new Uno(socket);
		game.listenForMessage();
		game.sendMessage();
	}
}
