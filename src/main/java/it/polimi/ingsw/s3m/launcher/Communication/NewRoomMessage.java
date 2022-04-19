package it.polimi.ingsw.s3m.launcher.Communication;

public class NewRoomMessage extends RoomMessage{
	private int playersNumber;

	public void setPlayersNumber(int playersNumber){
		this.playersNumber = playersNumber;
	}

	public int getPlayersNumber(){
		return playersNumber;
	}

	public NewRoomMessage(){}

	@Override
	public RoomMessage execute(ControllerInterface controller){
		return controller.executeNewRoom(this);
	}
}
