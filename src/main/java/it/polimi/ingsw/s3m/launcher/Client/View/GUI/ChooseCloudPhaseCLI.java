package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ChooseCloudPhaseCLI{
	@FXML
	GridPane gridPaneCloudOne;
	@FXML
	GridPane gridPaneCloudTwo;
	@FXML
	GridPane gridPaneCloudThree;
	@FXML
	ImageView studentOneCloudOne;
	@FXML
	ImageView studentOneCloudTwo;
	@FXML
	ImageView studentOneCloudThree;
	@FXML
	ImageView studentTwoCloudOne;
	@FXML
	ImageView studentTwoCloudTwo;
	@FXML
	ImageView studentTwoCloudThree;
	@FXML
	ImageView studentThreeCloudOne;
	@FXML
	ImageView studentThreeCloudTwo;
	@FXML
	ImageView studentThreeCloudThree;
	@FXML
	ImageView studentFourCloudOne;
	@FXML
	ImageView studentFourCloudTwo;
	@FXML
	ImageView studentFourCloudThree;

	private void choiceCloud(Image image, int cloudChoicePosition){
		//based on the chosen cloud, an if is activated which places the 4 images of the chosen island on the dashboard hall
		if(cloudChoicePosition == 0){
			studentOneCloudOne.setImage(image);
			studentTwoCloudOne.setImage(image);
			studentThreeCloudOne.setImage(image);
			studentFourCloudOne.setImage(image);

		}
		if(cloudChoicePosition == 1){
			studentOneCloudTwo.setImage(image);
			studentTwoCloudTwo.setImage(image);
			studentThreeCloudTwo.setImage(image);
			studentFourCloudTwo.setImage(image);
		}
		if(cloudChoicePosition == 2){
			studentOneCloudThree.setImage(image);
			studentTwoCloudThree.setImage(image);
			studentThreeCloudThree.setImage(image);
			studentFourCloudThree.setImage(image);
		}

	}


}
