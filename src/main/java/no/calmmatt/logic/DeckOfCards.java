package no.calmmatt.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a standard 52-card deck of playing cards.
 * Each card has a suit (spades, hearts, diamonds, clubs) and a face value (1-13).
 * The deck is initialized with all 52 cards, and cards can be randomly drawn from the deck.
 * Once a card is drawn from the deck, it cannot be drawn again until the deck is reset.
 *
 * @author Matti Kjellstadli
 * @version 2023-03-21
 */
public class DeckOfCards {
    private final ArrayList<PlayingCard> AllCards;

    /**
     * This method constructs a deck of cards by first creating all 13 cards of spades (S),
     * followed by 13 cards of hearts (H), then 13 cards of diamonds (D), and finally 13 cards of clubs (C).
     */
    public DeckOfCards(){
        AllCards = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                char[] suit = {'S', 'H', 'D', 'C'};
                AllCards.add(new PlayingCard(suit[j], i + 1));
            }
        }
    }

    /**
     * Returns the size of the deck as int
     * @return returns the size of the deck as int
     */
    public int getSizeOfDeck(){
        return AllCards.size();
    }

    /**
     * This method randomly selects a card from the deck to draw and returns it for use in the hand.
     * @return returns the random card that has been drawn
     */
    public PlayingCard getRandomCard() {
        Random random = new Random();
        PlayingCard randomCard = AllCards.get(random.nextInt(AllCards.size()));
        AllCards.remove(randomCard);
        return randomCard;
    }
}
