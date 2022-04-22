package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.util.ArrayList;

public class LoginMessage implements Message{
	private int numberOfRooms;
	private ArrayList<Integer> availableRoomsID;
	private String message;

	public int getNumberOfRooms(){
		return numberOfRooms;
	}

	public ArrayList<Integer> getAvailableRoomsID(){
		return availableRoomsID;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public Message execute(View view){
		return view.login(this);
	}
}
