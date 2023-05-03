package no.ntnu.idatx2001.oblig3.cardgame;

/**
 * The MainController class represents the controller for the card game application. It contains methods for dealing a new
 * hand, checking for specific card combinations, and calculating the sum of the cards in the player's hand.
 * This class also includes a private Hand object to represent the player's current hand.
 *
 * @author Matti Kjellstadli
 * @version 2023-03-21
 */
public class MainController {
    Hand hand = new Hand();

    /**
     * Deals a new hand of five cards to the player.
     */
    public void handleDealButton() {
        hand = new Hand();
        hand.dealHand(5);
    }

    /**
     * Returns a string containing all the hearts in the player's current hand.
     * @return a string representing all the hearts in the player's current hand.
     */
    public String getAllHeartsInHand() {
        StringBuilder allHearts = new StringBuilder();
        for (PlayingCard playingCard : hand.getHand()) {
            if (playingCard.getSuit() == 'H') {
                allHearts.append(playingCard.getAsString()).append(" ");
            }
        }
        if (allHearts.toString().equals("")) {
            allHearts = new StringBuilder("No hearts");
        }
        return allHearts.toString();
    }

    /**
     * Returns a boolean indicating whether the player's hand contains the queen of spades.
     * @return true if the player's hand contains the queen of spades, false otherwise.
     */
    public boolean getQueenOfSpades() {
        boolean queenSpade12 = false;
        for (PlayingCard playingCard : hand.getHand()) {
            if (playingCard.getAsString().equals("S12")) {
                queenSpade12 = true;
            }
        }
        return queenSpade12;
    }

    /**
     * Calculates the sum of the cards in the player's hand and returns it as a string.
     * @return a string representing the sum of the cards in the player's hand.
     */
    public String getSumOfCardsAsString() {
        int sumOfHand = 0;
        for (PlayingCard playingCard : hand.getHand()) {
            sumOfHand += playingCard.getFace();
        }
        return Integer.toString(sumOfHand);
    }

    /**
     * Checks if the player's hand contains a flush (all cards of the same suit)
     * and returns a boolean indicating the result.
     * @return true if the player's hand contains a flush, false otherwise.
     */
    public boolean checkIfFlush() {
        return hand.getHand().get(0).getSuit() == hand.getHand().get(1).getSuit() &&
                hand.getHand().get(0).getSuit() == hand.getHand().get(2).getSuit() &&
                hand.getHand().get(0).getSuit() == hand.getHand().get(3).getSuit() &&
                hand.getHand().get(0).getSuit() == hand.getHand().get(4).getSuit();
    }
}

