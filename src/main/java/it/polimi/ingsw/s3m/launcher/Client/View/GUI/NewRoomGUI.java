package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GuiController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Server.Message.LoginMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
    TextArea otherIDRoom;
    @FXML
    GridPane gridPane;




    public void selectTwoPlayers(MouseEvent event) {
        NumberOfPlayersMessage number = new NumberOfPlayersMessage(2);
        ControllerGUI.getInstance().sendObject(number);
        ControllerGUI.getInstance().startLoading();
    }

    public void selectThreePlayers(MouseEvent event) {
        NumberOfPlayersMessage number = new NumberOfPlayersMessage(3);
        ControllerGUI.getInstance().sendObject(number);
        ControllerGUI.getInstance().startLoading();
    }
    private Rectangle2D takeBorderScreen() {
        return Screen.getPrimary().getVisualBounds();
    }





    public void selectNormal(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendObject(new GameConfigMessage(false));
        ControllerGUI.getInstance().startLoading();
    }

    public void selectExpert(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendObject(new GameConfigMessage(true));
        ControllerGUI.getInstance().startLoading();
    }




    public void enterGame(ActionEvent event) {
        String nick = nickname.getText();
        ControllerGUI.getInstance().sendObject(new LoginMessage(nick));
        ControllerGUI.getInstance().startLoading();
    }



}
