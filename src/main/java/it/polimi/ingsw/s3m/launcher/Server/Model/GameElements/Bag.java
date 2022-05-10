package it.polimi.ingsw.s3m.launcher.Server.Model.GameElements;

import java.util.HashMap;

public class Bag{
	private final HashMap<PawnColor, Integer> students;

	public Bag(){
		students = new HashMap<>();
		for(PawnColor color : PawnColor.values())
			students.put(color, 24);
	}

	public HashMap<PawnColor, Integer> getStudents(){
		return students;
	}

	/**
	 * The method returns the sum of all the students contained in the bag
	 *
	 * @return sum of all students
	 */
	public int getTotalNumberOfStudents(){
		int sum = 0;
		for(PawnColor color : PawnColor.values())
			sum += students.get(color);
		return sum;
	}

	/**
	 * Method used to decrement the number of students of an extracted color
	 *
	 * @param student extracted student
	 */
	public void decrementStudentsColor(Student student){
		PawnColor currentColor = student.getColor();
		students.replace(currentColor, students.get(currentColor) - 1);
	}
}
