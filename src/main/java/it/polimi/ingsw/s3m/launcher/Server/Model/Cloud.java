package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public class Cloud{
	private ArrayList<Student> students = new ArrayList<>();

	/**
	 * Method used to take the students from the cloud that are going to
	 * be added to a player's dashboard's entrance
	 *
	 * @return the students on the cloud
	 */
	public ArrayList<Student> returnStudents(){
		ArrayList<Student> returningStudents = new ArrayList<>(students);
		students.clear();
		return returningStudents;
	}

	// GETTER
	public ArrayList<Student> getStudents(){
		return students;
	}

	// SETTER
	public void setStudents(ArrayList<Student> students){
		this.students = students;
	}
}
