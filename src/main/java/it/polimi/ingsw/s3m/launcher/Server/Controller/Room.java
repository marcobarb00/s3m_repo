package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Server.Communication.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public class Room {
    private int roomID;
    private int playersNumber;
    private ArrayList<PlayerController> playersList;
    private Game gameState;

    public Room(int playersNumber, int roomID) {
        this.roomID = roomID;
        this.playersNumber = playersNumber;
        this.playersList = new ArrayList<>();
    }

    public int getRoomID(){
        return roomID;
    }

    public ArrayList<PlayerController> getPlayersList(){
        return playersList;
    }

    public boolean isFull(){
        return playersList.size() >= playersNumber;
    }

    public boolean isAllowedName(String nickname){
        if(playersList.isEmpty())
            return true;
        return playersList.stream()
                .map(PlayerController::getNickname)
                .noneMatch(name -> name.equals(nickname));
    }

    public void addPlayer(PlayerController player){
        playersList.add(player);
    }

    public void sendNotificationToAll(NotificationMessage notification){
        for(PlayerController player : playersList){
            player.sendMessage(notification);
        }
    }
}