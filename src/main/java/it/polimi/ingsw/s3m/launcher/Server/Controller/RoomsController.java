package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.EnterRoomResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.LoginResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.NewRoomResponse;
import it.polimi.ingsw.s3m.launcher.Server.Message.EnterRoomMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.NewRoomMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.NotificationMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RoomsController{
	private static RoomsController instance = null;
	private final static HashMap<Integer, Room> rooms = new HashMap<>();

	private RoomsController(){}

	public static RoomsController instance(){
		return Objects.requireNonNullElseGet(instance, RoomsController::new);
	}

	public void login(PlayerController player){
		Runnable login = () -> {
			boolean successful;
			do{
				LoginMessage loginMessage = new LoginMessage();
				LoginResponse loginResponse = (LoginResponse) player.communicateWithClient(loginMessage);

				if(loginResponse.isNewRoom()){
					successful = newRoom(player);
				}else{
					successful = enterRoom(player);
				}
			}while(!successful);
		};
		new Thread(login).start();
	}

	private synchronized boolean newRoom(PlayerController player){
		NewRoomResponse newRoomMessageInfo = (NewRoomResponse) player.communicateWithClient(new NewRoomMessage());

		int roomID;
		do{
			roomID = ThreadLocalRandom.current().nextInt(0, 100000);
		}while(rooms.containsKey(roomID));
		sendNotificationToPlayer(player, "room created successfully, room ID is: " + roomID);

		player.setNickname(newRoomMessageInfo.getNickname());
		player.setRoomID(roomID);
		Room newRoom = new Room(roomID, newRoomMessageInfo.getNumberOfPlayers(), newRoomMessageInfo.isExpertMode());
		newRoom.addPlayer(player);
		rooms.put(roomID, newRoom);
		return true;
	}

	private synchronized boolean enterRoom(PlayerController player){
		ArrayList<Integer> availableRoomIDs = rooms.keySet().stream().filter(roomID -> !rooms.get(roomID).isFull())
				.collect(Collectors.toCollection(ArrayList::new));

		if(availableRoomIDs.isEmpty()){
			sendNotificationToPlayer(player, "there are no rooms to join in");
			return false;
		}

		EnterRoomMessage enterRoomMessageInfo = new EnterRoomMessage(availableRoomIDs);
		EnterRoomResponse enterRoomMessageResult = (EnterRoomResponse) player.communicateWithClient(enterRoomMessageInfo);

		Integer roomID = enterRoomMessageResult.getRoomID();

		if(!rooms.containsKey(roomID)){
			sendNotificationToPlayer(player, "there is no room with ID: " + roomID);
			return false;
		}else if(rooms.get(roomID).isFull()){
			sendNotificationToPlayer(player, "the room is already full");
			return false;
		}else if(!rooms.get(roomID).isAllowedName(enterRoomMessageResult.getNickname())){
			sendNotificationToPlayer(player, "there is another player with that nickname in the room");
			return false;
		}else{
			sendNotificationToPlayer(player, "entered in the room successfully");

			player.setNickname(enterRoomMessageResult.getNickname());
			player.setRoomID(roomID);
			rooms.get(roomID).addPlayer(player);
			return true;
		}
	}

	public void sendNotificationToPlayer(PlayerController player, String message){
		player.communicateWithClient(new NotificationMessage(message));
	}

	public synchronized void deleteRoom(Integer roomID){
		rooms.get(roomID).sendNotificationToAll("the room is being deleted");
		Room room = rooms.remove(roomID);
		room = null;
	}

	public synchronized void deleteRoom(Integer roomID, PlayerController player){
		rooms.get(roomID).sendNotificationToAllButOne(player, "the room is being deleted");
		Room room = rooms.remove(roomID);
		room = null;
	}
}
