package edu.greenriver.it.cardgame;

import edu.greenriver.it.cards.PokerCard;

/**
 * Abstract class that represents a object for a card game class.
 * 
 * @author Peter
 *
 */
public abstract class CardGame {

	// Attributes.
	private String name;
	private String welcomeMessage;

	/**
	 * The constructor for the card game class.
	 * 
	 * @param name
	 *            - the name of the game.
	 * @param welcomeMessage
	 *            - the welcome message of the game.
	 */
	public CardGame(String name, String welcomeMessage) {
		this.name = name;
		this.welcomeMessage = welcomeMessage;
	}

	/**
	 * Method that shuffles cards
	 */
	public abstract void shuffle();

	/**
	 * Method that deals cards
	 * 
	 * @return - Returns a card to player.
	 */
	public abstract PokerCard dealCard();

	/**
	 * Starts the game and plays a round of the game.
	 */
	public abstract void playRound();

	/**
	 * Gets the game's name.
	 * 
	 * @return - String value of the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the game.
	 * 
	 * @param name
	 *            - The name of the game.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Welcome message of the game.
	 * 
	 * @return - returns the welcome message of the game.
	 */
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	/**
	 * Sets the welcome Message if it is needed to be changed.
	 * 
	 * @param welcomeMessage
	 *            - The welcome message of the game.
	 */
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
