package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class NewRoomResponse implements Response{
	private String nickname;
	private int numberOfPlayers;
	private boolean expertMode;

	public NewRoomResponse(String nickname, int numberOfPlayers, boolean expertMode){
		this.nickname = nickname;
		this.numberOfPlayers = numberOfPlayers;
		this.expertMode = expertMode;
	}

	public String getNickname(){
		return nickname;
	}

	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}

	public boolean isExpertMode(){
		return expertMode;
	}
}