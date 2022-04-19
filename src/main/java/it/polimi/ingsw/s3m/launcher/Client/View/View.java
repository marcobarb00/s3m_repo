package it.polimi.ingsw.s3m.launcher.Client.View;

import it.polimi.ingsw.s3m.launcher.Communication.*;

public abstract class View{
	String nickname;

	public abstract RoomMessage roomChoice();

	public abstract EnterRoomMessage enterRoom();

	public abstract NewRoomMessage newRoom();

	public abstract void showEnterRoomResult(EnterRoomMessage enterRoomResult);

	public abstract void showNewRoomResult(NewRoomMessage newRoomResult);
}
