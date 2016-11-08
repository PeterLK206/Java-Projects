package edu.greenriver.it.cards;

public class PokerCard extends PlayingCard {

	// attributes
	private String suit;
	private String rank;
	private String[] suitType = new String[] { "Hearts", "Dimonds", "Clubs", "Spades" };// array
																						// of
																						// suits.
	private String[] rankType = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };// array
																													// of
																													// ranks.

	/**
	 * Constructor for the Poker Card Class.
	 * 
	 * @param color
	 *            - Color of the card.
	 * @param width
	 *            - Width of the card.
	 * @param height
	 *            - Height of the card.
	 * @param suit
	 *            - Suit of the card.
	 * @param rank
	 *            - Rank of the card.
	 */
	public PokerCard(String color, int width, int height, String suit, String rank) {
		super(color, width, height);

		for (int i = 0; i < rankType.length; i++) {
			if (suitType[i].equals(suit)) {
				this.suit = suit;
				break;
			} else {
				if (i >= suitType.length - 1) {
					throw new IllegalArgumentException("Invalid Suit Type!!!");
				}
			}
		}

		for (int i = 0; i < rankType.length; i++) {
			if (rankType[i].equals(rank)) {
				this.rank = rank;
				break;
			} else {
				if (i >= rankType.length - 1) {
					throw new IllegalArgumentException("Invalid Rank Type!!!");
				}
			}
		}
	}

	/**
	 * Retrieves the suit of the card.
	 * 
	 * @return - String Value of the card.
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Sets the Suit of the card.
	 * 
	 * @param suit
	 *            - The new suit you would like to set the card too.
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Retrieves the rank of the card.
	 * 
	 * @return - String value of rank.
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Sets the rank to a new value.
	 * 
	 * @param rank
	 *            - The new rank to be set.
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Retrieves the string representation of the PokerCard object.
	 * 
	 * @return - String rep of object.
	 */
	public String toString() {

		return "The " + rank + " of " + suit + ".";

	}

}
