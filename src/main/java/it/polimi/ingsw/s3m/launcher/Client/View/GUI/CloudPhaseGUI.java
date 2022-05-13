package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.CloudResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CloudDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.CloudPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.*;

public class CloudPhaseGUI extends GameStateGUI{
    @FXML
    TextField numOfCloud;
    @FXML
    GridPane gridPaneCloudOne;
    @FXML
    GridPane gridPaneCloudTwo;
    @FXML
    GridPane gridPaneCloudThree;
    @FXML
    GridPane gridPane;

	public void printMessageInformation(CloudPhaseMessage cloudPhaseMessage){
        GameDTO gameState = cloudPhaseMessage.getGameState();
        setGameState(gameState);
	}

    public void submitCloudChosen(ActionEvent actionEvent) {
        int cloudChoice;
        try{
            cloudChoice = Integer.parseInt(numOfCloud.getText());
        }catch(NumberFormatException e){
            cloudChoice = -1;
        }
        ControllerGUI.getInstance().sendResponse(new CloudResponse(cloudChoice));
        ControllerGUI.getInstance().startLoading();
    }
}
