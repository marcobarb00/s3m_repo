package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class NewRoomGUI{


	@FXML
	ImageView backgroundImage;
	@FXML
	VBox vBox;


	@FXML
	Button normalButton;
	@FXML
	Button expertButton;


	@FXML
	Button twoPlayersButton;
	@FXML
	Button threePlayersButton;


	@FXML
	TextField nickname;
	@FXML
	GridPane gridPane;


	public void selectTwoPlayers(MouseEvent event){
		SceneHandlerGUI.getInstance().getNewRoomResponse().setNumberOfPlayers(2);
		SceneHandlerGUI.getInstance().startLoading();
		SceneHandlerGUI.getInstance().launchGameConfigMessage();
	}

	public void selectThreePlayers(MouseEvent event){
		SceneHandlerGUI.getInstance().getNewRoomResponse().setNumberOfPlayers(3);
		SceneHandlerGUI.getInstance().startLoading();
		SceneHandlerGUI.getInstance().launchGameConfigMessage();
	}

	public void selectNormal(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().getNewRoomResponse().setExpertMode(false);
		SceneHandlerGUI.getInstance().startLoading();
		SceneHandlerGUI.getInstance().launchSetNickname();
	}

	public void selectExpert(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().getNewRoomResponse().setExpertMode(true);
		SceneHandlerGUI.getInstance().startLoading();
		SceneHandlerGUI.getInstance().launchSetNickname();
	}


	public void enterGame(ActionEvent event){
		String nick = nickname.getText();
		SceneHandlerGUI.getInstance().getNewRoomResponse().setNickname(nick);
		SceneHandlerGUI.getInstance().startLoading();
		SceneHandlerGUI.getInstance().sendResponse(SceneHandlerGUI.getInstance().getNewRoomResponse());
	}


}
