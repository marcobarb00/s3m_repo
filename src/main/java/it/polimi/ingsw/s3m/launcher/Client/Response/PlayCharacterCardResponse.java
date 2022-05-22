package it.polimi.ingsw.s3m.launcher.Client.Response;

import java.util.ArrayList;

public class PlayCharacterCardResponse implements Response{
	private int characterCardPosition;

	//jester and minstrel inputs
	private ArrayList<String> studentsToPutOn;
	private ArrayList<String> studentsToGetFrom;

	//mushroomer input
	private String nonInfluencingColor;

	public PlayCharacterCardResponse(int characterCardPosition){
		this.characterCardPosition = characterCardPosition;
	}

	public PlayCharacterCardResponse(int characterCardPosition, ArrayList<String> studentsToPutOn,
									 ArrayList<String> studentsToGetFrom){
		this.characterCardPosition = characterCardPosition;
		this.studentsToGetFrom = studentsToGetFrom;
		this.studentsToPutOn = studentsToPutOn;
	}

	public PlayCharacterCardResponse(int characterCardPosition, String nonInfluencingColor){
		this.characterCardPosition = characterCardPosition;
		this.nonInfluencingColor = nonInfluencingColor;
	}

	public PlayCharacterCardResponse(){
		this.characterCardPosition = -1;
		this.studentsToGetFrom = null;
		this.studentsToPutOn = null;
		this.nonInfluencingColor = null;
	}

	public ArrayList<String> getStudentsToPutOn(){
		return studentsToPutOn;
	}

	public ArrayList<String> getStudentsToGetFrom(){
		return studentsToGetFrom;
	}

	public String getNonInfluencingColor(){
		return nonInfluencingColor;
	}

	public int getCharacterCardPosition(){
		return characterCardPosition;
	}

	public void setCharacterCardPosition(int characterCardPosition){
		this.characterCardPosition = characterCardPosition;
	}

	public void setStudentsToPutOn(ArrayList<String> studentsToPutOn){
		this.studentsToPutOn = studentsToPutOn;
	}

	public void setStudentsToGetFrom(ArrayList<String> studentsToGetFrom){
		this.studentsToGetFrom = studentsToGetFrom;
	}

	public void setNonInfluencingColor(String nonInfluencingColor){
		this.nonInfluencingColor = nonInfluencingColor;
	}
}
