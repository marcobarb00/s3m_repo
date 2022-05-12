package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.StudentsPhaseResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MoveStudentPhaseTest {
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
        assertThrows(IncorrectOperationException.class, () -> room.moveStudentPhase(player, null));
    }

    @Test
    void playerStudentsPhaseResponseGetOperationChoiceEquals1ExecuteCase1(){
        StudentsPhaseResponse studentsPhaseResponse = new StudentsPhaseResponse(1);
        assertDoesNotThrow(() -> room.moveStudentPhase(player, studentsPhaseResponse));
    }

    @Test
    void playerStudentsPhaseResponseGetOperationChoiceEquals2ExecuteCase2(){
        StudentsPhaseResponse studentsPhaseResponse = new StudentsPhaseResponse(2);
        //TODO
    }

    @Test
    void playerStudentsPhaseResponseGetOperationChoiceEquals3ButACharacterCardHasBeenAlreadyActivatedThrowsCharacterCardAlreadyActivatedException(){
        StudentsPhaseResponse studentsPhaseResponse = new StudentsPhaseResponse(3);
        room.getGameState().getTurn().setActivatedCharacterCard(true);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.moveStudentPhase(player, studentsPhaseResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void playerStudentsPhaseResponseGetOperationChoiceNotEqualsOneTwoOrThreeThrowsIncorrectOperationException(){
        StudentsPhaseResponse studentsPhaseResponse = new StudentsPhaseResponse(-1);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.moveStudentPhase(player, studentsPhaseResponse));
        assertEquals("invalid input", e.getMessage());
    }
}
