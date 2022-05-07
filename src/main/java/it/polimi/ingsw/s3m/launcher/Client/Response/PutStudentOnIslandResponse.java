package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class PutStudentOnIslandResponse implements Response{
	private String color;
	private int islandPosition;

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
