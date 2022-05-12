package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
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

import java.util.ArrayList;

public class JesterGUI {
    ObservableList<String> colorList = FXCollections.observableArrayList("Choose the student color", "RED", "GREEN", "BLUE", "PINK", "YELLOW");

    @FXML
    ImageView backgroundImage;
    @FXML
    GridPane gridPane;
    @FXML
    GridPane gridPaneJesterStudents;
    @FXML
    Button back;
    @FXML
    ComboBox<String> colorOfStudent1; //student from jester to entrance
    @FXML
    ComboBox<String> colorOfStudent2; //student from jester to entrance
    @FXML
    ComboBox<String> colorOfStudent3; //student from jester to entrance
    @FXML
    ComboBox<String> colorOfChange1; //student from entrance to jester
    @FXML
    ComboBox<String> colorOfChange2; //student from entrance to jester
    @FXML
    ComboBox<String> colorOfChange3; //student from entrance to jester
    @FXML
    ImageView jesterStudentOne;
    @FXML
    ImageView jesterStudentTwo;
    @FXML
    ImageView jesterStudentThree;
    @FXML
    ImageView jesterStudentFour;
    @FXML
    ImageView jesterStudentFive;
    @FXML
    ImageView jesterStudentSix;


    public void showJesterInfo(){
        colorOfStudent1.setValue("Choose the student color");
        colorOfStudent1.setItems(colorList);

        colorOfStudent2.setValue("Choose the student color");
        colorOfStudent2.setItems(colorList);

        colorOfStudent3.setValue("Choose the student color");
        colorOfStudent3.setItems(colorList);

        colorOfChange1.setValue("Choose the student color");
        colorOfChange1.setItems(colorList);

        colorOfChange2.setValue("Choose the student color");
        colorOfChange2.setItems(colorList);

        colorOfChange3.setValue("Choose the student color");
        colorOfChange3.setItems(colorList);
    }

    public void submitJester(ActionEvent action){
        ArrayList<String> studentsToPutOnJester = new ArrayList<>();
        ArrayList<String> studentsToGetFromJester = new ArrayList<>();

        if(isAColor(colorOfStudent1.getValue()))
            studentsToGetFromJester.add(colorOfStudent1.getValue());
        if(isAColor(colorOfStudent2.getValue()))
            studentsToGetFromJester.add(colorOfStudent2.getValue());
        if(isAColor(colorOfStudent3.getValue()))
            studentsToGetFromJester.add(colorOfStudent3.getValue());

        if(isAColor(colorOfChange1.getValue()))
            studentsToPutOnJester.add(colorOfChange1.getValue());
        if(isAColor(colorOfChange2.getValue()))
            studentsToPutOnJester.add(colorOfChange2.getValue());
        if(isAColor(colorOfChange3.getValue()))
            studentsToPutOnJester.add(colorOfChange3.getValue());

        ControllerGUI.getInstance().getPlayCharacterCardResponse().setStudentsToPutOn(studentsToPutOnJester);
        ControllerGUI.getInstance().getPlayCharacterCardResponse().setStudentsToGetFrom(studentsToGetFromJester);
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
