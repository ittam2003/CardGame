package no.ntnu.idatx2001.oblig3.cardgame;

import java.util.ArrayList;

/**
 * Represents the player's hand in the card game.
 * A hand is a collection of PlayingCard objects.
 * The hand can be dealt a variable number of cards from a DeckOfCards object.
 * The cards in the hand can be retrieved as an ArrayList of PlayingCard objects
 * or as an ArrayList of Strings representing each card.
 *
 * @author Matti Kjellstadli
 * @version 2023-03-21
 */
public class Hand {
    private final ArrayList<PlayingCard> hand;

    DeckOfCards deckOfCards = new DeckOfCards();

    /**
     * Creates an ArrayList of PlayingCard objects to store the player's cards.
     */
    public Hand(){
        this.hand = new ArrayList<>();
    }

    /**
     * Draws a variable number of cards from DeckOfCards, between 0 and 52 inclusive.
     * @param n number of cards drawn from DeckOfCards
     */
    public void dealHand(int n) {
        while (n > 0) {
            hand.add(deckOfCards.getRandomCard());
            n--;
        }
    }

    /**
     * Returns the object of this class
     * @return returns a Hand object
     */
    public ArrayList<PlayingCard> getHand(){
        return this.hand;
    }

    /**
     * Returns the hand ArrayList as a String
     * @return returns an ArrayList of Strings
     */
    public ArrayList<String> getHandAsString(){
        ArrayList<String> stringList = new ArrayList<>();
        for(PlayingCard playingCard : hand){
            String cardString = playingCard.getAsString();
            stringList.add(cardString);
        }
        return stringList;
    }
}
