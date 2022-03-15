package no.ntnu.idatg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestHand {

    private DeckOfCards deckOfCards;
    private List<PlayingCard> playingCards;
    private Hand hand;

    @BeforeEach
    void setup(){
        deckOfCards = new DeckOfCards();
        playingCards = new ArrayList<>();
        hand = new Hand(playingCards);
    }

    @Test
    void testConstructor(){
    }

    @Test
    void checkFlush() {
        deckOfCards.dealHand(5);
        assertEquals(false, hand.checkFlush());
    }
}
