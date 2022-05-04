package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GuiController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginGUI {

    @FXML
    TextField nickname;
    @FXML
    TextArea otherIDRoom;
    @FXML
    ImageView backgroundImage;
    @FXML
    GridPane gridPane;

    public void enterGame(ActionEvent event) {
        String nick = nickname.getText();
        /*ControllerGUI.getInstance().sendObject(new LoginMessage(nick));
        ControllerGUI.getInstance().startLoading();*/
    }

    public void setConnectedUsers(LoginMessage object, Stage secondaryStage) {
        /*if (object.getPlayers() != null) {
            for (String player : object.getPlayers())
                connected.appendText(player + "\n");
        }*/


    }
}