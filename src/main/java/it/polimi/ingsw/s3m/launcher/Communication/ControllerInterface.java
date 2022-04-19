package it.polimi.ingsw.s3m.launcher.Communication;

public interface ControllerInterface{
	public NewRoomMessage executeNewRoom(NewRoomMessage newRoomMessage);
	public EnterRoomMessage executeEnterRoom(EnterRoomMessage enterRoomMessage);
}
