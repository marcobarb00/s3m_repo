package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public class MushroomerComputeDominance implements ComputeDominanceStrategy {
    private PawnColor color;

    @Override
    public Player computeDominance(Island island, HashMap<PawnColor, Player> professors) {
        return null;
    }

    public void setColor(PawnColor color) { this.color = color; }
}
