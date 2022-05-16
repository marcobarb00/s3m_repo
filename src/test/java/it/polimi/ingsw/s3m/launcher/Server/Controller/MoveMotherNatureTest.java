package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.MoveMotherNatureResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveMotherNatureTest {
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
        assertThrows(IncorrectOperationException.class, () -> room.moveMotherNature(player, null));
    }

    @Test
    void playerResponseInstanceOfBackResponseThrowsBackException(){
        BackResponse backResponse = new BackResponse();
        assertThrows(BackException.class, () -> room.moveMotherNature(player, backResponse));
    }

    @Test
    void playerResponseNotEqualsToMoveMotherNatureResponseResponseThrowsIncorrectOperationException(){
        PutStudentOnTableResponse putStudentOnTableResponse = new PutStudentOnTableResponse("RED");
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.moveMotherNature(player, putStudentOnTableResponse));
        assertEquals("the operation received is not the correct type", e.getMessage());
    }

    @Test
    void nullGameStateInRoomThrowsIncorrectOperationException(){
        room.setGameState(null);
        MoveMotherNatureResponse moveMotherNatureResponse = new MoveMotherNatureResponse(1);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.moveMotherNature(player, moveMotherNatureResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullPlayerControllerThrowsIncorrectOperationException(){
        player = null;
        MoveMotherNatureResponse moveMotherNatureResponse = new MoveMotherNatureResponse(1);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.moveMotherNature(player, moveMotherNatureResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void responseFromAPlayerNotInListThrowsPlayerNotInListException(){
        player.setNickname("IncorrectPlayer");

        MoveMotherNatureResponse moveMotherNatureResponse = new MoveMotherNatureResponse(1);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.moveMotherNature(player, moveMotherNatureResponse));
        assertEquals("player is not in list", e.getMessage());
    }

    @Test
    void motherNatureMovementInPlayerResponseSmallerThanOneThrowsIncorrectOperationException(){
        room.getGameState().getPlayerHashMap().get(player.getNickname()).setLastPlayedCard(AssistantCard.OCTOPUS);
        assertEquals(2, room.getGameState().getPlayerHashMap().get(player.getNickname()).getLastPlayedCard().getMovements());

        MoveMotherNatureResponse moveMotherNatureResponse = new MoveMotherNatureResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.moveMotherNature(player, moveMotherNatureResponse));
        assertEquals("Incorrect mother nature movement value", e.getMessage());
    }

    @Test
    void motherNatureMovementInPlayerResponseGreaterThanPlayerLastPlayedCardMovementsThrowsIncorrectOperationException(){
        room.getGameState().getPlayerHashMap().get(player.getNickname()).setLastPlayedCard(AssistantCard.OCTOPUS);
        assertEquals(2, room.getGameState().getPlayerHashMap().get(player.getNickname()).getLastPlayedCard().getMovements());

        MoveMotherNatureResponse moveMotherNatureResponse = new MoveMotherNatureResponse(3);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.moveMotherNature(player, moveMotherNatureResponse));
        assertEquals("Incorrect mother nature movement value", e.getMessage());
    }

    @Test
    void rightValueOfMotherNatureMovementInPlayerResponseUpdatesMotherNaturePositionInGame() throws NotPlayerTurnException, BackException, ZeroTowersRemainedException, PlayerNotInListException, IncorrectOperationException, NotEnoughIslandsException {
        room.getGameState().getPlayerHashMap().get(player.getNickname()).setLastPlayedCard(AssistantCard.OCTOPUS);
        assertEquals(2, room.getGameState().getPlayerHashMap().get(player.getNickname()).getLastPlayedCard().getMovements());
        assertEquals(0, room.getGameState().getMotherNature().getCurrentPosition());

        MoveMotherNatureResponse moveMotherNatureResponse = new MoveMotherNatureResponse(2);
        room.moveMotherNature(player, moveMotherNatureResponse);
        assertEquals(2, room.getGameState().getMotherNature().getCurrentPosition());
    }
}
