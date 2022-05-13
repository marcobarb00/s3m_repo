package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.HashMap;

public class DashboardDTO implements Serializable{
	private final HashMap<String, Integer> entrance;
	private final HashMap<String, Integer> tables;
	private final int numberOfTowers;

	public DashboardDTO(HashMap<String, Integer> entrance, HashMap<String, Integer> tables, int numberOfTowers){
		this.entrance = entrance;
		this.tables = tables;
		this.numberOfTowers = numberOfTowers;
	}

	public HashMap<String, Integer> getEntrance(){
		return entrance;
	}

	public HashMap<String, Integer> getTables(){
		return tables;
	}

	public int getNumberOfTowers(){
		return numberOfTowers;
	}
}
