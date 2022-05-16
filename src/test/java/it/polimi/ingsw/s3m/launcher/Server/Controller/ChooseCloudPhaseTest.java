package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.CloudResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Student;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChooseCloudPhaseTest {
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
        assertThrows(IncorrectOperationException.class, () -> room.chooseCloudPhase(player, null));
    }

    @Test
    void playerResponseNotEqualsToCloudThrowsIncorrectOperationException(){
        PutStudentOnTableResponse putStudentOnTableResponse = new PutStudentOnTableResponse("RED");
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.chooseCloudPhase(player, putStudentOnTableResponse));
        assertEquals("the operation received is not the correct type", e.getMessage());
    }

    @Test
    void nullGameStateInRoomThrowsIncorrectOperationException(){
        room.setGameState(null);
        CloudResponse cloudResponse = new CloudResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.chooseCloudPhase(player, cloudResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void nullPlayerControllerThrowsIncorrectOperationException(){
        player = null;
        CloudResponse cloudResponse = new CloudResponse(0);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.chooseCloudPhase(player, cloudResponse));
        assertEquals("Invalid arguments", e.getMessage());
    }

    @Test
    void responseFromAPlayerNotInListThrowsPlayerNotInListException(){
        player.setNickname("IncorrectPlayer");

        CloudResponse cloudResponse = new CloudResponse(0);
        Exception e = assertThrows(PlayerNotInListException.class, () -> room.chooseCloudPhase(player, cloudResponse));
        assertEquals("player is not in list", e.getMessage());
    }

    @Test
    void cloudPositionOutOfArrayBoundariesThrowsCloudNotInListException(){
        CloudResponse cloudResponse = new CloudResponse(2);
        Exception e = assertThrows(CloudNotInListException.class, () -> room.chooseCloudPhase(player, cloudResponse));
        assertEquals("the selected cloud is not available", e.getMessage());
    }

    @Test
    void choosingLastPositionOfCloudListTwiceThrowsCloudNotInListException() throws CloudNotInListException, PlayerNotInListException, IncorrectOperationException {
        assertEquals(2, room.getGameState().getCloudsList().size());

        CloudResponse cloudResponse = new CloudResponse(1);
        room.chooseCloudPhase(player, cloudResponse);
        assertEquals(1, room.getGameState().getCloudsList().size());

        Exception e = assertThrows(CloudNotInListException.class, () -> room.chooseCloudPhase(player, cloudResponse));
        assertEquals("the selected cloud is not available", e.getMessage());
    }

    @Test
    void threePlayersGameCloudListArraySizeEquals3() throws EmptyBagException, CloudNotInListException, PlayerNotInListException, IncorrectOperationException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        nicknames.add("ThirdPlayer");
        room.setGameState(new Game(nicknames, room.isExpertMode()));
        assertEquals(3, room.getGameState().getCloudsList().size());

        CloudResponse cloudResponse = new CloudResponse(2);
        room.chooseCloudPhase(player, cloudResponse);
        assertEquals(2, room.getGameState().getCloudsList().size());
    }

    @Test
    void choosingAValidCloudPutStudentsOnCloudInPlayerEntrance() throws CloudNotInListException, PlayerNotInListException, IncorrectOperationException {
        ArrayList<Student> studentsOnCloud = new ArrayList<>();
        studentsOnCloud.add(new Student(PawnColor.BLUE));
        studentsOnCloud.add(new Student(PawnColor.RED));
        studentsOnCloud.add(new Student(PawnColor.RED));

        assertEquals(2, room.getGameState().getCloudsList().size());
        for (PawnColor color : PawnColor.values()) {
            room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().replace(color, 0);
            assertEquals(0, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(color));
        }
        room.getGameState().getCloudsList().get(0).setStudents(studentsOnCloud);

        CloudResponse cloudResponse = new CloudResponse(0);
        room.chooseCloudPhase(player, cloudResponse);

        assertEquals(1, room.getGameState().getCloudsList().size());
        assertEquals(1, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.BLUE));
        assertEquals(0, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.GREEN));
        assertEquals(0, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.PINK));
        assertEquals(2, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.RED));
        assertEquals(0, room.getGameState().getPlayerHashMap().get(player.getNickname()).getDashboard().getEntrance().get(PawnColor.YELLOW));
        assertEquals(0, room.getGameState().getCloudsList().get(0).getStudents().size());
    }
}
