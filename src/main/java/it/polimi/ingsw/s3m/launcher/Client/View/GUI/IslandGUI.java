package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.HashMap;

public class IslandGUI{
	ImageView island;
	HashMap<String, ImageView> studentsImage;
	HashMap<String, Label> studentsLabel;
	ImageView towerImage;
	Label towerLabel;

	public IslandGUI(ImageView island, ImageView REDStudImage, ImageView GREENStudImage, ImageView BLUEStudImage, ImageView PINKStudImage, ImageView YELLOWStudImage, Label REDStud, Label GREENStud, Label BLUEStud, Label PINKStud, Label YELLOWStud, ImageView towerImage, Label towerLabel){
		this.island = island;

		this.studentsImage = new HashMap<>();
		this.studentsImage.put("RED", REDStudImage);
		this.studentsImage.put("GREEN", GREENStudImage);
		this.studentsImage.put("BLUE", BLUEStudImage);
		this.studentsImage.put("PINK", PINKStudImage);
		this.studentsImage.put("YELLOW", YELLOWStudImage);

		this.studentsLabel = new HashMap<>();
		this.studentsLabel.put("RED", REDStud);
		this.studentsLabel.put("GREEN", GREENStud);
		this.studentsLabel.put("BLUE", BLUEStud);
		this.studentsLabel.put("PINK", PINKStud);
		this.studentsLabel.put("YELLOW", YELLOWStud);

		this.towerImage = towerImage;
		this.towerLabel = towerLabel;
	}

	public ImageView getIsland(){
		return island;
	}

	public HashMap<String, ImageView> getStudentsImage(){
		return studentsImage;
	}

	public HashMap<String, Label> getStudentsLabel(){
		return studentsLabel;
	}

	public ImageView getTowerImage(){
		return towerImage;
	}

	public Label getTowerLabel(){
		return towerLabel;
	}
}
