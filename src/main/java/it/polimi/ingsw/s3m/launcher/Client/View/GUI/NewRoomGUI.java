package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.View.Response.NewRoomResponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class NewRoomGUI {


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


    public void selectTwoPlayers(MouseEvent event) {
        ControllerGUI.getInstance().getNewRoomResponse().setNumberOfPlayers(2);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().launchGameConfigMessage();
    }

    public void selectThreePlayers(MouseEvent event) {
        ControllerGUI.getInstance().getNewRoomResponse().setNumberOfPlayers(3);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().launchGameConfigMessage();
    }
    private Rectangle2D takeBorderScreen() {
        return Screen.getPrimary().getVisualBounds();
    }





    public void selectNormal(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().getNewRoomResponse().setExpertMode(false);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().launchSetNickname();
    }

    public void selectExpert(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().getNewRoomResponse().setExpertMode(true);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().launchSetNickname();
    }




    public void enterGame(ActionEvent event) {
        String nick = nickname.getText();
        ControllerGUI.getInstance().getNewRoomResponse().setNickname(nick);
        ControllerGUI.getInstance().startLoading();
        ControllerGUI.getInstance().sendResponse(ControllerGUI.getInstance().getNewRoomResponse());
    }



}
