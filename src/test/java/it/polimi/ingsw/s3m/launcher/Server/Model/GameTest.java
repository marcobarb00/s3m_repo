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
        ArrayList<String> playersNames = new ArrayList<>();
        Game game = new Game(playersNames);
        assertNotEquals(null, game.getProfessorsList());
    }

    @Test
    void professorsArrayAllColorsInitialization() {
        ArrayList<String> playersNames = new ArrayList<>();
        Game game = new Game(playersNames);

        Set<PawnColor> colorList = game.getProfessorsList().stream()
                .map(Professor::getColor)
                .collect(Collectors.toSet());
        assertEquals(PawnColor.values().length, colorList.size());
    }

    @Test
    void drawThreeCharacterCards() {
        ArrayList<String> playersNicknames = new ArrayList<>();
        Game game = new Game(playersNicknames);
        assertEquals(6, game.getCharacterCardsList().size());
        for (CharacterCard characterCard : game.getCharacterCardsList()) {
            System.out.println(characterCard.getName());
        }
        System.out.println("");
        game.drawThreeCharacterCards();
        assertEquals(3, game.getCharacterCardsList().size());
        for (CharacterCard characterCard : game.getCharacterCardsList()) {
            System.out.println(characterCard.getName());
        }
    }
}