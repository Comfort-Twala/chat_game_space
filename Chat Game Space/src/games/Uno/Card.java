package games.Uno;

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

	/**
	 * String representation method for Uno Card
	 */
	public String toString() {
		switch (this.type) {
			case NONE:
				return this.number + " | " + this.colour;
			case DRAW_TWO:
				return "Take Two" + " | " + this.colour;
			case SKIP:
				return "Skip" + " | " + this.colour;
			case REVERSE:
				return "Reverse" + " | " + this.colour;
			case WILD:
				return "Wild Card";
			case WILD_DRAW_FOUR:
				return "Wild Take Four Card";
		}
		return null;
	}	
}
