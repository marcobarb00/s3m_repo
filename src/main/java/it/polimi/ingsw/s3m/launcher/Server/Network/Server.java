package it.polimi.ingsw.s3m.launcher.Server.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int PORT;
    private ServerSocket serverSocket;

    public Server(int PORT) {
        this.PORT = PORT;
    }

    /**
     * startServer creates the server socket and accepts new clients in an infinite loop
     */
    public void startServer() {
        //open the server socket
        try {
            serverSocket = new ServerSocket(this.PORT);
            System.out.println("welcome socket opened at port: " + this.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create threadPool for multiple clients
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            while(true){
                System.out.println("server is waiting for a new client");
                Socket clientSocket = serverSocket.accept();
                executor.submit(new ClientSocket(clientSocket));
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
