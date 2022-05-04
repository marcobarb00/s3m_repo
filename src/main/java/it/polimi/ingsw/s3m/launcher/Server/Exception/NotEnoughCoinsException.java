package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotEnoughCoinsException extends Exception{
    public NotEnoughCoinsException() {
        super("Not enough coins");
    }
}
