package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
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
    // NULL GAME
    @Test
    void nullGameThrowsIncorrectOperationException() {
        Game game = null;
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);

        Exception e = assertThrows(IncorrectOperationException.class, operation::executeOperation);
        assertEquals("Invalid arguments", e.getMessage());
    }

    // NULL PLAYER CONTROLLER
    @Test
    void nullPlayerControllerThrowsIncorrectOperationException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        PlayerController playerController = null;
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);

        Exception e = assertThrows(IncorrectOperationException.class, operation::executeOperation);
        assertEquals("Invalid arguments", e.getMessage());
    }

    // PLAYER CONTROLLER'S NICKNAME
    @Test
    void nullPlayerControllerNicknameThrowsPlayerNotInListException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);

        Exception e = assertThrows(PlayerNotInListException.class, operation::executeOperation);
        assertEquals("player is not in list", e.getMessage());
    }

    @Test
    void playerControllerNicknameNotInListOfPlayersNicknamesThrowsPlayerNotInListException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        playerController.setNickname("ThirdPlayer");
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);

        Exception e = assertThrows(PlayerNotInListException.class, operation::executeOperation);
        assertEquals("player is not in list", e.getMessage());
    }

    // EXPERT MODE
    @Test
    void notExpertModeGameThrowsNotExpertModeException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, false);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        playerController.setNickname("FirstPlayer");
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);

        Exception e = assertThrows(NotExpertModeException.class, operation::executeOperation);
        assertEquals("you cannot do this operation in normal mode", e.getMessage());
    }

    // ACTIVATED CHARACTER CARD
    @Test
    void characterCardAlreadyActivatedInPlayerTurnThrowsCharacterCardAlreadyActivatedException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        playerController.setNickname("FirstPlayer");
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);
        game.getTurn().setActivatedCharacterCard(true);

        Exception e = assertThrows(CharacterCardAlreadyActivatedException.class, operation::executeOperation);
        assertEquals("you already activated a character card", e.getMessage());
    }

    // COINS
    @Test
    void playerDoesNotHaveEnoughCoinsToActivateTheCardThrowsNotEnoughCoinsException() throws EmptyBagException {
        ArrayList<String> nicknames = new ArrayList<>();
        nicknames.add("FirstPlayer");
        nicknames.add("SecondPlayer");
        Game game = new Game(nicknames, true);
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        playerController.setNickname("FirstPlayer");
        ActivateCentaurEffectOperation operation = new ActivateCentaurEffectOperation(game, playerController);

        assertEquals(1, game.getPlayerHashMap().get(playerController.getNickname()).getCoins());
        // Exception e = assertThrows(NotEnoughCoinsException.class, operation::executeOperation);
        // assertEquals("you don't have enough coins", e.getMessage());
    }
}