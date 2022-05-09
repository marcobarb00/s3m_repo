package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class DoubleNicknameException extends Exception{
	public DoubleNicknameException(){
		super("there are two equal nicknames");
	}
}
