package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

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
	public void enterRoom(EnterRoomMessage enterRoomMessage){
		controllerGUI.launchEnterRoom(enterRoomMessage);
	}

	@Override
	public void newRoom(NewRoomMessage newRoomMessage){
		controllerGUI.launchNewRoom(newRoomMessage);
	}

	@Override
	public void notification(NotificationMessage notification){
		controllerGUI.launchNotification(notification);
	}

	@Override
	public void planningPhase(PlanningPhaseMessage planningPhaseMessage){

	}

	@Override
	public void moveStudentsPhase(StudentsPhaseMessage moveStudentsPhaseMessage){

	}

	@Override
	public void playCharacterCard(PlayCharacterCardMessage playCharacterCardMessage){
		controllerGUI.launchPlayCharacterCard(playCharacterCardMessage);
	}

	@Override
	public void putStudentOnTable(PutStudentOnTableMessage putStudentOnTableMessage){
		controllerGUI.launchPutStudentOnTable();
	}

	@Override
	public void putStudentOnIsland(PutStudentOnIslandMessage putStudentOnIslandMessage){
		controllerGUI.launchPutStudentOnIsland();
	}

	@Override
	public void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage){

	}

	@Override
	public void chooseCloudPhase(CloudPhaseMessage cloudPhaseMessage){

	}

	@Override
	public void moveMotherNature(MoveMotherNatureMessage moveMotherNatureMessage){
		controllerGUI.launchMoveMotherNature();
	}
}
