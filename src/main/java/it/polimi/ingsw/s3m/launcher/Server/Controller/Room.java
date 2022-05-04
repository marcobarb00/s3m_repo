package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.MoveStudentsResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.Mapper;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Exception.DoubleNicknameException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Message.GameStateMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveStudentsPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;
import it.polimi.ingsw.s3m.launcher.Server.Operation.PlayAssistantCardOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Room {
    private final int playersNumber;
    private final boolean expertMode;
    private final ArrayList<PlayerController> playersList;
    private boolean isStarted;
    private Game gameState;
    private final Mapper mapper = new Mapper();

    public Room(int playersNumber, boolean expertMode) {
        this.playersNumber = playersNumber;
        this.expertMode = expertMode;
        this.playersList = new ArrayList<>();
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
                PlayerController currentPlayer = playersList.get(i);
                sendNotificationToPlayer(currentPlayer, "it's your turn");
                sendNotificationToAllButOne(currentPlayer, currentPlayer + "'s turn");
                sendGameState(currentPlayer);
                planningPhase(currentPlayer);
            }

            //TODO call method to calculate player's turn

            for(int i = 0; i < playersNumber; i++){
                PlayerController currentPlayer = playersList.get(i);
                sendNotificationToPlayer(currentPlayer, "it's your turn");
                sendNotificationToAllButOne(currentPlayer, currentPlayer + "'s turn");
                sendGameState(currentPlayer);
                actionPhase(currentPlayer);
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
        ArrayList<AssistantCardDTO> playedCards = mapper.assistantCardListToDTO(gameState.getPlayedAssistantCardsList());
        ArrayList<AssistantCardDTO> handDTO = mapper.assistantCardListToDTO(gameState.getPlayerHand(player.getNickname()));
        PlanningPhaseMessage planningPhaseMessage = new PlanningPhaseMessage(playedCards, handDTO);
        Response response = player.communicateWithClient(planningPhaseMessage);

        while(!(response instanceof PlayAssistantCardResponse)){
            sendNotificationToPlayer(player, "the operation received is not the correct type");
            response = player.communicateWithClient(planningPhaseMessage);
        }

        PlayAssistantCardResponse playAssistantCardResponse = (PlayAssistantCardResponse) response;
        PlayAssistantCardOperation playAssistantCardOperation = new PlayAssistantCardOperation(gameState, player, playAssistantCardResponse.getCardChosen());
        try{
            playAssistantCardOperation.executeOperation();
        }catch(PlayerNotInListException e){
            e.printStackTrace();
        }
    }

    private void actionPhase(PlayerController player){
        //move students phase
        moveStudentPhase(player);
    }

    private void moveStudentPhase(PlayerController player){
        //TODO set attributes of moveStudentsPhaseMessage
        MoveStudentsPhaseMessage moveStudentsPhaseMessage = new MoveStudentsPhaseMessage();
        Response response = player.communicateWithClient(moveStudentsPhaseMessage);

        while(!(response instanceof MoveStudentsResponse)){
            sendNotificationToPlayer(player, "the operation received is not the correct type");
            response = player.communicateWithClient(moveStudentsPhaseMessage);
        }
    }

    public void deleteRoom(PlayerController player){
        sendNotificationToAllButOne(player, "someone left, the room is being deleted");
    }

    public void sendNotificationToPlayer(PlayerController player, String message){
        player.communicateWithClient(new NotificationMessage(message));
    }

    private void sendNotificationToAllButOne(PlayerController one, String message){
        NotificationMessage notification = new NotificationMessage(message);

        ArrayList<PlayerController> allButOne = new ArrayList<>(playersList);
        allButOne.remove(one);
        for(PlayerController player : allButOne){
            player.communicateWithClient(notification);
        }
    }

    private void sendNotificationToAll(String message){
        NotificationMessage notification = new NotificationMessage(message);
        for(PlayerController player : playersList){
            player.communicateWithClient(notification);
        }
    }

    private void sendGameState(PlayerController player){
        GameDTO gameDTO = mapper.gameToDTO(gameState);
        player.communicateWithClient(new GameStateMessage(gameDTO));
    }
}