package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

class StandardComputeDominanceTest {
    @Test
    void ifProfessorsAreAllNull() {
        Player dominatorPlayer;
        ComputeDominanceStrategy computeDominanceStrategy = new StandardComputeDominance();
        Island island = new Island();
        HashMap<PawnColor, Player> professors = new HashMap<>();
        for (PawnColor color : PawnColor.values()) professors.put(color, null);
        dominatorPlayer = computeDominanceStrategy.computeDominance(island, professors);
        assertNull(dominatorPlayer);
    }
}
