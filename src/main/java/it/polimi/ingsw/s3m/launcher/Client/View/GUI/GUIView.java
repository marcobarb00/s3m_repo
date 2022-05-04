package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public class GUIView extends View{

	@Override
	public void login(LoginMessage loginMessage){}

	@Override
	public void enterRoom(EnterRoomMessage enterRoomMessage){}

	@Override
	public void newRoom(NewRoomMessage newRoomMessage){}

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
