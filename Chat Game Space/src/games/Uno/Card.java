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
	 * Method to center text in middle of card
	 * @param str
	 * @param totLength
	 * @return
	 */
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
	 * Card like representation of card
	 */
	public String[] card(){
		String[] result = new String[6];
		result[0] = "----------";
		result[1] = "|        |";

		if (this.colour == this.colour.NONE){
			result[2] = "|  WILD  |";
		} else {
			result[2] = "|" + centerPad(this.colour.toString(), 8) + "|";
		} 
		if (this.number > 12){
			if (this.type == type.WILD){
				result[3] = "|" + centerPad("CARD", 8) + "|";
			} else {
				result[3] = "|" + centerPad("+4", 8) + "|";
			}
		}
		result[4] = "|		 |";
		result[5] = "---------";

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