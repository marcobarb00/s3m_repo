package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.CloudResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.CloudPhaseMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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

	public void submitCloudChosen(ActionEvent actionEvent){
		int cloudChoice;
		try{
			cloudChoice = Integer.parseInt(numOfCloud.getText());
		}catch(NumberFormatException e){
			cloudChoice = -1;
		}
		SceneHandlerGUI.getInstance().sendResponse(new CloudResponse(cloudChoice));
		SceneHandlerGUI.getInstance().startLoading();
	}
}
