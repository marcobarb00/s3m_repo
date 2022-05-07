package it.polimi.ingsw.s3m.launcher.Client.Response;

import java.io.Serializable;

public class StudentMove implements Serializable{
	private String color;
	private boolean movedOnIsland;
	private int islandIndex;

	public StudentMove(String color, boolean movedOnIsland, int islandIndex){
		this.color = color;
		this.movedOnIsland = movedOnIsland;
		this.islandIndex = islandIndex;
	}

	public StudentMove(String color, boolean movedOnIsland){
		this.color = color;
		this.movedOnIsland = movedOnIsland;
	}

	public String getColor(){
		return color;
	}

	public boolean isMovedOnIsland(){
		return movedOnIsland;
	}

	public int getIslandIndex(){
		return islandIndex;
	}
}
