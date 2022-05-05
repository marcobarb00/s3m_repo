package it.polimi.ingsw.s3m.launcher.Client.View.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class EnterRoomResponse implements Response{
	private String nickname;
	private Integer roomID;

	public EnterRoomResponse(String nickname, Integer roomID){
		this.nickname = nickname;
		this.roomID = roomID;
	}

	public EnterRoomResponse(){
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public void setRoomID(Integer roomID){
		this.roomID = roomID;
	}

	public String getNickname(){
		return nickname;
	}

	public Integer getRoomID(){
		return roomID;
	}
}
