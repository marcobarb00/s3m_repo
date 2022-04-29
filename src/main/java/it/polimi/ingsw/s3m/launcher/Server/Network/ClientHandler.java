package it.polimi.ingsw.s3m.launcher.Server.Network;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private final Socket socket;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;

    private PlayerController playerController;
    private Message messageToSend;
    private Message messageReceived;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        setupStream();
        this.playerController = new PlayerController(this);
        playerController.login();
        try{
            while(true){
                sendMessage();
            }
        }catch(IOException | ClassNotFoundException e){
            playerController.disconnect();
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

    public void writeOutputStream(Message message) throws NullPointerException{
        if(message == null){
            System.out.println("ERROR: trying to send a null message");
            throw new NullPointerException();
        }
        try{
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public Message readInputStream() throws IOException, ClassNotFoundException{
        return (Message) objectInputStream.readObject();
    }

    public synchronized void sendMessage() throws IOException, ClassNotFoundException{
        while(messageToSend == null){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if(messageToSend instanceof NotificationMessage){
            writeOutputStream(messageToSend);
            messageReceived = null;
        }else{
            writeOutputStream(messageToSend);
            messageReceived = readInputStream();
        }
        messageToSend = null;
        notifyAll();
    }

    public synchronized Message communicateWithClient(Message message){
        while (messageToSend != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        messageToSend = message;
        notifyAll();
        if(message instanceof NotificationMessage){
            return null;
        }else{
            while(messageReceived == null){
                try{
                    wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            Message temp = messageReceived;
            messageReceived = null;
            return temp;
        }
    }

    public void close(){
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
            System.out.println("client socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
