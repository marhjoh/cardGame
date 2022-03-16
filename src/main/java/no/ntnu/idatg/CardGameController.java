package no.ntnu.idatg;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CardGameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}