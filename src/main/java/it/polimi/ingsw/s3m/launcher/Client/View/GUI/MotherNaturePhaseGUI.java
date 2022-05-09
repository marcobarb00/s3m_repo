package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MotherNaturePhaseGUI{
	@FXML
	ImageView motherNatureIsland0;
	@FXML
	ImageView motherNatureIsland1;
	@FXML
	ImageView motherNatureIsland2;
	@FXML
	ImageView motherNatureIsland3;
	@FXML
	ImageView motherNatureIsland4;
	@FXML
	ImageView motherNatureIsland5;
	@FXML
	ImageView motherNatureIsland6;
	@FXML
	ImageView motherNatureIsland7;
	@FXML
	ImageView motherNatureIsland8;
	@FXML
	ImageView motherNatureIsland9;
	@FXML
	ImageView motherNatureIsland10;
	@FXML
	ImageView motherNatureIsland11;


	private void motherNatureControl(Image image, int motherNaturePosition){
		for(int i = 0; i < 11; i++){
			if(motherNaturePosition == 0){
				motherNatureIsland0.setImage(image);
				break;
			}
			if(motherNaturePosition == 1){
				motherNatureIsland1.setImage(image);
				break;
			}
			if(motherNaturePosition == 2){
				motherNatureIsland2.setImage(image);
				break;
			}
			if(motherNaturePosition == 3){
				motherNatureIsland3.setImage(image);
				break;
			}
			if(motherNaturePosition == 4){
				motherNatureIsland4.setImage(image);
				break;
			}
			if(motherNaturePosition == 5){
				motherNatureIsland5.setImage(image);
				break;
			}
			if(motherNaturePosition == 6){
				motherNatureIsland6.setImage(image);
				break;
			}
			if(motherNaturePosition == 7){
				motherNatureIsland7.setImage(image);
				break;
			}
			if(motherNaturePosition == 8){
				motherNatureIsland8.setImage(image);
				break;
			}
			if(motherNaturePosition == 9){
				motherNatureIsland9.setImage(image);
				break;
			}
			if(motherNaturePosition == 10){
				motherNatureIsland10.setImage(image);
				break;
			}
			if(motherNaturePosition == 11){
				motherNatureIsland11.setImage(image);
				break;
			}

		}
	}
}