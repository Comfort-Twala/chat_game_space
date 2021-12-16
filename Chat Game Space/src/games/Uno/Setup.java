package games.Uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import games.Uno.Card.Colour;
import games.Uno.Card.Type;

public class Setup {
	
	private ArrayList<Card> cards;
	private Stack<Card> deck;

	public Setup() {
		this.deck = new Stack<Card>();
		this.cards = new ArrayList<Card>();
		cards.add(new Card(0, Colour.RED, Type.NONE));
		cards.add(new Card(1, Colour.RED, Type.NONE));
		cards.add(new Card(2, Colour.RED, Type.NONE));
		cards.add(new Card(3, Colour.RED, Type.NONE));
		cards.add(new Card(4, Colour.RED, Type.NONE));
		cards.add(new Card(5, Colour.RED, Type.NONE));
		cards.add(new Card(6, Colour.RED, Type.NONE));
		cards.add(new Card(7, Colour.RED, Type.NONE));
		cards.add(new Card(8, Colour.RED, Type.NONE));
		cards.add(new Card(9, Colour.RED, Type.NONE));
		cards.add(new Card(10, Colour.RED, Type.SKIP));
		cards.add(new Card(11, Colour.RED, Type.REVERSE));
		cards.add(new Card(12, Colour.RED, Type.DRAW_TWO));
		cards.add(new Card(0, Colour.BLUE, Type.NONE));
		cards.add(new Card(1, Colour.BLUE, Type.NONE));
		cards.add(new Card(2, Colour.BLUE, Type.NONE));
		cards.add(new Card(3, Colour.BLUE, Type.NONE));
		cards.add(new Card(4, Colour.BLUE, Type.NONE));
		cards.add(new Card(5, Colour.BLUE, Type.NONE));
		cards.add(new Card(6, Colour.BLUE, Type.NONE));
		cards.add(new Card(7, Colour.BLUE, Type.NONE));
		cards.add(new Card(8, Colour.BLUE, Type.NONE));
		cards.add(new Card(9, Colour.BLUE, Type.NONE));
		cards.add(new Card(10, Colour.BLUE, Type.SKIP));
		cards.add(new Card(11, Colour.BLUE, Type.REVERSE));
		cards.add(new Card(12, Colour.BLUE, Type.DRAW_TWO));
		cards.add(new Card(0, Colour.GREEN, Type.NONE));
		cards.add(new Card(1, Colour.GREEN, Type.NONE));
		cards.add(new Card(2, Colour.GREEN, Type.NONE));
		cards.add(new Card(3, Colour.GREEN, Type.NONE));
		cards.add(new Card(4, Colour.GREEN, Type.NONE));
		cards.add(new Card(5, Colour.GREEN, Type.NONE));
		cards.add(new Card(6, Colour.GREEN, Type.NONE));
		cards.add(new Card(7, Colour.GREEN, Type.NONE));
		cards.add(new Card(8, Colour.GREEN, Type.NONE));
		cards.add(new Card(9, Colour.GREEN, Type.NONE));
		cards.add(new Card(10, Colour.GREEN, Type.SKIP));
		cards.add(new Card(11, Colour.GREEN, Type.REVERSE));
		cards.add(new Card(12, Colour.GREEN, Type.DRAW_TWO));
		cards.add(new Card(0, Colour.YELLOW, Type.NONE));
		cards.add(new Card(1, Colour.YELLOW, Type.NONE));
		cards.add(new Card(2, Colour.YELLOW, Type.NONE));
		cards.add(new Card(3, Colour.YELLOW, Type.NONE));
		cards.add(new Card(4, Colour.YELLOW, Type.NONE));
		cards.add(new Card(5, Colour.YELLOW, Type.NONE));
		cards.add(new Card(6, Colour.YELLOW, Type.NONE));
		cards.add(new Card(7, Colour.YELLOW, Type.NONE));
		cards.add(new Card(8, Colour.YELLOW, Type.NONE));
		cards.add(new Card(9, Colour.YELLOW, Type.NONE));
		cards.add(new Card(10, Colour.YELLOW, Type.SKIP));
		cards.add(new Card(11, Colour.YELLOW, Type.REVERSE));
		cards.add(new Card(12, Colour.YELLOW, Type.DRAW_TWO));
		cards.add(new Card(1, Colour.RED, Type.NONE));
		cards.add(new Card(2, Colour.RED, Type.NONE));
		cards.add(new Card(3, Colour.RED, Type.NONE));
		cards.add(new Card(4, Colour.RED, Type.NONE));
		cards.add(new Card(5, Colour.RED, Type.NONE));
		cards.add(new Card(6, Colour.RED, Type.NONE));
		cards.add(new Card(7, Colour.RED, Type.NONE));
		cards.add(new Card(8, Colour.RED, Type.NONE));
		cards.add(new Card(9, Colour.RED, Type.NONE));
		cards.add(new Card(10, Colour.RED, Type.SKIP));
		cards.add(new Card(11, Colour.RED, Type.REVERSE));
		cards.add(new Card(12, Colour.RED, Type.DRAW_TWO));
		cards.add(new Card(1, Colour.BLUE, Type.NONE));
		cards.add(new Card(2, Colour.BLUE, Type.NONE));
		cards.add(new Card(3, Colour.BLUE, Type.NONE));
		cards.add(new Card(4, Colour.BLUE, Type.NONE));
		cards.add(new Card(5, Colour.BLUE, Type.NONE));
		cards.add(new Card(6, Colour.BLUE, Type.NONE));
		cards.add(new Card(7, Colour.BLUE, Type.NONE));
		cards.add(new Card(8, Colour.BLUE, Type.NONE));
		cards.add(new Card(9, Colour.BLUE, Type.NONE));
		cards.add(new Card(10, Colour.BLUE, Type.SKIP));
		cards.add(new Card(11, Colour.BLUE, Type.REVERSE));
		cards.add(new Card(12, Colour.BLUE, Type.DRAW_TWO));
		cards.add(new Card(1, Colour.GREEN, Type.NONE));
		cards.add(new Card(2, Colour.GREEN, Type.NONE));
		cards.add(new Card(3, Colour.GREEN, Type.NONE));
		cards.add(new Card(4, Colour.GREEN, Type.NONE));
		cards.add(new Card(5, Colour.GREEN, Type.NONE));
		cards.add(new Card(6, Colour.GREEN, Type.NONE));
		cards.add(new Card(7, Colour.GREEN, Type.NONE));
		cards.add(new Card(8, Colour.GREEN, Type.NONE));
		cards.add(new Card(9, Colour.GREEN, Type.NONE));
		cards.add(new Card(10, Colour.GREEN, Type.SKIP));
		cards.add(new Card(11, Colour.GREEN, Type.REVERSE));
		cards.add(new Card(12, Colour.GREEN, Type.DRAW_TWO));
		cards.add(new Card(1, Colour.YELLOW, Type.NONE));
		cards.add(new Card(2, Colour.YELLOW, Type.NONE));
		cards.add(new Card(3, Colour.YELLOW, Type.NONE));
		cards.add(new Card(4, Colour.YELLOW, Type.NONE));
		cards.add(new Card(5, Colour.YELLOW, Type.NONE));
		cards.add(new Card(6, Colour.YELLOW, Type.NONE));
		cards.add(new Card(7, Colour.YELLOW, Type.NONE));
		cards.add(new Card(8, Colour.YELLOW, Type.NONE));
		cards.add(new Card(9, Colour.YELLOW, Type.NONE));
		cards.add(new Card(10, Colour.YELLOW, Type.SKIP));
		cards.add(new Card(11, Colour.YELLOW, Type.REVERSE));
		cards.add(new Card(12, Colour.YELLOW, Type.DRAW_TWO));
		cards.add(new Card(13, Colour.NONE, Type.WILD));
		cards.add(new Card(13, Colour.NONE, Type.WILD));
		cards.add(new Card(13, Colour.NONE, Type.WILD));
		cards.add(new Card(13, Colour.NONE, Type.WILD));
		cards.add(new Card(14, Colour.NONE, Type.WILD_DRAW_FOUR));
		cards.add(new Card(14, Colour.NONE, Type.WILD_DRAW_FOUR));
		cards.add(new Card(14, Colour.NONE, Type.WILD_DRAW_FOUR));
		cards.add(new Card(14, Colour.NONE, Type.WILD_DRAW_FOUR));
	}

	public Stack<Card> newDeck(){
		Collections.shuffle(cards);
		deck.addAll(cards);
		return deck;
	}

	public ArrayList<Card> dealCards() {
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int i = 0; i < 7; i++) {
			hand.add(deck.pop());
		}
		return hand;
	}
}
