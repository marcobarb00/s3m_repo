package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayCharacterCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.CentaurComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.KnightComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.MushroomerComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.StandardComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PlayCharacterCardTest {
    Room room = new Room(null, 0, false);
    PlayerController player;

    @BeforeEach
    void roomInit() throws EmptyBagException {
        // GameState init
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, room.isExpertMode()));

        // PlayerController init
        Socket socket = new Socket();
        ClientHandler clientHandler = new ClientHandler(socket);
        player = new PlayerController(clientHandler);
        player.setNickname("FirstPlayer");
    }

    @Test
    void nullResponseThrowsIncorrectOperation(){
        assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, null));
    }

    @Test
    void playerResponseInstanceOfBackResponseThrowsBackException(){
        BackResponse backResponse = new BackResponse();
        assertThrows(BackException.class, () -> room.playCharacterCard(player, backResponse));
    }

    @Test
    void playerResponseNotEqualsToPlayCharacterCardResponseThrowsIncorrectOperationException(){
        PutStudentOnTableResponse putStudentOnTableResponse = new PutStudentOnTableResponse("RED");
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, putStudentOnTableResponse));
        assertEquals("the operation received is not the correct type", e.getMessage());
    }

    @Test
    void playerPlayCharacterCardResponsePositionOutOfBoundThrowsIncorrectOperationException(){
        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(20);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid character card position", e.getMessage());
    }

    // WRONG CHARACTER CARD (default case)
    @Test
    void incorrectNameOfChosenCardThrowsIncorrectOperationException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new CharacterCard());
        room.getGameState().getCharacterCardsList().get(0).setName("GenericCard");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("character card chosen does not exists", e.getMessage());
    }

    // CENTAUR
    @Test
    void nullPlayerControllerChoosingCentaurThrowsIncorrectOperationException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Centaur());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void choosingCentaurInNotExpertModeGameThrowsNotExpertModeException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Centaur());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(NotExpertModeException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    @Test
    void choosingCentaurWhenACharacterCardIsAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Centaur());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getTurn().setActivatedCharacterCard(true);

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void choosingCentaurWithoutEnoughCoinsThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Centaur());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    @Test
    void activatingCentaurEffectChangesComputeDominanceInstance() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Centaur());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").addCoins(2);

        assertEquals(3, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(3, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertFalse(room.getGameState().isCharacterCardActivated());
        assertInstanceOf(StandardComputeDominance.class, room.getGameState().getComputeDominanceStrategy());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        room.playCharacterCard(player, playCharacterCardResponse);

        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(4, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertTrue(room.getGameState().isCharacterCardActivated());
        assertInstanceOf(CentaurComputeDominance.class, room.getGameState().getComputeDominanceStrategy());
    }

    // KNIGHT
    @Test
    void nullPlayerControllerChoosingKnightThrowsIncorrectOperationException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Knight());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void choosingKnightInNotExpertModeGameThrowsNotExpertModeException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Knight());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(NotExpertModeException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    @Test
    void choosingKnightWhenACharacterCardIsAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Knight());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getTurn().setActivatedCharacterCard(true);

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void choosingKnightWithoutEnoughCoinsThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Knight());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    @Test
    void activatingKnightEffectChangesComputeDominanceInstance() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Knight());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").addCoins(1);

        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(2, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertFalse(room.getGameState().isCharacterCardActivated());
        assertInstanceOf(StandardComputeDominance.class, room.getGameState().getComputeDominanceStrategy());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        room.playCharacterCard(player, playCharacterCardResponse);

        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(3, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertTrue(room.getGameState().isCharacterCardActivated());
        assertInstanceOf(KnightComputeDominance.class, room.getGameState().getComputeDominanceStrategy());
    }

    // MINSTREL

    @Test
    void nullPlayerControllerChoosingMinstrelThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, studentsToPutOn);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullStudentsToGetFromChoosingMinstrelThrowsIncorrectOperationException(){
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, null, studentsToPutOn);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullStudentsToPutOnChoosingMinstrelThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, null);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void choosingMinstrelInNotExpertModeGameThrowsNotExpertModeException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, studentsToPutOn);
        Exception e = assertThrows(NotExpertModeException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    @Test
    void choosingMinstrelWhenACharacterCardIsAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getTurn().setActivatedCharacterCard(true);

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, studentsToPutOn);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void choosingMinstrelWithoutEnoughCoinsThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").removeCoins(1);
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, studentsToPutOn);
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    // MUSHROOMER
    @Test
    void nullPlayerControllerChoosingMushroomerThrowsIncorrectOperationException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Mushroomer());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, "RED");
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void choosingMushroomerInNotExpertModeGameThrowsNotExpertModeException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Mushroomer());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, "RED");
        Exception e = assertThrows(NotExpertModeException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    @Test
    void choosingMushroomerWhenACharacterCardIsAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Mushroomer());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getTurn().setActivatedCharacterCard(true);

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, "RED");
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void choosingMushroomerWithoutEnoughCoinsThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Mushroomer());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, "RED");
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    @Test
    void activatingMushroomerEffectChangesComputeDominanceInstance() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Mushroomer());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").addCoins(2);

        assertEquals(3, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(3, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertFalse(room.getGameState().isCharacterCardActivated());
        assertInstanceOf(StandardComputeDominance.class, room.getGameState().getComputeDominanceStrategy());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, "RED");
        room.playCharacterCard(player, playCharacterCardResponse);

        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(4, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertTrue(room.getGameState().isCharacterCardActivated());
        assertInstanceOf(MushroomerComputeDominance.class, room.getGameState().getComputeDominanceStrategy());
    }

    // JESTER

    // MAGIC POSTMAN
    @Test
    void nullPlayerControllerChoosingMagicPostmanThrowsIncorrectOperationException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new MagicPostman());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void choosingMagicPostmanInNotExpertModeGameThrowsNotExpertModeException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new MagicPostman());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(NotExpertModeException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    @Test
    void choosingMagicPostmanWhenACharacterCardIsAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new MagicPostman());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getTurn().setActivatedCharacterCard(true);

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void choosingMagicPostmanWithoutEnoughCoinsThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new MagicPostman());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").removeCoins(1);
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    @Test
    void activatingMagicPostmanEffectAddTwoMovementPointsToTheLastPlayedAssistantCardFromThePlayer() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new MagicPostman());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").setLastPlayedCard(AssistantCard.DOG);

        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getLastPlayedCard().getMovements());
        assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(1, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertFalse(room.getGameState().isCharacterCardActivated());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        room.playCharacterCard(player, playCharacterCardResponse);

        assertEquals(4, room.getGameState().getPlayerHashMap().get("FirstPlayer").getLastPlayedCard().getMovements());
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(2, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertTrue(room.getGameState().isCharacterCardActivated());
    }
}
