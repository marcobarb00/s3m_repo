package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.EnterRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Communication.NewRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;

public abstract class View{

	public abstract void login(LoginMessage loginMessage);

	public abstract void enterRoom(EnterRoomMessage enterRoomMessage);

	public abstract void newRoom(NewRoomMessage newRoomMessage);
}
