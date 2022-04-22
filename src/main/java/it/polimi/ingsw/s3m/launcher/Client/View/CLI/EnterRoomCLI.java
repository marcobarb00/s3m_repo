package it.polimi.ingsw.s3m.launcher.Client.View.CLI;

import it.polimi.ingsw.s3m.launcher.Communication.EnterRoomMessage;
import it.polimi.ingsw.s3m.launcher.Communication.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class EnterRoomCLI implements MessageCLI{
    private ArrayList<Integer> availableRoomsID;

    public EnterRoomCLI(EnterRoomMessage enterRoomMessage) {
        this.availableRoomsID = enterRoomMessage.getAvailableRoomsID();
    }

    @Override
    public Message execute() {
        System.out.println("ID's of rooms that are open");

        for(Integer roomID : availableRoomsID){
            System.out.println(roomID);
        }

        System.out.println("please insert the room ID to join that room");
        Scanner scanner = new Scanner(System.in);
        int roomID;
        try{
            roomID = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            roomID = -1;
        }
        while(roomID < 0 || !availableRoomsID.contains(roomID)){
            System.out.println("invalid room ID");
            try{
                roomID = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                roomID = -1;
            }
        }

        System.out.println("please insert your nickname");
        String nickname = scanner.nextLine();

        EnterRoomMessage enterRoomMessage = new EnterRoomMessage();

        enterRoomMessage.setNickname(nickname);
        enterRoomMessage.setRoomID(roomID);
        return enterRoomMessage;
    }
}
