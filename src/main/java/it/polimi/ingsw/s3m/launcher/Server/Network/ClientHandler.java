package it.polimi.ingsw.s3m.launcher.Server.Network;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket socket;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;

    PlayerController playerController;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        setupStream();
        this.playerController = new PlayerController(this);
        try{
            playerController.login();
            while(true){
                readMessage();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public void setupStream(){
        try {
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message message){
        try{
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Message readMessage(){
        try{
            return (Message) objectInputStream.readObject();
        }catch(ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void activateCharacterCard(){}

    public void playAssistantCard(){}

    public void putStudentsOnIsland(){}

    public void putStudentOnTable(){}

    public void moveMotherNature(){}

    public void chooseCloud(){}

    public void close(){
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("client" + socket.getInetAddress() + "socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
