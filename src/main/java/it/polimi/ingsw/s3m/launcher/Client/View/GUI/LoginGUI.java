package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.LoginResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
        ControllerGUI.getInstance().sendResponse(new LoginResponse(true));
        ControllerGUI.getInstance().startLoading();
    }

    public void selectJoin(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new LoginResponse(false));
        ControllerGUI.getInstance().startLoading();
    }


}