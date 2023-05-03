package no.ntnu.idatx2001.oblig3.cardgame;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckOfCardsTest {
    @Test
    public void testConstructorInDeckOfCardsClass(){
        DeckOfCards deckOfCards = new DeckOfCards();
        assertEquals(52, deckOfCards.getSizeOfDeck());
    }

    @Test
    public void testDealHand(){
        DeckOfCards deckOfCards = new DeckOfCards();
        Hand hand = new Hand();
        hand.dealHand(7);
        System.out.println(hand.getHandAsString());
    }

    @Test
    public void getAsStringTest(){
        PlayingCard playingCard = new PlayingCard('H', 2);
        System.out.println(playingCard.getAsString());
    }

    @Test
    public void handTest(){
        Hand hand = new Hand();
        hand.dealHand(7);
        System.out.println(hand.getHandAsString());
    }

    @Test
    public void controllerTestGetSum(){
        MainController mainController = new MainController();
        mainController.handleDealButton();
        System.out.println(mainController.getSumOfCardsAsString());
        mainController.handleDealButton();
        System.out.println(mainController.getSumOfCardsAsString());
    }

    @Test
    public void getAllHeartsInHand(){
        MainController mainController = new MainController();
        mainController.handleDealButton();
        System.out.println(mainController.getAllHeartsInHand());
    }

    @Test
    public void checkForFlush(){
        MainController mainController = new MainController();
        mainController.hand.getHand().add(0, new PlayingCard('C', 1));
        mainController.hand.getHand().add(1, new PlayingCard('C', 2));
        mainController.hand.getHand().add(2, new PlayingCard('C', 3));
        mainController.hand.getHand().add(3, new PlayingCard('C', 4));
        mainController.hand.getHand().add(4, new PlayingCard('C', 5));
        assertTrue(mainController.checkIfFlush());
    }

    @Test
    public void checkForNotFlush(){
        MainController mainController = new MainController();
        mainController.hand.getHand().add(0, new PlayingCard('C', 1));
        mainController.hand.getHand().add(1, new PlayingCard('C', 2));
        mainController.hand.getHand().add(2, new PlayingCard('C', 3));
        mainController.hand.getHand().add(3, new PlayingCard('C', 4));
        mainController.hand.getHand().add(4, new PlayingCard('H', 5));
        assertFalse(mainController.checkIfFlush());
    }
}
