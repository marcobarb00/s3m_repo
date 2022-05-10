package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Locale;

public class PutStudentOnTableGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    TextField colorOfStudent;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;

    public void submitOnTable(ActionEvent event){
        String colorStud = colorOfStudent.getText();
        ControllerGUI.getInstance().sendResponse(new PutStudentOnTableResponse(colorStud.toUpperCase(Locale.ROOT)));
        ControllerGUI.getInstance().startLoading();
    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }
}
