package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Server.Message.NotificationMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.List;

public class PutMotherNatureOnIslandGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    TextField numOfSteps;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;
    @FXML
    Label stepsLimit;

    private String stepsMotherNatureOnIslandOnIsland;
    private List<String> stepsRequested;

    public void submitMotherNatureOnIsland(ActionEvent event){
        String steps = numOfSteps.getText();
        ControllerGUI.getInstance().getNewRoomResponse().setNickname(steps);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().sendResponse(ControllerGUI.getInstance().getNewRoomResponse());
    }

    public void insert(NotificationMessage object){
        stepsLimit.setText(object.getMessage());
    }

    public void back(MouseEvent mouseEvent) {
        stepsRequested.clear();
        stepsMotherNatureOnIslandOnIsland = "";
        stepsRequested.add("BACK");
        ControllerGUI.getInstance().sendObject(new ProductionMessage(resRequested,resProduced,resForFirstLeader,resForSecondLeader));
        ControllerGUI.getInstance().startLoading();
    }
}
