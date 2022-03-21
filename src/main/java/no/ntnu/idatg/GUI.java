package no.ntnu.idatg;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    private Hand hand;
    private List<PlayingCard> cardsOnHand;
    private DeckOfCards deckOfCards;

    public GUI(){
        hand = new Hand();
    }

    /**
     * Method used to calculate a sum expression.
     *
     * @param hand the hand to be calculated as int
     * @return the answer as an int
     */
    public int sum(Hand hand){
        return hand.getIntValueFromCardsOnHand();
        }


    public void showAllHeartsOnHand(Hand hand){

        if(hand.getAllHeartCardsOnHand().size() == 0){
            System.err.println("No hearts on hand");
        }

        else{
            System.out.println(hand.getAllHeartCardsOnHand());
        }
    }

    //I denne oppgaven skal du analysere kortene på hånd (se punktliste under) når brukeren trykker på "Check hand" knappen i forslaget til GUI over for eksempel.
    //Her er det meningen at du skal anvende streams med tilhørende funskjoner for filtrering, map, reduce osv. Prøv å løse så mange som du klarer av følgende:
    //Regn ut summen av alle verdiene av kortene på hånd (ess = 1)
    //Hent ut bare kort som er av fargen "Hjerter", og vis i et tekstfelt på formen "H12 H9 H1". Dersom det ikke er noen Hjerter på hånd, kan tekstfeltet inneholde teksten "No Hearts", for eksempel.
    //Sjekk om kortet "Spar dame" finnes blant kortene på hånden.
    //Sjekk om kortene på hånd utgjør en "5-flush". D.v.s. 5 kort av samme farge (5 hjerter eller 5 ruter eller 5 kløver eller 5 spar).
}
