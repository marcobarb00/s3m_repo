package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanningPhaseResponseTest{
	Room room = new Room(null, 0, false);
	PlayerController player = new PlayerController(null);

	@Test
	void nullResponseThrowsIncorrectOperation(){
		assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, null));
	}

	@Test
	void responseWithWrongCardChosenAttributeThrowsIncorrectOperation(){
		PlayAssistantCardResponse playAssistantCardResponse = new PlayAssistantCardResponse(-1);
		assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, playAssistantCardResponse));
	}
}
