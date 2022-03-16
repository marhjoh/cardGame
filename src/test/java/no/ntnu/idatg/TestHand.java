package no.ntnu.idatg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHand {

    private Hand hand;

    @BeforeEach
    @DisplayName("This method will create an object for the tests before each test")
    void setup() {
        hand = new Hand();
    }

    @Test
    @DisplayName("This method test the handConstructor")
    void testConstructor() {
        assertEquals(5, hand.getHandSize());
    }

    @Test
    @DisplayName("This test checks if the hand has a flush or not with mapValues, most likely it has not")
    void testCheckFlushWithMapValues() {
        assertFalse(hand.checkFlushWithMapValues());
    }

    @Test
    @DisplayName("This test checks if the hand has a flush or not with mapKeySet, most likely it has not")
    void testCheckFlushWithKeySet() {
        assertFalse(hand.checkFlushWithMapKeySet());
    }

    @Test
    @DisplayName("This method tests to add a playingCard to the current hand")
    void testAddPlayingCardToHand() {
        PlayingCard playingCard = new PlayingCard('C', 4);

        hand.addPlayingCardToHand(playingCard);

        assertEquals(6, hand.getHandSize());
    }

    @Test
    @DisplayName("This method tests the getHandSize method")
    void testShowAllHeartsOnHand() {
        assertEquals(5, hand.getHandSize());
    }

    @Test
    @DisplayName("This method tests the amount of heart cards on hand, this will never be above 6")
    void testGetAllHeartCardsOnHand(){
        assertNotEquals(6, hand.getAllHeartCardsOnHand().size());
    }

    @Test
    @DisplayName("This method tests the getHandSize method")
    void testGetHandSize(){
        assertEquals(5, hand.getHandSize());
    }
}
