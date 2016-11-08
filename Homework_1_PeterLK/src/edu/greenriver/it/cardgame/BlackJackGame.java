package edu.greenriver.it.cardgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import edu.greenriver.it.cards.PokerCard;
import edu.greenriver.it.console.Console;

public class BlackJackGame extends CardGame {
	// Number before face cards.
	public static final int BEFORE_FACE_CARDS = 8;
	// The deck divided into 4.
	public static final int DECK_DIVIDED_4 = 13;
	// The number 21 for over 21 or = to 21.
	public static final int WIN_OR_BUST = 21;
	// Values for cards J thru K.
	public static final int FACE_CARD = 10;
	// Represents the value for ace.
	private static final int ACE = 11;

	// Array containing 52 cards in a a regular deck.
	private PokerCard[] deck = new PokerCard[52];

	// Queue representing a deck where you can only retrieve cards one at a time
	// on the top of the deck.
	private Queue<PokerCard> gameDeck = new LinkedList<>();

	/**
	 * This is the constructor of this object that initiates a Black Jack game.
	 * 
	 * @param name
	 *            - The name of the game you are playing.
	 * @param welcomeMessage
	 *            - The welcome message for the Black Jack game.
	 */
	public BlackJackGame(String name, String welcomeMessage) {
		super(name, welcomeMessage);

		Console.print(super.getName() + "\n" + super.getWelcomeMessage() + "\n");

		createDeck();
		shuffle();
	}

	/**
	 * Methods that shuffle the global deck of cards.
	 */
	@Override
	public void shuffle() {

		// Temporary deck for shuffling cards.
		PokerCard[] tempShuffledDeck = new PokerCard[52];

		for (PokerCard c : deck) {

			// Creates a random number between 0 and 51;
			int rand = 0 + (int) (Math.random() * ((51 - 0) + 1));

			// Checks to see if there is a card already in that spot
			// if there is a card in that spot then it resets the random value.
			// repeats until there is a empty slot for the card.
			while (!(tempShuffledDeck[rand] == null)) {
				rand = 0 + (int) (Math.random() * ((51 - 0) + 1));
			}

			// Sets the poker card into the random slot.
			tempShuffledDeck[rand] = c;

		}

		// Re-reference the newly shuffled deck.
		deck = tempShuffledDeck;

		// Adds deck to a Queue.
		for (PokerCard pCard : deck) {
			gameDeck.add(pCard);
		}

	}

	/**
	 * Returns the next card on top of the deck.
	 * 
	 * @return PokerCard - returns a PokerCard object.
	 * 
	 */
	@Override
	public PokerCard dealCard() {
		return gameDeck.remove();
	}

	/**
	 * Starts a round of Black Jack. At the end of round asks if you want to
	 * play another round. If you say yes you play another round.
	 */
	@Override
	public void playRound() {

		// Dealer.s Hand.
		ArrayList<PokerCard> dealersHand = new ArrayList<>();

		// Player's Hand.
		ArrayList<PokerCard> playersHand = new ArrayList<>();

		// Player's total.
		int playerTotal;

		// Dealer's total.
		int dealerTotal;

		// Set initial Player's hands
		playersHand.add(dealCard());
		playersHand.add(dealCard());

		// Set initial Dealer's hand
		dealersHand.add(dealCard());
		dealersHand.add(dealCard());

		// Displays player's hand.
		Console.print("You are delt " + playersHand.get(0).toString());
		Console.print("You are delt " + playersHand.get(1).toString());

		// Sets players total.
		playerTotal = setBJHandValue(playersHand);

		Console.print("Your total is:" + playerTotal + "\n");

		if (playerTotal == WIN_OR_BUST) {

			Console.print("WINNER WINNER CHICKEN DINNER!!!!");

		} else {

			String hitThem = Console.getString("hit? (Y/N)");

			// Loop that keeps round going until player is done with their turn.
			while (hitThem.equals("Y") || hitThem.equals("y")) {

				// Stops loop for now.
				hitThem = "N";

				// Deals a card to player.
				playersHand.add(dealCard());

				// Sets total for player based of their hand.
				playerTotal = setBJHandValue(playersHand);

				// Prints out what the player was delt and the players total
				// hand after new card was delt.
				Console.print("You was delt " + playersHand.get(playersHand.size() - 1));
				Console.print("Your total is:" + playerTotal + "\n");

				if (setBJHandValue(playersHand) > WIN_OR_BUST) {
					Console.print("BUUUUUSSST!, You Lose, Game Over!!!!! \n");
					playAgain();

				} else if (setBJHandValue(playersHand) == WIN_OR_BUST) {
					Console.print("You Won Congrates");

				} else {
					hitThem = Console.getString("hit? (Y/N)");
				}

				if (hitThem.equals("N") || hitThem.equals("n")) {
					break;
				}
			}

		}

		// Checks to see if the players total doesn't not equal 21.
		if (playerTotal != WIN_OR_BUST) {

			// Prints the dealer hand.
			Console.print("DEALER is delt " + dealersHand.get(0).toString());
			Console.print("DEALER is delt " + dealersHand.get(1).toString());

			dealerTotal = setBJHandValue(dealersHand);

			Console.print("DEALER'S total is:" + dealerTotal + "\n");

			if (dealerTotal == WIN_OR_BUST) {

				Console.print("\n Dealer Won!, And you Lost! \n");

			} else if (dealerTotal > playerTotal) {

				Console.print("\n Dealer Won!, And you Lost! \n");

			} else {

				// Check whether dealers total is greater than players total.
				while (dealerTotal <= playerTotal) {

					// Adds a card to dealers hand.
					dealersHand.add(dealCard());
					// Changes dealers hand to new hand.
					dealerTotal = setBJHandValue(dealersHand);

					// Prints out what the player was delt and the Dealers total
					// hand after new card was delt.
					Console.print("DEALER was delt " + dealersHand.get(dealersHand.size() - 1));
					Console.print("DEALER's total is:" + dealerTotal);

					// Check to see if dealer bust.
					if (dealerTotal > WIN_OR_BUST) {

						Console.print("\n Dealer has Bust, Congratulations!!!, You Are A Winner!!! \n");

						// Checks to see if dealer has more than player.
					} else if (dealerTotal > playerTotal) {

						Console.print("\n Dealer Won!, And you Lost! \n");

					}

				}

			}

		}

		playAgain();
	}

	// A method that resets a round.
	private void playAgain() {

		String play = Console.getString("Play Another Round? (Y/N)");

		if (play.endsWith("Y") || play.endsWith("y")) {

			playRound();

		} else if (play.equals("N") || play.endsWith("n")) {

			Console.print("Thank You For Playing =] .");

		} else {
			playAgain();
		}
	}

	// Finds the total for player or dealer.
	private int setBJHandValue(ArrayList<PokerCard> bJHand) {

		int handValue = 0;

		for (PokerCard p : bJHand) {

			if (p.getRank().equals("J") || p.getRank().equals("Q") || p.getRank().equals("K")) {

				handValue += FACE_CARD;

			} else if (p.getRank().equals("A")) {

				handValue += ACE;

			} else {
				handValue += Integer.parseInt(p.getRank());
			}
		}

		return handValue;
	}

	// Creates a new deck of cards.
	private void createDeck() {

		for (int i = 0; i < DECK_DIVIDED_4; i++) {

			String rankT = null;// the rank value created dynamically.

			if (i <= BEFORE_FACE_CARDS) {

				rankT = i + 2 + "";

			} else {

				switch (i) {

				case 9:

					rankT = "J";
					break;

				case 10:

					rankT = "Q";
					break;

				case 11:

					rankT = "K";
					break;

				case 12:

					rankT = "A";
					break;

				default:
					break;

				}
			}

			if (i <= 12) {

				// Creates set of cards by rank.
				deck[(i * 4) + 0] = new PokerCard("Red", 30, 90, "Hearts", rankT);
				deck[(i * 4) + 1] = new PokerCard("Red", 30, 90, "Dimonds", rankT);
				deck[(i * 4) + 2] = new PokerCard("Black", 30, 90, "Clubs", rankT);
				deck[(i * 4) + 3] = new PokerCard("Black", 30, 90, "Spades", rankT);

			}

		}
	}

}
