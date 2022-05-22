package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.MoveMotherNatureResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveMotherNatureMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MoveMotherNatureGUI{
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

	public void printMessageInformation(MoveMotherNatureMessage message){
		GameDTO gameState = message.getGameState();
		int motherNatureMaxSteps = gameState.getTurn().getMotherNatureMaxAllowedMovements();

		stepsLimit.setText(String.valueOf(motherNatureMaxSteps));
	}

	public void submitMotherNatureOnIsland(ActionEvent event){
		int steps;
		try{
			steps = Integer.parseInt(numOfSteps.getText());
		}catch(NumberFormatException e){
			steps = -1;
		}
		SceneHandlerGUI.getInstance().sendResponse(new MoveMotherNatureResponse(steps));
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void insert(MoveMotherNatureMessage message){
		GameDTO gameState = message.getGameState();
		stepsLimit.setText(String.valueOf(gameState.getMotherNaturePosition()));
	}

	public void back(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new BackResponse());
		SceneHandlerGUI.getInstance().startLoading();
	}
}
