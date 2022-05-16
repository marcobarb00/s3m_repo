package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.MotherNaturePhaseResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.CharacterCardAlreadyActivatedException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MotherNaturePhaseTest {
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
        assertThrows(IncorrectOperationException.class, () -> room.motherNaturePhase(player, null));
    }

    @Test
    void playerResponseNotEqualsToMotherNaturePhaseThrowsIncorrectOperationException(){
        PutStudentOnTableResponse putStudentOnTableResponse = new PutStudentOnTableResponse("RED");
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.motherNaturePhase(player, putStudentOnTableResponse));
        assertEquals("the operation received is not the correct type", e.getMessage());
    }

    @Test
    void playerMotherNaturePhaseResponseGetOperationChoiceEquals2ButGameIsNotInExpertModeThrowsIncorrectOperationException(){
        MotherNaturePhaseResponse motherNaturePhaseResponse = new MotherNaturePhaseResponse(2);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.motherNaturePhase(player, motherNaturePhaseResponse));
        assertEquals("you cannot play a character card in normal mode", e.getMessage());
    }

    @Test
    void playerMotherNaturePhaseResponseGetOperationChoiceEquals2ButACharacterCardHasBeenAlreadyActivatedThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        room.setGameState(new Game(nicknames, true));

        MotherNaturePhaseResponse motherNaturePhaseResponse = new MotherNaturePhaseResponse(2);
        room.getGameState().getTurn().setActivatedCharacterCard(true);
        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, () -> room.motherNaturePhase(player, motherNaturePhaseResponse));
        assertEquals("you already activated a character card", e.getMessage());
    }

    @Test
    void playerMotherNaturePhaseResponseGetOperationChoiceNotEqualsOneOrTwoThrowsIncorrectOperationException(){
        MotherNaturePhaseResponse motherNaturePhaseResponse = new MotherNaturePhaseResponse(-1);
        Exception e = assertThrows(IncorrectOperationException.class, () -> room.motherNaturePhase(player, motherNaturePhaseResponse));
        assertEquals("invalid input", e.getMessage());
    }
}
