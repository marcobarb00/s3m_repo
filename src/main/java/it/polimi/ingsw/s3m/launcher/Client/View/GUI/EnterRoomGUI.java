package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.View.Response.EnterRoomResponse;
import it.polimi.ingsw.s3m.launcher.Server.Message.EnterRoomMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class EnterRoomGUI {

    @FXML
    TextField nickname;
    @FXML
    TextField roomID;
    @FXML
    Label otherIDRoom;
    @FXML
    ImageView backgroundImage;
    @FXML
    GridPane gridPane;

    private EnterRoomResponse enterRoomResponse = new EnterRoomResponse();

    public void enterGame(ActionEvent event) {
        String nick = nickname.getText();
        enterRoomResponse.setNickname(nick);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().sendResponse(enterRoomResponse);
    }

    public void setCreatedRoom(EnterRoomMessage message) {
        if (message.getAvailableRoomsID() != null) {
            for (Integer roomID : message.getAvailableRoomsID())
                otherIDRoom.setText(roomID + "\n");
        }
    }
}
