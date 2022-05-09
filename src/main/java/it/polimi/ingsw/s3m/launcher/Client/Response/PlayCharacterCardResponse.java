package it.polimi.ingsw.s3m.launcher.Client.Response;

import it.polimi.ingsw.s3m.launcher.Communication.Response;

import java.util.ArrayList;

public class PlayCharacterCardResponse implements Response{
	private int characterCardPosition;

	//jester and mushroomer inputs
	private ArrayList<String> studentsToPutOn;
	private ArrayList<String> studentsToGetFrom;

	//minstrel input
	private String notInfluencingColor;

	public PlayCharacterCardResponse(int characterCardPosition){
		this.characterCardPosition = characterCardPosition;
	}

	public PlayCharacterCardResponse(int characterCardPosition, ArrayList<String> studentsToPutOn,
									 ArrayList<String> studentsToGetFrom){
		this.characterCardPosition = characterCardPosition;
		this.studentsToGetFrom = studentsToGetFrom;
		this.studentsToPutOn = studentsToPutOn;
	}

	public PlayCharacterCardResponse(int characterCardPosition, String notInfluencingColor){
		this.characterCardPosition = characterCardPosition;
		this.notInfluencingColor = notInfluencingColor;
	}

	public ArrayList<String> getStudentsToPutOn(){
		return studentsToPutOn;
	}

	public ArrayList<String> getStudentsToGetFrom(){
		return studentsToGetFrom;
	}

	public String getNotInfluencingColor(){
		return notInfluencingColor;
	}

	public int getCharacterCardPosition(){
		return characterCardPosition;
	}
}
