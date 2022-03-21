package no.ntnu.idatg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of cards. A deck of cards has 52 cards.
 * The value of these are between 1 and 13. The cards are divided
 * equally in 4 different suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author Martin Hegnum Johannessen
 * @version 2022-03-21
 */
public class DeckOfCards {

    private final List<PlayingCard> playingCards;
    private final char[] suits = { 'S', 'H', 'D', 'C' };
    private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private Random random;

    /**
     * Creates a list of a DeckOfCards which contains 52 cards,
     * 13 different values and 4 different suits.
     */
    public DeckOfCards(){
        random = new Random();
        playingCards = new ArrayList<>();

        for (char suit : suits) {
            for (int face : faces) {
                playingCards.add(new PlayingCard(suit, face));
            }
        }
    }

    /**
     * Returns a random playingCard in the deck
     * @return a random playingCard
     */
    public PlayingCard getRandomPlayingCard(){
        int randomIndex = random.nextInt(playingCards.size());
        return playingCards.get(randomIndex);
    }

    /**
     * Returns a random hand of cards
     * @param amountOfCards the amount of cards wanted in the hand
     * @return an ArrayList of playingCards
     */
    public ArrayList<PlayingCard> dealHand(int amountOfCards){
        ArrayList<PlayingCard> dealtHand = new ArrayList<>();
        for(int i=0;i<amountOfCards;i++) {
            PlayingCard card = getRandomPlayingCard();
            dealtHand.add(card);
            playingCards.remove(card);
        }

        return dealtHand;
    }

    /**
     * Returns the list size of all playingCards available in the deck
     * @return the size of the list
     */
    public int getAllPlayingCards(){
        return playingCards.size();
    }
}

