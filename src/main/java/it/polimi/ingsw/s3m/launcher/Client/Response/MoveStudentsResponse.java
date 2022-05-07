package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

import java.util.ArrayList;

public class MoveStudentsResponse implements Response{
	private boolean characterCardActivated;
	private int characterCardPosition;
	private ArrayList<StudentMove> studentMoves;

	public MoveStudentsResponse(boolean characterCardActivated, int characterCardPosition, ArrayList<StudentMove> studentMoves){
		this.characterCardActivated = characterCardActivated;
		this.characterCardPosition = characterCardPosition;
		this.studentMoves = studentMoves;
	}

	public boolean isCharacterCardActivated(){
		return characterCardActivated;
	}

	public int getCharacterCardPosition(){
		return characterCardPosition;
	}

	public ArrayList<StudentMove> getStudentMoves(){
		return studentMoves;
	}
}
