package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class CharacterCardAlreadyActivatedException extends Exception{
	public CharacterCardAlreadyActivatedException(){
		super("you already activated a character card");
	}
}
