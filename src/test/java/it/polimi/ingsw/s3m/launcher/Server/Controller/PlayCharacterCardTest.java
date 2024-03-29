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
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
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
    void responseFromAPlayerNotInListChoosingCentaurThrowsPlayerNotInListException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Centaur());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        player.setNickname("IncorrectPlayer");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("player is not in list", e.getMessage());
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
    void responseFromAPlayerNotInListChoosingKnightThrowsPlayerNotInListException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Knight());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        player.setNickname("IncorrectPlayer");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("player is not in list", e.getMessage());
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

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
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

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, null);
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

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, null, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void studentsToGetFromContainingNullChoosingMinstrelThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add(null);
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void studentsToPutOnContainingNullChoosingMinstrelThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add(null);

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void responseFromAPlayerNotInListChoosingMinstrelThrowsPlayerNotInListException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        player.setNickname("IncorrectPlayer");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("player is not in list", e.getMessage());
    }

    @Test
    void choosingMinstrelInNotExpertModeGameThrowsNotExpertModeException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
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

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
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

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    @Test
    void choosingMinstrelWithIncorrectStudentsToGetFromSizeThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("GREEN");
        studentsToGetFrom.add("YELLOW");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("RED");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Incorrect students value", e.getMessage());
    }

    @Test
    void choosingMinstrelWithIncorrectStudentsToPutOnSizeThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("RED");
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("YELLOW");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Incorrect students value", e.getMessage());
    }

    @Test
    void choosingMinstrelWithCorrectButNotEqualsStudentsToGetFromAndStudentsToPutOnSizesThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("RED");
        studentsToPutOn.add("GREEN");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Incorrect students value", e.getMessage());
    }

    @Test
    void choosingMinstrelWithoutStudentsInEntranceThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 0);
            assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Not enough students in entrance", e.getMessage());
    }

    @Test
    void choosingMinstrelWithoutEnoughStudentsInEntranceThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Minstrel());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 1);
            assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Not enough students in entrance", e.getMessage());
    }

   @Test
   void choosingMinstrelWithoutStudentsOnTablesThrowsIncorrectOperationException() throws EmptyBagException {
       ArrayList<String> nicknames = new ArrayList<>();
       nicknames.add("FirstPlayer");
       nicknames.add("SecondPlayer");
       room.setGameState(new Game(nicknames, true));
       ArrayList<String> studentsToGetFrom = new ArrayList<>();
       studentsToGetFrom.add("RED");
       ArrayList<String> studentsToPutOn = new ArrayList<>();
       studentsToPutOn.add("GREEN");

       room.getGameState().getCharacterCardsList().clear();
       assertEquals(0, room.getGameState().getCharacterCardsList().size());
       room.getGameState().getCharacterCardsList().add(new Minstrel());
       assertEquals(1, room.getGameState().getCharacterCardsList().size());
       for (PawnColor color : PawnColor.values()) {
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 1);
           assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().replace(color, 0);
           assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(color));
       }

       PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
       Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
       assertEquals("Not enough students on tables", e.getMessage());
   }

   @Test
   void choosingMinstrelWithoutEnoughStudentsOnTablesThrowsIncorrectOperationException() throws EmptyBagException {
       ArrayList<String> nicknames = new ArrayList<>();
       nicknames.add("FirstPlayer");
       nicknames.add("SecondPlayer");
       room.setGameState(new Game(nicknames, true));
       ArrayList<String> studentsToGetFrom = new ArrayList<>();
       studentsToGetFrom.add("RED");
       studentsToGetFrom.add("RED");
       ArrayList<String> studentsToPutOn = new ArrayList<>();
       studentsToPutOn.add("GREEN");
       studentsToPutOn.add("GREEN");

       room.getGameState().getCharacterCardsList().clear();
       assertEquals(0, room.getGameState().getCharacterCardsList().size());
       room.getGameState().getCharacterCardsList().add(new Minstrel());
       assertEquals(1, room.getGameState().getCharacterCardsList().size());
       for (PawnColor color : PawnColor.values()) {
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 2);
           assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().replace(color, 1);
           assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(color));
       }

       PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
       Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
       assertEquals("Not enough students on tables", e.getMessage());
   }

   @Test
   void tryToInsertStudentsInFullTablesThrowsIncorrectOperationException() throws EmptyBagException {
       ArrayList<String> nicknames = new ArrayList<>();
       nicknames.add("FirstPlayer");
       nicknames.add("SecondPlayer");
       room.setGameState(new Game(nicknames, true));
       ArrayList<String> studentsToGetFrom = new ArrayList<>();
       studentsToGetFrom.add("BLUE");
       studentsToGetFrom.add("RED");
       ArrayList<String> studentsToPutOn = new ArrayList<>();
       studentsToPutOn.add("GREEN");
       studentsToPutOn.add("GREEN");

       room.getGameState().getCharacterCardsList().clear();
       assertEquals(0, room.getGameState().getCharacterCardsList().size());
       room.getGameState().getCharacterCardsList().add(new Minstrel());
       assertEquals(1, room.getGameState().getCharacterCardsList().size());
       for (PawnColor color : PawnColor.values()) {
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 2);
           assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().replace(color, 9);
           assertEquals(9, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(color));
       }

       PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
       Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
       assertEquals("Too much students moving on tables", e.getMessage());
   }

   @Test
   void activatingMinstrelEffectChangesEntranceAndTablesState() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
       ArrayList<String> nicknames = new ArrayList<>();
       nicknames.add("FirstPlayer");
       nicknames.add("SecondPlayer");
       room.setGameState(new Game(nicknames, true));
       ArrayList<String> studentsToGetFrom = new ArrayList<>();
       studentsToGetFrom.add("RED");
       studentsToGetFrom.add("RED");
       ArrayList<String> studentsToPutOn = new ArrayList<>();
       studentsToPutOn.add("GREEN");
       studentsToPutOn.add("GREEN");

       room.getGameState().getCharacterCardsList().clear();
       assertEquals(0, room.getGameState().getCharacterCardsList().size());
       room.getGameState().getCharacterCardsList().add(new Minstrel());
       assertEquals(1, room.getGameState().getCharacterCardsList().size());
       for (PawnColor color : PawnColor.values()) {
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 0);
           assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
           room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().replace(color, 0);
           assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(color));
       }

       room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(PawnColor.GREEN, 2);
       assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.GREEN));
       room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().replace(PawnColor.RED, 2);
       assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(PawnColor.RED));

       assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
       assertEquals(1, room.getGameState().getCharacterCardsList().get(0).getCost());
       assertFalse(room.getGameState().isCharacterCardActivated());

       PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
       room.playCharacterCard(player, playCharacterCardResponse);

       assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
       assertEquals(2, room.getGameState().getCharacterCardsList().get(0).getCost());
       assertTrue(room.getGameState().isCharacterCardActivated());
       assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.GREEN));
       assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.RED));
       assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(PawnColor.RED));
       assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getTables().get(PawnColor.GREEN));
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
    void responseFromAPlayerNotInListChoosingMushroomerThrowsPlayerNotInListException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Mushroomer());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        player.setNickname("IncorrectPlayer");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, "RED");
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("player is not in list", e.getMessage());
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

    @Test
    void nullPlayerControllerChoosingJesterThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, studentsToPutOn);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullStudentsToGetFromChoosingJesterThrowsIncorrectOperationException(){
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, null);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullStudentsToPutOnChoosingJesterThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, null, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void studentsToGetFromContainingNullChoosingJesterThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add(null);
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void studentsToPutOnContainingNullChoosingJesterThrowsIncorrectOperationException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add(null);

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void responseFromAPlayerNotInListChoosingJesterThrowsPlayerNotInListException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        player.setNickname("IncorrectPlayer");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("player is not in list", e.getMessage());
    }

    @Test
    void choosingJesterInNotExpertModeGameThrowsNotExpertModeException(){
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToGetFrom, studentsToPutOn);
        Exception e = assertThrows(NotExpertModeException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    @Test
    void choosingJesterWhenACharacterCardIsAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getTurn().setActivatedCharacterCard(true);

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void choosingJesterWithoutEnoughCoinsThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        ArrayList<String> studentsToPutOn = new ArrayList<>();

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getPlayerHashMap().get("FirstPlayer").removeCoins(1);
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(NotEnoughCoinsException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("you don't have enough coins", e.getMessage());
    }

    @Test
    void choosingJesterWithIncorrectStudentsToGetFromSizeThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("GREEN");
        studentsToGetFrom.add("YELLOW");
        studentsToGetFrom.add("PINK");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("RED");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Incorrect exchange students value", e.getMessage());
    }

    @Test
    void choosingJesterWithIncorrectStudentsToPutOnSizeThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("RED");
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("YELLOW");
        studentsToPutOn.add("PINK");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Incorrect exchange students value", e.getMessage());
    }

    @Test
    void choosingJesterWithCorrectButNotEqualsStudentsToGetFromAndStudentsToPutOnSizesThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("RED");
        studentsToPutOn.add("GREEN");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Incorrect exchange students value", e.getMessage());
    }

    @Test
    void choosingJesterWithoutStudentsOnCardThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 0);
            assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Not enough students on jester card", e.getMessage());
    }

    @Test
    void choosingJesterWithoutEnoughStudentsOnCardThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("RED");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        HashMap<PawnColor, Integer> studentsOnCard = new HashMap<>();
        for (PawnColor color : PawnColor.values())
            studentsOnCard.put(color, 0);
        studentsOnCard.replace(PawnColor.RED, 1);

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        ((Jester) room.getGameState().getCharacterCardsList().get(0)).setStudentsOnCard(studentsOnCard);
        assertEquals(1, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(PawnColor.RED));
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 0);
            assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Not enough students on jester card", e.getMessage());
    }

    @Test
    void choosingJesterWithoutStudentsInEntranceThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("PINK");
        studentsToGetFrom.add("YELLOW");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        HashMap<PawnColor, Integer> studentsOnCard = new HashMap<>();
        for (PawnColor color : PawnColor.values())
            studentsOnCard.put(color, 1);

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        ((Jester) room.getGameState().getCharacterCardsList().get(0)).setStudentsOnCard(studentsOnCard);
        for (PawnColor color : PawnColor.values())
            assertEquals(1, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(color));
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 0);
            assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Not enough students in entrance", e.getMessage());
    }

    @Test
    void choosingJesterWithoutEnoughStudentsInEntranceThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("PINK");
        studentsToGetFrom.add("YELLOW");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        HashMap<PawnColor, Integer> studentsOnCard = new HashMap<>();
        for (PawnColor color : PawnColor.values())
            studentsOnCard.put(color, 1);

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        ((Jester) room.getGameState().getCharacterCardsList().get(0)).setStudentsOnCard(studentsOnCard);
        for (PawnColor color : PawnColor.values())
            assertEquals(1, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(color));
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 1);
            assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("Not enough students in entrance", e.getMessage());
    }

    @Test
    void activatingJesterEffectChangesEntranceAndStudentsOnCardState() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));
        ArrayList<String> studentsToGetFrom = new ArrayList<>();
        studentsToGetFrom.add("RED");
        studentsToGetFrom.add("PINK");
        studentsToGetFrom.add("YELLOW");
        ArrayList<String> studentsToPutOn = new ArrayList<>();
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("GREEN");
        studentsToPutOn.add("BLUE");
        HashMap<PawnColor, Integer> studentsOnCard = new HashMap<>();
        for (PawnColor color : PawnColor.values())
            studentsOnCard.put(color, 1);

        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new Jester());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        ((Jester) room.getGameState().getCharacterCardsList().get(0)).setStudentsOnCard(studentsOnCard);
        for (PawnColor color : PawnColor.values())
                assertEquals(1, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(color));
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(color, 1);
            assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(color));
        }
        room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().replace(PawnColor.GREEN, 2);
        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.GREEN));

        assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(1, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertFalse(room.getGameState().isCharacterCardActivated());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0, studentsToPutOn, studentsToGetFrom);
        room.playCharacterCard(player, playCharacterCardResponse);

        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(2, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertTrue(room.getGameState().isCharacterCardActivated());
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.BLUE));
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.GREEN));
        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.PINK));
        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.RED));
        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getDashboard().getEntrance().get(PawnColor.YELLOW));

        assertEquals(2, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(PawnColor.BLUE));
        assertEquals(3, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(PawnColor.GREEN));
        assertEquals(0, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(PawnColor.PINK));
        assertEquals(0, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(PawnColor.RED));
        assertEquals(0, ((Jester) room.getGameState().getCharacterCardsList().get(0)).getStudentsOnCard().get(PawnColor.YELLOW));
    }

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
    void responseFromAPlayerNotInListChoosingMagicPostmanThrowsPlayerNotInListException(){
        room.getGameState().getCharacterCardsList().clear();
        assertEquals(0, room.getGameState().getCharacterCardsList().size());
        room.getGameState().getCharacterCardsList().add(new MagicPostman());
        assertEquals(1, room.getGameState().getCharacterCardsList().size());
        player.setNickname("IncorrectPlayer");

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.playCharacterCard(player, playCharacterCardResponse));
        assertEquals("player is not in list", e.getMessage());
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
        room.getGameState().getTurn().setMotherNatureMaxAllowedMovements(room.getGameState().getPlayerHashMap().get("FirstPlayer").getLastPlayedCard().getMovements());

        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getLastPlayedCard().getMovements());
        assertEquals(2, room.getGameState().getTurn().getMotherNatureMaxAllowedMovements());
        assertEquals(1, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(1, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertFalse(room.getGameState().isCharacterCardActivated());

        PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse(0);
        room.playCharacterCard(player, playCharacterCardResponse);

        assertEquals(2, room.getGameState().getPlayerHashMap().get("FirstPlayer").getLastPlayedCard().getMovements());
        assertEquals(4, room.getGameState().getTurn().getMotherNatureMaxAllowedMovements());
        assertEquals(0, room.getGameState().getPlayerHashMap().get("FirstPlayer").getCoins());
        assertEquals(2, room.getGameState().getCharacterCardsList().get(0).getCost());
        assertTrue(room.getGameState().isCharacterCardActivated());
    }
}
