package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class NotExpertModeException extends Exception{
    public NotExpertModeException() {
        super("you cannot do this operation in normal mode");
    }
}
