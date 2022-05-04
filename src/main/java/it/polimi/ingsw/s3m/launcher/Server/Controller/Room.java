package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.View.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.Mapper;
import it.polimi.ingsw.s3m.launcher.Server.Exception.DoubleNicknameException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Message.GameStateMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;
import it.polimi.ingsw.s3m.launcher.Server.Operation.PlayAssistantCardOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Room {
    private final int roomID;
    private final int playersNumber;
    private final boolean expertMode;
    private final ArrayList<PlayerController> playersList;
    private boolean isStarted;
    private Game gameState;
    private final Mapper mapper = new Mapper();

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
    private void start() throws DoubleNicknameException {
        sendNotificationToAll("the game is starting");

        ArrayList<String> playersNicknameList = playersList.stream()
                .map(PlayerController::getNickname)
                .collect(Collectors.toCollection(ArrayList::new));

        checkGameInstanceConditions(playersNicknameList);
        this.gameState = new Game(playersNicknameList, expertMode);

        while(true){
            gameState.refillClouds();

            //TODO call the method to calculate who's starting

            for(int i = 0; i < playersNumber; i++){
                planningPhase(playersList.get(i));
            }

            //TODO call method to calculate player's turn

            for(int i = 0; i < playersNumber; i++){
                actionPhase(playersList.get(i));
            }
            //turn.setPLayer(turn.getNextPlayer());
        }
    }

    private void checkGameInstanceConditions(ArrayList<String> players) throws DoubleNicknameException{
        for(String p : players){
            int occurrences = Collections.frequency(players, p);
            if(occurrences > 1){
                throw new DoubleNicknameException();
            }
        }
    }

    private void planningPhase(PlayerController player){
        sendGameState(player);

        PlanningPhaseMessage planningPhaseMessage = new PlanningPhaseMessage();
        ArrayList<AssistantCardDTO> playedCards = mapper.assistantCardListToDTO(gameState.getPlayedAssistantCardsList());
        planningPhaseMessage.setPlayedAssistantCards(playedCards);
        ArrayList<AssistantCardDTO> handDTO = mapper.assistantCardListToDTO(gameState.getPlayerHand(player.getNickname()));
        planningPhaseMessage.setHand(handDTO);
        PlayAssistantCardResponse playAssistantCardResponse = (PlayAssistantCardResponse) player.communicateWithClient(planningPhaseMessage);
        //TODO check if it really is a playAssistantCardMessage???

        PlayAssistantCardOperation playAssistantCardOperation = new PlayAssistantCardOperation(gameState, player, playAssistantCardResponse.getCardChosen());
        try{
            playAssistantCardOperation.executeOperation();
        }catch(PlayerNotInListException e){
            e.printStackTrace();
        }
    }

    private void actionPhase(PlayerController player){
        sendGameState(player);

        //move students phase

    }

    private void moveStudentPhase(PlayerController player){

    }

    public void deleteRoom(PlayerController player){
        sendNotificationToAllButOne(player, "someone left, the room is being deleted");
    }

    private void sendNotificationToAllButOne(PlayerController one, String message){
        NotificationMessage notification = new NotificationMessage();
        notification.setMessage(message);

        ArrayList<PlayerController> allButOne = new ArrayList<>(playersList);
        allButOne.remove(one);
        for(PlayerController player : allButOne){
            player.communicateWithClient(notification);
        }
    }

    private void sendNotificationToAll(String message){
        NotificationMessage notification = new NotificationMessage();
        notification.setMessage(message);
        for(PlayerController player : playersList){
            player.communicateWithClient(notification);
        }
    }

    private void sendGameState(PlayerController player){
        GameDTO gameDTO = mapper.gameToDTO(gameState);
        player.communicateWithClient(new GameStateMessage(gameDTO));
    }
}