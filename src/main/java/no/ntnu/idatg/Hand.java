package no.ntnu.idatg;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a hand of cards. The number of cards on hand can differ.
 *
 * @author Martin Hegnum Johannessen
 * @version 2022-03-15
 */
public class Hand {

    private List<PlayingCard> cardsOnHand;
    private DeckOfCards deckOfCards;
    private List<Character> suits;
    private Hand hand;

    /**
     * Creates an instance of a hand which is held in an ArrayList
     */
    public Hand(){
        cardsOnHand = new ArrayList<>(deckOfCards.dealHand(5));
    }

    /**
     * Returns whether the hand contains a flush or not
     *
     * @return the whether the hand contains a flush or not as a boolean
     */
    public boolean checkFlush(){
        boolean isFlush = false;
        int cardCounter = 0;
        for(Character suit : deckOfCards.getAllSuits()){
            //lambda feil, må telle opp antall av unik char for å sjekke om den er 5 eller mer.
                   if(cardsOnHand.stream().collect(suit -> suits).count(cardCounter<= 5)){
                isFlush = true;
                }
            }
        return isFlush; }


    public int getIntValueFromCardsOnHand() {
        int sum = 0;
        for (PlayingCard card : cardsOnHand) {
            sum = sum + card.getFace();
        }
        return sum;
    }
}


        //Da kan man for eksempel legge til metoder på denne klassen for å f.eks. sjekke for flush og andre poenggivende kombinasjoner.



}
