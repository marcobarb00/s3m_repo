package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class LoginMessage implements Message{
	private String nickname;
	private int roomID;
	private boolean newRoom;
	private int playersNumber;
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

	public boolean isNewRoom(){
		return newRoom;
	}

	public void setNewRoom(boolean newRoom){
		this.newRoom = newRoom;
	}

	public void setPlayersNumber(int playersNumber){
		this.playersNumber = playersNumber;
	}

	public int getPlayersNumber(){
		return playersNumber;
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

	@Override
	public Message execute(View view){
		if(this.isSuccessful()){
			view.showLoginResult(this);
			return null;
		}else{
			return view.login();
		}
	}
}
