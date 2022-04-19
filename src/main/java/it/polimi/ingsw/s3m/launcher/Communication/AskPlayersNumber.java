package it.polimi.ingsw.s3m.launcher.Communication;

public class AskPlayersNumber implements Message{
	private int playersNumber;

	public AskPlayersNumber(int playersNumber){
		this.playersNumber = playersNumber;
	}

	public int getPlayersNumber(){
		return playersNumber;
	}
}
