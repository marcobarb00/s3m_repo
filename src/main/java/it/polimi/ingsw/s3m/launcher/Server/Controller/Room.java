package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.*;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.Mapper;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;
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

        boolean gameEndingFlag = false;
        while(!gameEndingFlag){
            //planning phase
            //TODO change the phase in game
            try{
                gameState.refillClouds();
            }catch(EmptyBagException e){
                sendNotificationToAll(e.getMessage());
                gameEndingFlag = true;
            }

            ArrayList<String> nicknameList =  playersList.stream().map(PlayerController::getNickname).collect(Collectors.toCollection(ArrayList::new));

            int startingIndex = nicknameList.indexOf(gameState.getFirstPlayerNickname());
            for(int i = 0; i < playersNumber; i++){
                //TODO set current player to turn
                PlayerController currentPlayer = playersList.get((startingIndex + i) % playersNumber);
                sendNotificationToPlayer(currentPlayer, "it's your turn to execute the planning phase");
                sendNotificationToAllButOne(currentPlayer, currentPlayer.getNickname() + "'s turn to execute the planning phase");
                planningPhase(currentPlayer);
            }

            gameState.setTurnFirstPlayer();
            //action phase
            //TODO change the phase in game

            startingIndex = nicknameList.indexOf(gameState.getFirstPlayerNickname());
            for(int i = 0; i < playersNumber; i++){
                //TODO set current player to turn
                PlayerController currentPlayer = playersList.get((startingIndex + i) % playersNumber);
                sendNotificationToAllButOne(currentPlayer, currentPlayer.getNickname() + "'s turn to execute the action phase");

                try{
                    actionPhase(currentPlayer);
                }catch(ZeroTowersRemainedException | NotEnoughIslandsException e){
                    //TODO ask for break (setting gameEndingFlag to true and ignoring different methods)??? maybe call different methods based on the exception
                }
            }

            //reset turn
            //TODO reset the turn
        }

        if(gameEndingFlag){
            //TODO check win conditions for the possible endings where the turn must continue
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
                return;
            }catch(IllegalArgumentException e){
                sendNotificationToPlayer(player, e.getMessage());
                continue;
            }

            successful = true;
        }
    }

    private void actionPhase(PlayerController player) throws ZeroTowersRemainedException, NotEnoughIslandsException{
        moveStudentPhase(player);
        motherNaturePhase(player);
        chooseCloudPhase(player);
    }

    private void moveStudentPhase(PlayerController player) throws ZeroTowersRemainedException, NotEnoughIslandsException{
        int movedStudents = 0;
        int studentsToBeMoved = 3;
        if(playersNumber == 3){
            studentsToBeMoved = 4;
        }

        while(movedStudents < studentsToBeMoved){
            Response response = player.communicateWithClient(new StudentsPhaseMessage(mapper.gameToDTO(gameState)));
            if(!(response instanceof StudentsPhaseResponse)){
                sendNotificationToPlayer(player, "the operation received is not the correct type");
                continue;
            }

            StudentsPhaseResponse studentsPhaseResponse = (StudentsPhaseResponse) response;
            switch(studentsPhaseResponse.getOperationChoice()){
                //TODO fix putStudentOnIslandOperation so that in the constructor parameters there is a String color or a PawnColor and not a Student
                case 1:
                    //TODO putStudentOnTable
                    break;
                case 2:
                    //TODO putStudentOnIsland
                    break;
                case 3:
                    if(((ActionPhase) gameState.getTurn().getCurrentPhase()).isActivatedCharacterCard()){
                        sendNotificationToPlayer(player, "you already activated a character card");
                        continue;
                    }
                    try{
                        playCharacterCard(player);
                    }catch(NotEnoughCoinsException | NotPlayerTurnException | NotExpertModeException | CloudNotInListException e){
                        //unable to play the character card
                        sendNotificationToPlayer(player, e.getMessage());
                        continue;
                    }
                    //successful play of character card
                    //TODO set characterCardActivated to true
                    //TODO continue?
                    break;
            }
        }
    }
    
    private void playCharacterCard(PlayerController player) throws ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughCoinsException, NotPlayerTurnException, NotExpertModeException, CloudNotInListException{
        Response response = player.communicateWithClient(new PlayCharacterCardMessage(mapper.gameToDTO(gameState)));
        if(!(response instanceof PlayCharacterCardResponse)){
            sendNotificationToPlayer(player, "the operation received is not the correct type");
            throw new ClassCastException();
        }
        PlayCharacterCardResponse playCharacterCardResponse = (PlayCharacterCardResponse) response;

        CharacterCard playedCharacterCard = gameState.getCharacterCardsList().get(playCharacterCardResponse.getCharacterCardPosition());
        Operation characterCardOperation = null;
        //TODO fix playCharacterCardMessage arguments to include minstrel, mushroomer and jester inputs
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
                throw new IllegalArgumentException("character card chosen does not exists");
        }

        try{
            characterCardOperation.executeOperation();
        }catch(PlayerNotInListException e){
            sendNotificationToAll("a player not supposed to be in the room tried to do an operation, the room is being deleted");
            RoomsController.instance().deleteRoom(roomID, player);
        }
    }

    private void motherNaturePhase(PlayerController player) throws ZeroTowersRemainedException, NotEnoughIslandsException{
        sendNotificationToPlayer(player, "it's your turn to move mother nature");

        boolean motherNatureMoved = false;
        while(!motherNatureMoved){
            Response response = player.communicateWithClient(new MotherNaturePhaseMessage(mapper.gameToDTO(gameState)));
            if(!(response instanceof MotherNaturePhaseResponse)){
                sendNotificationToPlayer(player, "the operation received is not the correct type");
                throw new ClassCastException();
            }

            MotherNaturePhaseResponse motherNaturePhaseResponse = (MotherNaturePhaseResponse) response;
            switch(motherNaturePhaseResponse.getOperationChoice()){
                case 1:
                    try{
                        moveMotherNature(player);
                    }catch(NotPlayerTurnException e){
                        sendNotificationToPlayer(player, e.getMessage());
                        continue;
                    }
                    motherNatureMoved = true;
                    break;
                case 2:
                    if(((ActionPhase) gameState.getTurn().getCurrentPhase()).isActivatedCharacterCard()){
                        sendNotificationToPlayer(player, "you already activated a character card");
                        continue;
                    }
                    try{
                        playCharacterCard(player);
                    }catch(NotEnoughCoinsException | NotPlayerTurnException | NotExpertModeException | CloudNotInListException e){
                        //unable to play the character card
                        sendNotificationToPlayer(player, e.getMessage());
                        continue;
                    }
                    break;
            }
        }
    }

    private void moveMotherNature(PlayerController player) throws NotPlayerTurnException, ZeroTowersRemainedException, NotEnoughIslandsException{
        Response response = player.communicateWithClient(new MoveMotherNatureMessage(mapper.gameToDTO(gameState)));
        if(!(response instanceof MoveMotherNatureResponse)){
            sendNotificationToPlayer(player, "the operation received is not the correct type");
            throw new ClassCastException();
        }
        MoveMotherNatureResponse moveMotherNatureResponse = (MoveMotherNatureResponse) response;

        MoveMotherNatureOperation moveMotherNatureOperation = new MoveMotherNatureOperation(gameState, player, moveMotherNatureResponse.getMotherNatureMovement());
        try{
            moveMotherNatureOperation.executeOperation();
        }catch(PlayerNotInListException e){
            sendNotificationToAll("a player not supposed to be in the room tried to do an operation, the room is being deleted");
            RoomsController.instance().deleteRoom(roomID, player);
        }
    }

    private void chooseCloudPhase(PlayerController player){
        sendNotificationToPlayer(player, "it's your turn to choose the cloud");
        //TODO implementation
    }

    public void sendNotificationToPlayer(PlayerController player, String message){
        player.communicateWithClient(new NotificationMessage(message));
    }

    public void sendNotificationToAllButOne(PlayerController one, String message){
        NotificationMessage notification = new NotificationMessage(message);

        ArrayList<PlayerController> allButOne = new ArrayList<>(playersList);
        allButOne.remove(one);
        for(PlayerController player : allButOne){
            player.communicateWithClient(notification);
        }
    }

    public void sendNotificationToAll(String message){
        NotificationMessage notification = new NotificationMessage(message);
        for(PlayerController player : playersList){
            player.communicateWithClient(notification);
        }
    }
}