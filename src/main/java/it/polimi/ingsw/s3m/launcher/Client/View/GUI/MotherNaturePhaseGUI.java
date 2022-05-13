package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MotherNaturePhaseResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CloudDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.MotherNaturePhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.*;

public class MotherNaturePhaseGUI extends GameStateGUI{
	@FXML
	ImageView moveMotherNature;
	@FXML
	ImageView characterCardList;

	public void printMessageInformation(MotherNaturePhaseMessage motherNaturePhaseMessage){
		GameDTO gameState = motherNaturePhaseMessage.getGameState();

		setGameState(gameState);
	}

	public void moveMotherNatureAction(MouseEvent mouseEvent){
		ControllerGUI.getInstance().sendResponse(new MotherNaturePhaseResponse(1));
		ControllerGUI.getInstance().startLoading();
	}

	public void playCharacterCardAction(MouseEvent mouseEvent){
		ControllerGUI.getInstance().sendResponse(new MotherNaturePhaseResponse(2));
		ControllerGUI.getInstance().startLoading();
	}
}