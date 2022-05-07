package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

public class PutStudentOnTableResponse implements Response{
	private String color;

	public PutStudentOnTableResponse(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}
}
