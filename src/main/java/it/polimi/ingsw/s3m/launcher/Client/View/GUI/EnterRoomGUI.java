package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.EnterRoomResponse;
import it.polimi.ingsw.s3m.launcher.Server.Message.EnterRoomMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class EnterRoomGUI{

	@FXML
	ComboBox<String> otherIDRoom;
	@FXML
	TextField nickname;
	@FXML
	TextField roomID;
	@FXML
	ImageView backgroundImage;
	@FXML
	GridPane gridPane;

	private final EnterRoomResponse enterRoomResponse = new EnterRoomResponse();

	public void enterGame(ActionEvent event){
		String nick = nickname.getText();
		enterRoomResponse.setNickname(nick);
		int roomIDChoice;
		try{
			roomIDChoice = Integer.parseInt(otherIDRoom.getValue());
		}catch(NumberFormatException e){
			roomIDChoice = 0;
		}
		enterRoomResponse.setRoomID(roomIDChoice);
		SceneHandlerGUI.getInstance().startLoading();
		SceneHandlerGUI.getInstance().sendResponse(enterRoomResponse);
	}

	public void setCreatedRoom(EnterRoomMessage message){
		ArrayList<String> availableRoom = new ArrayList<>();
		message.getAvailableRoomsID().forEach((roomID) -> {
			availableRoom.add(roomID.toString());
		});
		ObservableList<String> availableRoomFXStringList = FXCollections.observableArrayList(availableRoom);

		otherIDRoom.setValue("choose the room ID");
		otherIDRoom.setItems(availableRoomFXStringList);
	}
}
