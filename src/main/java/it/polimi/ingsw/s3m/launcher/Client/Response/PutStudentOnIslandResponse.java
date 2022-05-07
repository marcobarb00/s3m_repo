package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class PutStudentOnIslandResponse implements Response{
	private String color;
	private boolean movedOnIsland;

	public PutStudentOnIslandResponse(String color, boolean movedOnIsland){
		this.color = color;
		this.movedOnIsland = movedOnIsland;
	}

	public String getColor(){
		return color;
	}

	public boolean isMovedOnIsland(){
		return movedOnIsland;
	}
}
