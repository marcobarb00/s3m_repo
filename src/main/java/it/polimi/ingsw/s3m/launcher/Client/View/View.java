package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public abstract class View{

	public abstract void login(LoginMessage loginMessage);

	public abstract void enterRoom(EnterRoomMessage enterRoomMessage);

	public abstract void newRoom(NewRoomMessage newRoomMessage);

	public abstract void notification(NotificationMessage notification);

	public abstract void updateGameState(GameStateMessage gameState);

	public abstract void planningPhase(PlanningPhaseMessage planningPhaseMessage);

	public abstract void moveStudentsPhase(MoveStudentsPhaseMessage moveStudentsPhaseMessage);

	public abstract void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage);

	public abstract void chooseCloudPhase(ChooseCloudPhaseMessage chooseCloudPhaseMessage);
}
