package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class DoubleNicknameException extends Exception{
    public DoubleNicknameException() {
        super("2 nicknames are the same");
    }
}
