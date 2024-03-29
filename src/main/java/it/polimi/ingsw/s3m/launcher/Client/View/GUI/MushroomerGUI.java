package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MushroomerGUI{
	ObservableList<String> colorList = FXCollections.observableArrayList("Choose the student color", "RED", "GREEN", "BLUE", "PINK", "YELLOW");

	@FXML
	ImageView backgroundImage;
	@FXML
	GridPane gridPane;
	@FXML
	Button back;
	@FXML
	ComboBox<String> colorOfStudent1;

	public void showMushroomerInfo(){
		colorOfStudent1.setValue("Choose the student color");
		colorOfStudent1.setItems(colorList);
	}

	public void submitMushroomer(ActionEvent action){
		String nonInfluencingColor = null;

		if(isAColor(colorOfStudent1.getValue()))
			nonInfluencingColor = colorOfStudent1.getValue();

		SceneHandlerGUI.getInstance().getPlayCharacterCardResponse().setNonInfluencingColor(nonInfluencingColor);
		SceneHandlerGUI.getInstance().sendCharacterCardResponse();
	}

	private boolean isAColor(String string){
		return string.equalsIgnoreCase("RED") || string.equalsIgnoreCase("GREEN") ||
				string.equalsIgnoreCase("BLUE") || string.equalsIgnoreCase("PINK") ||
				string.equalsIgnoreCase("YELLOW");
	}

	public void back(MouseEvent mouseEvent){
		SceneHandlerGUI.getInstance().sendResponse(new BackResponse());
		SceneHandlerGUI.getInstance().startLoading();
	}
}
