package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Login;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomsControllerTest{

	@Test
	void loginMultipleClientsWithTheSameNickname(){
		ClientHandler client1 = new ClientHandler(null);
		Login login1 = new Login("test");
		ClientHandler client2 = new ClientHandler(null);
		Login login2 = new Login("test");

		Login loginResult1 = RoomsController.instance().loginClient(client1, login1);
		Login loginResult2 = RoomsController.instance().loginClient(client2, login2);

		assertTrue(loginResult1.isSuccessful());
		assertFalse(loginResult2.isSuccessful());
	}
}