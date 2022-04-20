package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket socket;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;
    private Room room; //?
    private String nickname;

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        setupStream();
        login();
        //TODO start reading and writing messages
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

    public void login(){
        RoomsController.instance().login(this);
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
