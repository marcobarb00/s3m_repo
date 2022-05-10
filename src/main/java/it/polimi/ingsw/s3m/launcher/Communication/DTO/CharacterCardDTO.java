package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.HashMap;

public class CharacterCardDTO implements Serializable{
	private String name;
	private int cost;
	private HashMap<String, Integer> studentsOnCard;

	public CharacterCardDTO(String name, int cost, HashMap<String, Integer> studentsOnCard){
		this.name = name;
		this.cost = cost;
		this.studentsOnCard = studentsOnCard;
	}

	public String getName(){
		return name;
	}

	public int getCost(){
		return cost;
	}

	public HashMap<String, Integer> getStudentsOnCard(){
		return studentsOnCard;
	}
}
