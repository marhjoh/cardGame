package no.ntnu.idatg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

/**
 * Represents the card game controller.
 *
 * @author Martin Hegnum Johannessen
 * @version 2022-03-21
 */
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
    private MenuItem closeMenuItem;

    /**
     * Creates a new hand of 5 cards, and distributes the image that matches each card's suit and face.
     */
    @FXML
    private void onDealHandButtonClick(){
    hand = new Hand();
    cardsOnHand = hand.getCardsOnHand();
    card1.setImage(this.getImage(cardsOnHand.get(0).getSuit(),cardsOnHand.get(0).getFace()));
    card2.setImage(this.getImage(cardsOnHand.get(1).getSuit(),cardsOnHand.get(1).getFace()));
    card3.setImage(this.getImage(cardsOnHand.get(2).getSuit(),cardsOnHand.get(2).getFace()));
    card4.setImage(this.getImage(cardsOnHand.get(3).getSuit(),cardsOnHand.get(3).getFace()));
    card5.setImage(this.getImage(cardsOnHand.get(4).getSuit(),cardsOnHand.get(4).getFace()));
    }

    /**
     * Returns the image that matches the given card's suit and face
     *
     * @param suit the suit of the playing card
     * @param face the face of the playing card
     *
     * @return an image that matches the given card's suit and face
     */
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

    /**
     * When the check hand button is pressed, it will sum the hand value, check if the hand contains a flush,
     * check if the hand contains queen of spades and get all the heart cards on the hand
     *
     * TODO: Hvis hånd ikke er delt ut, pop up error melding.
     */
    @FXML
    private void onCheckHandButtonClick(){
        String sum = String.valueOf(hand.getIntValueFromCardsOnHand());
        sumOfTheFaces.setText(sum);

        String checkFlush = String.valueOf(hand.checkFlushWithMapValues());
        flush.setText(checkFlush);

        String checkQueenOfSpades = String.valueOf(hand.checkQueenOfSpades());
        queenOfSpades.setText(checkQueenOfSpades);

        String heartCardsOnHand = String.valueOf(hand.getAllHeartCardsOnHand());
        cardsOfHearts.setText(heartCardsOnHand);
    }

    /**
     * Creates an alert box if the close button is pressed
     *
     * TODO: Thrower exception ingen tar imot
     */
    @FXML
    private void onCloseMenuItemClick(){
        Alert closeApplicationAlert = new Alert(Alert.AlertType.INFORMATION);
        closeApplicationAlert.setTitle("Exit Application");// line 2
        closeApplicationAlert.setHeaderText("Exiting the Card Game Application");// line 3
        closeApplicationAlert.setContentText("Are you sure you want to exit the application?");// line 4
        if (closeApplicationAlert.showAndWait().get() == ButtonType.OK) {
            exit();
        } else {
            closeApplicationAlert.close();
        }
    }

    /**
     * This method will initialize the application
     *
     * @param url the url of the application
     * @param resourceBundle the resource bundle of the application
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}