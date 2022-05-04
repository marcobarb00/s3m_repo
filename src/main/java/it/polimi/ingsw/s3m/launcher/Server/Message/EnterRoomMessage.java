package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;

public class EnterRoomMessage implements Message{
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
