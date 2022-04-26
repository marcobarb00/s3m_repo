package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

public class NewRoomMessage extends RoomMessage{
	private int numberOfPlayers;
	private boolean expertMode;

	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setExpertMode(boolean expertMode){
		this.expertMode = expertMode;
	}

	public boolean isExpertMode(){
		return expertMode;
	}

	@Override
	public void apply(View view){
		view.newRoom(this);
	}
}
