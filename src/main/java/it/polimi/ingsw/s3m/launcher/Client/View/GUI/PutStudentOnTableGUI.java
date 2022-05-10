package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.List;

public class PutStudentOnTableGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    TextField colorOfStudent;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;

    private String colorOfStudenstOnIsland;
    private List<String> sudentsRequested;



    public void submitOnTable(ActionEvent event){
        String colorStud = colorOfStudent.getText();
        ControllerGUI.getInstance().getNewRoomResponse().setNickname(colorStud);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().sendResponse(ControllerGUI.getInstance().getNewRoomResponse());
    }

    public void back(MouseEvent mouseEvent) {
        sudentsRequested.clear();
        colorOfStudenstOnIsland = "";
        sudentsRequested.add("BACK");
        ControllerGUI.getInstance().sendObject(new ProductionMessage(resRequested,resProduced,resForFirstLeader,resForSecondLeader));
        ControllerGUI.getInstance().startLoading();
    }
}
