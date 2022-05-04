package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import it.polimi.ingsw.s3m.launcher.Server.Operation.Operation;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void checkNickname() {
        ArrayList<String> playerList = new ArrayList<>(Arrays.asList("paolo","nino","giacomo"));
        Game game = new Game(playerList,false);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));

        playerController.setNickname("giovanni");
        Operation operation = new Operation(game, playerController) {
            @Override
            public void executeOperation() throws PlayerNotInListException, CloudNotInListException, IllegalArgumentException, NotExpertModeException {

            }
        };

        assertFalse(operation.checkNickname());
        playerController.setNickname("paolo");
        assertTrue(operation.checkNickname());
    }

}