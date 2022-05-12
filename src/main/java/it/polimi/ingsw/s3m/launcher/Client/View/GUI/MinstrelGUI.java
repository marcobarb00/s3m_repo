package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayCharacterCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.spreadsheet.Grid;

import java.util.ArrayList;
import java.util.Locale;

public class MinstrelGUI {
    ObservableList<String> colorList = FXCollections.observableArrayList("Choose the student color", "RED", "GREEN", "BLUE", "PINK", "YELLOW");

    @FXML
    ImageView backgroundImage;
    @FXML
    GridPane gridPane;
    @FXML
    Button back;
    @FXML
    ComboBox<String> colorOfStudent1; //student from tables to entrance
    @FXML
    ComboBox<String> colorOfStudent2; //student from tables to entrance
    @FXML
    ComboBox<String> colorOfChange1; //student from entrance to table
    @FXML
    ComboBox<String> colorOfChange2; //student from entrance to table

    public void showMinstrelInfo(){
        colorOfStudent1.setValue("Choose the student color");
        colorOfStudent1.setItems(colorList);

        colorOfStudent2.setValue("Choose the student color");
        colorOfStudent2.setItems(colorList);

        colorOfChange1.setValue("Choose the student color");
        colorOfChange1.setItems(colorList);

        colorOfChange2.setValue("Choose the student color");
        colorOfChange2.setItems(colorList);
    }

    public void submitMinstrel(ActionEvent action){
        ArrayList<String> studentsToPutOnTable = new ArrayList<>();
        ArrayList<String> studentsToGetFromTable = new ArrayList<>();

        if(isAColor(colorOfStudent1.getValue()))
            studentsToGetFromTable.add(colorOfStudent1.getValue());
        if(isAColor(colorOfStudent2.getValue()))
            studentsToGetFromTable.add(colorOfStudent2.getValue());

        if(isAColor(colorOfChange1.getValue()))
            studentsToPutOnTable.add(colorOfChange1.getValue());
        if(isAColor(colorOfChange2.getValue()))
            studentsToPutOnTable.add(colorOfChange2.getValue());

        ControllerGUI.getInstance().getPlayCharacterCardResponse().setStudentsToPutOn(studentsToPutOnTable);
        ControllerGUI.getInstance().getPlayCharacterCardResponse().setStudentsToGetFrom(studentsToGetFromTable);
        ControllerGUI.getInstance().sendCharacterCardResponse();
    }

    private boolean isAColor(String string){
        return string.equalsIgnoreCase("RED") || string.equalsIgnoreCase("GREEN") ||
                string.equalsIgnoreCase("BLUE") || string.equalsIgnoreCase("PINK") ||
                string.equalsIgnoreCase("YELLOW");
    }

    public void back(MouseEvent mouseEvent) {
        ControllerGUI.getInstance().sendResponse(new BackResponse());
        ControllerGUI.getInstance().startLoading();
    }

}
