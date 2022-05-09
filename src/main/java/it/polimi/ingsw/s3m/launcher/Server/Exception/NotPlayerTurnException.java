package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotPlayerTurnException extends Exception{
	public NotPlayerTurnException(){
		super("it's not your turn to play");
	}
}
