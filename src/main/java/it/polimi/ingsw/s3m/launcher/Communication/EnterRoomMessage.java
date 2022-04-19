package it.polimi.ingsw.s3m.launcher.Communication;

public class EnterRoomMessage extends RoomMessage{

	@Override
	public RoomMessage execute(ControllerInterface controller){
		return controller.executeEnterRoom(this);
	}
}
