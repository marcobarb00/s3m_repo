package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.LoginMessage;

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
        LoginMessage loginMessageResult = new LoginMessage();
        player.sendMessage(loginMessageResult);
        do{
            LoginMessage loginMessage = (LoginMessage) player.readMessage();
            if(loginMessage.isNewRoom())
                loginMessageResult = newRoom(loginMessage);
            else
                loginMessageResult = enterRoom(loginMessage);

            player.sendMessage(loginMessageResult);
        }while(!loginMessageResult.isSuccessful());

        player.setNickname(loginMessageResult.getNickname());
        Room room = rooms.get(loginMessageResult.getRoomID());
        room.addPlayer(player);
    }

    /**
     * create a new room and send the result to the player
     * @param loginMessage info about the creation of the new room
     * @return results of the room created
     */
    public synchronized LoginMessage newRoom(LoginMessage loginMessage){
        int roomID;
        do{
            roomID = ThreadLocalRandom.current().nextInt(0, 100000);
        }while(rooms.containsKey(roomID));

        LoginMessage loginResult = new LoginMessage();
        loginResult.setSuccessful(true);
        loginResult.setMessage("room created successfully, room ID is: " + roomID);
        loginResult.setRoomID(roomID);
        loginResult.setNickname(loginMessage.getNickname());
        Room newRoom = new Room(roomID, loginMessage.getPlayersNumber());
        rooms.put(roomID, newRoom);
        return loginResult;
    }

    /**
     * see if the player can enter a room and send the result of the attempt to the player
     * @param loginMessage info about the request to enter a room
     * @return result of the attempt to enter a room
     */
    public synchronized LoginMessage enterRoom(LoginMessage loginMessage){
        int roomID = loginMessage.getRoomID();
        LoginMessage loginResult = new LoginMessage();
        if(!rooms.containsKey(roomID)){
            loginResult.setSuccessful(false);
            loginResult.setMessage("there is no room with ID: " + roomID);
        }
        else if(rooms.get(roomID).isFull()){
            loginResult.setSuccessful(false);
            loginResult.setMessage("the room is already full");
        }
        else if(!rooms.get(roomID).isAllowedName(loginMessage.getNickname())){
            loginResult.setSuccessful(false);
            loginResult.setMessage("there is another player with that nickname in the room");
        }
        else{
            loginResult.setSuccessful(true);
            loginResult.setMessage("entered in the room successfully");
            loginResult.setNickname(loginMessage.getNickname());
            loginResult.setRoomID(roomID);
        }

        return loginResult;
    }

    public void startRoom(int roomID){
    }
}
