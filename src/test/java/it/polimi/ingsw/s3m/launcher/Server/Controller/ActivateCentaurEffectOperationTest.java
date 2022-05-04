package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import it.polimi.ingsw.s3m.launcher.Server.Operation.ActivateCentaurEffectOperation;
import it.polimi.ingsw.s3m.launcher.Server.Operation.Operation;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActivateCentaurEffectOperationTest {

    @Test
    void executeOperation() {
        ArrayList<String> playerList = new ArrayList<>(Arrays.asList("paolo","nino"));
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));

        //Not expert mode exception test
        Game game = new Game(playerList,false);
        playerController.setNickname("paolo");
        Operation operation1 = new ActivateCentaurEffectOperation(game, playerController);
        Exception e = assertThrows(NotExpertModeException.class,() -> operation1.executeOperation() );
        assertEquals("Not in expert mode", e.getMessage());

        //Player not in list exception test
        game = new Game(playerList,true);
        playerController.setNickname("giovanni");
        Operation operation2 = new ActivateCentaurEffectOperation(game, playerController);
        e = assertThrows(PlayerNotInListException.class,() -> operation2.executeOperation() );
        assertEquals("Player is not in list", e.getMessage());
    }
}