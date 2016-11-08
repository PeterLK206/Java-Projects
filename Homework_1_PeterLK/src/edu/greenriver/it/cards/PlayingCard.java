package edu.greenriver.it.cards;

/**
 * Class that represents a regular card class.
 * 
 * @author PeterLKim
 *
 */
public class PlayingCard {

	private String color;// Color of Card
	private int width;// Width of Card
	private int height;// Height of Card

	/**
	 * Constructor of the Playing card class used to create a playing card
	 * object.
	 * 
	 * @param color
	 *            The color value of the card.
	 * @param width
	 *            The width of the card.
	 * @param height
	 *            The height of the card.
	 */
	public PlayingCard(String color, int width, int height) {

		this.color = color;
		this.width = width;
		this.height = height;

	}

	/**
	 * Retrieves the color of the object.
	 * 
	 * @return - Color of the PokerCard object.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color of the object.
	 * 
	 * @param color
	 *            - Color you want to set.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Retrieves the width of the object.
	 * 
	 * @return - the width of the PokerCard object.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the card value.
	 * 
	 * @param width
	 *            - Width of the card value.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Retrieves the height value of the card.
	 * 
	 * @return - returns the height of the card.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set the height of this card object.
	 * 
	 * @param height
	 *            - a height value for the card.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Retrieves the string representation of the PokerCard object.
	 * 
	 * @return - String rep of object.
	 */
	public String toString() {

		return "The card color is: " + color + " .\n " + "The card width is: " + width + " .\n "
				+ "The card height is: " + height + " .";
	}

}
