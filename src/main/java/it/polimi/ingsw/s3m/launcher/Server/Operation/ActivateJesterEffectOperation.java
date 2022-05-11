package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Student;

import java.util.ArrayList;
import java.util.HashMap;

// DONE
public class ActivateJesterEffectOperation extends Operation{
	private ArrayList<PawnColor> requiredStudents;
	private ArrayList<PawnColor> givenStudents;

	/**
	 * Checks if activateJesterEffect method has safe parameters.
	 * Required students are those the player wants from the card,
	 * given students are those from the player hall.
	 *
	 * @param game
	 * @param playerController
	 * @param requiredStudents
	 * @param givenStudents
	 */
	public ActivateJesterEffectOperation(Game game, PlayerController playerController,
										 ArrayList<PawnColor> requiredStudents,
										 ArrayList<PawnColor> givenStudents){
		super(game, playerController);
		this.requiredStudents = requiredStudents;
		this.givenStudents = givenStudents;
	}

	@Override
	public void executeOperation() throws PlayerNotInListException, NotExpertModeException,
			NotEnoughCoinsException, CharacterCardAlreadyActivatedException, IncorrectOperationException {
		//check null args
		boolean checkArgs = game != null && playerController != null && requiredStudents != null
				&& givenStudents != null && !requiredStudents.contains(null) && !givenStudents.contains(null);
		if(!checkArgs){
			throw new IncorrectOperationException("Invalid arguments");
		}

		//Check for double nicknames
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList){
			throw new PlayerNotInListException();
		}

		//checking expert mode
		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode){
			throw new NotExpertModeException();
		}

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard){
			throw new CharacterCardAlreadyActivatedException();
		}

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Jester");
		if(!checkCost){
			throw new NotEnoughCoinsException();
		}

		boolean checkRequired = requiredStudents.size() <= 3;
		boolean checkGiven = givenStudents.size() <= 3;
		boolean checkStudents = (givenStudents.size() == requiredStudents.size()) &&
				checkGiven && checkRequired;
		if(!checkStudents){
			throw new IncorrectOperationException("Incorrect exchange students value");
		}

		//Search students on card
		searchStudentsOnCard();

		//Search students in dashboard hall
		//Method looks like crap but should work
		searchStudentsInEntrance();

		super.game.activateJesterEffect(playerController.getNickname(),
				requiredStudents, givenStudents);
	}

	/**
	 * Checks if on Jester card the students are enough
	 */
	private void searchStudentsOnCard() throws IncorrectOperationException {
		HashMap<PawnColor, Integer> studentsOnJester = game.getJesterStudentsOnCard();

		//checking on Jester card
		for(PawnColor color : PawnColor.values()){
			int numberOfRequiredStudents = (int) requiredStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsOnCard =
					numberOfRequiredStudents > studentsOnJester.get(color);
			if(notEnoughStudentsOnCard){
				throw new IncorrectOperationException("Not enough students on jester card");
			}
		}
	}

	private void searchStudentsInEntrance() throws IncorrectOperationException {
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> entrance = player.getDashboard().getEntrance();

		//For each color looks how many students of that color and compares
		// with entrance of that color
		for(PawnColor color : PawnColor.values()){
			int numberOfGivenStudents = (int) givenStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsInEntrance =
					numberOfGivenStudents > entrance.get(color);
			if(notEnoughStudentsInEntrance){
				throw new IncorrectOperationException("Not enough students in entrance");
			}
		}

	}
}
