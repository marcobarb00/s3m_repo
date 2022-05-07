package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Server.Message.*;

public abstract class View{

	public abstract void login(LoginMessage loginMessage);

	public abstract void enterRoom(EnterRoomMessage enterRoomMessage);

	public abstract void newRoom(NewRoomMessage newRoomMessage);

	public abstract void notification(NotificationMessage notification);

	public abstract void planningPhase(PlanningPhaseMessage planningPhaseMessage);

	public abstract void moveStudentsPhase(MoveStudentsPhaseMessage moveStudentsPhaseMessage);

	public abstract void playCharacterCard(PlayCharacterCardMessage playCharacterCardMessage);

	public abstract void putStudentOnTable(PutStudentOnTableMessage putStudentOnTableMessage);

	public abstract void putStudentOnIsland(PutStudentOnIslandMessage putStudentOnIslandMessage);

	public abstract void motherNaturePhase(MotherNaturePhaseMessage motherNaturePhaseMessage);

	public abstract void chooseCloudPhase(ChooseCloudPhaseMessage chooseCloudPhaseMessage);
}
