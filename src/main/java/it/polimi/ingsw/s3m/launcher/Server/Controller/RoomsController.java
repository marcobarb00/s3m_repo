package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.*;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientHandler;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class RoomsController implements ControllerInterface{
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
        RoomMessage roomMessageResult;
        do{
            RoomMessage roomMessage = (RoomMessage) player.readMessage();
            roomMessageResult = roomMessage.execute(this);
            player.sendMessage(roomMessageResult);
        }while(!roomMessageResult.isSuccessful());

        player.setNickname(roomMessageResult.getNickname());
        Room room = rooms.get(roomMessageResult.getRoomID());
        room.addPlayer(player);
    }

    /**
     * create a new room and send the result to the player
     * @param newRoomMessage info about the creation of the new room
     * @return results of the room created
     */
    @Override
    public synchronized NewRoomMessage executeNewRoom(NewRoomMessage newRoomMessage){
        int roomID;
        do{
            roomID = ThreadLocalRandom.current().nextInt(0, 100000);
        }while(rooms.containsKey(roomID));

        NewRoomMessage newRoomResult = new NewRoomMessage();
        newRoomResult.setSuccessful(true);
        newRoomResult.setMessage("room created successfully, room ID is: " + roomID);
        newRoomResult.setRoomID(roomID);
        newRoomResult.setNickname(newRoomMessage.getNickname());
        Room newRoom = new Room(roomID, newRoomMessage.getPlayersNumber());
        rooms.put(roomID, newRoom);
        return newRoomResult;
    }

    /**
     * see if the player can enter a room and send the result of the attempt to the player
     * @param enterRoomMessage info about the request to enter a room
     * @return result of the attempt to enter a room
     */
    @Override
    public synchronized EnterRoomMessage executeEnterRoom(EnterRoomMessage enterRoomMessage){
        int roomID = enterRoomMessage.getRoomID();
        EnterRoomMessage enterRoomResult = new EnterRoomMessage();
        if(!rooms.containsKey(roomID)){
            enterRoomResult.setSuccessful(false);
            enterRoomResult.setMessage("there is no room with ID: " + roomID);
        }
        else if(rooms.get(roomID).isFull()){
            enterRoomResult.setSuccessful(false);
            enterRoomResult.setMessage("the room is already full");
        }
        else if(!rooms.get(roomID).isAllowedName(enterRoomMessage.getNickname())){
            enterRoomResult.setSuccessful(false);
            enterRoomResult.setMessage("there is another player with that nickname in the room");
        }
        else{
            enterRoomResult.setSuccessful(true);
            enterRoomResult.setMessage("entered in the room successfully");
            enterRoomResult.setNickname(enterRoomMessage.getNickname());
            enterRoomResult.setRoomID(roomID);
        }

        return enterRoomResult;
    }

    @Override
    public void readNotification(Notification notification){

    }

    public void startRoom(int roomID){
    }
}
