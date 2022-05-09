package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Dashboard{
	private final HashMap<PawnColor, Integer> entrance;
	private final HashMap<PawnColor, Integer> tables;
	private int numberOfTowers;

	public Dashboard(){
		this.entrance = new HashMap<>();
		this.tables = new HashMap<>();
		for(PawnColor color : PawnColor.values()){
			entrance.put(color, 0);
			tables.put(color, 0);
		}
	}

	// Entrance

	/**
	 * Method used to add students in the entrance of the dashboard
	 *
	 * @param enteringStudents students that are going to be added to the entrance
	 */
	public void addStudentsInEntrance(ArrayList<Student> enteringStudents){
		for(Student student : enteringStudents){
			PawnColor color = student.getColor();
			entrance.replace(color, entrance.get(color) + 1);
		}
	}

	/**
	 * Method used to delete a single student from the entrance, because moved
	 * on tables or an island
	 *
	 * @param deletingStudent student to be deleted
	 */
	public void deleteSingleStudentFromEntrance(Student deletingStudent){
		PawnColor color = deletingStudent.getColor();
		entrance.replace(color, entrance.get(color) - 1);
	}

	/**
	 * Method used to delete a bunch of students from the entrance, because moved
	 * on tables or an island
	 *
	 * @param deletingStudents students to be deleted
	 */
	public void deleteStudentsFromEntrance(ArrayList<Student> deletingStudents){
		for(Student student : deletingStudents){
			PawnColor color = student.getColor();
			entrance.replace(color, entrance.get(color) - 1);
		}
	}

	// Tables

	/**
	 * Method used to delete a bunch of students from the tables
	 *
	 * @param deletingStudents students to be deleted
	 */
	public void deleteStudentsFromTables(ArrayList<Student> deletingStudents){
		for(Student student : deletingStudents){
			PawnColor color = student.getColor();
			tables.replace(color, tables.get(color) - 1);
		}
	}

	/**
	 * Method used to move a single student from the entrance to the tables
	 *
	 * @param movingStudent student to be moved
	 * @return the number of coins earned
	 */
	public int moveSingleStudentFromEntranceToTables(Student movingStudent){
		int earnCoins = 0;
		PawnColor color = movingStudent.getColor();
		entrance.replace(color, entrance.get(color) - 1);
		tables.replace(color, tables.get(color) + 1);
		if(tables.get(color) % 3 == 0) earnCoins++;
		return earnCoins;
	}

	/**
	 * Method used to move a bunch of students from the entrance to the tables
	 *
	 * @param movingStudents students to be moved
	 * @return the number of coins earned
	 */
	public int moveStudentsFromEntranceToTables(ArrayList<Student> movingStudents){
		int earnCoins = 0;
		for(Student student : movingStudents){
			PawnColor color = student.getColor();
			entrance.replace(color, entrance.get(color) - 1);
			tables.replace(color, tables.get(color) + 1);
			if(tables.get(color) % 3 == 0) earnCoins++;
		}
		return earnCoins;
	}

	// Towers
	public void incrementTowers(){
		numberOfTowers++;
	}

	public void decrementTowers(){
		numberOfTowers--;
	}

	// GETTER
	public HashMap<PawnColor, Integer> getEntrance(){
		return entrance;
	}

	public HashMap<PawnColor, Integer> getTables(){
		return tables;
	}

	public int getNumberOfTowers(){
		return numberOfTowers;
	}

	// SETTER
	public void setNumberOfTowers(int numberOfTowers){
		this.numberOfTowers = numberOfTowers;
	}
}

