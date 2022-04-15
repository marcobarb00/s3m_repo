package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Login;

import java.util.ArrayList;
import java.util.Objects;

public class RoomsController {
    private static RoomsController instance = null;
    private ArrayList<Room> rooms = new ArrayList<>();

    private RoomsController() {
        instance = new RoomsController();
    }

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
        Room lastRoom = getLastRoom();
        if(lastRoom.isFull()){
            int playersNumber = client.askPlayersNumber();
            rooms.add(new Room(playersNumber));
        }else{
            if(lastRoom.getClientList().stream()
                    .map(ClientHandler::getNickname)
                    .anyMatch(nickname -> Objects.equals(nickname, loginInfo.getNickname()))){
                loginInfo.setSuccessful(false);
                loginInfo.setMessage("there is another player with that nickname");
                /*
                 * marco
                  * create a new Login object and send it to the client
                 */
            }
        }
        /*
         * send the login information to the client
         * add the client in the room
         */
    }
}
