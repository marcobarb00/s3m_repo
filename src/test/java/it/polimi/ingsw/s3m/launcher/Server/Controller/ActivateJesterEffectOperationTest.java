package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import it.polimi.ingsw.s3m.launcher.Server.Operation.ActivateJesterEffectOperation;
import it.polimi.ingsw.s3m.launcher.Server.Operation.Operation;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActivateJesterEffectOperationTest {

    @Test
    void executeOperation() {
        ArrayList<String> playerList = new ArrayList<>(Arrays.asList("paolo","nino"));
        PlayerController playerController = new PlayerController(new ClientHandler(new Socket()));
        ArrayList<PawnColor> requiredStudents = new ArrayList<>(
                Arrays.asList(
                        PawnColor.GREEN,
                        PawnColor.RED,
                        PawnColor.BLUE
                )
        );
        ArrayList<PawnColor> givenStudents = new ArrayList<>(
                Arrays.asList(
                PawnColor.GREEN,
                PawnColor.YELLOW,
                PawnColor.PINK
                )
        );

        //Not expert mode exception
        expertModeException(playerList, playerController,
                (ArrayList<PawnColor>) requiredStudents.clone(),
                (ArrayList<PawnColor>) givenStudents.clone());

        //PlayerNotInListException
        playerNotInListException(playerList, playerController,
                (ArrayList<PawnColor>) requiredStudents.clone(),
                (ArrayList<PawnColor>) givenStudents.clone());

        //IllegalArg Exc Incorrect Exchange Students Value
        incorrectStudentsValue(playerList, playerController,
                (ArrayList<PawnColor>) requiredStudents.clone(),
                (ArrayList<PawnColor>) givenStudents.clone());

        //IllegalArgExc Not enough students on jester card
    }

    private void expertModeException(ArrayList<String> playerList, PlayerController playerController,
                                     ArrayList<PawnColor> requiredStudents, ArrayList<PawnColor> givenStudents){
        Game game = new Game(playerList,false);
        playerController.setNickname("paolo");
        Operation operation1 = new ActivateJesterEffectOperation(game, playerController,
                requiredStudents, givenStudents);
        Exception e = assertThrows(NotExpertModeException.class,() -> operation1.executeOperation() );
        assertEquals("Not in expert mode", e.getMessage());
    }

    private void playerNotInListException(ArrayList<String> playerList, PlayerController playerController,
                                           ArrayList<PawnColor> requiredStudents, ArrayList<PawnColor> givenStudents){
        Game game = new Game(playerList,true);
        playerController.setNickname("giovanni");
        Operation operation2 = new ActivateJesterEffectOperation(game, playerController,
                requiredStudents, givenStudents);
        Exception e = assertThrows(PlayerNotInListException.class,() -> operation2.executeOperation());
        assertEquals("Player is not in list", e.getMessage());
    }

    private void incorrectStudentsValue(ArrayList<String> playerList, PlayerController playerController,
                                                ArrayList<PawnColor> requiredStudents, ArrayList<PawnColor> givenStudents){
        playerController.setNickname("paolo");
        requiredStudents.remove(0);
        System.out.println(requiredStudents.size());
        Game game = new Game(playerList,true);
        Operation operation = new ActivateJesterEffectOperation(game, playerController,
                requiredStudents, givenStudents);
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> operation.executeOperation());
        assertEquals("Incorrect exchange students value", e.getMessage());
    }
    private void notStudentsOnJester(ArrayList<String> playerList, PlayerController playerController,
                                     ArrayList<PawnColor> requiredStudents, ArrayList<PawnColor> givenStudents){
        playerController.setNickname("paolo");
        System.out.println(requiredStudents.size());
        Game game = new Game(playerList,true);
        Operation operation = new ActivateJesterEffectOperation(game, playerController,
                requiredStudents, givenStudents);
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> operation.executeOperation());
        assertEquals("Not enough students on jester card", e.getMessage());
    }
}