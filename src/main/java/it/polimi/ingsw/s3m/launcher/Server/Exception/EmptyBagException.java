package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class EmptyBagException extends Exception{
	public EmptyBagException(){
		super("the bag is empty, this is the last turn");
	}
}
