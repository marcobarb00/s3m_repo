package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.*;
import it.polimi.ingsw.s3m.launcher.Server.Exception.RoomFullException;

import java.io.IOException;
import java.util.ArrayList;
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

    public Room getRoom(Integer roomID){
        return rooms.get(roomID);
    }

    public synchronized void login(PlayerController player){
        LoginMessage loginMessage = new LoginMessage();
        int numberOfRooms = rooms.size();
        loginMessage.setNumberOfRooms(numberOfRooms);
        player.sendMessage(loginMessage);
        LoginMessage loginResponse;
        try{
            loginResponse = (LoginMessage) player.readMessage();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            return;
        }

        if (loginResponse.isNewRoom()){
            newRoom(player);
        }else{
            enterRoom(player);
        }
    }

    public synchronized void newRoom(PlayerController player){
        player.sendMessage(new NewRoomMessage());
        NewRoomMessage newRoomMessageInfo;
        try{
            newRoomMessageInfo = (NewRoomMessage) player.readMessage();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            return;
        }

        int roomID;
        do{
            roomID = ThreadLocalRandom.current().nextInt(0, 100000);
        }while(rooms.containsKey(roomID));

        NotificationMessage notification = new NotificationMessage();
        notification.setMessage("room created successfully, room ID is: " + roomID);
        player.sendMessage(notification);

        player.setNickname(newRoomMessageInfo.getNickname());
        player.setRoomID(roomID);
        Room newRoom = new Room(roomID, newRoomMessageInfo.getNumberOfPlayers(), newRoomMessageInfo.isExpertMode());
        newRoom.addPlayer(player);
        rooms.put(roomID, newRoom);
    }

    public synchronized void enterRoom(PlayerController player){
        boolean successful = false;
        do{
            EnterRoomMessage enterRoomMessageInfo = new EnterRoomMessage();
            enterRoomMessageInfo.setAvailableRoomsID(new ArrayList<>(rooms.keySet()));
            player.sendMessage(enterRoomMessageInfo);

            EnterRoomMessage enterRoomMessageResult;
            try{
                enterRoomMessageResult = (EnterRoomMessage) player.readMessage();
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
                return;
            }
            Integer roomID = enterRoomMessageResult.getRoomID();

            NotificationMessage notification = new NotificationMessage();
            if(!rooms.containsKey(roomID)){
                notification.setMessage("there is no room with ID: " + roomID);
                player.sendMessage(notification);
            }
            else if(rooms.get(roomID).isFull()){
                notification.setMessage("the room is already full");
                player.sendMessage(notification);
            }
            else if(!rooms.get(roomID).isAllowedName(enterRoomMessageResult.getNickname())){
                notification.setMessage("there is another player with that nickname in the room");
                player.sendMessage(notification);
            }
            else{
                notification.setMessage("entered in the room successfully");
                player.sendMessage(notification);
                successful = true;

                player.setNickname(enterRoomMessageInfo.getNickname());
                player.setRoomID(roomID);
                rooms.get(roomID).addPlayer(player);
            }
        }while(!successful);
    }

    public void deleteRoom(Integer roomID, PlayerController player){
        rooms.get(roomID).deleteRoom(player);
        rooms.remove(roomID);
    }
}
