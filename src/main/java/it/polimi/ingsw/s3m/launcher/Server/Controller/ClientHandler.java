package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientSocket;

public class ClientHandler{
    private ClientSocket clientSocket;
    private Room room;
    private String nickname;

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public ClientHandler(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void sendMessage(Message message){
        clientSocket.sendMessage(message);
    }

    public Message readMessage(){
        return clientSocket.readMessage();
    }

    public void activateCharacterCard(){}

    public void playAssistantCard(){}

    public void putStudentsOnIsland(){}

    public void putStudentOnTable(){}

    public void moveMotherNature(){}

    public void chooseCloud(){}

    public void close(){}
}
