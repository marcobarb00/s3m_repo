package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.CentaurComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.KnightComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

        game.mergeIsland(game.getIslandsList().get(4), game.getIslandsList().get(5), false);
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
    void checkWinCondition2PlayersLessTowers() throws EmptyBagException, TieException, NullWinnerException {
        //one winner 2 players
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");
        player1.getDashboard().setNumberOfTowers(2);
        player2.getDashboard().setNumberOfTowers(3);
        assertEquals("player1", game.checkWinCondition());
    }

    @Test
    void checkWinCondition3PlayersTest() throws EmptyBagException, TieException, NullWinnerException {
        //one winner 3 player
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2", "player3"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");
        Player player3 = game.getPlayerHashMap().get("player3");
        player1.getDashboard().setNumberOfTowers(2);
        player2.getDashboard().setNumberOfTowers(3);
        player3.getDashboard().setNumberOfTowers(1);
        assertEquals("player3", game.checkWinCondition());
    }

    @Test
    void checkWinCondition2PlayersTestTowerTie() throws EmptyBagException, TieException, NullWinnerException {
        //tie 2 players
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");
        player1.getDashboard().setNumberOfTowers(2);
        player2.getDashboard().setNumberOfTowers(2);
        HashMap<PawnColor,Player> professors = game.getProfessorsHashMap();
        professors.replace(PawnColor.RED, player1);
        professors.replace(PawnColor.BLUE, player1);
        assertEquals("player1", game.checkWinCondition());
    }

    @Test
    void checkWinCondition3PlayersTestTowerTie() throws EmptyBagException, TieException, NullWinnerException {
        //tie 3 players
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2", "player3"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");
        Player player3 = game.getPlayerHashMap().get("player3");
        player1.getDashboard().setNumberOfTowers(2);
        player2.getDashboard().setNumberOfTowers(2);
        player3.getDashboard().setNumberOfTowers(2);
        HashMap<PawnColor,Player> professors = game.getProfessorsHashMap();
        professors.replace(PawnColor.RED, player1);
        professors.replace(PawnColor.BLUE, player1);
        assertEquals("player1", game.checkWinCondition());
    }

    @Test
    void zeroTowersLeftWinCondition2Players() throws EmptyBagException, TieException, NullWinnerException {
        //2 players
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");
        player1.getDashboard().setNumberOfTowers(0);
        player2.getDashboard().setNumberOfTowers(2);
        assertEquals("player1", game.zeroTowersLeftWinCondition());
    }

    @Test
    void zeroTowersLeftWinCondition2PlayersNoOneWithZeroTowers() throws EmptyBagException, NullWinnerException {
        //2 players
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");
        player1.getDashboard().setNumberOfTowers(1);
        player2.getDashboard().setNumberOfTowers(1);
        Exception e = assertThrows(NullWinnerException.class, () -> game.zeroTowersLeftWinCondition());
        assertEquals("Winner computation error", e.getMessage());
    }

    @Test
    void activateCentaurEffect2Players() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();

        //checking no character card
        assertEquals(0 ,game.getCharacterCardsList().size());
        game.getCharacterCardsList().add(new Centaur());
        Player player1 = game.getPlayerHashMap().get("player1");
        //check state before call
        player1.addCoins(2);
        assertEquals(3, player1.getCoins());
        assertFalse(game.getTurn().isActivatedCharacterCard());
        game.activateCentaurEffect("player1");
        //check state before call
        assertEquals(0, player1.getCoins());
        assertEquals(4, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());
        assertTrue(game.getComputeDominanceStrategy() instanceof CentaurComputeDominance);
    }

    @Test
    void activateCentaurEffect3Players() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2", "player3"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();

        //checking no character card activated
        assertEquals(0, game.getCharacterCardsList().size());
        game.getCharacterCardsList().add(new Centaur());
        Player player3 = game.getPlayerHashMap().get("player3");
        //check state before call
        player3.addCoins(2);
        assertEquals(3, player3.getCoins());
        assertFalse(game.getTurn().isActivatedCharacterCard());
        game.activateCentaurEffect("player3");
        //check state after call
        assertEquals(0, player3.getCoins());
        assertEquals(4, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());
    }


    @Test
    void activateJesterEffect() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();
        ArrayList<PawnColor> studentsGive;
        ArrayList<PawnColor> studentsGet;

        //checking no character card
        assertEquals(0, game.getCharacterCardsList().size());
        Jester jester = new Jester();
        game.getCharacterCardsList().add(jester);
        Player player1 = game.getPlayerHashMap().get("player1");
        HashMap<PawnColor, Integer> entrance = player1.getDashboard().getEntrance();
        entrance.replace(PawnColor.RED, 1);             //7 students
        entrance.replace(PawnColor.PINK, 2);
        entrance.replace(PawnColor.GREEN, 3);
        entrance.replace(PawnColor.BLUE, 1);
        entrance.replace(PawnColor.YELLOW, 0);

        HashMap<PawnColor, Integer> studentsOnJester = new HashMap<>();
        studentsOnJester.put(PawnColor.RED, 1);             //6 students
        studentsOnJester.put(PawnColor.PINK, 0);
        studentsOnJester.put(PawnColor.GREEN, 1);
        studentsOnJester.put(PawnColor.BLUE, 2);
        studentsOnJester.put(PawnColor.YELLOW, 2);
        jester.setStudentsOnCard(studentsOnJester);

        //check before call
        assertFalse(game.getTurn().isActivatedCharacterCard());

        studentsGet = new ArrayList<>(Arrays.asList(PawnColor.BLUE,PawnColor.BLUE,PawnColor.YELLOW));
        studentsGive = new ArrayList<>(Arrays.asList(PawnColor.RED,PawnColor.GREEN,PawnColor.GREEN));

        game.activateJesterEffect("player1", studentsGet, studentsGive);

        //check after call
        assertEquals(0, player1.getCoins());
        assertEquals(2, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());

        //checking entrance
        assertEquals(0, player1.getDashboard().getEntrance().get(PawnColor.RED));
        assertEquals(2, player1.getDashboard().getEntrance().get(PawnColor.PINK));
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.GREEN));
        assertEquals(3, player1.getDashboard().getEntrance().get(PawnColor.BLUE));
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.YELLOW));

        //checking on jester
        assertEquals(2, jester.getStudentsOnCard().get(PawnColor.RED));
        assertEquals(0, jester.getStudentsOnCard().get(PawnColor.PINK));
        assertEquals(3, jester.getStudentsOnCard().get(PawnColor.GREEN));
        assertEquals(0, jester.getStudentsOnCard().get(PawnColor.BLUE));
        assertEquals(1, jester.getStudentsOnCard().get(PawnColor.YELLOW));
    }

    @Test
    void activateKnightEffect2Players() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();

        //checking no character card
        assertEquals(0 ,game.getCharacterCardsList().size());
        game.getCharacterCardsList().add(new Knight());
        Player player1 = game.getPlayerHashMap().get("player1");

        //check state before call
        player1.addCoins(2);
        assertEquals(3, player1.getCoins());
        assertFalse(game.getTurn().isActivatedCharacterCard());
        game.activateKnightEffect("player1");

        //check state after call
        assertEquals(1, player1.getCoins());
        assertEquals(3, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());
        assertTrue(game.getComputeDominanceStrategy() instanceof KnightComputeDominance);
    }

    @Test
    void activateMagicPostmanEffect2Players() throws EmptyBagException, NotEnoughAssistantCardsException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();

        //checking no character card
        assertEquals(0 ,game.getCharacterCardsList().size());
        game.getCharacterCardsList().add(new Knight());
        Player player1 = game.getPlayerHashMap().get("player1");
        game.playAssistantCard("player1", 9);           //cheetah
        game.getTurn().setMotherNatureMaxAllowedMovements(AssistantCard.CHEETAH.getMovements());

        //check state before call
        player1.addCoins(2);
        assertEquals(3, player1.getCoins());
        assertFalse(game.getTurn().isActivatedCharacterCard());
        assertEquals(5, player1.getLastPlayedCard().getMovements());
        assertEquals(5, game.getTurn().getMotherNatureMaxAllowedMovements());

        game.activateMagicPostmanEffect("player1");

        //check state after call
        assertEquals(2, player1.getCoins());
        assertEquals(2, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());
        assertEquals(5, player1.getLastPlayedCard().getMovements());
        assertEquals(7, game.getTurn().getMotherNatureMaxAllowedMovements());
    }

    @Test
    void activateMinstrelEffect() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();
        ArrayList<PawnColor> studentsGive;
        ArrayList<PawnColor> studentsGet;

        //checking no character card
        assertEquals(0, game.getCharacterCardsList().size());
        Minstrel minstrel = new Minstrel();
        game.getCharacterCardsList().add(minstrel);
        Player player1 = game.getPlayerHashMap().get("player1");
        HashMap<PawnColor, Integer> entrance = player1.getDashboard().getEntrance();
        entrance.replace(PawnColor.RED, 1);             //7 students
        entrance.replace(PawnColor.PINK, 2);
        entrance.replace(PawnColor.GREEN, 3);
        entrance.replace(PawnColor.BLUE, 1);
        entrance.replace(PawnColor.YELLOW, 0);

        HashMap<PawnColor, Integer> studentsInHall = player1.getDashboard().getTables();
        studentsInHall.replace(PawnColor.RED, 1);             //6 students
        studentsInHall.replace(PawnColor.PINK, 0);
        studentsInHall.replace(PawnColor.GREEN, 1);
        studentsInHall.replace(PawnColor.BLUE, 2);
        studentsInHall.replace(PawnColor.YELLOW, 2);

        //check before call
        assertFalse(game.getTurn().isActivatedCharacterCard());

        studentsGet = new ArrayList<>(Arrays.asList(PawnColor.BLUE,PawnColor.BLUE,PawnColor.YELLOW));
        studentsGive = new ArrayList<>(Arrays.asList(PawnColor.RED,PawnColor.GREEN,PawnColor.GREEN));

        game.activateMinstrelEffect("player1", studentsGet, studentsGive);

        //check after call
        assertEquals(1, player1.getCoins());
        assertEquals(2, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());

        //checking entrance
        assertEquals(0, player1.getDashboard().getEntrance().get(PawnColor.RED));
        assertEquals(2, player1.getDashboard().getEntrance().get(PawnColor.PINK));
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.GREEN));
        assertEquals(3, player1.getDashboard().getEntrance().get(PawnColor.BLUE));
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.YELLOW));

        //checking in tables
        assertEquals(2, player1.getDashboard().getTables().get(PawnColor.RED));
        assertEquals(0, player1.getDashboard().getTables().get(PawnColor.PINK));
        assertEquals(3, player1.getDashboard().getTables().get(PawnColor.GREEN));
        assertEquals(0, player1.getDashboard().getTables().get(PawnColor.BLUE));
        assertEquals(1, player1.getDashboard().getTables().get(PawnColor.YELLOW));
    }

    @Test
    void activateMushroomerEffect2Players() throws EmptyBagException, NotEnoughAssistantCardsException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        game.getCharacterCardsList().clear();

        //checking no character card
        assertEquals(0 ,game.getCharacterCardsList().size());
        game.getCharacterCardsList().add(new Mushroomer());
        Player player1 = game.getPlayerHashMap().get("player1");

        //check state before call
        game.playAssistantCard("player1", 9);
        player1.addCoins(2);
        assertEquals(3, player1.getCoins());
        assertFalse(game.getTurn().isActivatedCharacterCard());

        game.activateMushroomerEffect("player1", PawnColor.BLUE);

        //check state after call
        assertEquals(0, player1.getCoins());
        assertEquals(4, game.getCharacterCardsList().get(0).getCost());
        assertTrue(game.getTurn().isActivatedCharacterCard());
    }

    @Test
    void chooseCloud2playersTest() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");

        //4 students in entrance before choosing cloud
        HashMap<PawnColor, Integer> entrance = player1.getDashboard().getEntrance();
        entrance.replace(PawnColor.RED, 1);
        entrance.replace(PawnColor.PINK, 2);
        entrance.replace(PawnColor.GREEN, 0);
        entrance.replace(PawnColor.BLUE, 1);
        entrance.replace(PawnColor.YELLOW, 0);

        Cloud cloud = game.getCloudsList().get(0);
        ArrayList<Student> studentsGet = new ArrayList<>(
                Arrays.asList(
                    new Student(PawnColor.BLUE),
                    new Student(PawnColor.BLUE),
                    new Student(PawnColor.YELLOW)
                )
        );
        cloud.setStudents(studentsGet);

        game.chooseCloud("player1", 0);

        //checking entrance
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.RED));
        assertEquals(2, player1.getDashboard().getEntrance().get(PawnColor.PINK));
        assertEquals(0, player1.getDashboard().getEntrance().get(PawnColor.GREEN));
        assertEquals(3, player1.getDashboard().getEntrance().get(PawnColor.BLUE));
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.YELLOW));
    }

    @Test
    void putStudentsOnTablesTest() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");

        //set state before call
        HashMap<PawnColor, Integer> studentsInHall = player1.getDashboard().getTables();
        studentsInHall.replace(PawnColor.RED, 1);             //6 students
        studentsInHall.replace(PawnColor.PINK, 0);
        studentsInHall.replace(PawnColor.GREEN, 1);
        studentsInHall.replace(PawnColor.BLUE, 2);
        studentsInHall.replace(PawnColor.YELLOW, 2);

        game.putStudentOnTables("player1", PawnColor.BLUE);

        //check after call
        //checking in tables
        assertEquals(1, player1.getDashboard().getTables().get(PawnColor.RED));
        assertEquals(0, player1.getDashboard().getTables().get(PawnColor.PINK));
        assertEquals(1, player1.getDashboard().getTables().get(PawnColor.GREEN));
        assertEquals(3, player1.getDashboard().getTables().get(PawnColor.BLUE));
        assertEquals(2, player1.getDashboard().getTables().get(PawnColor.YELLOW));

        //checking coins
        assertEquals(2, player1.getCoins());
    }

    @Test
    void putStudentsOnIslandsTest() throws EmptyBagException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");

        //set state before call
        HashMap<PawnColor, Integer> entrance = player1.getDashboard().getEntrance();
        entrance.replace(PawnColor.RED,         1);         //7 students
        entrance.replace(PawnColor.PINK,        2);
        entrance.replace(PawnColor.GREEN,       0);
        entrance.replace(PawnColor.BLUE,        1);
        entrance.replace(PawnColor.YELLOW,      3);

        Island island = game.getIslandsList().get(0);
        HashMap<PawnColor, Integer> studentsOnIsland = island.getStudents();
        studentsOnIsland.replace(PawnColor.RED,       0);
        studentsOnIsland.replace(PawnColor.PINK,      0);
        studentsOnIsland.replace(PawnColor.GREEN,     0);
        studentsOnIsland.replace(PawnColor.BLUE,      0);
        studentsOnIsland.replace(PawnColor.YELLOW,    0);

        game.putStudentOnIslands("player1", 0,PawnColor.BLUE);

        //check after call
        //checking on island
        assertEquals(0, island.getStudents().get(PawnColor.RED));
        assertEquals(0, island.getStudents().get(PawnColor.PINK));
        assertEquals(0, island.getStudents().get(PawnColor.GREEN));
        assertEquals(1, island.getStudents().get(PawnColor.BLUE));
        assertEquals(0, island.getStudents().get(PawnColor.YELLOW));

        //checking in entrance
        assertEquals(1, player1.getDashboard().getEntrance().get(PawnColor.RED));
        assertEquals(2, player1.getDashboard().getEntrance().get(PawnColor.PINK));
        assertEquals(0, player1.getDashboard().getEntrance().get(PawnColor.GREEN));
        assertEquals(0, player1.getDashboard().getEntrance().get(PawnColor.BLUE));
        assertEquals(3, player1.getDashboard().getEntrance().get(PawnColor.YELLOW));
    }

    @Test
    void moveMotherNatureEasyTest() throws EmptyBagException,
            ZeroTowersRemainedException, NotEnoughIslandsException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");

        //setting state
        HashMap<PawnColor, Player> professors = game.getProfessorsHashMap();
        professors.replace(PawnColor.RED, player1);
        Island island1 = game.getIslandsList().get(1);
        island1.addStudent(PawnColor.RED);
        player1.getDashboard().getTables().replace(PawnColor.RED,2);

        game.moveMotherNature(1);

        //check after call
        assertEquals(1, game.getMotherNature().getCurrentPosition());
        assertEquals(player1, island1.getDominator());
    }

    @Test
    void moveMotherNatureHardTest() throws EmptyBagException,
            ZeroTowersRemainedException, NotEnoughIslandsException {
        ArrayList<String> players = new ArrayList<>(Arrays.asList("player1", "player2"));
        Game game = new Game(players, true);
        Player player1 = game.getPlayerHashMap().get("player1");
        Player player2 = game.getPlayerHashMap().get("player2");

        //setting state
        HashMap<PawnColor, Player> professors = game.getProfessorsHashMap();
        professors.replace(PawnColor.RED, player1);
        professors.replace(PawnColor.BLUE, player1);
        Island island1 = game.getIslandsList().get(1);
        island1.addStudent(PawnColor.RED);
        island1.addStudent(PawnColor.RED);
        island1.addStudent(PawnColor.BLUE);
        player1.getDashboard().getTables().replace(PawnColor.RED,2);
        player2.getDashboard().getTables().replace(PawnColor.BLUE,2);

        game.moveMotherNature(1);

        //check after call
        assertEquals(1, game.getMotherNature().getCurrentPosition());
        assertEquals(player1, island1.getDominator());
    }

}