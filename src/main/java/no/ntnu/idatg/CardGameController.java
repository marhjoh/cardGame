package no.ntnu.idatg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.Optional;
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

    // Define a boolean flag to track if the hand has been dealt
    private boolean handDealt = false;

    /**
     * When the check hand button is pressed, it will sum the hand value, check if the hand contains a flush,
     * check if the hand contains the queen of spades, and get all the heart cards on the hand.
     */
    @FXML
    private void onCheckHandButtonClick() {
        // Check if any cards have been dealt
        if (hand == null || hand.getCardsOnHand().isEmpty()) {
            // No cards have been dealt, show an alert
            Alert noCardsAlert = new Alert(Alert.AlertType.WARNING);
            noCardsAlert.setTitle("No Cards Dealt");
            noCardsAlert.setHeaderText("No cards have been dealt.");
            noCardsAlert.setContentText("Please deal a hand before checking.");

            ButtonType dealHandButton = new ButtonType("Deal Hand");
            ButtonType closeButton = new ButtonType("Close", ButtonBar.ButtonData.CANCEL_CLOSE);
            noCardsAlert.getButtonTypes().setAll(dealHandButton, closeButton);

            Optional<ButtonType> result = noCardsAlert.showAndWait();
            if (result.isPresent() && result.get() == dealHandButton) {
                // User chose to deal a hand, you can call the deal hand method here
                onDealHandButtonClick();
            }
        } else {
            // Cards have been dealt, perform the hand check
            String sum = String.valueOf(hand.getIntValueFromCardsOnHand());
            sumOfTheFaces.setText(sum);

            String checkFlush = String.valueOf(hand.checkFlushWithMapValues());
            flush.setText(checkFlush);

            String checkQueenOfSpades = String.valueOf(hand.checkQueenOfSpades());
            queenOfSpades.setText(checkQueenOfSpades);

            String heartCardsOnHand = String.valueOf(hand.getAllHeartCardsOnHand());
            cardsOfHearts.setText(heartCardsOnHand);
        }
    }


    /**
     * Creates an alert box if the close button is pressed
     */
    @FXML
    private void onCloseMenuItemClick() {
        Alert closeApplicationAlert = new Alert(Alert.AlertType.INFORMATION);
        closeApplicationAlert.setTitle("Exit Application");
        closeApplicationAlert.setHeaderText("Exiting the Card Game Application");
        closeApplicationAlert.setContentText("Are you sure you want to exit the application?");
        Optional<ButtonType> result = closeApplicationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            // User chose not to exit, do nothing or handle it as needed
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