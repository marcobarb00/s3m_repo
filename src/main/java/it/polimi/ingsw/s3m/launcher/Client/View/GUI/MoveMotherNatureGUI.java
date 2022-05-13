package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.MoveMotherNatureResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveMotherNatureMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MoveMotherNatureGUI{
    @FXML
    ImageView backgroundImage;
    @FXML
    TextField numOfSteps;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;
    @FXML
    Label stepsLimit;

    public void printMessageInformation(MoveMotherNatureMessage message){
        GameDTO gameState = message.getGameState();
        int motherNatureMaxSteps = gameState.getCurrentPlayer().getLastCardPlayed().getMovements();

        stepsLimit.setText(String.valueOf(motherNatureMaxSteps));
    }

    public void submitMotherNatureOnIsland(ActionEvent event){
        int steps;
        try{
            steps = Integer.parseInt(numOfSteps.getText());
        }catch(NumberFormatException e){
            steps = -1;
        }
        ControllerGUI.getInstance().sendResponse(new MoveMotherNatureResponse(steps));
        ControllerGUI.getInstance().startLoading();
    }

    public void insert(MoveMotherNatureMessage message){
        GameDTO gameState = message.getGameState();
        stepsLimit.setText(String.valueOf(gameState.getMotherNaturePosition()));
    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }
}
