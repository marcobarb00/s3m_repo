package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientSocket;

public class ClientHandler{
    private ClientSocket ClientSocket;
    private Room room;
    private Player player;
    //message

    public ClientSocket getClientSocket() {
        return ClientSocket;
    }

    public void setClientSocket(ClientSocket clientSocket) {
        ClientSocket = clientSocket;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ClientHandler(ClientSocket clientSocket) {
        ClientSocket = clientSocket;
    }

    public void setup(){}

    public void setPlayersNumber(){}

    public void activateCharacterCard(){}

    public void playAssistantCard(){}

    public void putStudentsOnIsland(){}

    public void putStudentOnTable(){}

    public void moveMotherNature(){}

    public void chooseCloud(){}

    public void close(){}
}
