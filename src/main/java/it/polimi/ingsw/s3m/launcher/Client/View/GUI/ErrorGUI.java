package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GuiController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.Response.ErrorResponse;
import it.polimi.ingsw.s3m.launcher.Server.Message.ErrorMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ErrorGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    Label notification;


    public void insert(ErrorMessage message) {
        notification.setText(message.getMessage());
        ControllerGUI.getInstance().sendObject(new ErrorResponse());
    }
}
