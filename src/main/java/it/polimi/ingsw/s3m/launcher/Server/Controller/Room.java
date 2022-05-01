package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Communication.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Exception.DoubleNicknameException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.Turn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Room {
    private final int roomID;
    private final int playersNumber;
    private final boolean expertMode;
    private final ArrayList<PlayerController> playersList;
    private boolean isStarted;
    private Game gameState;

    public Room(int roomID, int playersNumber, boolean expertMode) {
        this.roomID = roomID;
        this.playersNumber = playersNumber;
        this.expertMode = expertMode;
        this.playersList = new ArrayList<>();
    }

    public int getRoomID(){
        return roomID;
    }

    public ArrayList<PlayerController> getPlayersList(){
        return playersList;
    }

    public synchronized boolean isFull(){
        return playersList.size() >= playersNumber;
    }

    public synchronized boolean isAllowedName(String nickname){
        if(playersList.isEmpty())
            return true;
        return playersList.stream()
                .map(PlayerController::getNickname)
                .noneMatch(name -> name.equals(nickname));
    }

    public synchronized void addPlayer(PlayerController player){
        playersList.add(player);
        if(!isFull() || isStarted){
            return;
        }

        isStarted = true;
        new Thread(() -> {
            try {
                start();
            } catch (DoubleNicknameException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Instantiates game if controls are passed, if not an exception is thrown
     * @throws DoubleNicknameException
     */
    public void start() throws DoubleNicknameException {
        sendNotificationToAll("the game is starting");

        ArrayList<String> playersNicknameList = playersList.stream()
                .map(PlayerController::getNickname)
                .collect(Collectors.toCollection(ArrayList::new));

<<<<<<< HEAD
        //TODO Controls for game instance
        checkGameInstanceConditions(playersNicknameList);
        this.gameState = new Game(playersNicknameList, expertMode);

        Iterator<Turn> turnIterator = new Iterator<Turn>(){
            ArrayList<Turn> turnList = new ArrayList<>();

            @Override
            public boolean hasNext(){
                return false;
            }

            @Override
            public Turn next(){
                return null;
            }
        };

        while(true){

        }
    }

    private void checkGameInstanceConditions(ArrayList<String> players) throws DoubleNicknameException{
=======
        boolean checkNicknames = checkGameInstanceConditions(playersNicknameList);
        if(checkNicknames) {
            this.gameState = new Game(playersNicknameList, expertMode);
        }else{
            throw new DoubleNicknameException();
        }
    }

    /**
     * Controls if two or more players have the same nickname
     * @param players
     * @return
     */
    private boolean checkGameInstanceConditions(ArrayList<String> players) {
>>>>>>> master
        for(String p : players){
            int occurrences = Collections.frequency(players, p);
            if(occurrences > 1){
                throw new DoubleNicknameException();
            }
        }
    }

    public void deleteRoom(PlayerController player){
        sendNotificationToAllButOne(player, "someone left, the room is being deleted");
    }

    public void sendNotificationToAllButOne(PlayerController one, String message){
        NotificationMessage notification = new NotificationMessage();
        notification.setMessage(message);

        ArrayList<PlayerController> allButOne = new ArrayList<>(playersList);
        allButOne.remove(one);
        for(PlayerController player : allButOne){
            player.communicateWithClient(notification);
        }
    }

    public void sendNotificationToAll(String message){
        NotificationMessage notification = new NotificationMessage();
        notification.setMessage(message);
        for(PlayerController player : playersList){
            player.communicateWithClient(notification);
        }
    }


}