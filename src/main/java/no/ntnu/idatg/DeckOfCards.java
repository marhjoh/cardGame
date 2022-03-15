package no.ntnu.idatg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

    private final List<PlayingCard> playingCards;
    private final char[] suits = { 'S', 'H', 'D', 'C' };
    private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static final int DECK_SIZE = 52;
    private Random random;

    public DeckOfCards(){
        random = new Random();
        playingCards = new ArrayList<>(DECK_SIZE);

        int cardIndex = 0;
        for (char suit : suits) {
            for (int face : faces) {
                playingCards.add(cardIndex, new PlayingCard(suit, face));
                cardIndex++;
            }
        }
    }

    public PlayingCard getRandomPlayingCard(){
        int randomIndex = random.nextInt(0, DECK_SIZE-1);
        return playingCards.get(randomIndex);
    }

    public List<PlayingCard> dealHand(int amountOfCards){
        ArrayList<PlayingCard> dealtHand = new ArrayList<>();
        for(int i=0;i<amountOfCards;i++) {
            PlayingCard card = getRandomPlayingCard();
            dealtHand.add(card);
            playingCards.remove(card);
        }

        return dealtHand;
    }

    public int getAllPlayingCards(){
        return playingCards.size();
    }

    public char[] getAllSuits() {
        return suits;
    }
}
