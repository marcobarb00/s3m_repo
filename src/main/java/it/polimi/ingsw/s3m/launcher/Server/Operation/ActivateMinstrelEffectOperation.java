package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import java.util.ArrayList;
import java.util.HashMap;

//DONE
public class ActivateMinstrelEffectOperation extends Operation{
	ArrayList<PawnColor> enteringEntranceStudents;
	ArrayList<PawnColor> enteringTablesStudents;

	public ActivateMinstrelEffectOperation(Game game, PlayerController playerController,
										   ArrayList<PawnColor> enteringEntranceStudents,
										   ArrayList<PawnColor> enteringTablesStudents){
		super(game, playerController);
		this.enteringEntranceStudents = enteringEntranceStudents;
		this.enteringTablesStudents = enteringTablesStudents;
	}

	@Override
	public void executeOperation() throws PlayerNotInListException, NotExpertModeException, NotEnoughCoinsException, CharacterCardAlreadyActivatedException, IncorrectOperationException {
		//check args
		boolean checkArgs = game != null && playerController != null && enteringEntranceStudents != null
				&& enteringTablesStudents != null && !enteringEntranceStudents.contains(null) &&
				!enteringTablesStudents.contains(null);
		if(!checkArgs) throw new IncorrectOperationException("Invalid arguments");

		//Check players
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList) throw new PlayerNotInListException();

		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode) throw new NotExpertModeException();

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard) throw new CharacterCardAlreadyActivatedException();

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Minstrel");
		if(!checkCost) throw new NotEnoughCoinsException();

		boolean checkStudentsNumber = (enteringEntranceStudents.size() == 2 && enteringTablesStudents.size() == 2)
				|| (enteringEntranceStudents.size() == 1 && enteringTablesStudents.size() == 1);
		if(!checkStudentsNumber) throw new IncorrectOperationException("Incorrect students value");

		searchStudentsInEntrance();
		searchStudentsInTables();
		checkTablesAreNotFull();

		game.activateMinstrelEffect(playerController.getNickname(), enteringEntranceStudents,
				enteringTablesStudents);
	}

	private void searchStudentsInEntrance() throws IncorrectOperationException {
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> entrance = player.getDashboard().getEntrance();

		//For each color looks how many students of that color and compares
		// with entrance of that color
		for(PawnColor color : PawnColor.values()){
			int numberOfEnteringTablesStudents = (int) enteringTablesStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsInEntrance =
					numberOfEnteringTablesStudents > entrance.get(color);
			if(notEnoughStudentsInEntrance)
				throw new IncorrectOperationException("Not enough students in entrance");
		}
	}

	private void searchStudentsInTables() throws IncorrectOperationException {
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> tables = player.getDashboard().getTables();

		//For each color looks how many students of that color and compares
		// with tables of that color
		for(PawnColor color : PawnColor.values()){
			int numberOfEnteringEntranceStudents = (int) enteringEntranceStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsInTables =
					numberOfEnteringEntranceStudents > tables.get(color);
			if(notEnoughStudentsInTables)
				throw new IncorrectOperationException("Not enough students on tables");
		}
	}

	private void checkTablesAreNotFull() throws IncorrectOperationException {
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> tables = player.getDashboard().getTables();
		HashMap<PawnColor, Integer> colorInfluence = new HashMap<>();
		for (PawnColor color : PawnColor.values())
			colorInfluence.put(color, 0);

		for (PawnColor color : enteringTablesStudents)
			colorInfluence.replace(color, colorInfluence.get(color) + 1);
		for (PawnColor color : enteringEntranceStudents)
			colorInfluence.replace(color, colorInfluence.get(color) - 1);

		for (PawnColor color : PawnColor.values())
			if (tables.get(color) + colorInfluence.get(color) > 10)
				throw new IncorrectOperationException("Too much students moving on tables");
	}
}
