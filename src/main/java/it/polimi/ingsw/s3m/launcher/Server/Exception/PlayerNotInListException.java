package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class PlayerNotInListException extends Exception{
    public PlayerNotInListException() {
        super("Player is not in list");
    }
}
