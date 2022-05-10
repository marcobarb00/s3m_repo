package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class IncorrectOperationException extends Exception{
	public IncorrectOperationException(String message){
		super(message);
	}
	public IncorrectOperationException(){
		super("the operation received is not the correct type");
	}
}
