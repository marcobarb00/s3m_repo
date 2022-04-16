package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Communication.Login;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;

import java.util.ArrayList;

public class Room {
    private int playersNumber;
    private ArrayList<ClientHandler> clientList;
    private Game gameState;

    public Room(int playersNumber) {
        this.playersNumber = playersNumber;
        clientList = new ArrayList<>();
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

    public Login login(ClientHandler client, Login loginInfo){

        if(isAllowedName(loginInfo.getNickname())){
            client.setNickname(loginInfo.getNickname());
            this.add(client);
            Login loginResult = new Login(loginInfo.getNickname());
            loginResult.setSuccessful(true);
            loginResult.setMessage("login successful");
            return loginResult;
        }
        Login loginResult = new Login(loginInfo.getNickname());
        loginResult.setSuccessful(false);
        loginResult.setMessage("there is already a player with that name");
        return loginResult;
    }

    public void add(ClientHandler client){
        clientList.add(client);
    }
}