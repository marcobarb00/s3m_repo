package it.polimi.ingsw.s3m.launcher.Server.Exception;

public class CloudNotInListException extends Exception {
    public CloudNotInListException() {
        super("Cloud is not in list");
    }

}
