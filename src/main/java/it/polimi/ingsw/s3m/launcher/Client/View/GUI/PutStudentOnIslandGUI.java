package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnIslandResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.List;

public class PutStudentOnIslandGUI {
    @FXML
    ImageView backgroundImage;
    @FXML
    TextField colorOfStudent;
    @FXML
    TextField numOfIsland;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;

    public void submitOnIsland(ActionEvent event) {
        String colorStud = colorOfStudent.getText();
        int numIsland;
        try{
            numIsland = Integer.parseInt(numOfIsland.getText());
        }catch(NumberFormatException e){
            numIsland = -1;
        }
        ControllerGUI.getInstance().sendResponse(new PutStudentOnIslandResponse(colorStud, numIsland));
        ControllerGUI.getInstance().startLoading();
    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }
}