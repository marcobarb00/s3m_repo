package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    void initializeFirstStudent() {
        int sum = 0;
        ArrayList<String> playersNames = new ArrayList<>();
        Game game = new Game(playersNames);
        Island island = new Island(game, 1);
        for (PawnColor color : PawnColor.values()) {
            assertEquals(0, island.getStudents().get(color));
        }
        island.initializeFirstStudent();
        for (PawnColor color : PawnColor.values()) {
            int colorValue = island.getStudents().get(color);
            assertTrue(colorValue == 0 || colorValue == 1);
            sum += colorValue;
        }
        assertEquals(1, sum);
    }
}