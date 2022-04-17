package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Login;

import java.util.ArrayList;
import java.util.Objects;

public class RoomsController {
    private static RoomsController instance = null;
    private static ArrayList<Room> rooms = new ArrayList<>();

    private RoomsController() {}

    public static RoomsController instance(){
        if(instance == null)
            return new RoomsController();
        else
            return instance;
    }

    public Room getLastRoom(){
        return rooms.get(rooms.size() - 1);
    }

    public Login loginClient(ClientHandler client, Login loginInfo){
        Login loginResult;

        if(rooms.isEmpty()){
            int playersNumber = client.askPlayersNumber();
            Room newRoom = new Room(playersNumber);
            loginResult = newRoom.login(client, loginInfo);
            rooms.add(newRoom);
        }
        else if(getLastRoom().isFull()){
            int playersNumber = client.askPlayersNumber();
            Room newRoom = new Room(playersNumber);
            loginResult = newRoom.login(client, loginInfo);
            rooms.add(newRoom);
        }else{
            loginResult = getLastRoom().login(client, loginInfo);
        }
        return loginResult;
    }
}
