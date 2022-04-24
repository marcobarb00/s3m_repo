package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.util.ArrayList;

public class EnterRoomMessage extends RoomMessage{
	private ArrayList<Integer> availableRoomsID;

	public ArrayList<Integer> getAvailableRoomsID() {
		return availableRoomsID;
	}

	public void setAvailableRoomsID(ArrayList<Integer> availableRoomsID) {
		this.availableRoomsID = availableRoomsID;
	}

	@Override
	public void apply(View view){
		view.enterRoom(this);
	}
}
