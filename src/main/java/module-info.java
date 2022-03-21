module no.ntnu.idatg {
    requires javafx.controls;
    requires javafx.fxml;


    opens no.ntnu.idatg to javafx.fxml;
    exports no.ntnu.idatg;
}