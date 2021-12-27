package games.Uno;

import java.util.Arrays;

/**
 * Card class for Uno cards 
 */
public class Card {

	private int number;
	private Colour colour;
	private Type type;
	private String[] card;

	/**
	 * Colour enum for the different Uno card colours
	 */
	public enum Colour {
		RED,
		GREEN,
		YELLOW,
		BLUE, 
		NONE
	}

	/**
	 * Type enum for the different Uno card types 
	 */
	public enum Type {
		NONE,
		DRAW_TWO,
		SKIP,
		REVERSE,
		WILD,
		WILD_DRAW_FOUR
	}

	/**
	 * Card constructor to create Uno card
	 * @param number
	 * @param colour
	 * @param type
	 */
	public Card(int number, Colour colour, Type type) {
		this.number = number;
		this.colour = colour;
		this.type = type;
		this.card = new String[6];
	}

	private String centerPad(String str, int totLength) {
		int pad = (totLength - str.length()) / 2;
		String result = "";
		for (int i = 0; i < pad; i++) {
			result += " ";
		}
		result += str;
		for (int i = 0; i < (totLength - pad - str.length()); i++) {
			result += " ";
		}
		return result;
	}

	/**
	 * String representation method for Uno Card
	 */
	public String toString() {
		this.card[0] = "-----------";
		this.card[1] = "|         |";
		switch (this.colour) {
			case NONE:
				this.card[2] = "|  WILD   |";
				switch (this.type) {
					case WILD:
						this.card[3] = "|  CARD   |";
						break;
					case WILD_DRAW_FOUR:
						this.card[3] = "|   +4    |";
						break;
					default:
						break;
				}
				break;
			case RED:
				this.card[2] = "|   RED   |";
				break;
			case BLUE:
				this.card[2] = "|  BLUE   |";
				break;
			case GREEN:
				this.card[2] = "|  GREEN  |";
				break;
			case YELLOW:
				this.card[2] = "|  YELLOW |";
				break;
			
		}
		if (this.colour != Colour.NONE)
			this.card[3] = "|" + centerPad(Integer.toString(this.number), 9) + "|";
		this.card[4] = "|         |";
		this.card[5] = "-----------";

		return Arrays.asList(card).toString();
	}	
}
