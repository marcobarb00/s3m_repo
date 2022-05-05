package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.CLI.ClientCLI;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public class GUIView extends View{
	ClientGUI client;
	private ControllerGUI controllerGUI;

	public GUIView(ClientGUI client, ControllerGUI controllerGUI){
		this.client = client;
		this.controllerGUI = controllerGUI;
	}

	@Override
	public void login(LoginMessage loginMessage){
		controllerGUI.threadSleep(3000);
		controllerGUI.launchLogin(loginMessage);
		controllerGUI.closePrimaryStage();
	}

	@Override
	public void enterRoom(EnterRoomMessage enterRoomMessage){}

	@Override
	public void newRoom(NewRoomMessage newRoomMessage){
		controllerGUI.launchNewRoom(newRoomMessage);
	}

	@Override
	public void notification(NotificationMessage notification){

	}

	@Override
	public void updateGameState(GameStateMessage gameState){

	}

	@Override
	public void planningPhase(PlanningPhaseMessage planningPhaseMessage){

	}

	@Override
	public void moveStudentsPhase(MoveStudentsPhaseMessage moveStudentsPhaseMessage){

	}

	@Override
	public void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage){

	}

	@Override
	public void chooseCloudPhase(ChooseCloudPhaseMessage chooseCloudPhaseMessage){

	}
}
