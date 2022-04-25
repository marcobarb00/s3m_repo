package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.*;

public abstract class View{

	public abstract void login(LoginMessage loginMessage);

	public abstract void enterRoom(EnterRoomMessage enterRoomMessage);

	public abstract void newRoom(NewRoomMessage newRoomMessage);

	public abstract void notification(NotificationMessage notification);

	public abstract void operationChoice(OperationChoiceMessage operationChoice);
}
