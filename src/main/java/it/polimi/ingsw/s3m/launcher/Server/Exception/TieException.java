package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class TieException extends Exception {
    public TieException(String firstWinnerNickname, String secondWinnerNickname) {
        super(firstWinnerNickname + ", " + secondWinnerNickname);
    }
}
