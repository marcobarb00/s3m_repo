package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class JesterGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;
    @FXML
    ComboBox colorOfStudent1;
    @FXML
    ComboBox colorOfStudent2;
    @FXML
    ComboBox colorOfStudent3;
    @FXML
    ComboBox colorOfChange1;
    @FXML
    ComboBox colorOfChange2;
    @FXML
    ComboBox colorOfChange3;


    public void submitJester(ActionEvent action){

    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }

}
