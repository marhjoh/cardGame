package no.ntnu.idatg;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Represents a hand of cards. The number of cards on hand can differ.
 *
 * @author Martin Hegnum Johannessen
 * @version 2022-03-21
 */
public class Hand {

    private List<PlayingCard> cardsOnHand;
    private DeckOfCards deckOfCards;

    /**
     * Creates an instance of a hand which is held in an ArrayList
     */
    public Hand(){
        deckOfCards = new DeckOfCards();
        cardsOnHand = deckOfCards.dealHand(5);
    }

    /**
     * Returns whether the hand contains a flush or not
     *
     * @return the whether the hand contains a flush or not as a boolean
     */
    public boolean checkFlushWithMapValues(){
        Map<Character, Long> map = cardsOnHand.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

            for(Long suit : map.values()){
                if(suit >= 5){
                    return true;
                }
            }
            return false;
        }

    /**
     * Returns whether the hand contains a flush or not.
     *
     * @return whether the hand contains a flush or not (5 or more cards of the similar suit) as a boolean
     */
    public boolean checkFlushWithMapKeySet(){
        Map<Character, Long> map = cardsOnHand.stream()
                .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

        for(Character suit : map.keySet()){
            if(map.get(suit) >= 5){
                return true;
            }
        }
        return false;
    }

    /**
     * This method adds a playingCard to the current hand
     *
     * @param playingCard the card to be added to the hand
     */
    public void addPlayingCardToHand(PlayingCard playingCard){
        cardsOnHand.add(playingCard);
    }

    /**
     * This method sums up the value of all the cards on the hand
     *
     * @return the sum as an int
     */
    public int getIntValueFromCardsOnHand() {
        int sum = 0;
        for (PlayingCard card : cardsOnHand) {
            sum = sum + card.getFace();
        }
        return sum;
    }

    /**
     * Returns the heart cards on the hand
     *
     * @return the cards of suit heart as a String
     */
    public String getAllHeartCardsOnHand(){
        String message = "No heart cards on hand";
        String matchingCards = cardsOnHand.stream().
                filter(p -> p.getSuit() == 'H').toList().stream().map(PlayingCard::getAsString).collect(Collectors.joining(", "));
        if (matchingCards.length() > 0) {
            return matchingCards;
        } else {
            return message;
        }
    }

    /**
     * Returns the size of the hand
     *
     * @return the size of the hand as an int
     */
    public int getHandSize(){
        return cardsOnHand.size();
    }

    /**
     * Returns all the cards on the hand
     *
     * @return all the cards on the hand as a list
     */
    public List<PlayingCard> getCardsOnHand(){
        return cardsOnHand;
    }

    /**
     * Returns whether the hand contains a flush or not.
     *
     * @return whether the hand contains a flush or not (5 or more cards of the similar suit) as a boolean
     */
    public boolean checkQueenOfSpades(){
        Optional<PlayingCard> matchingObject = cardsOnHand.stream().
                filter(p -> p.getAsString().equals("S12")).
                findFirst();

        if(matchingObject.isPresent()){
                return true;
        }
        return false;
    }

}