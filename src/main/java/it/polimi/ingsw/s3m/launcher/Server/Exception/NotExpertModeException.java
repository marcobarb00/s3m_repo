package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotExpertModeException extends Exception{
    public NotExpertModeException() {
        super("Not in expert mode");
    }
}
