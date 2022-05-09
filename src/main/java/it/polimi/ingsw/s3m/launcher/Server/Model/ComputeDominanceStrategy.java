package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.HashMap;

public interface ComputeDominanceStrategy{
	public Player computeDominance(Island island, HashMap<PawnColor, Player> professors);
}
