package it.polimi.ingsw.s3m.launcher.Client.Response;

public class PutStudentOnIslandResponse implements Response{
	private final String color;
	private final int islandPosition;

	public PutStudentOnIslandResponse(String color, int islandPosition){
		this.color = color;
		this.islandPosition = islandPosition;
	}

	public String getColor(){
		return color;
	}

	public int getIslandPosition(){
		return islandPosition;
	}
}
