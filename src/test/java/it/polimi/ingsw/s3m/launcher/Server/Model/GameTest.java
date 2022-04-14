package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.Professor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void professorsArrayNotNullInitialization() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        assertNotEquals(null, game.getProfessorsList());
    }

    @Test
    void professorsArrayAllColorsInitialization() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);

        Set<PawnColor> colorList = game.getProfessorsList().stream()
                .map(Professor::getColor)
                .collect(Collectors.toSet());
        assertEquals(PawnColor.values().length, colorList.size());
    }

    @Test
    void fullBagInitialization() {
        ArrayList<Player> players = new ArrayList<>();
        Game game = new Game(players);
        assertEquals(130, game.getBag().getNumberOfStudents());
        assertNotNull(game.getBag());
    }
}