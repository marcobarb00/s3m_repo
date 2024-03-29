package it.polimi.ingsw.s3m.launcher.Server.Model.GameElements;

import java.util.ArrayList;
import java.util.HashMap;

public class Island{
	private Player dominator = null;
	private final HashMap<PawnColor, Integer> students;
	private int numberOfTowers;

	public Island(){
		students = new HashMap<>();
		for(PawnColor color : PawnColor.values())
			students.put(color, 0);
		this.numberOfTowers = 0;
	}

	// Adding students

	/**
	 * Method used to add a single student on the island
	 *
	 * @param studentColor color of the student to be added
	 */
	public void addStudent(PawnColor studentColor){
		students.replace(studentColor, students.get(studentColor) + 1);
	}

	public void addStudentsOnIsland(ArrayList<Student> islandStudents){
		for(Student student : islandStudents){
			PawnColor color = student.getColor();
			students.replace(color, students.get(color) + 1);
		}
	}

	// Towers
	public void addTower(){
		numberOfTowers++;
	}

	public void sumTower(int addend){
		numberOfTowers += addend;
	}

	// GETTER
	public Player getDominator(){
		return dominator;
	}

	public HashMap<PawnColor, Integer> getStudents(){
		return students;
	}

	public int getStudentsPerColor(PawnColor pawnColor){
		return students.get(pawnColor);
	}

	public int getTotalNumberOfStudents(){
		int sum = 0;
		for(PawnColor color : PawnColor.values())
			sum += students.get(color);
		return sum;
	}

	public int getNumberOfTowers(){
		return numberOfTowers;
	}

	// SETTER
	public void setDominator(Player dominator){
		this.dominator = dominator;
	}
}
