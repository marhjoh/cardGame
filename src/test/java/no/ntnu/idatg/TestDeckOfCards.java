package no.ntnu.idatg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class of DeckOfCards.
 *
 * @author Martin Hegnum Johannessen
 * @version 2022-03-15
 */
class TestDeckOfCards {

    private DeckOfCards deckOfCards;

    @BeforeEach
    @DisplayName("This method will create an object for the tests before each test")
    void setup(){
        deckOfCards = new DeckOfCards();
    }

    @Test
    @DisplayName("This method will test if the constructor fills up the deckOfCards with playingCards")
    void testDeckOfCardsConstructor(){
        assertEquals(52, deckOfCards.getAllPlayingCards());
    }

    @Test
    @DisplayName("This test method checks the getRandomPlayingCard method")
    void testGetRandomPlayingCard() {
        assertNotEquals("C4", deckOfCards.getRandomPlayingCard());
        assertNotNull(deckOfCards.getRandomPlayingCard());
    }

    @Test
    @DisplayName("This test method checks if the dealHand method actually deals a hand")
    void testDealHand() {
        assertEquals(5, deckOfCards.dealHand(5).size());
        assertEquals(47, deckOfCards.getAllPlayingCards());
    }

    @Test
    @DisplayName("This test method checks if a new deckOfCards contains 52 cards")
    void testGetAllPlayingCards(){
        assertEquals(52, deckOfCards.getAllPlayingCards());
    }
}
