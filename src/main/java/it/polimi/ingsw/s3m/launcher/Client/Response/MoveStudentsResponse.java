package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

import java.util.ArrayList;

public class MoveStudentsResponse implements Response{
	private boolean characterCardActivated;
	private int characterCardPosition;
	private ArrayList<StudentMove> studentsMove;

	//TODO when cli input ready create new moveStudentsResponse an return it
	public MoveStudentsResponse(boolean characterCardActivated, int characterCardPosition, ArrayList<StudentMove> studentsMove){
		this.characterCardActivated = characterCardActivated;
		this.characterCardPosition = characterCardPosition;
		this.studentsMove = studentsMove;
	}

	public boolean isCharacterCardActivated(){
		return characterCardActivated;
	}

	public int getCharacterCardPosition(){
		return characterCardPosition;
	}

	public ArrayList<StudentMove> getStudentsMove(){
		return studentsMove;
	}
}
