package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotEnoughCoinsException extends Exception{
	public NotEnoughCoinsException(){
		super("you don't have enough coins");
	}
}
