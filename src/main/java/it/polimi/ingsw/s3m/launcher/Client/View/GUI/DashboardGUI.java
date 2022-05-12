package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.List;

public class DashboardGUI{
	List<ImageView> entranceImages;
	HashMap<String, List<ImageView>> tablesImages;
	List<ImageView> towerImages;

	public DashboardGUI(List<ImageView> entranceImages, List<ImageView> redStudentsTable, List<ImageView> greenStudentsTable,
						List<ImageView> blueStudentsTable, List<ImageView> pinkStudentsTable, List<ImageView> yellowStudentsTable,
						List<ImageView> towerImages){
		this.entranceImages = entranceImages;

		this.tablesImages = new HashMap<>();
		this.tablesImages.put("RED", redStudentsTable);
		this.tablesImages.put("GREEN", greenStudentsTable);
		this.tablesImages.put("BLUE", blueStudentsTable);
		this.tablesImages.put("PINK", pinkStudentsTable);
		this.tablesImages.put("YELLOW", yellowStudentsTable);


		this.towerImages = towerImages;
	}
}
