package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.*;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RoomsController{
    private static RoomsController instance = null;
    private static HashMap<Integer, Room> rooms = new HashMap<>();

    private RoomsController() {}

    public static RoomsController instance(){
        if(instance == null)
            return new RoomsController();
        else
            return instance;
    }

    public synchronized void login(PlayerController player){
        LoginMessage loginMessage = new LoginMessage();
        int numberOfRooms = rooms.size();
        loginMessage.setNumberOfRooms(numberOfRooms);
        player.sendMessage(loginMessage);
        LoginMessage loginResponse = (LoginMessage) player.readMessage();

        if (loginResponse.isNewRoom()){
            newRoom(player);
        }else{
            enterRoom(player);
        }
    }

    public synchronized void newRoom(PlayerController player){
        player.sendMessage(new NewRoomMessage());
        NewRoomMessage newRoomMessageInfo = (NewRoomMessage) player.readMessage();
        Integer roomID;
        do{
            roomID = ThreadLocalRandom.current().nextInt(0, 100000);
        }while(rooms.containsKey(roomID));

        Room newRoom = new Room(roomID, newRoomMessageInfo.getNumberOfPlayers());
        rooms.put(roomID, newRoom);
        player.setNickname(newRoomMessageInfo.getNickname());
        player.setRoomID(roomID);

        NotificationMessage notification = new NotificationMessage();
        notification.setMessage("room created successfully, room ID is: " + roomID);
        player.sendMessage(notification);
    }

    public synchronized void enterRoom(PlayerController player){
        boolean successful = false;

        do{
            EnterRoomMessage enterRoomMessageInfo = (EnterRoomMessage) player.readMessage();
            Integer roomID = enterRoomMessageInfo.getRoomID();

            NotificationMessage notification = new NotificationMessage();
            if(!rooms.containsKey(roomID)){
                notification.setMessage("there is no room with ID: " + roomID);
            }
            else if(rooms.get(roomID).isFull()){
                notification.setMessage("the room is already full");
            }
            else if(!rooms.get(roomID).isAllowedName(enterRoomMessageInfo.getNickname())){
                notification.setMessage("there is another player with that nickname in the room");
            }
            else{
                notification.setMessage("entered in the room successfully");
                player.sendMessage(notification);
                successful = true;
            }
        }while(successful);
    }

    public void startRoom(int roomID){
    }
}
