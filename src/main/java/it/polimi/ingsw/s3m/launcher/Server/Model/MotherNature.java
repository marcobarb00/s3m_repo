package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class MotherNature {
    private int currentPosition;

    public MotherNature () {
        this.currentPosition = 0;
    }

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
