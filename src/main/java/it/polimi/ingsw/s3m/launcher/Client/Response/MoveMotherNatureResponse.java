package it.polimi.ingsw.s3m.launcher.Client.Response;

public class MoveMotherNatureResponse implements Response{
	int motherNatureMovement;

	public MoveMotherNatureResponse(int motherNatureMovement){
		this.motherNatureMovement = motherNatureMovement;
	}

	public int getMotherNatureMovement(){
		return motherNatureMovement;
	}
}
