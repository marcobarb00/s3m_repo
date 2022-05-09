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
    private final Integer roomID;
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
     */
    private void start() throws DoubleNicknameException {
        sendNotificationToAll("the game is starting");

        ArrayList<String> playersNicknameList = playersList.stream()
                .map(PlayerController::getNickname)
                .collect(Collectors.toCollection(ArrayList::new));

        checkGameInstanceConditions(playersNicknameList);
        this.gameState = new Game(playersNicknameList, expertMode);

        boolean gameEndingFlag = false;
        try{
            while(!gameEndingFlag){
                //planning phase
                try{
                    gameState.refillClouds();
                }catch(EmptyBagException e){
                    sendNotificationToAll(e.getMessage());
                    gameEndingFlag = true;
                }

                ArrayList<String> nicknameList = playersList.stream().map(PlayerController::getNickname).collect(Collectors.toCollection(ArrayList::new));

                int startingIndex = nicknameList.indexOf(gameState.getFirstPlayerNickname());
                for(int i = 0; i < playersNumber; i++){
                    PlayerController currentPlayer = playersList.get((startingIndex + i) % playersNumber);
                    gameState.setCurrentPlayerNickname(currentPlayer.getNickname());
                    sendNotificationToPlayer(currentPlayer, "it's your turn to execute the planning phase");
                    sendNotificationToAllButOne(currentPlayer, currentPlayer.getNickname() + "'s turn to execute the planning phase");
                    try{
                        planningPhase(currentPlayer);
                    }catch(NotEnoughAssistantCardsException e){
                        sendNotificationToAll(e.getMessage());
                        gameEndingFlag = true;
                    }
                }

                gameState.setTurnFirstPlayer();
                //action phase

                startingIndex = nicknameList.indexOf(gameState.getFirstPlayerNickname());
                for(int i = 0; i < playersNumber; i++){
                    PlayerController currentPlayer = playersList.get((startingIndex + i) % playersNumber);
                    gameState.setCurrentPlayerNickname(currentPlayer.getNickname());
                    sendNotificationToAllButOne(currentPlayer, currentPlayer.getNickname() + "'s turn to execute the action phase");

                    try{
                        try{
                            actionPhase(currentPlayer);
                        }catch(NotEnoughIslandsException e){
                            break;
                        }
                    }catch(NotEnoughAssistantCardsException e){
                        sendNotificationToAll(e.getMessage());
                        gameEndingFlag = true;
                    }
                }

                //reset turn
                gameState.resetTurn();
            }
        }catch(ZeroTowersRemainedException e){
            String winnerNickname = gameState.zeroTowersLeftWinCondition();
            sendNotificationToAll("the winner is " + winnerNickname);
            RoomsController.instance().deleteRoom(roomID);
            return;
        }

        String winnerNickname = gameState.checkWinCondition();
        sendNotificationToAll("the winner is " + winnerNickname);
        RoomsController.instance().deleteRoom(roomID);
    }

    private void checkGameInstanceConditions(ArrayList<String> players) throws DoubleNicknameException{
        for(String p : players){
            int occurrences = Collections.frequency(players, p);
            if(occurrences > 1)
                throw new DoubleNicknameException();
        }
    }

    private void planningPhase(PlayerController player) throws NotEnoughAssistantCardsException{
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

    private void actionPhase(PlayerController player) throws ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughAssistantCardsException{
        sendNotificationToPlayer(player, "it's your turn to move the students");

        int movedStudents = 0;
        int studentsToBeMoved = 3;
        if(playersNumber == 3){
            studentsToBeMoved = 4;
        }

        while(movedStudents < studentsToBeMoved){
            Response response = player.communicateWithClient(new StudentsPhaseMessage(mapper.gameToDTO(gameState)));
            try{
                if(moveStudentPhase(player, response))
                    movedStudents++;
            }catch(IncorrectOperationException e){
                sendNotificationToPlayer(player, e.getMessage());
            }
        }

        sendNotificationToPlayer(player, "it's your turn to move mother nature");

        boolean motherNatureMoved = false;
        while(!motherNatureMoved){
            Response response = player.communicateWithClient(new MotherNaturePhaseMessage(mapper.gameToDTO(gameState)));
            try{
                motherNatureMoved = motherNaturePhase(player, response);
            }catch(IncorrectOperationException e){
                sendNotificationToPlayer(player, e.getMessage());
            }
        }

        sendNotificationToPlayer(player, "it's your turn to choose the cloud");

        boolean cloudChosen = false;
        while(!cloudChosen){
            Response response = player.communicateWithClient(new CloudPhaseMessage(mapper.gameToDTO(gameState)));
            try{
                cloudChosen = chooseCloudPhase(player, response);
            }catch(IncorrectOperationException e){
                sendNotificationToPlayer(player, e.getMessage());
            }
        }
    }

    /**
     *
     * @param player the player who's playing the turn
     * @param response the response that contains the operation chosen by the player
     * @return true if a student has been moved successfully, false otherwise
     */
    private boolean moveStudentPhase(PlayerController player, Response response) throws ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughAssistantCardsException, IncorrectOperationException{
        if(!(response instanceof StudentsPhaseResponse))
            throw new IncorrectOperationException();

        StudentsPhaseResponse studentsPhaseResponse = (StudentsPhaseResponse) response;
        switch(studentsPhaseResponse.getOperationChoice()){
            case 1:
                try{
                    Response putStudentOnTableResponse = player.communicateWithClient(new PutStudentOnTableMessage(mapper.gameToDTO(gameState)));
                    putStudentOnTable(player, putStudentOnTableResponse);
                }catch(IncorrectOperationException | PlayerNotInListException e){
                    //unable to move the student
                    sendNotificationToPlayer(player, e.getMessage());
                }
                //successful play of character card
                return true;
            case 2:
                try{
                    Response putStudentOnIslandResponse = player.communicateWithClient(new PutStudentOnIslandMessage(mapper.gameToDTO(gameState)));
                    putStudentOnIsland(player, putStudentOnIslandResponse);
                }catch(IncorrectOperationException | PlayerNotInListException e){
                    //unable to move the student
                    sendNotificationToPlayer(player, e.getMessage());
                }
                //successful play of character card
                return true;
            case 3:
                if(gameState.getTurn().isActivatedCharacterCard()){
                    sendNotificationToPlayer(player, "you already activated a character card");
                    return false;
                }
                try{
                    Response playCharacterCardResponse = player.communicateWithClient(new PlayCharacterCardMessage(mapper.gameToDTO(gameState)));
                    playCharacterCard(player, playCharacterCardResponse);
                }catch(NotEnoughCoinsException | NotPlayerTurnException | NotExpertModeException | CloudNotInListException | IncorrectOperationException e){
                    //unable to play the character card
                    sendNotificationToPlayer(player, e.getMessage());
                    return false;
                }catch(BackException e){
                    return false;
                }
                //successful play of character card
                gameState.getTurn().setActivatedCharacterCard(true);
        }
        return false;
    }

    private void putStudentOnTable(PlayerController player, Response response) throws IncorrectOperationException, PlayerNotInListException{
        if(!(response instanceof PutStudentOnTableResponse))
            throw new IncorrectOperationException();

        PutStudentOnTableResponse putStudentOnTableResponse = (PutStudentOnTableResponse) response;

        PutStudentOnTableOperation putStudentOnTableOperation = new PutStudentOnTableOperation(gameState, player, mapper.stringToColor(putStudentOnTableResponse.getColor()));
        putStudentOnTableOperation.executeOperation();
    }

    private void putStudentOnIsland(PlayerController player, Response response) throws IncorrectOperationException, PlayerNotInListException{
        if(!(response instanceof PutStudentOnIslandResponse))
            throw new IncorrectOperationException();

        PutStudentOnIslandResponse putStudentOnIslandResponse = (PutStudentOnIslandResponse) response;

        PutStudentOnIslandOperation putStudentOnIslandOperation = new PutStudentOnIslandOperation(gameState, player, putStudentOnIslandResponse.getIslandPosition(), mapper.stringToColor(putStudentOnIslandResponse.getColor()));
        putStudentOnIslandOperation.executeOperation();
    }
    
    private void playCharacterCard(PlayerController player, Response response) throws ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughCoinsException, NotPlayerTurnException, NotExpertModeException, CloudNotInListException, IncorrectOperationException, NotEnoughAssistantCardsException, BackException{
        if(response instanceof BackResponse)
            throw new BackException();

        if(!(response instanceof PlayCharacterCardResponse))
            throw new IncorrectOperationException();

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

    /**
     *
     * @param player the player who's playing the turn
     * @param response the response that contains the operation chosen by the player
     * @return true if mother nature has been moved successfully, false otherwise
     */
    private boolean motherNaturePhase(PlayerController player, Response response) throws ZeroTowersRemainedException, NotEnoughIslandsException, NotEnoughAssistantCardsException, IncorrectOperationException{
        if(!(response instanceof MotherNaturePhaseResponse))
            throw new IncorrectOperationException();

        MotherNaturePhaseResponse motherNaturePhaseResponse = (MotherNaturePhaseResponse) response;
        switch(motherNaturePhaseResponse.getOperationChoice()){
            case 1:
                try{
                    Response moveMotherNatureResponse = player.communicateWithClient(new MoveMotherNatureMessage(mapper.gameToDTO(gameState)));
                    moveMotherNature(player, moveMotherNatureResponse);
                }catch(NotPlayerTurnException e){
                    sendNotificationToPlayer(player, e.getMessage());
                    return false;
                }catch(BackException e){
                    return false;
                }
                return true;
            case 2:
                if(gameState.getTurn().isActivatedCharacterCard()){
                    sendNotificationToPlayer(player, "you already activated a character card");
                    return false;
                }
                try{
                    Response playCharacterCardResponse = player.communicateWithClient(new PlayCharacterCardMessage(mapper.gameToDTO(gameState)));
                    playCharacterCard(player, playCharacterCardResponse);
                }catch(NotEnoughCoinsException | NotPlayerTurnException | NotExpertModeException | CloudNotInListException | IllegalArgumentException e){
                    //unable to play the character card
                    sendNotificationToPlayer(player, e.getMessage());
                    return false;
                }catch(BackException e){
                    return false;
                }
        }

        return false;
    }

    private void moveMotherNature(PlayerController player, Response response) throws NotPlayerTurnException, ZeroTowersRemainedException, NotEnoughIslandsException, IncorrectOperationException, BackException{
        if(response instanceof BackResponse)
            throw new BackException();

        if(!(response instanceof MoveMotherNatureResponse))
            throw new IncorrectOperationException();

        MoveMotherNatureResponse moveMotherNatureResponse = (MoveMotherNatureResponse) response;

        MoveMotherNatureOperation moveMotherNatureOperation = new MoveMotherNatureOperation(gameState, player, moveMotherNatureResponse.getMotherNatureMovement());
        try{
            moveMotherNatureOperation.executeOperation();
        }catch(PlayerNotInListException e){
            sendNotificationToAll("a player not supposed to be in the room tried to do an operation, the room is being deleted");
            RoomsController.instance().deleteRoom(roomID, player);
        }
    }

    private boolean chooseCloudPhase(PlayerController player, Response response) throws IncorrectOperationException{
        if(!(response instanceof CloudResponse))
            throw new IncorrectOperationException();

        CloudResponse cloudResponse = (CloudResponse) response;

        ChooseCloudOperation chooseCloudOperation = new ChooseCloudOperation(gameState, player, cloudResponse.getCloud());

        try{
            chooseCloudOperation.executeOperation();
        }catch(PlayerNotInListException e){
            sendNotificationToAll("a player not supposed to be in the room tried to do an operation, the room is being deleted");
            RoomsController.instance().deleteRoom(roomID, player);
            return false;
        }catch(CloudNotInListException e){
            return false;
        }

        return true;
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