package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public class GUIView extends View{
	ClientGUI client;

	public GUIView(ClientGUI client){
		this.client = client;
	}

	@Override
	public void login(LoginMessage loginMessage){
		ControllerGUI.getInstance().threadSleep(1000);
		ControllerGUI.getInstance().launchLogin(loginMessage);
		ControllerGUI.getInstance().closePrimaryStage();
	}

	@Override
	public void enterRoom(EnterRoomMessage enterRoomMessage){
		ControllerGUI.getInstance().launchEnterRoom(enterRoomMessage);
	}

	@Override
	public void newRoom(NewRoomMessage newRoomMessage){
		ControllerGUI.getInstance().launchNewRoom(newRoomMessage);
	}

	@Override
	public void notification(NotificationMessage notification){
		ControllerGUI.getInstance().launchNotification(notification);
	}

	@Override
	public void planningPhase(PlanningPhaseMessage planningPhaseMessage){
		ControllerGUI.getInstance().launchPlanningPhase(planningPhaseMessage);
	}

	@Override
	public void moveStudentsPhase(StudentsPhaseMessage moveStudentsPhaseMessage){
		ControllerGUI.getInstance().launchMoveStudentsPhase(moveStudentsPhaseMessage);
	}

	@Override
	public void playCharacterCard(PlayCharacterCardMessage playCharacterCardMessage){
		ControllerGUI.getInstance().launchPlayCharacterCard(playCharacterCardMessage);
	}

	@Override
	public void putStudentOnTable(PutStudentOnTableMessage putStudentOnTableMessage){
		ControllerGUI.getInstance().launchPutStudentOnTable();
	}

	@Override
	public void putStudentOnIsland(PutStudentOnIslandMessage putStudentOnIslandMessage){
		ControllerGUI.getInstance().launchPutStudentOnIsland();
	}

	@Override
	public void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage){
		ControllerGUI.getInstance().launchMotherNaturePhase(motherNaturePhaseMessage);
	}

	@Override
	public void chooseCloudPhase(CloudPhaseMessage cloudPhaseMessage){
		ControllerGUI.getInstance().launchCloudPhase(cloudPhaseMessage);
	}

	@Override
	public void moveMotherNature(MoveMotherNatureMessage moveMotherNatureMessage){
		ControllerGUI.getInstance().launchMoveMotherNature(moveMotherNatureMessage);
	}
}
