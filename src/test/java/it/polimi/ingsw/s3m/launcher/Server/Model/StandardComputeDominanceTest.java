package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

class StandardComputeDominanceTest {
    @Test
    void ifProfessorsAreAllNullThenNoDominatingPlayer() {
        Player dominatorPlayer;
        ComputeDominanceStrategy computeDominanceStrategy = new StandardComputeDominance();
        Island island = new Island();
        HashMap<PawnColor, Player> professors = new HashMap<>();
        for (PawnColor color : PawnColor.values()) professors.put(color, null);
        dominatorPlayer = computeDominanceStrategy.computeDominance(island, professors);
        assertNull(dominatorPlayer);
    }

    @Test
    void ifTwoPlayersTieTheIslandDominatorWins() {
        ComputeDominanceStrategy computeDominanceStrategy = new StandardComputeDominance();
        Player firstPlayer = new Player("First", TowerColor.WHITE);
        Player secondPlayer = new Player("Second", TowerColor.BLACK);
        Player dominatorPlayer;

        Island island = new Island();
        island.setDominator(firstPlayer);
        island.addTower();
        island.addStudent(new Student(PawnColor.BLUE));
        island.addStudent(new Student(PawnColor.RED));
        island.addStudent(new Student(PawnColor.RED));

        HashMap<PawnColor, Player> professors = new HashMap<>();
        professors.put(PawnColor.BLUE, firstPlayer);
        professors.put(PawnColor.RED, secondPlayer);

        dominatorPlayer = computeDominanceStrategy.computeDominance(island, professors);
        assertEquals("First", dominatorPlayer.getNickname());
    }

    @Test
    void ifTwoPlayersTieAndNoOneIsControllingTheIslandThenNobodyWins() {
        ComputeDominanceStrategy computeDominanceStrategy = new StandardComputeDominance();
        Player firstPlayer = new Player("First", TowerColor.WHITE);
        Player secondPlayer = new Player("Second", TowerColor.BLACK);
        Player dominatorPlayer;

        Island island = new Island();
        island.addStudent(new Student(PawnColor.BLUE));
        island.addStudent(new Student(PawnColor.RED));

        HashMap<PawnColor, Player> professors = new HashMap<>();
        professors.put(PawnColor.RED, secondPlayer);
        professors.put(PawnColor.BLUE, firstPlayer);

        dominatorPlayer = computeDominanceStrategy.computeDominance(island, professors);
        assertNull(dominatorPlayer);
    }
}
