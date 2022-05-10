package it.polimi.ingsw.s3m.launcher.Server.Controller;

import it.polimi.ingsw.s3m.launcher.Client.Response.*;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.Mapper;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.CharacterCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Operation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Room{
	private final Integer roomID;
	private final int playersNumber;
	private final boolean expertMode;
	private final ArrayList<PlayerController> playersList;
	private boolean isStarted;
	private Game gameState;
	private final Mapper mapper = new Mapper();

	public Room(Integer roomID, int playersNumber, boolean expertMode){
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
			try{
				start();
			}catch(DoubleNicknameException e){
				sendNotificationToAll("there was an error during the assignment of nicknames, the room is being deleted");
			}catch(NullWinnerException ex){
				sendNotificationToAll("there was an error during calculation of the winner, everyone wins :)");
			}catch(NotPlayerTurnException e){
				sendNotificationToAll("something went wrong handling the turn, the room is being deleted");
			}catch(PlayerNotInListException e){
				sendNotificationToAll("someone not supposed to be in the room tried to play, the room is being deleted");
			}

			RoomsController.instance().deleteRoom(roomID);
		}).start();
	}

	/**
	 * Instantiates game if controls are passed, if not an exception is thrown
	 */
	private void start() throws DoubleNicknameException, NullWinnerException, NotPlayerTurnException, PlayerNotInListException{
		sendNotificationToAll("the game is starting");

		ArrayList<String> playersNicknameList = playersList.stream()
				.map(PlayerController::getNickname)
				.collect(Collectors.toCollection(ArrayList::new));

		checkGameInstanceConditions(playersNicknameList);
		this.gameState = new Game(playersNicknameList, expertMode);

		boolean gameEndingFlag = false;
		try{
			while(!gameEndingFlag){
				//initialize planning phase
				try{
					gameState.refillClouds();
				}catch(EmptyBagException e){
					sendNotificationToAll(e.getMessage());
					gameEndingFlag = true;
				}

				ArrayList<String> nicknameList = playersList.stream().map(PlayerController::getNickname).collect(Collectors.toCollection(ArrayList::new));

				int startingIndex = nicknameList.indexOf(gameState.getFirstPlayerNickname());
				//cycle all the players to let them play the planning phase
				for(int i = 0; i < playersNumber; i++){
					PlayerController currentPlayer = playersList.get((startingIndex + i) % playersNumber);
					gameState.setCurrentPlayerNickname(currentPlayer.getNickname());
					try{
						planningPhase(currentPlayer);
					}catch(NotEnoughAssistantCardsException e){
						sendNotificationToAll(e.getMessage());
						gameEndingFlag = true;
					}
				}

				//initialize action phase
				gameState.setTurnFirstPlayer();

				startingIndex = nicknameList.indexOf(gameState.getFirstPlayerNickname());
				//cycle all the players to let them play the planning phase
				for(int i = 0; i < playersNumber; i++){
					PlayerController currentPlayer = playersList.get((startingIndex + i) % playersNumber);
					gameState.setCurrentPlayerNickname(currentPlayer.getNickname());

					try{
						actionPhase(currentPlayer);
					}catch(NotEnoughAssistantCardsException e){
						sendNotificationToAll(e.getMessage());
						gameEndingFlag = true;
					}catch(NotEnoughIslandsException e){
						break;
					}
				}

				//reset turn
				gameState.resetTurn();
			}
		}catch(ZeroTowersRemainedException e){
			String winnerNickname;
			winnerNickname = gameState.zeroTowersLeftWinCondition();
			sendNotificationToAll("the winner is " + winnerNickname);
			return;
		}

		try{
			String winnerNickname;
			winnerNickname = gameState.checkWinCondition();
			sendNotificationToAll("the winner is " + winnerNickname);
		}catch(TieException e){
			sendNotificationToAll("there was a tie! the winners are " + e.getMessage());
		}
	}

	private void checkGameInstanceConditions(ArrayList<String> players) throws DoubleNicknameException{
		for(String p : players){
			int occurrences = Collections.frequency(players, p);
			if(occurrences > 1)
				throw new DoubleNicknameException();
		}
	}

	private void planningPhase(PlayerController player) throws NotEnoughAssistantCardsException, PlayerNotInListException{
		sendNotificationToPlayer(player, "it's your turn to execute the planning phase");
		sendNotificationToAllButOne(player, player.getNickname() + "'s turn to execute the planning phase");
		PlanningPhaseMessage planningPhaseMessage = new PlanningPhaseMessage(mapper.gameToDTO(gameState));

		boolean successful = false;

		while(!successful){
			Response response = player.communicateWithClient(planningPhaseMessage);
			try{
				successful = planningPhaseResponse(player, response);
			}catch(IncorrectOperationException | IllegalArgumentException e){
				sendNotificationToPlayer(player, e.getMessage());
			}
		}
	}

	private boolean planningPhaseResponse(PlayerController player, Response response) throws NotEnoughAssistantCardsException,
			IncorrectOperationException, PlayerNotInListException{
		if(!(response instanceof PlayAssistantCardResponse)){
			throw new IncorrectOperationException();
		}

		PlayAssistantCardResponse playAssistantCardResponse = (PlayAssistantCardResponse) response;
		PlayAssistantCardOperation playAssistantCardOperation = new PlayAssistantCardOperation(gameState, player, playAssistantCardResponse.getCardChosen());

		playAssistantCardOperation.executeOperation();
		sendNotificationToPlayer(player, "card played successfully");
		return true;
	}

	private void actionPhase(PlayerController player) throws ZeroTowersRemainedException, NotEnoughIslandsException,
			NotEnoughAssistantCardsException, NotPlayerTurnException, PlayerNotInListException{
		sendNotificationToAllButOne(player, player.getNickname() + "'s turn to execute the action phase");

		sendNotificationToPlayer(player, "it's your turn to move the students");

		gameState.getTurn().resetMovedStudents();
		int studentsToBeMoved = 3;
		if(playersNumber == 3){
			studentsToBeMoved = 4;
		}

		while(gameState.getTurnMovedStudents() < studentsToBeMoved){
			Response response = player.communicateWithClient(new StudentsPhaseMessage(mapper.gameToDTO(gameState)));
			try{
				moveStudentPhase(player, response);
			}catch(IncorrectOperationException | PlayerNotInListException | NotEnoughCoinsException | CloudNotInListException |
					NotExpertModeException | CharacterCardAlreadyActivatedException e){
				sendNotificationToPlayer(player, e.getMessage());
			}catch(BackException e){
				//don't do anything, just continue while to repeat the moveStudentPhase
			}
		}

		sendNotificationToPlayer(player, "it's your turn to move mother nature");

		boolean motherNatureMoved = false;
		while(!motherNatureMoved){
			Response response = player.communicateWithClient(new MotherNaturePhaseMessage(mapper.gameToDTO(gameState)));
			try{
				motherNatureMoved = motherNaturePhase(player, response);
			}catch(IncorrectOperationException | NotEnoughCoinsException | NotExpertModeException |
					CloudNotInListException | CharacterCardAlreadyActivatedException e){
				sendNotificationToPlayer(player, e.getMessage());
			}catch(BackException e){
				//don't do anything, just continue while to repeat the mother nature phase
			}
		}

		sendNotificationToPlayer(player, "it's your turn to choose the cloud");

		boolean cloudChosen = false;
		while(!cloudChosen){
			Response response = player.communicateWithClient(new CloudPhaseMessage(mapper.gameToDTO(gameState)));
			try{
				cloudChosen = chooseCloudPhase(player, response);
			}catch(IncorrectOperationException | CloudNotInListException e){
				sendNotificationToPlayer(player, e.getMessage());
			}
		}
	}

	/**
	 * @param player   the player who's playing the turn
	 * @param response the response that contains the operation chosen by the player
	 */
	private void moveStudentPhase(PlayerController player, Response response) throws ZeroTowersRemainedException,
			NotEnoughIslandsException, NotEnoughAssistantCardsException, IncorrectOperationException,
			PlayerNotInListException, NotEnoughCoinsException, NotPlayerTurnException, BackException,
			NotExpertModeException, CloudNotInListException, CharacterCardAlreadyActivatedException{
		if(!(response instanceof StudentsPhaseResponse))
			throw new IncorrectOperationException();

		StudentsPhaseResponse studentsPhaseResponse = (StudentsPhaseResponse) response;
		switch(studentsPhaseResponse.getOperationChoice()){
			case 1:
				Response putStudentOnTableResponse = player.communicateWithClient(new PutStudentOnTableMessage(mapper.gameToDTO(gameState)));
				putStudentOnTable(player, putStudentOnTableResponse);
				//student moved successfully
				sendNotificationToPlayer(player, "student moved successfully");
				break;
			case 2:
				Response putStudentOnIslandResponse = player.communicateWithClient(new PutStudentOnIslandMessage(mapper.gameToDTO(gameState)));
				putStudentOnIsland(player, putStudentOnIslandResponse);
				//student moved successfully
				sendNotificationToPlayer(player, "student moved successfully");
				break;
			case 3:
				if(gameState.isCharacterCardActivated())
					throw new CharacterCardAlreadyActivatedException();

				Response playCharacterCardResponse = player.communicateWithClient(new PlayCharacterCardMessage(mapper.gameToDTO(gameState)));
				playCharacterCard(player, playCharacterCardResponse);
				//successful play of character card
				sendNotificationToPlayer(player, "character card activated successfully");
				gameState.getTurn().setActivatedCharacterCard(true);
				break;
		}
	}

	private void putStudentOnTable(PlayerController player, Response response) throws IncorrectOperationException, PlayerNotInListException{
		if(!(response instanceof PutStudentOnTableResponse))
			throw new IncorrectOperationException();

		PutStudentOnTableResponse putStudentOnTableResponse = (PutStudentOnTableResponse) response;

		PutStudentOnTableOperation putStudentOnTableOperation = new PutStudentOnTableOperation(gameState, player,
				mapper.stringToColor(putStudentOnTableResponse.getColor()));
		putStudentOnTableOperation.executeOperation();
	}

	private void putStudentOnIsland(PlayerController player, Response response) throws IncorrectOperationException, PlayerNotInListException{
		if(!(response instanceof PutStudentOnIslandResponse))
			throw new IncorrectOperationException();

		PutStudentOnIslandResponse putStudentOnIslandResponse = (PutStudentOnIslandResponse) response;

		PutStudentOnIslandOperation putStudentOnIslandOperation = new PutStudentOnIslandOperation(gameState, player,
				putStudentOnIslandResponse.getIslandPosition(), mapper.stringToColor(putStudentOnIslandResponse.getColor()));
		putStudentOnIslandOperation.executeOperation();
	}

	private void playCharacterCard(PlayerController player, Response response) throws ZeroTowersRemainedException,
			NotEnoughIslandsException, NotEnoughCoinsException, NotPlayerTurnException, NotExpertModeException,
			CloudNotInListException, IncorrectOperationException, NotEnoughAssistantCardsException, BackException,
			PlayerNotInListException, CharacterCardAlreadyActivatedException{
		if(response instanceof BackResponse)
			throw new BackException();

		if(!(response instanceof PlayCharacterCardResponse))
			throw new IncorrectOperationException();

		PlayCharacterCardResponse playCharacterCardResponse = (PlayCharacterCardResponse) response;

		CharacterCard playedCharacterCard = gameState.getCharacterCardsList().get(playCharacterCardResponse.getCharacterCardPosition());
		Operation characterCardOperation;
		switch(playedCharacterCard.getName()){
			case "Centaur":
				characterCardOperation = new ActivateCentaurEffectOperation(gameState, player);
				break;
			case "Knight":
				characterCardOperation = new ActivateKnightEffectOperation(gameState, player);
				break;
			case "Minstrel":
				ArrayList<PawnColor> studentsToPutOnEntrance = mapper.StringListToColor(playCharacterCardResponse.getStudentsToGetFrom());
				ArrayList<PawnColor> studentsToPutOnTables = mapper.StringListToColor(playCharacterCardResponse.getStudentsToPutOn());
				characterCardOperation = new ActivateMinstrelEffectOperation(gameState, player, studentsToPutOnEntrance, studentsToPutOnTables);
				break;
			case "Mushroomer":
				characterCardOperation = new ActivateMushroomerEffectOperation(gameState, player,
						mapper.stringToColor(playCharacterCardResponse.getNotInfluencingColor()));
				break;
			case "Jester":
				ArrayList<PawnColor> studentsToGetFromJester = mapper.StringListToColor(playCharacterCardResponse.getStudentsToGetFrom());
				ArrayList<PawnColor> studentsToPutOnJester = mapper.StringListToColor(playCharacterCardResponse.getStudentsToPutOn());
				characterCardOperation = new ActivateJesterEffectOperation(gameState, player, studentsToGetFromJester, studentsToPutOnJester);
				break;
			case "MagicPostman":
				characterCardOperation = new ActivateMagicPostmanEffectOperation(gameState, player);
				break;
			default:
				throw new IllegalArgumentException("character card chosen does not exists");
		}

		characterCardOperation.executeOperation();
	}

	/**
	 * @param player   the player who's playing the turn
	 * @param response the response that contains the operation chosen by the player
	 * @return true if mother nature has been moved, false otherwise
	 */
	private boolean motherNaturePhase(PlayerController player, Response response) throws ZeroTowersRemainedException,
			NotEnoughIslandsException, NotEnoughAssistantCardsException, IncorrectOperationException,
			NotPlayerTurnException, BackException, NotEnoughCoinsException, NotExpertModeException, CloudNotInListException,
			PlayerNotInListException, CharacterCardAlreadyActivatedException{
		if(!(response instanceof MotherNaturePhaseResponse))
			throw new IncorrectOperationException();

		MotherNaturePhaseResponse motherNaturePhaseResponse = (MotherNaturePhaseResponse) response;
		switch(motherNaturePhaseResponse.getOperationChoice()){
			case 1:
				Response moveMotherNatureResponse = player.communicateWithClient(new MoveMotherNatureMessage(mapper.gameToDTO(gameState)));
				moveMotherNature(player, moveMotherNatureResponse);
				//mother nature moved successfully
				sendNotificationToPlayer(player, "mother nature moved successfully");
				return true;
			case 2:
				if(gameState.isCharacterCardActivated())
					throw new CharacterCardAlreadyActivatedException();

				Response playCharacterCardResponse = player.communicateWithClient(new PlayCharacterCardMessage(mapper.gameToDTO(gameState)));
				playCharacterCard(player, playCharacterCardResponse);
				//character card played successfully
				return false;
		}
		return false;
	}

	private void moveMotherNature(PlayerController player, Response response) throws NotPlayerTurnException,
			ZeroTowersRemainedException, NotEnoughIslandsException, IncorrectOperationException, BackException, PlayerNotInListException{
		if(response instanceof BackResponse)
			throw new BackException();

		if(!(response instanceof MoveMotherNatureResponse))
			throw new IncorrectOperationException();

		MoveMotherNatureResponse moveMotherNatureResponse = (MoveMotherNatureResponse) response;

		MoveMotherNatureOperation moveMotherNatureOperation = new MoveMotherNatureOperation(gameState, player, moveMotherNatureResponse.getMotherNatureMovement());
		moveMotherNatureOperation.executeOperation();
	}

	private boolean chooseCloudPhase(PlayerController player, Response response) throws IncorrectOperationException,
			PlayerNotInListException, CloudNotInListException{
		if(!(response instanceof CloudResponse))
			throw new IncorrectOperationException();

		CloudResponse cloudResponse = (CloudResponse) response;

		ChooseCloudOperation chooseCloudOperation = new ChooseCloudOperation(gameState, player, cloudResponse.getCloud());

		chooseCloudOperation.executeOperation();
		//cloud chosen successfully
		sendNotificationToPlayer(player, "the cloud was chosen successfully");
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