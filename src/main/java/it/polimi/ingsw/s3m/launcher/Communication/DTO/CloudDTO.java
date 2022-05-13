package it.polimi.ingsw.s3m.launcher.Communication.DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class CloudDTO implements Serializable{
	private final ArrayList<String> students;

	public CloudDTO(ArrayList<String> students){
		this.students = students;
	}

	public ArrayList<String> getStudents(){
		return students;
	}
}
