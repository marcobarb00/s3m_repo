package it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance;

import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Island;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import java.util.HashMap;

public interface ComputeDominanceStrategy{
	Player computeDominance(Island island, HashMap<PawnColor, Player> professors);
}
