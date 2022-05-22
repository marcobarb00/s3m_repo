package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;

import java.util.ArrayList;
import java.util.HashMap;

// DONE
public class ActivateJesterEffectOperation extends Operation{
	private final ArrayList<PawnColor> requiredStudents;
	private final ArrayList<PawnColor> givenStudents;

	/**
	 * @param game             the game state in which the player is in
	 * @param playerController the player who's executing the operation
	 * @param requiredStudents the students on the card that the player wants to put on the entrance
	 * @param givenStudents    the students on the entrance that the player wants to put on the card
	 */
	public ActivateJesterEffectOperation(Game game, PlayerController playerController,
										 ArrayList<PawnColor> requiredStudents,
										 ArrayList<PawnColor> givenStudents){
		super(game, playerController);
		this.requiredStudents = requiredStudents;
		this.givenStudents = givenStudents;
	}

	/**
	 * checks if the arguments of the operation are valid, if so the game activates the jester card effect
	 */
	@Override
	public void executeOperation() throws PlayerNotInListException, NotExpertModeException,
			NotEnoughCoinsException, CharacterCardAlreadyActivatedException, IncorrectOperationException{
		//check null args
		boolean checkArgs = game != null && playerController != null && requiredStudents != null
				&& givenStudents != null && !requiredStudents.contains(null) && !givenStudents.contains(null);
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		//Check for double nicknames
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		//checking expert mode
		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode) throw new NotExpertModeException();

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard) throw new CharacterCardAlreadyActivatedException();

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Jester");
		if(!checkCost) throw new NotEnoughCoinsException();

		boolean checkGiven = givenStudents.size() > 0 && givenStudents.size() <= 3;
		boolean checkStudents = givenStudents.size() == requiredStudents.size() && checkGiven;
		if(!checkStudents) throw new IncorrectOperationException("Incorrect exchange students value");

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
	 *
	 * @throws IncorrectOperationException thrown if there aren't enough students on the jester card
	 */
	private void searchStudentsOnCard() throws IncorrectOperationException{
		HashMap<PawnColor, Integer> studentsOnJester = game.getJesterStudentsOnCard();

		//checking on Jester card
		for(PawnColor color : PawnColor.values()){
			int numberOfRequiredStudents = (int) requiredStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsOnCard =
					numberOfRequiredStudents > studentsOnJester.get(color);
			if(notEnoughStudentsOnCard)
				throw new IncorrectOperationException("Not enough students on jester card");
		}
	}

	/**
	 * check if the students in the entrance are enough
	 *
	 * @throws IncorrectOperationException thrown if there aren't enough students in the entrance
	 */
	private void searchStudentsInEntrance() throws IncorrectOperationException{
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> entrance = player.getDashboard().getEntrance();

		//For each color looks how many students of that color and compares
		// with entrance of that color
		for(PawnColor color : PawnColor.values()){
			int numberOfGivenStudents = (int) givenStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsInEntrance =
					numberOfGivenStudents > entrance.get(color);
			if(notEnoughStudentsInEntrance)
				throw new IncorrectOperationException("Not enough students in entrance");
		}

	}
}
