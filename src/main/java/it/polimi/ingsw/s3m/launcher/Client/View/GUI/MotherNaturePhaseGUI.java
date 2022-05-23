package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.MotherNaturePhaseResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.MotherNaturePhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
		SceneHandlerGUI.getInstance().sendResponse(new MotherNaturePhaseResponse(1));
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void playCharacterCardAction(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new MotherNaturePhaseResponse(2));
		SceneHandlerGUI.getInstance().startLoading();
	}
}