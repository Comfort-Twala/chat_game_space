package games.Uno;

import java.util.Arrays;

/**
 * Card class for Uno cards 
 */
public class Card {

	private int number;
	private Colour colour;
	private Type type;

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
		String result = "|";
		switch (this.colour) {
			case NONE:
				result += "Wild ";
				switch (this.type) {
					case WILD:
						result += "Card";
						break;
					case WILD_DRAW_FOUR:
						result += "+4";
						break;
					default:
						break;
				}
				break;
			case RED:
				result += "Red ";
				break;
			case BLUE:
				result += "Blue ";
				break;
			case GREEN:
				result += "Green ";
				break;
			case YELLOW:
				result += "Yellow ";
				break;
		}
		if (this.colour != Colour.NONE)
			result += Integer.toString(this.number);

		return result;
	}	
}