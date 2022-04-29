package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.*;

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

    public void login(PlayerController player){
        Runnable login = () -> {
            LoginMessage loginMessage = new LoginMessage();
            loginMessage.setNumberOfRooms(rooms.size());
            LoginMessage loginResponse = (LoginMessage) player.communicateWithClient(loginMessage);

            if(loginResponse.isNewRoom()){
                newRoom(player);
            }else{
                enterRoom(player);
            }
        };
        new Thread(login).start();
    }

    public synchronized void newRoom(PlayerController player){
        NewRoomMessage newRoomMessageInfo = (NewRoomMessage) player.communicateWithClient(new NewRoomMessage());

        int roomID;
        do{
            roomID = ThreadLocalRandom.current().nextInt(0, 100000);
        }while(rooms.containsKey(roomID));

        NotificationMessage notification = new NotificationMessage();
        notification.setMessage("room created successfully, room ID is: " + roomID);
        player.communicateWithClient(notification);

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
            EnterRoomMessage enterRoomMessageResult = (EnterRoomMessage) player.communicateWithClient(enterRoomMessageInfo);

            Integer roomID = enterRoomMessageResult.getRoomID();

            NotificationMessage notification = new NotificationMessage();
            if(!rooms.containsKey(roomID)){
                notification.setMessage("there is no room with ID: " + roomID);
                player.communicateWithClient(notification);
            }
            else if(rooms.get(roomID).isFull()){
                notification.setMessage("the room is already full");
                player.communicateWithClient(notification);
            }
            else if(!rooms.get(roomID).isAllowedName(enterRoomMessageResult.getNickname())){
                notification.setMessage("there is another player with that nickname in the room");
                player.communicateWithClient(notification);
            }
            else{
                notification.setMessage("entered in the room successfully");
                player.communicateWithClient(notification);
                successful = true;

                player.setNickname(enterRoomMessageInfo.getNickname());
                player.setRoomID(roomID);
                rooms.get(roomID).addPlayer(player);
            }
        }while(!successful);
    }

    public synchronized void deleteRoom(Integer roomID, PlayerController player){
        rooms.get(roomID).deleteRoom(player);
        rooms.remove(roomID);
    }
}
