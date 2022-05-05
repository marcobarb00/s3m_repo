package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GuiController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.View.Response.LoginResponse;
import it.polimi.ingsw.s3m.launcher.Server.Message.LoginMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginGUI {

    @FXML
    ImageView backgroundImage;
    @FXML
    Button createButton;
    @FXML
    Button joinButton;
    @FXML
    VBox vBox;


    public void selectCreate(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendObject(new LoginResponse(true));
        ControllerGUI.getInstance().startLoading();
    }

    public void selectJoin(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendObject(new LoginResponse(false));
        ControllerGUI.getInstance().startLoading();
    }


}