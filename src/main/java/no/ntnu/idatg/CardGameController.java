package no.ntnu.idatg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class CardGameController implements Initializable {

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
    private void onDealHandButtonClick(ActionEvent event){

    }

    @FXML
    private void onCheckHandButtonClick(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Hand hand = new Hand();
    }
}