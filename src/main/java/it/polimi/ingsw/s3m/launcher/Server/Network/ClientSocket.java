package it.polimi.ingsw.s3m.launcher.Server.Network;

import it.polimi.ingsw.s3m.launcher.Server.Controller.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements Runnable{
    private final Socket socket;
    private ObjectInputStream objectIinputStream;
    private ObjectOutputStream objectOutputStream;
    private Client client;

    public ClientSocket(Socket socket) {
        this.socket = socket;
        try {
            objectIinputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Client client = new Client(this);
        client.setup();

    }

    public void notifyClient(){
    }

    public void close(){
        try {
            objectIinputStream.close();
            objectOutputStream.close();
            socket.close();
            System.out.println("client" + socket.getInetAddress() + "socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
