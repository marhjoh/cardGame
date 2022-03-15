package no.ntnu.idatg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestDeckOfCards {

    private DeckOfCards deckOfCards;

    @Test
    void getRandomPlayingCard() {
        deckOfCards = new DeckOfCards();

        assertNotEquals("C4", deckOfCards.getRandomPlayingCard());
        assertNotNull(deckOfCards.getRandomPlayingCard());
    }

    @Test
    void testDealHand() {
        deckOfCards = new DeckOfCards();

        assertEquals(5, deckOfCards.dealHand(5).size());
        assertEquals(47, deckOfCards.getAllPlayingCards());

    }

    @Test
    void testGetAllPlayingCards(){
        deckOfCards = new DeckOfCards();
        assertEquals(52, deckOfCards.getAllPlayingCards());
    }
}
