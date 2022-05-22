package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application{

	@Override
	public void start(Stage primaryStage){
		SceneHandlerGUI.getInstance().startGame(primaryStage);
	}

	public void startGUI(){
		launch();
	}
}
