package no.ntnu.idatg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CardGameController implements Initializable {

    private Hand hand;
    private List<PlayingCard> cardsOnHand;

    @FXML
    private ImageView card1;

    @FXML
    private ImageView card2;

    @FXML
    private ImageView card3;

    @FXML
    private ImageView card4;

    @FXML
    private ImageView card5;

    @FXML
    private Button dealHandButton;

    @FXML
    private Button checkHandButton;

    @FXML
    private TextField flush;

    @FXML
    private TextField queenOfSpades;

    @FXML
    private TextField cardsOfHearts;

    @FXML
    private TextField sumOfTheFaces;

    @FXML
    private void onDealHandButtonClick(ActionEvent event){
    hand = new Hand();
    cardsOnHand = hand.getCardsOnHand();
    card1.setImage(this.getImage(cardsOnHand.get(0).getSuit(),cardsOnHand.get(0).getFace()));
    card2.setImage(this.getImage(cardsOnHand.get(1).getSuit(),cardsOnHand.get(1).getFace()));
    card3.setImage(this.getImage(cardsOnHand.get(2).getSuit(),cardsOnHand.get(2).getFace()));
    card4.setImage(this.getImage(cardsOnHand.get(3).getSuit(),cardsOnHand.get(3).getFace()));
    card5.setImage(this.getImage(cardsOnHand.get(4).getSuit(),cardsOnHand.get(4).getFace()));
    }

    @FXML
    private Image getImage(char suit, int face){
        String imageFace ;
        String imageSuit = "";
        switch (face){
            case 1:
                imageFace = "ace";
                break;
            case 11:
                imageFace = "jack";
                break;
            case 12:
                imageFace = "queen";
                break;
            case 13:
                imageFace = "king";
                break;
            default:
                imageFace = String.valueOf(face);
                break;

        }

        switch (suit){
            case 'D':
                imageSuit = "_of_diamonds";
                break;
            case 'S':
                imageSuit = "_of_spades";
                break;
            case 'C':
                imageSuit = "_of_clubs";
                break;
            case 'H':
                imageSuit = "_of_hearts";
                break;
        }

        return new Image(CardGameController.class.getResource("images/"+imageFace+imageSuit+".png").toExternalForm());

    }


    @FXML
    private void onCheckHandButtonClick(){
        String sum = String.valueOf(hand.getIntValueFromCardsOnHand());
        sumOfTheFaces.setText(sum);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}