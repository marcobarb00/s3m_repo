package it.polimi.ingsw.s3m.launcher.Client.View.GUI;


import it.polimi.ingsw.s3m.launcher.Client.Response.StudentsPhaseResponse;
import it.polimi.ingsw.s3m.launcher.DTOs.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.StudentsPhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class MoveStudentsPhaseGUI extends GameStateGUI{

	@FXML
	ImageView studentOnTable;
	@FXML
	ImageView studentOnIsland;
	@FXML
	ImageView characterCardList;

	public void printMessageInformation(StudentsPhaseMessage studentsPhaseMessage){
		GameDTO gameState = studentsPhaseMessage.getGameState();

		setGameState(gameState);
	}

	public void studentOnTableAction(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new StudentsPhaseResponse(1));
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void studentOnIslandAction(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new StudentsPhaseResponse(2));
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void playCharacterCardAction(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new StudentsPhaseResponse(3));
		SceneHandlerGUI.getInstance().startLoading();
	}
}
