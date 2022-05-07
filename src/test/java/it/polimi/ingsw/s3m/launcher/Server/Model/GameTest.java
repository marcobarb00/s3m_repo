package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void activateCentaurEffect() {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("paolo", "giovanni"));
        Game game = new Game(players, true);

    }

    @Test
    void activateJesterEffect() {
    }

    @Test
    void activateKnightEffect() {
    }

    @Test
    void activateMagicPostmanEffect() {
    }

    @Test
    void activateMinstrelEffect() {
    }

    @Test
    void activateMushroomerEffect() {
    }
}