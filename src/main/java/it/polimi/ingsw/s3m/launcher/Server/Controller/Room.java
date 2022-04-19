package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.RoomMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public class Room {
    private int roomID;
    private int playersNumber;
    private ArrayList<ClientHandler> clientList;
    private Game gameState;

    public Room(int playersNumber, int roomID) {
        this.roomID = roomID;
        this.playersNumber = playersNumber;
        this.clientList = new ArrayList<>();
    }

    public int getRoomID(){
        return roomID;
    }

    public ArrayList<ClientHandler> getClientList(){
        return clientList;
    }

    public boolean isFull(){
        return clientList.size() >= playersNumber;
    }

    public boolean isAllowedName(String nickname){
        if(clientList.isEmpty())
            return true;
        return clientList.stream()
                .map(ClientHandler::getNickname)
                .noneMatch(name -> name.equals(nickname));
    }

    public void addClient(ClientHandler client){
        clientList.add(client);
    }

    public void add(ClientHandler client){
        clientList.add(client);
    }
}