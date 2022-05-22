package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PutStudentOnTableGUI{
	ObservableList<String> colorList = FXCollections.observableArrayList("Choose the student color", "RED", "GREEN", "BLUE", "PINK", "YELLOW");

	@FXML
	ImageView backgroundImage;
	@FXML
	ComboBox<String> colorOfStudent;
	@FXML
	GridPane gridPane;
	@FXML
	Button back;

	public void putStudentOnTable(){
		colorOfStudent.setValue("Choose the student color");
		colorOfStudent.setItems(colorList);
	}

	public void submitOnTable(ActionEvent event){
		SceneHandlerGUI.getInstance().sendResponse(new PutStudentOnTableResponse(colorOfStudent.getValue()));
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void back(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new BackResponse());
		SceneHandlerGUI.getInstance().startLoading();
	}
}
