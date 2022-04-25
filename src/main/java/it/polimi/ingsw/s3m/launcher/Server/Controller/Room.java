package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public class Room {
    private int roomID;
    private int playersNumber;
    private ArrayList<PlayerController> playersList;
    private boolean isStarted;
    private Game gameState;

    public Room(int roomID, int playersNumber) {
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

    public synchronized void addPlayer(PlayerController player){
        playersList.add(player);
        if(!isFull() || isStarted){
            return;
        }

        isStarted = true;
        start();
    }

    public void start(){
        sendNotificationToAll("the room is starting");
    }

    public void deleteRoom(PlayerController player){
        sendNotificationToAllButOne(player, "someone left, the room is being deleted");
    }

    public void sendNotificationToAllButOne(PlayerController one, String message){
        NotificationMessage notification = new NotificationMessage();
        notification.setMessage(message);

        ArrayList<PlayerController> allButOne = playersList;
        allButOne.remove(one);
        for(PlayerController player : allButOne){
            player.sendMessage(notification);
        }
    }

    public void sendNotificationToAll(String message){
        NotificationMessage notification = new NotificationMessage();
        notification.setMessage(message);
        for(PlayerController player : playersList){
            player.sendMessage(notification);
        }
    }
}