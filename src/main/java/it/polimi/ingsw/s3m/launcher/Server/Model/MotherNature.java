package it.polimi.ingsw.s3m.launcher.Server.Model;

public class MotherNature {
    private int currentPosition = 0;

    public void incrementCurrentPosition () {
        currentPosition++;
    }

    // GETTER
    public int getCurrentPosition() { return currentPosition; }

    // SETTER
    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
