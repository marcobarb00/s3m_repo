package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.MoveStudentsResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.CharacterCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.Mapper;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.MoveStudentsPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.NotificationMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import it.polimi.ingsw.s3m.launcher.Server.Model.*;
import it.polimi.ingsw.s3m.launcher.Server.Operation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Room {
    private Integer roomID;
    private final int playersNumber;
    private final boolean expertMode;
    private final ArrayList<PlayerController> playersList;
    private boolean isStarted;
    private Game gameState;
    private final Mapper mapper = new Mapper();

    public Room(Integer roomID, int playersNumber, boolean expertMode) {
        this.roomID = roomID;
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

            ArrayList<String> nicknameList =  playersList.stream().map(PlayerController::getNickname).collect(Collectors.toCollection(ArrayList::new));

            int i = nicknameList.indexOf(gameState.getFirstPlayerNickname());
            while(i < playersNumber){
                PlayerController currentPlayer = playersList.get(i);
                sendNotificationToPlayer(currentPlayer, "it's your turn to execute the planning phase");
                sendNotificationToAllButOne(currentPlayer, currentPlayer + "'s turn to execute the planning phase");
                planningPhase(currentPlayer);

                i = (i+1) % playersNumber;
            }

            gameState.setTurnFirstPlayer();

            i = nicknameList.indexOf(gameState.getFirstPlayerNickname());
            while(i < playersNumber){
                PlayerController currentPlayer = playersList.get(i);
                sendNotificationToAllButOne(currentPlayer, currentPlayer + "'s turn to execute the action phase");
                actionPhase(currentPlayer);

                i = (i+1) % playersNumber;
            }
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
        //TODO change gameState.getPlayedAssistantCardsList() into gameState.getTurn().getPlayedAssistantCardsList()
        PlanningPhaseMessage planningPhaseMessage = new PlanningPhaseMessage(mapper.gameToDTO(gameState));

        boolean successful = false;

        while(!successful){
            Response response = player.communicateWithClient(planningPhaseMessage);
            if(!(response instanceof PlayAssistantCardResponse)){
                sendNotificationToPlayer(player, "the operation received is not the correct type");
                continue;
            }

            PlayAssistantCardResponse playAssistantCardResponse = (PlayAssistantCardResponse) response;
            PlayAssistantCardOperation playAssistantCardOperation = new PlayAssistantCardOperation(gameState, player, playAssistantCardResponse.getCardChosen());

            try{
                playAssistantCardOperation.executeOperation();
            }catch(PlayerNotInListException e){
                sendNotificationToAll("a player not supposed to be in the room tried to do an operation, the room is being deleted");
                RoomsController.instance().deleteRoom(roomID, player);
            }catch(IllegalArgumentException e){
                sendNotificationToPlayer(player, e.getMessage());
            }

            successful = true;
        }
    }

    private void actionPhase(PlayerController player){
        moveStudentPhase(player);
        motherNaturePhase(player);
        chooseCloudPhase(player);
    }

    private void moveStudentPhase(PlayerController player){
        sendNotificationToPlayer(player, "it's your turn to move the students");

        MoveStudentsPhaseMessage moveStudentsPhaseMessage = new MoveStudentsPhaseMessage(mapper.gameToDTO(gameState));
        Response response = player.communicateWithClient(moveStudentsPhaseMessage);

        while(!(response instanceof MoveStudentsResponse)){
            sendNotificationToPlayer(player, "the operation received is not the correct type");
            response = player.communicateWithClient(moveStudentsPhaseMessage);
        }

        MoveStudentsResponse moveStudentsResponse = (MoveStudentsResponse) response;

        if(moveStudentsResponse.isCharacterCardActivated()){
            CharacterCard playedCharacterCard = gameState.getCharacterCardsList().get(moveStudentsResponse.getCharacterCardPosition());
            Operation characterCardOperation = null;
            switch(playedCharacterCard.getName()){
                case "Centaur":
                    characterCardOperation = new ActivateCentaurEffectOperation(gameState, player);
                    break;
                case "Knight":
                    characterCardOperation = new ActivateKnightEffectOperation(gameState, player);
                    break;
                case "Minstrel":
                    //characterCardOperation = new ActivateMinstrelEffectOperation(gameState, player);
                    break;
                case "Mushroomer":
                    //characterCardOperation = new ActivateMushroomerEffectOperation(gameState, player);
                    break;
                case "Jester":
                    //characterCardOperation = new ActivateJesterEffectOperation(gameState, player);
                    break;
                case "MagicPostman":
                    characterCardOperation = new ActivateMagicPostmanEffectOperation(gameState, player);
                    break;
                default:
                    //TODO notificate the error
            }

            try{
                characterCardOperation.executeOperation();
            }catch(PlayerNotInListException e){
                sendNotificationToAll("a player not supposed to be in the room tried to do an operation, the room is being deleted");
                RoomsController.instance().deleteRoom(roomID, player);
            }catch(CloudNotInListException | NotExpertModeException | NotEnoughCoinsException | NotPlayersTurnException | ZeroTowersRemainedException | NotEnoughIslandsException e){
                //TODO fix exceptions ZeroTowersRemainedException, NotEnoughIslandsException
                sendNotificationToAll(e.getMessage());
            }
        }
    }

    public void motherNaturePhase(PlayerController player){
        sendNotificationToPlayer(player, "it's your turn to move the students");
    }

    public void chooseCloudPhase(PlayerController player){
        sendNotificationToPlayer(player, "it's your turn to choose the cloud");
    }

    public void deleteRoom(PlayerController player){
        sendNotificationToAllButOne(player, "the room is being deleted");
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
}