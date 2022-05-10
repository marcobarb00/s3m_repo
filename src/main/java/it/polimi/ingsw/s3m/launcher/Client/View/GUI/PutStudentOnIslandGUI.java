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

public class PutStudentOnIslandGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    TextField colorOfStudent;
    @FXML
    TextField numOfIsland;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;

    private String colorOfStudentOnIsland;
    private String islandNumber;
    private List<String> sudentsRequested;


    public void submitOnIsland(ActionEvent event) {
        String colorStud = colorOfStudent.getText();
        String numIsland = numOfIsland.getText();
        ControllerGUI.getInstance().getNewRoomResponse().setNickname(colorStud);
        ControllerGUI.getInstance().getNewRoomResponse().setNickname(numIsland);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().sendResponse(ControllerGUI.getInstance().getNewRoomResponse());
    }

    public void back(MouseEvent mouseEvent) {
        sudentsRequested.clear();
        islandNumber = "";
        colorOfStudentOnIsland = "";
        sudentsRequested.add("BACK");
        ControllerGUI.getInstance().sendObject(new ProductionMessage(resRequested, resProduced, resForFirstLeader, resForSecondLeader));
        ControllerGUI.getInstance().startLoading();
    }
}
