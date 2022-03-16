package no.ntnu.idatg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPlayingCard {

    private PlayingCard playingCard = new PlayingCard('C', 3);

    @Test
    @DisplayName("This test if the constructor works properly")
    void testPlayingCardConstructor(){
        assertEquals('C', playingCard.getSuit());
        assertEquals(3, playingCard.getFace());
    }

    @Test
    @DisplayName("This test if the playingCard is returned as intended")
    void testGetAsString() {
        assertEquals("C3", playingCard.getAsString());
    }

    @Test
    @DisplayName("This method tests the getSuit method")
    void testGetSuit() {
        assertEquals('C', playingCard.getSuit());
    }

    @Test
    @DisplayName("This method tests the getFace method")
    void testGetFace() {
        assertEquals(3, playingCard.getFace());
    }
}
