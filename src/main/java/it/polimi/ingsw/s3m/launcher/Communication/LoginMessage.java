package it.polimi.ingsw.s3m.launcher.Communication;

import it.polimi.ingsw.s3m.launcher.Client.View.View;

import java.util.ArrayList;
import java.util.Set;

public class LoginMessage implements Message{
	private int numberOfRooms;
	private boolean isNewRoom;
	private String message;

	public int getNumberOfRooms(){
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public void setNewRoom(boolean newRoom) {
		isNewRoom = newRoom;
	}

	public boolean isNewRoom() {
		return isNewRoom;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void apply(View view){
		view.login(this);
	}
}
