package it.polimi.ingsw.s3m.launcher.Client.View.GUIController;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application{

	@Override
	public void start(Stage primaryStage){
		ControllerGUI.getInstance().startGame(primaryStage);
	}

	public void startGUI(){
		launch();
	}
}
