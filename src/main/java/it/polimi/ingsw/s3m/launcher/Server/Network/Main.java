package it.polimi.ingsw.s3m.launcher.Server.Network;

public class Main {
    public static void main(String[] args) {
        int port = 12000;
        Server server = new Server(port);
        server.startServer();
    }
}
