package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public class GUIView extends View{
	ClientGUI client;

	public GUIView(ClientGUI client){
		this.client = client;
	}

	@Override
	public void login(LoginMessage loginMessage){
		SceneHandlerGUI.getInstance().threadSleep(2000);
		SceneHandlerGUI.getInstance().launchLogin(loginMessage);
		SceneHandlerGUI.getInstance().closePrimaryStage();
	}

	@Override
	public void enterRoom(EnterRoomMessage enterRoomMessage){
		SceneHandlerGUI.getInstance().launchEnterRoom(enterRoomMessage);
	}

	@Override
	public void newRoom(NewRoomMessage newRoomMessage){
		SceneHandlerGUI.getInstance().launchNewRoom(newRoomMessage);
	}

	@Override
	public void notification(NotificationMessage notification){
		SceneHandlerGUI.getInstance().launchNotification(notification);
		SceneHandlerGUI.getInstance().threadSleep(1500);
	}

	@Override
	public void planningPhase(PlanningPhaseMessage planningPhaseMessage){
		SceneHandlerGUI.getInstance().launchPlanningPhase(planningPhaseMessage);
	}

	@Override
	public void moveStudentsPhase(StudentsPhaseMessage moveStudentsPhaseMessage){
		SceneHandlerGUI.getInstance().launchMoveStudentsPhase(moveStudentsPhaseMessage);
	}

	@Override
	public void playCharacterCard(PlayCharacterCardMessage playCharacterCardMessage){
		SceneHandlerGUI.getInstance().launchPlayCharacterCard(playCharacterCardMessage);
	}

	@Override
	public void putStudentOnTable(PutStudentOnTableMessage putStudentOnTableMessage){
		SceneHandlerGUI.getInstance().launchPutStudentOnTable();
	}

	@Override
	public void putStudentOnIsland(PutStudentOnIslandMessage putStudentOnIslandMessage){
		SceneHandlerGUI.getInstance().launchPutStudentOnIsland();
	}

	@Override
	public void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage){
		SceneHandlerGUI.getInstance().launchMotherNaturePhase(motherNaturePhaseMessage);
	}

	@Override
	public void chooseCloudPhase(CloudPhaseMessage cloudPhaseMessage){
		SceneHandlerGUI.getInstance().launchCloudPhase(cloudPhaseMessage);
	}

	@Override
	public void moveMotherNature(MoveMotherNatureMessage moveMotherNatureMessage){
		SceneHandlerGUI.getInstance().launchMoveMotherNature(moveMotherNatureMessage);
	}
}
