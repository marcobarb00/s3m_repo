package it.polimi.ingsw.s3m.launcher.Communication;

public abstract class RoomMessage implements Message{
	private String nickname;
	private int roomID;
	private boolean successful;
	private String message;

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public void setRoomID(int roomID){
		this.roomID = roomID;
	}

	public int getRoomID(){
		return roomID;
	}

	public void setSuccessful(boolean successful){
		this.successful = successful;
	}

	public boolean isSuccessful(){
		return successful;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public abstract RoomMessage execute(ControllerInterface controller);
}
