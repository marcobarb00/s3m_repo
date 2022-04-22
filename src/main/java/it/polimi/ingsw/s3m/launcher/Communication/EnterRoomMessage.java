package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class EnterRoomMessage implements Message{
	String nickname;
	Integer roomID;

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public void setRoomID(Integer roomID){
		this.roomID = roomID;
	}

	@Override
	public Message execute(View view){
		return null;
	}
}
