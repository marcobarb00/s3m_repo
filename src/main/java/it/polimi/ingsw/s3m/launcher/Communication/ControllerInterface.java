package it.polimi.ingsw.s3m.launcher.Communication;

public interface ControllerInterface{
	NewRoomMessage executeNewRoom(NewRoomMessage newRoomMessage);
	EnterRoomMessage executeEnterRoom(EnterRoomMessage enterRoomMessage);
	void readNotification(NotificationMessage notification);
}
