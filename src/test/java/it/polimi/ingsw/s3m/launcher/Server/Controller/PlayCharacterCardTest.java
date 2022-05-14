package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayCharacterCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.Centaur;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.CentaurComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.ComputeDominance.StandardComputeDominance;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
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
        assertThrows(IncorrectOperationException.class, () -> room.playCharacterCard(null, playCharacterCardResponse));
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
    void activatingCentaurEffectChangesActivatedCharacterCardToTrueAndComputeDominanceInstance() throws EmptyBagException, NotEnoughCoinsException, NotPlayerTurnException, NotEnoughAssistantCardsException, BackException, CharacterCardAlreadyActivatedException, ZeroTowersRemainedException, NotExpertModeException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
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
}
