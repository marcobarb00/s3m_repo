package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Login;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Network.ClientSocket;

public class ClientHandler{
    private ClientSocket clientSocket;
    private Room room;
    private String nickname;

    public ClientSocket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public ClientHandler(ClientSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void login(){
        Login loginInfo = (Login) clientSocket.readMessage();
        Login loginResult = RoomsController.instance().loginClient(this, loginInfo);
        clientSocket.sendMessage(loginResult);
    }

    public int askPlayersNumber(){
        return 2;
    }

    public void activateCharacterCard(){}

    public void playAssistantCard(){}

    public void putStudentsOnIsland(){}

    public void putStudentOnTable(){}

    public void moveMotherNature(){}

    public void chooseCloud(){}

    public void close(){}
}
