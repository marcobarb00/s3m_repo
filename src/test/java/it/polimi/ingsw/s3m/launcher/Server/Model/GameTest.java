package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Cloud;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    // CHARACTER CARDS
    @Test
    void normalModeGameCharacterCardsListIsEmpty() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        assertEquals(0, game.getCharacterCardsList().size());
    }

    @Test
    void expertModeGameCharacterCardsListLengthEquals3() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        assertEquals(3, game.getCharacterCardsList().size());
    }

    // CLOUDS
    @Test
    void threePlayersGameCloudsHaveFourStudents() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        nicknames.add("ThirdPlayer");
        Game game = new Game(nicknames, true);
        game.refillClouds();
        for (Cloud cloud : game.getCloudsList())
            assertEquals(4, cloud.getStudents().size());
    }

    @Test
    void twoPlayersGameCloudsHaveThreeStudents() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        game.refillClouds();
        for (Cloud cloud : game.getCloudsList())
            assertEquals(3, cloud.getStudents().size());
    }

    // MOTHER NATURE
    @Test
    void updatingMotherNaturePositionSurpassingIslandListArraySize() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        assertEquals(0, game.getMotherNature().getCurrentPosition());

        game.updateMotherNaturePosition(10);
        assertEquals(10, game.getMotherNature().getCurrentPosition());

        game.updateMotherNaturePosition(2);
        assertEquals(0, game.getMotherNature().getCurrentPosition());
        assertNotEquals(12, game.getMotherNature().getCurrentPosition());

        game.updateMotherNaturePosition(1);
        assertEquals(1, game.getMotherNature().getCurrentPosition());
    }

    @Test
    void updatingMotherNaturePositionWithLessIslandsThanTheBeginningOfTheGame() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        assertEquals(0, game.getMotherNature().getCurrentPosition());

        game.getIslandsList().remove(game.getIslandsList().get(5));
        game.getIslandsList().remove(game.getIslandsList().get(9));
        game.updateMotherNaturePosition(5);
        assertEquals(5, game.getMotherNature().getCurrentPosition());

        game.updateMotherNaturePosition(4);
        assertEquals(9, game.getMotherNature().getCurrentPosition());

        game.updateMotherNaturePosition(3);
        assertEquals(2, game.getMotherNature().getCurrentPosition());
    }
}