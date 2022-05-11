package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughAssistantCardsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlanningPhaseResponseTest{
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
		assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, null));
	}

	@Test
	void chooseAnInvalidPositionToPlayAnAssistantCardThrowsIllegalArgumentException(){
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(-1);
		Exception e = assertThrows(IllegalArgumentException.class, () -> room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals("Incorrect card position value", e.getMessage());
	}

	@Test
	void correctResponseReturnsTrue() throws NotEnoughAssistantCardsException, PlayerNotInListException, IncorrectOperationException {
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(0);
		assertTrue(room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals(9, room.getGameState().getPlayerHashMap().get("FirstPlayer").getHand().size());
	}

	@Test
	void nullGameStateInRoomThrowsIncorrectOperationException(){
		room.setGameState(null);
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(0);
		Exception e = assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals("Invalid arguments", e.getMessage());
	}

	@Test
	void nullPlayerControllerThrowsIncorrectOperationException(){
		player = null;
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(0);
		Exception e = assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals("Invalid arguments", e.getMessage());
	}

	@Test
	void playTheAssistantCardInTheLastPositionTwiceThrowsIllegalArgumentException() throws NotEnoughAssistantCardsException, PlayerNotInListException, IncorrectOperationException {
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(9);
		assertTrue(room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals(9, room.getGameState().getPlayerHashMap().get("FirstPlayer").getHand().size());

		Exception e = assertThrows(IllegalArgumentException.class, () -> room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals("Incorrect card position value", e.getMessage());
	}

	@Test
	void ifTheSecondPlayerTriesToPlayTheSameAssistantCardPlayedByTheFirstPlayerThrowsIllegalArgumentException() throws NotEnoughAssistantCardsException, PlayerNotInListException, IncorrectOperationException {
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(9);
		assertTrue(room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals(9, room.getGameState().getPlayerHashMap().get("FirstPlayer").getHand().size());

		player.setNickname("SecondPlayer");
		Exception e = assertThrows(IllegalArgumentException.class, () -> room.planningPhaseResponse(player, playAssistantCardResponse));
		assertEquals("AssistantCard already played", e.getMessage());
	}
}
