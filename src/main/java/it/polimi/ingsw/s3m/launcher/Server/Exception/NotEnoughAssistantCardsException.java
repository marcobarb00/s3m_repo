package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotEnoughAssistantCardsException extends Exception{
	public NotEnoughAssistantCardsException(){
		super("someone doesn't have any more assistant cards, this is the last turn");
	}
}
