package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughAssistantCardsException;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

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

    // ISLANDS
    @Test
    void samePlayerCheckInNextIslandFailure() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(0).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(0).getDominator().getNickname());

        game.getIslandsList().get(1).setDominator(game.getPlayerHashMap().get("SecondPlayer"));
        assertEquals("SecondPlayer", game.getIslandsList().get(1).getDominator().getNickname());

        game.samePlayerCheckInNextIsland(game.getIslandsList().get(0));
        assertEquals(12, game.getIslandsList().size());

        game.samePlayerCheckInNextIsland(game.getIslandsList().get(1));
        assertEquals(12, game.getIslandsList().size());
    }

    @Test
    void samePlayerCheckInNextIslandSuccess() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(0).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(0).getDominator().getNickname());

        game.getIslandsList().get(1).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(1).getDominator().getNickname());

        game.samePlayerCheckInNextIsland(game.getIslandsList().get(0));
        assertEquals(11, game.getIslandsList().size());
        assertEquals("FirstPlayer", game.getIslandsList().get(0).getDominator().getNickname());
        assertNull(game.getIslandsList().get(1).getDominator());
    }

    @Test
    void samePlayerCheckInNextIslandWithFirstIslandInTheListAsNextIslandFailureAndSuccess() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(11).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(11).getDominator().getNickname());

        game.getIslandsList().get(0).setDominator(game.getPlayerHashMap().get("SecondPlayer"));
        assertEquals("SecondPlayer", game.getIslandsList().get(0).getDominator().getNickname());

        // Failure
        game.samePlayerCheckInNextIsland(game.getIslandsList().get(11));
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(0).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(0).getDominator().getNickname());

        // Success
        game.samePlayerCheckInNextIsland(game.getIslandsList().get(11));
        assertEquals(11, game.getIslandsList().size());
        assertEquals("FirstPlayer", game.getIslandsList().get(10).getDominator().getNickname());
        assertNull(game.getIslandsList().get(0).getDominator());
    }

    @Test
    void samePlayerCheckInPreviousIslandFailure() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(11).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(11).getDominator().getNickname());

        game.getIslandsList().get(10).setDominator(game.getPlayerHashMap().get("SecondPlayer"));
        assertEquals("SecondPlayer", game.getIslandsList().get(10).getDominator().getNickname());

        game.samePlayerCheckInPreviousIsland(game.getIslandsList().get(11));
        assertEquals(12, game.getIslandsList().size());

        game.samePlayerCheckInPreviousIsland(game.getIslandsList().get(10));
        assertEquals(12, game.getIslandsList().size());
    }

    @Test
    void samePlayerCheckInPreviousIslandSuccess() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(11).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(11).getDominator().getNickname());

        game.getIslandsList().get(10).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(10).getDominator().getNickname());

        game.samePlayerCheckInPreviousIsland(game.getIslandsList().get(11));
        assertEquals(11, game.getIslandsList().size());
        assertEquals("FirstPlayer", game.getIslandsList().get(10).getDominator().getNickname());
        assertNull(game.getIslandsList().get(9).getDominator());
    }

    @Test
    void samePlayerCheckInPreviousIslandWithLastIslandInTheListAsPreviousIslandFailureAndSuccess() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(0).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(0).getDominator().getNickname());

        game.getIslandsList().get(11).setDominator(game.getPlayerHashMap().get("SecondPlayer"));
        assertEquals("SecondPlayer", game.getIslandsList().get(11).getDominator().getNickname());

        // Failure
        game.samePlayerCheckInPreviousIsland(game.getIslandsList().get(0));
        assertEquals(12, game.getIslandsList().size());

        game.getIslandsList().get(11).setDominator(game.getPlayerHashMap().get("FirstPlayer"));
        assertEquals("FirstPlayer", game.getIslandsList().get(11).getDominator().getNickname());

        // Success
        game.samePlayerCheckInPreviousIsland(game.getIslandsList().get(0));
        assertEquals(11, game.getIslandsList().size());
        assertEquals("FirstPlayer", game.getIslandsList().get(0).getDominator().getNickname());
        assertNull(game.getIslandsList().get(10).getDominator());
    }

    @Test
    void mergeIslandsTest() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        assertEquals(12, game.getIslandsList().size());

        ArrayList<Student> addingStudents = new ArrayList<>();
        addingStudents.add(new Student(PawnColor.BLUE));
        addingStudents.add(new Student(PawnColor.BLUE));
        addingStudents.add(new Student(PawnColor.GREEN));
        addingStudents.add(new Student(PawnColor.RED));
        assertEquals(4, addingStudents.size());
        game.getIslandsList().get(4).addTower();
        game.getIslandsList().get(4).addStudentsOnIsland(addingStudents);
        assertEquals(1, game.getIslandsList().get(4).getNumberOfTowers());
        assertEquals(5, game.getIslandsList().get(4).getTotalNumberOfStudents());

        addingStudents.subList(0, 4).clear();
        assertEquals(0, addingStudents.size());
        addingStudents.add(new Student(PawnColor.BLUE));
        addingStudents.add(new Student(PawnColor.PINK));
        addingStudents.add(new Student(PawnColor.PINK));
        addingStudents.add(new Student(PawnColor.YELLOW));
        assertEquals(4, addingStudents.size());
        game.getIslandsList().get(5).sumTower(2);
        game.getIslandsList().get(5).addStudentsOnIsland(addingStudents);
        assertEquals(2, game.getIslandsList().get(5).getNumberOfTowers());
        assertEquals(5, game.getIslandsList().get(5).getTotalNumberOfStudents());
        Island eliminatingIsland = game.getIslandsList().get(5);

        game.mergeIsland(game.getIslandsList().get(4), game.getIslandsList().get(5));
        assertEquals(11, game.getIslandsList().size());
        assertEquals(3, game.getIslandsList().get(4).getNumberOfTowers());
        assertEquals(10, game.getIslandsList().get(4).getTotalNumberOfStudents());
        assertFalse(game.getIslandsList().contains(eliminatingIsland));
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

    // TURN
    @Test
    void resetTurnVerifyTest() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>(Arrays.asList("FirstPlayer", "SecondPlayer"));
        Game game = new Game(nicknames, false);
        assertEquals("PlanningPhase", game.getTurn().getPhaseName());

        game.getTurn().setFirstPlayerNickname("FirstPlayer");
        game.getTurn().setCurrentPlayerNickname("SecondPlayer");
        game.getTurn().setPhaseName("ActionPhase");
        game.getTurn().getPlayedCards().put("Card", AssistantCard.CAT);
        game.getTurn().setActivatedCharacterCard(true);
        assertEquals("FirstPlayer", game.getTurn().getFirstPlayerNickname());
        assertEquals("SecondPlayer", game.getTurn().getCurrentPlayerNickname());
        assertEquals("ActionPhase", game.getTurn().getPhaseName());
        assertEquals(1, game.getTurnPlayedCards().size());
        assertTrue(game.getTurn().isActivatedCharacterCard());

        game.resetTurn();
        assertEquals("FirstPlayer", game.getTurn().getFirstPlayerNickname());
        assertEquals("FirstPlayer", game.getTurn().getCurrentPlayerNickname());
        assertEquals("PlanningPhase", game.getTurn().getPhaseName());
        assertEquals(0, game.getTurnPlayedCards().size());
        assertFalse(game.getTurn().isActivatedCharacterCard());
    }

    @Test
    void setTurnFirstPlayerTest() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>(Arrays.asList("FirstPlayer", "SecondPlayer"));
        Game game = new Game(nicknames, false);

        game.getTurn().setFirstPlayerNickname("FirstPlayer");
        game.getTurn().setCurrentPlayerNickname("FirstPlayer");
        game.getTurn().getPlayedCards().put("FirstPlayer", AssistantCard.DOG);
        game.getTurn().getPlayedCards().put("SecondPlayer", AssistantCard.ELEPHANT);
        game.setTurnFirstPlayer();
        assertEquals("SecondPlayer", game.getTurn().getFirstPlayerNickname());
        assertEquals("ActionPhase", game.getTurn().getPhaseName());
    }

    @Test
    void playAssistantCardTest() throws EmptyBagException, NotEnoughAssistantCardsException {
        ArrayList<String> nicknames = new ArrayList<>(Arrays.asList("FirstPlayer", "SecondPlayer"));
        Game game = new Game(nicknames, false);

        game.playAssistantCard("FirstPlayer", 8);
        game.playAssistantCard("SecondPlayer", 9);
        assertTrue(game.getTurnPlayedCards().contains(AssistantCard.OSTRICH));
        assertTrue(game.getTurnPlayedCards().contains(AssistantCard.CHEETAH));

        //Raising the exception
        Game game2 = new Game(nicknames, false);
        Player player = game2.getPlayerHashMap().get("FirstPlayer");
        ArrayList<AssistantCard> cards = player.getHand();
        for(int i = 0; i < 9; i++){
            cards.remove(0);
        }
        Exception e = assertThrows(NotEnoughAssistantCardsException.class,
                () ->  game2.playAssistantCard("FirstPlayer", 0)  );
        assertEquals("someone doesn't have any more assistant cards, this is the last turn",
                e.getMessage());
    }

    @Test
    void checkWinCondition() {

    }


}