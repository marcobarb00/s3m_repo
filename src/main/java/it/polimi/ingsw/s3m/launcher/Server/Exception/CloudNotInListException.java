package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class CloudNotInListException extends Exception {
    public CloudNotInListException() {
        super("the selected cloud is not available");
    }
}
