package it.polimi.ingsw.s3m.launcher.Server.Model.Initializers;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Student;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.TowerColor;

import java.util.ArrayList;

public class TwoPlayersGameInitializer extends GameInitializer{

	/**
	 * Constructor used to call the methods needed to initialize
	 * a two players game
	 *
	 * @param game             game to be initialized
	 * @param playersNicknames list of the players' nicknames given from the game
	 */
	public TwoPlayersGameInitializer(Game game, ArrayList<String> playersNicknames){
		super(game);
		playersSetup(playersNicknames);
		dashboardsSetup();
		studentsInEntranceSetup();
		islandsSetup();
	}

	/**
	 * Method used to create the hash map of the players in the Game, given the
	 * players' nicknames, and assignment of the tower colors
	 *
	 * @param nicknames list of the players' nicknames
	 */
	@Override
	public void playersSetup(ArrayList<String> nicknames){
		String firstPlayerNickname = nicknames.get(0);
		String secondPlayerNickname = nicknames.get(1);
		game.getPlayerHashMap().put(firstPlayerNickname, new Player(firstPlayerNickname, TowerColor.WHITE));
		game.getPlayerHashMap().put(secondPlayerNickname, new Player(secondPlayerNickname, TowerColor.BLACK));
	}

	/**
	 * Method used to initialize the number of towers in dashboard to 8
	 */
	@Override
	public void dashboardsSetup(){
		for(Player player : game.getPlayerHashMap().values()){
			player.getDashboard().setNumberOfTowers(8);
		}
	}

	/**
	 * Method used to give the first 7 students to the entrance of each player
	 */
	@Override
	public void studentsInEntranceSetup(){
		for(Player player : game.getPlayerHashMap().values()){
			ArrayList<Student> enteringHallStudents = new ArrayList<>();
			for(int j = 0; j < 7; j++){
				try{
					Student student = game.extractStudent();
					enteringHallStudents.add(student);
				}catch(EmptyBagException e){
					e.printStackTrace();
				}
			}
			player.getDashboard().addStudentsInEntrance(enteringHallStudents);
		}
	}
}
