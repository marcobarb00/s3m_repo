package it.polimi.ingsw.s3m.launcher.Server.Message;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.util.ArrayList;

public class EnterRoomMessage implements Message{
	private final ArrayList<Integer> availableRoomsID;

	public EnterRoomMessage(ArrayList<Integer> availableRoomsID){
		this.availableRoomsID = availableRoomsID;
	}

	public ArrayList<Integer> getAvailableRoomsID(){
		return availableRoomsID;
	}

	@Override
	public void apply(View view){
		view.enterRoom(this);
	}
}
