package it.polimi.ingsw.s3m.launcher.Server.Model;

public class CharacterCard{
	private String name;
	private int cost;

	public void incrementCost(){
		cost++;
	}

	public String getName(){
		return name;
	}

	public int getCost(){
		return cost;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setCost(int cost){
		this.cost = cost;
	}
}