package no.ntnu.idatg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPlayingCard {

    private PlayingCard playingCard = new PlayingCard('C', 3);

    @Test
    void testPlayingCardConstructor(){
        assertEquals('C', playingCard.getSuit());
        assertEquals(3, playingCard.getFace());
    }

    @Test
    void testGetAsString() {
        assertEquals("C3", playingCard.getAsString());
    }

    @Test
    void testGetSuit() {
        assertEquals('C', playingCard.getSuit());
    }

    @Test
    void testGetFace() {
        assertEquals(3, playingCard.getFace());
    }
}
