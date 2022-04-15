package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public class Room {
    private int playersNumber;
    private ArrayList<ClientHandler> clientList;
    private Game gameState;

    public Room(int playersNumber) {
        this.playersNumber = playersNumber;
        clientList = new ArrayList<>();
    }

    public ArrayList<ClientHandler> getClientList(){
        return clientList;
    }

    public boolean isFull(){
        return clientList.size() >= playersNumber;
    }
}