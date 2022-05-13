package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.PutStudentOnTableResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.Socket;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PutStudentOnTableTest {
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
        assertThrows(IncorrectOperationException.class, () -> room.putStudentOnTable(player, null));
    }
}
