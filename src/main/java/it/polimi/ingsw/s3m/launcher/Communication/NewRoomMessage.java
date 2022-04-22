package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class NewRoomMessage implements Message{
	String nickname;
	int numberOfPlayers;

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public Message execute(View view){
		return null;
	}
}
