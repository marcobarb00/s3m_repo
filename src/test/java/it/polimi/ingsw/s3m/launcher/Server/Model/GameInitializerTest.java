package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameInitializerTest {

    @Test
    void islandsSetup() {
        ArrayList<String> playersNickname = new ArrayList<>();
        Game game = new Game(playersNickname);
        GameInitializer gameInitializer = new GameInitializer(game);
        assertEquals(10, gameInitializer.getFirstStudentsOnIslands().size());
        for (Island island : game.getIslandsList()) {
            for (PawnColor color : PawnColor.values()) {
                assertEquals(0, island.getStudents().get(color));
            }
        }
        gameInitializer.islandsSetup();
        assertEquals(0, gameInitializer.getFirstStudentsOnIslands().size());
        for (Island island : game.getIslandsList()) {
            int sum = 0;
            for (PawnColor color : PawnColor.values()) {
                sum += island.getStudents(color);
            }
            if (island.getId() == 1 || island.getId() == 7) {
                assertEquals(0, sum);
            } else {
                assertEquals(1, sum);
            }
        }
    }
}