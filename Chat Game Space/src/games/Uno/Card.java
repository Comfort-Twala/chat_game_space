package games.Uno;

public class Card {

	private int number;
	private Colour colour;
	private Type type;

	public enum Colour {
		RED,
		GREEN,
		YELLOW,
		BLUE, 
		NONE
	};
	public enum Type {
		NONE,
		DRAW_TWO,
		SKIP,
		REVERSE,
		WILD,
		WILD_DRAW_FOUR
	}

	public Card(int number, Colour colour, Type type) {
		this.number = number;
		this.colour = colour;
		this.type = type;
	}

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
