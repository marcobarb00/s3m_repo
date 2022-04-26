package it.polimi.ingsw.s3m.launcher.Server.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static final String SERVERIP = "localhost";
    public static final int PORT = 12000;
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }

    /**
     * startServer creates the server socket and accepts new clients in an infinite loop
     */
    public void startServer() {
        //open the server socket
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("welcome socket opened at port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create threadPool for multiple clients
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            while(true){
                Socket clientSocket = serverSocket.accept();
                executor.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //shutdown the threadPool and close the server socket
            executor.shutdown();
            try {
                serverSocket.close();
                System.out.println("server socket closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
