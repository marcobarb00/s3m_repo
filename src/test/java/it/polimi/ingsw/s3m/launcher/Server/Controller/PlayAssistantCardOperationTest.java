package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.CloudNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayAssistantCardOperationTest {

    @Test
    void executeOperation() {
        ArrayList<String> playerList = new ArrayList<>(Arrays.asList("paolo","nino"));
        Game game = new Game(playerList,false);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));

        //PlayerNotInListException
        playerController.setNickname("giovanni");
        Operation operation1 = new PlayAssistantCardOperation(game, playerController, 0);
        Exception e = assertThrows(Exception.class,() -> operation1.executeOperation());
        assertEquals("Player is not in list", e.getMessage());

        //IllegalArgumentException
        playerController.setNickname("paolo");
        Operation operation2 = new PlayAssistantCardOperation(game, playerController, -1);
        e = assertThrows(Exception.class,() -> operation2.executeOperation());
        assertEquals("Incorrect card position value", e.getMessage());

        Operation operation3 = new PlayAssistantCardOperation(game, playerController, 11);
        e = assertThrows(Exception.class,() -> operation3.executeOperation());
        assertEquals("Incorrect card position value", e.getMessage());
    }

}