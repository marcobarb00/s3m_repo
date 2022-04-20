package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CloudTest {

    @Test
    void refillThreeStudents() {
        ArrayList<String> playersName = new ArrayList<>();
        Game game = new Game(playersName);
        Cloud cloud = new Cloud(game, 1);
        assertEquals(0, cloud.returnThreeStudents().size());
        cloud.refillThreeStudents();
        assertEquals(3, cloud.returnThreeStudents().size());
        cloud.refillThreeStudents();
        assertEquals(3, cloud.returnThreeStudents().size());
    }
}