package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnIslandResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PutStudentOnIslandGUI{
	ObservableList<String> colorList = FXCollections.observableArrayList("Choose the student color", "RED", "GREEN", "BLUE", "PINK", "YELLOW");

	@FXML
	ImageView backgroundImage;
	@FXML
	ComboBox<String> colorOfStudent;
	@FXML
	TextField numOfIsland;
	@FXML
	GridPane gridPane;
	@FXML
	Button back;

	public void putStudentOnIsland(){
		colorOfStudent.setValue("Choose the student color");
		colorOfStudent.setItems(colorList);
	}

	public void submitOnIsland(ActionEvent event){
		int numIsland;
		try{
			numIsland = Integer.parseInt(numOfIsland.getText());
		}catch(NumberFormatException e){
			numIsland = -1;
		}

		SceneHandlerGUI.getInstance().sendResponse(new PutStudentOnIslandResponse(colorOfStudent.getValue(), numIsland));
		SceneHandlerGUI.getInstance().startLoading();
	}

	public void back(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new BackResponse());
		SceneHandlerGUI.getInstance().startLoading();
	}
}
