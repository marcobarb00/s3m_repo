package it.polimi.ingsw.s3m.launcher.Server.Operation;

import it.polimi.ingsw.s3m.launcher.Server.Controller.PlayerController;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotEnoughCoinsException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.NotExpertModeException;
import it.polimi.ingsw.s3m.launcher.Server.Exception.PlayerNotInListException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.Student;

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
	public void executeOperation() throws PlayerNotInListException, IllegalArgumentException, NotExpertModeException, NotEnoughCoinsException{
		//Check for double nicknames
		boolean playerControllerInList = checkNickname();
		if(!playerControllerInList){
			throw new PlayerNotInListException();
		}

		boolean checkExpertMode = game.isExpertMode();
		if(!checkExpertMode){
			throw new NotExpertModeException();
		}

		//checks if CharacterCard already active
		boolean activatedCharacterCard = game.isCharacterCardActivated();
		if(activatedCharacterCard){
			throw new IllegalArgumentException("Cannot play a second character card");
		}

		//checking if player has enough coins
		boolean checkCost = checkCharacterCardCost("Minstrel");
		if(!checkCost){
			throw new NotEnoughCoinsException();
		}

		boolean checkStudentsNumber = enteringEntranceStudents.size() == 2 && enteringTablesStudents.size() == 2;
		if(!checkStudentsNumber){
			throw new IllegalArgumentException("Incorrect students value");
		}

		searchStudentsInEntrance();
		searchStudentsInTables();

		//FIXME
		// Temporary Arrays, change to ArrayList<PawnColor>
		ArrayList<Student> enteringEntranceStudentsAL = new ArrayList<>();
		ArrayList<Student> enteringTablesStudentsAL = new ArrayList<>();

		enteringEntranceStudents.forEach(color -> enteringEntranceStudentsAL.add(new Student(color)));
		enteringTablesStudents.forEach(color -> enteringTablesStudentsAL.add(new Student(color)));

		game.activateMinstrelEffect(playerController.getNickname(), enteringEntranceStudentsAL,
				enteringTablesStudentsAL);
	}

	private void searchStudentsInEntrance(){
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> entrance = player.getDashboard().getEntrance();

		//For each color looks how many students of that color and compares
		// with entrance of that color
		for(PawnColor color : PawnColor.values()){
			int numberOfEnteringTablesStudents = (int) enteringTablesStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsInEntrance =
					numberOfEnteringTablesStudents > entrance.get(color);
			if(notEnoughStudentsInEntrance){
				throw new IllegalArgumentException("Not enough students in entrance");
			}
		}
	}

	private void searchStudentsInTables(){
		Player player = game.getPlayerHashMap().get(playerController.getNickname());
		HashMap<PawnColor, Integer> tables = player.getDashboard().getTables();

		//For each color looks how many students of that color and compares
		// with tables of that color
		for(PawnColor color : PawnColor.values()){
			int numberOfEnteringEntranceStudents = (int) enteringEntranceStudents.stream().filter(
					studentColor -> studentColor.equals(color)).count();
			boolean notEnoughStudentsInTables =
					numberOfEnteringEntranceStudents > tables.get(color);
			if(notEnoughStudentsInTables){
				throw new IllegalArgumentException("Not enough students in tables");
			}
		}
	}

}
