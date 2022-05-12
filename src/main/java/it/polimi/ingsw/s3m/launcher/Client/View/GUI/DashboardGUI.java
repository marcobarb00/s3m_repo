package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.List;

public class DashboardGUI{
	private List<ImageView> entranceImages;
	private HashMap<String, List<ImageView>> tablesImages;
	private HashMap<String, ImageView> professorsImages;
	private List<ImageView> towerImages;

	public DashboardGUI(List<ImageView> entranceImages, List<ImageView> redStudentsTable, List<ImageView> greenStudentsTable,
						List<ImageView> blueStudentsTable, List<ImageView> pinkStudentsTable, List<ImageView> yellowStudentsTable,
						HashMap<String, ImageView> professorsImages, List<ImageView> towerImages){
		this.entranceImages = entranceImages;
		this.professorsImages = professorsImages;

		this.tablesImages = new HashMap<>();
		this.tablesImages.put("RED", redStudentsTable);
		this.tablesImages.put("GREEN", greenStudentsTable);
		this.tablesImages.put("BLUE", blueStudentsTable);
		this.tablesImages.put("PINK", pinkStudentsTable);
		this.tablesImages.put("YELLOW", yellowStudentsTable);

		this.towerImages = towerImages;
	}

	public List<ImageView> getEntranceImages(){
		return entranceImages;
	}

	public HashMap<String, List<ImageView>> getTablesImages(){
		return tablesImages;
	}

	public HashMap<String, ImageView> getProfessorsImages(){
		return professorsImages;
	}

	public List<ImageView> getTowerImages(){
		return towerImages;
	}
}
