package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Client.Network.Client;
import it.polimi.ingsw.s3m.launcher.Communication.Message;
import it.polimi.ingsw.s3m.launcher.Communication.Notification;

public class ClientCLI {
    private Client client;
    private CLIView view;
    private MessageCLI message;

    public void start(){
        this.view = new CLIView(this);
        this.client = new Client();
        client.start();

        while (true) {
            try {
                Message receivedMessage = client.receiveMessage();
                receivedMessage.apply(view);
                if(receivedMessage instanceof Notification){
                    message.execute();
                }else{
                    Message toSendMessage = message.execute();
                    client.sendMessage(toSendMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void setMessage(MessageCLI message) {
        this.message = message;
    }
}
