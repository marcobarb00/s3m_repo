package it.polimi.ingsw.s3m.launcher.Client.Response;

public class StudentMove{
	private String color;
	private boolean movedOnIsland;
	private int islandIndex;

	public StudentMove(String color, boolean movedOnIsland, int islandIndex){
		this.color = color;
		this.movedOnIsland = movedOnIsland;
		this.islandIndex = islandIndex;
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
