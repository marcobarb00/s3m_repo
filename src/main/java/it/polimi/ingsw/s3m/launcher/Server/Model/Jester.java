package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Jester extends CharacterCard{
	private HashMap<PawnColor, Integer> studentsOnCard;

	public Jester(){
		setName("Jester");
		setCost(1);
		studentsOnCard = new HashMap<>();
		for(PawnColor color : PawnColor.values())
			studentsOnCard.put(color, 0);
	}

	/**
	 * Method used to activate the effect of the Jester: the player asks for a maximum of three students
	 * to be changed with three given students
	 *
	 * @param requiredStudents students on the card asked from the player
	 * @param givenStudents    students given from the player
	 * @return students required from the player
	 */
	public ArrayList<Student> exchangeStudents(ArrayList<Student> requiredStudents, ArrayList<Student> givenStudents){
		ArrayList<Student> students = new ArrayList<>(requiredStudents);
		for(Student student : requiredStudents){
			PawnColor color = student.getColor();
			studentsOnCard.replace(color, studentsOnCard.get(color) - 1);
		}
		for(Student student : givenStudents){
			PawnColor color = student.getColor();
			studentsOnCard.replace(color, studentsOnCard.get(color) + 1);
		}
		return students;
	}

	// GETTER
	public HashMap<PawnColor, Integer> getStudentsOnCard(){
		return studentsOnCard;
	}

	// SETTER
	public void setStudentsOnCard(HashMap<PawnColor, Integer> studentsOnCard){
		this.studentsOnCard = studentsOnCard;
	}
}
