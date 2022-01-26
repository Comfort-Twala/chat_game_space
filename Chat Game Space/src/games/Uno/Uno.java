package games.Uno;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import sockets.*;

/**
 * Main game class with game logic and mechanics which joins server as a Client
 */
public class Uno extends Client {

	private HashMap<String, ArrayList<Card>> players;
	// private Stack<Card> playedDeck;
	private Stack<Card> deck;
	private Setup game;
	private boolean gameStarted;

	/**
	 * Constructor to Set up game and connect Uno class to server with socket
	 * @param socket
	 * @throws IOException
	 */
	public Uno(Socket socket) throws IOException {
		super(socket, "UNO");
		this.players = new HashMap<String, ArrayList<Card>>();
		// this.playedDeck = new Stack<Card>(); 
		this.game = new Setup();
		this.deck = game.newDeck();
		this.gameStarted = false;
		TimeUnit time = TimeUnit.MILLISECONDS;
		try {
			time.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.welcomeMessage();
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
		if (command.equals("!join")){
			if (this.gameStarted == true){
				bufferedWriter.write("UNO: Game Already started... Wait for next game to join.");
				bufferedWriter.newLine();
				bufferedWriter.flush();
			} else {
				boolean new_player = true;
				for (String p : players.keySet()) {
					if (p.equals(player)){
						bufferedWriter.write("UNO: " + player + " already in game");	
						bufferedWriter.newLine();
						bufferedWriter.flush();
						new_player = false;					
						break;
					}
				}
				if (new_player == true){
					bufferedWriter.write("UNO: " + player + " has joined the game!");
					bufferedWriter.newLine();
					bufferedWriter.flush();
					players.put(player, game.dealCards());
					System.out.println("Players in game: ");
					players.forEach((k,v) -> {System.out.println("\t" + k);});
					updatePlayer(player);
				}
			}	
		} else if (command.equals("!start")){
			if (this.gameStarted == true){
				bufferedWriter.write("UNO: Game Already started...");
				bufferedWriter.newLine();
				bufferedWriter.flush();
			} else {
				if (players.size() > 1){
					this.gameStarted = true;
					bufferedWriter.write("UNO: Starting Game...\n" + players.size() + " players in game.");
					bufferedWriter.newLine();
					bufferedWriter.flush();
				} else {
					bufferedWriter.write("UNO: Need 2 or more players to start game.");
					bufferedWriter.newLine();
					bufferedWriter.flush();
				}
			}
		} else {
			if (this.gameStarted == false){
				bufferedWriter.write("UNO: Game not started... Enter \"!start\" to start game.");
				bufferedWriter.newLine();
				bufferedWriter.flush();
			} else {			
				switch (command) {
					case "!draw":
						bufferedWriter.write("UNO: " + player + " drew a card.");
						bufferedWriter.newLine();
						bufferedWriter.flush();
						if (players.containsKey(player)){
							players.get(player).add(deck.pop());
							updatePlayer(player);
						}
						break;
					case "!view":
						updatePlayer(player);
						break;
					default:
						if (command.startsWith("!play")){
							System.out.println(Arrays.asList(command.split(" ")));
							Card card = players.get(player).get(Integer.valueOf(command.split("-")[1])-1);
							bufferedWriter.write("UNO: " + player + " played card - " + card.toString());
							bufferedWriter.newLine();
							bufferedWriter.flush();
							players.get(player).remove(card);
							updatePlayer(player);
						}
						break;
				}
			}
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
	
	/**
	 * Joining instruction after UNO client joins server.
	 * @throws IOException
	 */
	private void welcomeMessage() throws IOException {
		bufferedWriter.write("UNO: Enter \"!join\" to join in UNO game then \"!start\" to start it.");
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
