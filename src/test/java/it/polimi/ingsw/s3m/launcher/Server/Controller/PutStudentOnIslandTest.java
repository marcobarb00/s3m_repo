package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.BackResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnIslandResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.BackException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PutStudentOnIslandTest {
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
        assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, null));
    }

    @Test
    void playerResponseInstanceOfBackResponseThrowsBackException(){
        BackResponse backResponse = new BackResponse();
        assertThrows(BackException.class, () -> room.putStudentOnIsland(player, backResponse));
    }

    @Test
    void playerResponseNotEqualsToPutStudentOnIslandResponseThrowsIncorrectOperationException(){
        PutStudentOnTableResponse putStudentOnTableResponse = new PutStudentOnTableResponse("RED");
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnTableResponse));
        assertEquals("the operation received is not the correct type", e.getMessage());
    }

    @Test
    void nullGameStateInRoomThrowsIncorrectOperationException(){
        room.setGameState(null);
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnIslandResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullPlayerControllerThrowsIncorrectOperationException(){
        player = null;
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnIslandResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void TwoPlayersGameMovedStudentsInCurrentActionPhaseEquals3ThrowsIncorrectOperationException(){
        for (int i = 0; i < 3; i++)
            room.getGameState().getTurn().incrementMovedStudents();
        assertEquals(3, room.getGameState().getTurnMovedStudents());
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnIslandResponse));
        assertEquals("Cannot move another student", e.getMessage());
    }

    @Test
    void ThreePlayersGameMoveStudentsInCurrentActionPhaseEquals4ThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        nicknames.add("ThirdPlayer");
        room.setGameState(new Game(nicknames, room.isExpertMode()));

        for (int i = 0; i < 4; i++)
            room.getGameState().getTurn().incrementMovedStudents();
        assertEquals(4, room.getGameState().getTurnMovedStudents());
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnIslandResponse));
        assertEquals("Cannot move another student", e.getMessage());
    }

    @Test
    void playerPutStudentOnIslandResponseColorEquals0StudentsInEntranceThrowsIncorrectOperationException(){
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 0);
        System.out.println("0 students test: " + room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));
        while (room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED) != 0) {
            Player gamePlayer = room.getGameState().getPlayerHashMap().get(player.getNickname());
            gamePlayer.getDashboard().getEntrance().replace(PawnColor.RED, gamePlayer.getDashboard().getEntrance().get(PawnColor.RED)-1);
        }
        assertEquals(0, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnIslandResponse));
        assertEquals("Student not in entrance", e.getMessage());
    }

    @Test
    void playerPutStudentOnIslandResponseColorEquals1StudentInEntranceThen0StudentsLeftAfterPutStudentOnIslandMethodExecution() throws BackException, PlayerNotInListException, IncorrectOperationException {
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 0);
        Player gamePlayer = room.getGameState().getPlayerHashMap().get(player.getNickname());
        System.out.println("1 student method - students: " + room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));

        if (room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED) == 0)
            gamePlayer.getDashboard().getEntrance().replace(PawnColor.RED, 1);
        else {
            while (room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED) != 1) {
                gamePlayer = room.getGameState().getPlayerHashMap().get(player.getNickname());
                gamePlayer.getDashboard().getEntrance().replace(PawnColor.RED, gamePlayer.getDashboard().getEntrance().get(PawnColor.RED)-1);
            }
        }
        assertEquals(1, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));

        room.putStudentOnIsland(player, putStudentOnIslandResponse);
        assertEquals(0, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));
    }

    @Test
    void playerPutStudentOnIslandResponsePositionIsNotContainedInIslandListArraySizeThrowsIncorrectOperationException(){
        PutStudentOnIslandResponse putStudentOnIslandResponse = new PutStudentOnIslandResponse("RED", 20);
        Player gamePlayer = room.getGameState().getPlayerHashMap().get(player.getNickname());
        System.out.println("1 student method - islands: " + room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));

        if (room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED) == 0)
            gamePlayer.getDashboard().getEntrance().replace(PawnColor.RED, 1);
        else {
            while (room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED) != 1) {
                gamePlayer = room.getGameState().getPlayerHashMap().get(player.getNickname());
                gamePlayer.getDashboard().getEntrance().replace(PawnColor.RED, gamePlayer.getDashboard().getEntrance().get(PawnColor.RED)-1);
            }
        }
        assertEquals(1, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));

        Exception e = assertThrows(IncorrectOperationException.class, () -> room.putStudentOnIsland(player, putStudentOnIslandResponse));
        assertEquals("Incorrect island value", e.getMessage());
    }
}
