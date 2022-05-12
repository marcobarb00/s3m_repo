package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Locale;

public class PutStudentOnTableGUI {
    ObservableList<String> colorList = FXCollections.observableArrayList("Choose the student color", "RED", "GREEN", "BLUE", "PINK", "YELLOW");

    @FXML
    ImageView backgroundImage;
    @FXML
    ComboBox<String> colorOfStudent;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;

    public void submitOnTable(ActionEvent event){
        colorOfStudent.setValue("Choose the student color");
        colorOfStudent.setItems(colorList);

        ControllerGUI.getInstance().sendResponse(new PutStudentOnTableResponse(colorOfStudent.getValue()));
        ControllerGUI.getInstance().startLoading();
    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }
}
