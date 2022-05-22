package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.HashMap;

public class IslandDTO implements Serializable{
	private final HashMap<String, Integer> students;
	private final String dominatorColor;
	private final String dominator;
	private final int numberOfTowers;

	public IslandDTO(HashMap<String, Integer> students, String dominator, String dominatorColor, int numberOfTowers){
		this.students = students;
		this.dominatorColor = dominatorColor;
		this.dominator = dominator;
		this.numberOfTowers = numberOfTowers;
	}

	public HashMap<String, Integer> getStudents(){
		return students;
	}

	public String getDominatorColor(){
		return dominatorColor;
	}

	public String getDominator(){
		return dominator;
	}

	public int getNumberOfTowers(){
		return numberOfTowers;
	}
}
