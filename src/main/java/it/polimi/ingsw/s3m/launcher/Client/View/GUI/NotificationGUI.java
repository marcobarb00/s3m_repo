package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class NotificationGUI {

    @FXML
    ImageView backgroundImage;

    @FXML
    Label notification;

    public void insert(NotificationMessage object) {
        notification.setText(object.getMessage());
    }

}
