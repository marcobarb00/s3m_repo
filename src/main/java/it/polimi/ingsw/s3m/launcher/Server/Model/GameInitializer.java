package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GameInitializer{
	Game game;

	/**
	 * Constructor used to get the game
	 *
	 * @param game game to be initialized
	 */
	public GameInitializer(Game game){
		this.game = game;
	}

	// Abstract methods
	public abstract void playersSetup(ArrayList<String> nicknames);

	public abstract void dashboardsSetup();

	public abstract void studentsInEntranceSetup();

	// Common method islandsSetup

	/**
	 * Method used to initialize the islands: put one random student on
	 * each island, expect for the first and the mirrored one
	 */
	public void islandsSetup(){
		ArrayList<Student> firstStudentsOnIslands = new ArrayList<>();
		for(PawnColor color : PawnColor.values()){
			firstStudentsOnIslands.add(new Student(color));
			firstStudentsOnIslands.add(new Student(color));
		}
		for(int i = 0; i < game.getIslandsList().size(); i++){
			if(i != 0 && i != 6){
				Student student = extractStudent(firstStudentsOnIslands);
				game.getIslandsList().get(i).addStudent(student);
			}
		}
	}

	private Student extractStudent(ArrayList<Student> students){
		Student returnedStudent;
		int extractedNumber = ThreadLocalRandom.current().nextInt(0, students.size()-1);
		returnedStudent = students.get(extractedNumber);
		students.remove(extractedNumber);
		return returnedStudent;
	}
}
