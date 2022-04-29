package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.util.ArrayList;
import java.util.HashMap;

public class DashboardDTO{
	private ArrayList<String> hall;
	private HashMap<String, Integer> tables;
	private int numberOfTowers;

	public DashboardDTO(ArrayList<String> hall, HashMap<String, Integer> tables, int numberOfTowers){
		this.hall = hall;
		this.tables = tables;
		this.numberOfTowers = numberOfTowers;
	}

	public ArrayList<String> getHall(){
		return hall;
	}

	public HashMap<String, Integer> getTables(){
		return tables;
	}

	public int getNumberOfTowers(){
		return numberOfTowers;
	}
}
