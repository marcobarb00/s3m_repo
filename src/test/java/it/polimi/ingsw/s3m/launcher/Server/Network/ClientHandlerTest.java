package it.polimi.ingsw.s3m.launcher.Server.Network;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class ClientHandlerTest{
	ClientHandler clientHandler;
	@BeforeEach
	void setUp(){
		this.clientHandler = new ClientHandler(new Socket());
	}

	@Test
	void writeOutputStreamNullInput(){
		assertThrows(NullPointerException.class, () -> clientHandler.writeOutputStream(null));
	}
}