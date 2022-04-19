package it.polimi.ingsw.s3m.launcher.Server.Network;

import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Server.Controller.ClientHandler;
import it.polimi.ingsw.s3m.launcher.Server.Controller.RoomsController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements Runnable{
    private final Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ClientHandler clientHandler;

    public ClientSocket(Socket socket) {
        this.socket = socket;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ClientHandler clientHandler = new ClientHandler(this);
        RoomsController.instance().login(clientHandler);
    }

    /**
     * write a message in the outputStream
     * @param message the message to be sent
     */
    public void sendMessage(Message message){
        try{
            outputStream.writeObject(message);
            outputStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * read the inputStream of the client
     * @return message written in the inputStream
     */
    public Message readMessage(){
        try{
            return (Message) inputStream.readObject();
        }catch(ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * closes the streams and the socket
     */
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
