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
import org.controlsfx.control.spreadsheet.Grid;

public class MinstrelGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;
    @FXML
    ComboBox<String> colorOfStudent1;
    @FXML
    ComboBox<String> colorOfStudent2;
    @FXML
    ComboBox<String> colorOfChange1;
    @FXML
    ComboBox<String> colorOfChange2;

    public void showMinstrelInfo(){

    }

    public void submitMinstrel(ActionEvent action){

    }
    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }

}
