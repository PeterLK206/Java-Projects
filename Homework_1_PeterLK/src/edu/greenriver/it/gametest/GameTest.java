package edu.greenriver.it.gametest;

import edu.greenriver.it.cardgame.BlackJackGame;

/**
 * a driver class to start the black jack application.
 * 
 * @author Peter
 *
 */
public class GameTest {

	public static void main(String[] args) {
		// Instantiate the game object.
		BlackJackGame game = new BlackJackGame("Lets Play Some Black Jack.", "Welcome to JAVA Black Jack.");
		game.playRound();// Play Round

	}
}
