package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanningPhaseResponseTest{
	Room room = new Room(null, 0, false);
	PlayerController player = new PlayerController(null);

	@Test
	void nullResponseThrowsIncorrectOperation(){
		Exception e = assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, null));
		assertEquals("the operation received is not the correct type", e.getMessage());
	}

	void responseWithNullCardChosenAttributeThrowsIncorrectOperation(){
		Exception e = assertThrows(IncorrectOperationException.class, () -> room.planningPhaseResponse(player, null));
		assertEquals("the operation received is not the correct type", e.getMessage());
	}
}
