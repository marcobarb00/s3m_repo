package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class MotherNature {
    private int currentPosition;

    public MotherNature () {
        this.currentPosition = 0;
    }

    public int getCurrentPosition() { return currentPosition; }

    public int setCurrentPosition(int jump, ArrayList<Island> islands) {
        //TODO jump non negative exception (?)
        //if (jump <= 0) throw NonPositiveJumpParemeterException e;
        while (jump != 0) {
            if (currentPosition == islands.size()-1) {
                currentPosition = 0;
            } else {
                currentPosition++;
            }
            jump--;
        }
        return currentPosition;
    }
}
