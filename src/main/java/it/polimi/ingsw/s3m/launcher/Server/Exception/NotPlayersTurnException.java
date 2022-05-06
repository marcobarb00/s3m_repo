package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotPlayersTurnException extends Exception{
    public NotPlayersTurnException() {
        super("Not player's turn");
    }
}
