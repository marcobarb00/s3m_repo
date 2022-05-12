package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.*;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.*;


public class PlanningPhaseGUI{
	@FXML
	GridPane gridPane;
	@FXML
	VBox vBoxAssistantCard;
	@FXML
	ImageView blueScreen;
	@FXML
	ImageView islandZero;
	@FXML
	ImageView islandOne;
	@FXML
	ImageView islandTwo;
	@FXML
	ImageView islandThree;
	@FXML
	ImageView islandFour;
	@FXML
	ImageView islandFive;
	@FXML
	ImageView islandSix;
	@FXML
	ImageView islandSeven;
	@FXML
	ImageView islandEight;
	@FXML
	ImageView islandNine;
	@FXML
	ImageView islandTen;
	@FXML
	ImageView cloudOne;
	@FXML
	ImageView cloudTwo;
	@FXML
	ImageView cloudThree;
	@FXML
	ImageView islandEleven;
	@FXML
	GridPane gridPaneIsland0;
	@FXML
	GridPane gridPaneIsland1;
	@FXML
	GridPane gridPaneIsland2;
	@FXML
	GridPane gridPaneIsland3;
	@FXML
	GridPane gridPaneIsland4;
	@FXML
	GridPane gridPaneIsland5;
	@FXML
	GridPane gridPaneIsland6;
	@FXML
	GridPane gridPaneIsland7;
	@FXML
	GridPane gridPaneIsland8;
	@FXML
	GridPane gridPaneIsland9;
	@FXML
	GridPane gridPaneIsland10;
	@FXML
	GridPane gridPaneIsland11;
	@FXML
	ImageView assistantZero;
	@FXML
	ImageView assistantOne;
	@FXML
	ImageView assistantTwo;
	@FXML
	ImageView assistantThree;
	@FXML
	ImageView assistantFour;
	@FXML
	ImageView assistantFive;
	@FXML
	ImageView assistantSix;
	@FXML
	ImageView assistantSeven;
	@FXML
	ImageView assistantEight;
	@FXML
	ImageView assistantNine;
	@FXML
	Label coinPlayerOne;
	@FXML
	Label coinPlayerTwo;
	@FXML
	Label coinPlayerThree;
	@FXML
	ImageView coinImagePlayer1;
	@FXML
	ImageView coinImagePlayer2;
	@FXML
	ImageView coinImagePlayer3;
	@FXML
	ImageView blueStudentsIsland0;
	@FXML
	ImageView redStudentsIsland0;
	@FXML
	ImageView yellowStudentsIsland0;
	@FXML
	ImageView pinkStudentsIsland0;
	@FXML
	ImageView greenStudentsIsland0;
	@FXML
	ImageView blueStudentsIsland1;
	@FXML
	ImageView redStudentsIsland1;
	@FXML
	ImageView yellowStudentsIsland1;
	@FXML
	ImageView pinkStudentsIsland1;
	@FXML
	ImageView greenStudentsIsland1;
	@FXML
	ImageView blueStudentsIsland2;
	@FXML
	ImageView redStudentsIsland2;
	@FXML
	ImageView yellowStudentsIsland2;
	@FXML
	ImageView pinkStudentsIsland2;
	@FXML
	ImageView greenStudentsIsland2;
	@FXML
	ImageView blueStudentsIsland3;
	@FXML
	ImageView redStudentsIsland3;
	@FXML
	ImageView yellowStudentsIsland3;
	@FXML
	ImageView pinkStudentsIsland3;
	@FXML
	ImageView greenStudentsIsland3;
	@FXML
	ImageView blueStudentsIsland4;
	@FXML
	ImageView redStudentsIsland4;
	@FXML
	ImageView yellowStudentsIsland4;
	@FXML
	ImageView pinkStudentsIsland4;
	@FXML
	ImageView greenStudentsIsland4;
	@FXML
	ImageView blueStudentsIsland5;
	@FXML
	ImageView redStudentsIsland5;
	@FXML
	ImageView yellowStudentsIsland5;
	@FXML
	ImageView pinkStudentsIsland5;
	@FXML
	ImageView greenStudentsIsland5;
	@FXML
	ImageView blueStudentsIsland6;
	@FXML
	ImageView redStudentsIsland6;
	@FXML
	ImageView yellowStudentsIsland6;
	@FXML
	ImageView pinkStudentsIsland6;
	@FXML
	ImageView greenStudentsIsland6;
	@FXML
	ImageView blueStudentsIsland7;
	@FXML
	ImageView redStudentsIsland7;
	@FXML
	ImageView yellowStudentsIsland7;
	@FXML
	ImageView pinkStudentsIsland7;
	@FXML
	ImageView greenStudentsIsland7;
	@FXML
	ImageView blueStudentsIsland8;
	@FXML
	ImageView redStudentsIsland8;
	@FXML
	ImageView yellowStudentsIsland8;
	@FXML
	ImageView pinkStudentsIsland8;
	@FXML
	ImageView greenStudentsIsland8;
	@FXML
	ImageView blueStudentsIsland9;
	@FXML
	ImageView redStudentsIsland9;
	@FXML
	ImageView yellowStudentsIsland9;
	@FXML
	ImageView pinkStudentsIsland9;
	@FXML
	ImageView greenStudentsIsland9;
	@FXML
	ImageView blueStudentsIsland10;
	@FXML
	ImageView redStudentsIsland10;
	@FXML
	ImageView yellowStudentsIsland10;
	@FXML
	ImageView pinkStudentsIsland10;
	@FXML
	ImageView greenStudentsIsland10;
	@FXML
	ImageView blueStudentsIsland11;
	@FXML
	ImageView redStudentsIsland11;
	@FXML
	ImageView yellowStudentsIsland11;
	@FXML
	ImageView pinkStudentsIsland11;
	@FXML
	ImageView greenStudentsIsland11;
	@FXML
	ImageView towersIsland0;
	@FXML
	ImageView towersIsland1;
	@FXML
	ImageView towersIsland2;
	@FXML
	ImageView towersIsland3;
	@FXML
	ImageView towersIsland4;
	@FXML
	ImageView towersIsland5;
	@FXML
	ImageView towersIsland6;
	@FXML
	ImageView towersIsland7;
	@FXML
	ImageView towersIsland8;
	@FXML
	ImageView towersIsland9;
	@FXML
	ImageView towersIsland10;
	@FXML
	ImageView towersIsland11;
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
	@FXML
	Label coinPlayer3;
	@FXML
	Label numTowersIsland0;
	@FXML
	Label numTowersIsland1;
	@FXML
	Label numTowersIsland2;
	@FXML
	Label numTowersIsland3;
	@FXML
	Label numTowersIsland4;
	@FXML
	Label numTowersIsland5;
	@FXML
	Label numTowersIsland6;
	@FXML
	Label numTowersIsland7;
	@FXML
	Label numTowersIsland8;
	@FXML
	Label numTowersIsland9;
	@FXML
	Label numTowersIsland10;
	@FXML
	Label numTowersIsland11;
	@FXML
	ImageView dashboardPlayerOne;
	@FXML
	ImageView dashboardPlayerTwo;
	@FXML
	ImageView dashboardPlayerThree;
	@FXML
	ImageView hallStudentOnePone;
	@FXML
	ImageView hallStudentTwoPone;
	@FXML
	ImageView hallStudentThreePone;
	@FXML
	ImageView hallStudentFourPone;
	@FXML
	ImageView hallStudentFivePone;
	@FXML
	ImageView hallStudentSixPone;
	@FXML
	ImageView hallStudentSevenPone;
	@FXML
	ImageView hallStudentEightPone;
	@FXML
	ImageView hallStudentNinePone;
	@FXML
	ImageView hallStudentOnePTwo;
	@FXML
	ImageView hallStudentTwoPTwo;
	@FXML
	ImageView hallStudentThreePTwo;
	@FXML
	ImageView hallStudentFourPTwo;
	@FXML
	ImageView hallStudentFivePTwo;
	@FXML
	ImageView hallStudentSixPTwo;
	@FXML
	ImageView hallStudentSevenPTwo;
	@FXML
	ImageView hallStudentEightPTwo;
	@FXML
	ImageView hallStudentNinePTwo;
	@FXML
	ImageView hallStudentOnePThree;
	@FXML
	ImageView hallStudentTwoPThree;
	@FXML
	ImageView hallStudentThreePThree;
	@FXML
	ImageView hallStudentFourPThree;
	@FXML
	ImageView hallStudentFivePThree;
	@FXML
	ImageView hallStudentSixPThree;
	@FXML
	ImageView hallStudentSevenPThree;
	@FXML
	ImageView hallStudentEightPThree;
	@FXML
	ImageView hallStudentNinePThree;
	@FXML
	ImageView studGreenOnePone;
	@FXML
	ImageView studGreenTwoPone;
	@FXML
	ImageView studGreenThreePone;
	@FXML
	ImageView studGreenFourPone;
	@FXML
	ImageView studGreenFivePone;
	@FXML
	ImageView studGreenSixPone;
	@FXML
	ImageView studGreenSevenPone;
	@FXML
	ImageView studGreenEightPone;
	@FXML
	ImageView studGreenNinePone;
	@FXML
	ImageView studGreenTenPone;
	@FXML
	ImageView studGreenOnePTwo;
	@FXML
	ImageView studGreenTwoPTwo;

	@FXML
	ImageView studGreenThreePTwo;
	@FXML
	ImageView studGreenFourPTwo;
	@FXML
	ImageView studGreenFivePTwo;
	@FXML
	ImageView studGreenSixPTwo;
	@FXML
	ImageView studGreenSevenPTwo;
	@FXML
	ImageView studGreenEightPTwo;
	@FXML
	ImageView studGreenNinePTwo;
	@FXML
	ImageView studGreenTenPTwo;
	@FXML
	ImageView studGreenOnePThree;
	@FXML
	ImageView studGreenTwoPThree;
	@FXML
	ImageView studGreenThreePThree;
	@FXML
	ImageView studGreenFourPThree;
	@FXML
	ImageView studGreenFivePThree;
	@FXML
	ImageView studGreenSixPThree;
	@FXML
	ImageView studGreenSevenPThree;
	@FXML
	ImageView studGreenEightPThree;
	@FXML
	ImageView studGreenNinePThree;
	@FXML
	ImageView studGreenTenPThree;
	@FXML
	ImageView studRedOnePone;
	@FXML
	ImageView studRedTwoPone;
	@FXML
	ImageView studRedThreePone;
	@FXML
	ImageView studRedFourPone;
	@FXML
	ImageView studRedFivePone;
	@FXML
	ImageView studRedSixPone;
	@FXML
	ImageView studRedSevenPone;
	@FXML
	ImageView studRedEightPone;
	@FXML
	ImageView studRedNinePone;
	@FXML
	ImageView studRedTenPone;
	@FXML
	ImageView studRedOnePTwo;
	@FXML
	ImageView studRedTwoPTwo;
	@FXML
	ImageView studRedThreePTwo;
	@FXML
	ImageView studRedFourPTwo;
	@FXML
	ImageView studRedFivePTwo;
	@FXML
	ImageView studRedSixPTwo;
	@FXML
	ImageView studRedSevenPTwo;
	@FXML
	ImageView studRedEightPTwo;
	@FXML
	ImageView studRedNinePTwo;
	@FXML
	ImageView studRedTenPTwo;
	@FXML
	ImageView studRedOnePThree;
	@FXML
	ImageView studRedTwoPThree;
	@FXML
	ImageView studRedThreePThree;
	@FXML
	ImageView studRedFourPThree;
	@FXML
	ImageView studRedFivePThree;
	@FXML
	ImageView studRedSixPThree;
	@FXML
	ImageView studRedSevenPThree;
	@FXML
	ImageView studRedEightPThree;
	@FXML
	ImageView studRedNinePThree;
	@FXML
	ImageView studRedTenPThree;
	@FXML
	ImageView studYellowOnePone;
	@FXML
	ImageView studYellowTwoPone;
	@FXML
	ImageView studYellowThreePone;
	@FXML
	ImageView studYellowFourPone;
	@FXML
	ImageView studYellowFivePone;
	@FXML
	ImageView studYellowSixPone;
	@FXML
	ImageView studYellowSevenPone;
	@FXML
	ImageView studYellowEightPone;
	@FXML
	ImageView studYellowNinePone;
	@FXML
	ImageView studYellowTenPone;
	@FXML
	ImageView studYellowOnePTwo;
	@FXML
	ImageView studYellowTwoPTwo;
	@FXML
	ImageView studYellowThreePTwo;
	@FXML
	ImageView studYellowFourPTwo;
	@FXML
	ImageView studYellowFivePTwo;
	@FXML
	ImageView studYellowSixPTwo;
	@FXML
	ImageView studYellowSevenPTwo;
	@FXML
	ImageView studYellowEightPTwo;
	@FXML
	ImageView studYellowNinePTwo;
	@FXML
	ImageView studYellowTenPTwo;
	@FXML
	ImageView studYellowOnePThree;
	@FXML
	ImageView studYellowTwoPThree;
	@FXML
	ImageView studYellowThreePThree;
	@FXML
	ImageView studYellowFourPThree;
	@FXML
	ImageView studYellowFivePThree;
	@FXML
	ImageView studYellowSixPThree;
	@FXML
	ImageView studYellowSevenPThree;
	@FXML
	ImageView studYellowEightPThree;
	@FXML
	ImageView studYellowNinePThree;
	@FXML
	ImageView studYellowTenPThree;
	@FXML
	ImageView studPinkOnePone;
	@FXML
	ImageView studPinkTwoPone;
	@FXML
	ImageView studPinkThreePone;
	@FXML
	ImageView studPinkFourPone;
	@FXML
	ImageView studPinkFivePone;
	@FXML
	ImageView studPinkSixPone;
	@FXML
	ImageView studPinkSevenPone;
	@FXML
	ImageView studPinkEightPone;
	@FXML
	ImageView studPinkNinePone;
	@FXML
	ImageView studPinkTenPone;
	@FXML
	ImageView studPinkOnePTwo;
	@FXML
	ImageView studPinkTwoPTwo;

	@FXML
	ImageView studPinkThreePTwo;
	@FXML
	ImageView studPinkFourPTwo;
	@FXML
	ImageView studPinkFivePTwo;
	@FXML
	ImageView studPinkSixPTwo;
	@FXML
	ImageView studPinkSevenPTwo;
	@FXML
	ImageView studPinkEightPTwo;
	@FXML
	ImageView studPinkNinePTwo;
	@FXML
	ImageView studPinkTenPTwo;
	@FXML
	ImageView studPinkOnePThree;
	@FXML
	ImageView studPinkTwoPThree;

	@FXML
	ImageView studPinkThreePThree;
	@FXML
	ImageView studPinkFourPThree;
	@FXML
	ImageView studPinkFivePThree;
	@FXML
	ImageView studPinkSixPThree;
	@FXML
	ImageView studPinkSevenPThree;
	@FXML
	ImageView studPinkEightPThree;
	@FXML
	ImageView studPinkNinePThree;
	@FXML
	ImageView studPinkTenPThree;
	@FXML
	ImageView studBlueOnePone;
	@FXML
	ImageView studBlueTwoPone;
	@FXML
	ImageView studBlueThreePone;
	@FXML
	ImageView studBlueFourPone;
	@FXML
	ImageView studBlueFivePone;
	@FXML
	ImageView studBlueSixPone;
	@FXML
	ImageView studBlueSevenPone;
	@FXML
	ImageView studBlueEightPone;
	@FXML
	ImageView studBlueNinePone;
	@FXML
	ImageView studBlueTenPone;
	@FXML
	ImageView studBlueOnePTwo;
	@FXML
	ImageView studBlueTwoPTwo;
	@FXML
	ImageView studBlueThreePTwo;
	@FXML
	ImageView studBlueFourPTwo;
	@FXML
	ImageView studBlueFivePTwo;
	@FXML
	ImageView studBlueSixPTwo;
	@FXML
	ImageView studBlueSevenPTwo;
	@FXML
	ImageView studBlueEightPTwo;
	@FXML
	ImageView studBlueNinePTwo;
	@FXML
	ImageView studBlueTenPTwo;
	@FXML
	ImageView studBlueOnePThree;
	@FXML
	ImageView studBlueTwoPThree;
	@FXML
	ImageView studBlueThreePThree;
	@FXML
	ImageView studBlueFourPThree;
	@FXML
	ImageView studBlueFivePThree;
	@FXML
	ImageView studBlueSixPThree;
	@FXML
	ImageView studBlueSevenPThree;
	@FXML
	ImageView studBlueEightPThree;
	@FXML
	ImageView studBlueNinePThree;
	@FXML
	ImageView studBlueTenPThree;
	@FXML
	ImageView professorGreenPone;
	@FXML
	ImageView professorGreenPTwo;
	@FXML
	ImageView professorGreenPThree;
	@FXML
	ImageView professorRedPone;
	@FXML
	ImageView professorRedPTwo;
	@FXML
	ImageView professorRedPThree;
	@FXML
	ImageView professorYellowPone;
	@FXML
	ImageView professorYellowPTwo;
	@FXML
	ImageView professorYellowPThree;
	@FXML
	ImageView professorPinkPone;
	@FXML
	ImageView professorPinkPTwo;
	@FXML
	ImageView professorPinkPThree;
	@FXML
	ImageView professorBluePone;
	@FXML
	ImageView professorBluePTwo;
	@FXML
	ImageView professorBluePThree;
	@FXML
	ImageView towerOnePone;
	@FXML
	ImageView towerTwoPone;
	@FXML
	ImageView towerThreePone;
	@FXML
	ImageView towerFourPone;
	@FXML
	ImageView towerFivePone;
	@FXML
	ImageView towerSixPone;
	@FXML
	ImageView towerSevenPone;
	@FXML
	ImageView towerEightPone;
	@FXML
	ImageView towerOnePTwo;
	@FXML
	ImageView towerTwoPTwo;
	@FXML
	ImageView towerThreePTwo;
	@FXML
	ImageView towerFourPTwo;
	@FXML
	ImageView towerFivePTwo;
	@FXML
	ImageView towerSixPTwo;
	@FXML
	ImageView towerSevenPTwo;
	@FXML
	ImageView towerEightPTwo;
	@FXML
	ImageView towerOnePThree;
	@FXML
	ImageView towerTwoPThree;
	@FXML
	ImageView towerThreePThree;
	@FXML
	ImageView towerFourPThree;
	@FXML
	ImageView towerFivePThree;
	@FXML
	ImageView towerSixPThree;
	@FXML
	GridPane gridPaneCloudOne;
	@FXML
	GridPane gridPaneCloudTwo;
	@FXML
	GridPane gridPaneCloudThree;
	@FXML
	ImageView studentOneCloudOne;
	@FXML
	ImageView studentTwoCloudOne;
	@FXML
	ImageView studentThreeCloudOne;
	@FXML
	ImageView studentFourCloudOne;
	@FXML
	ImageView studentOneCloudTwo;
	@FXML
	ImageView studentTwoCloudTwo;
	@FXML
	ImageView studentThreeCloudTwo;
	@FXML
	ImageView studentFourCloudTwo;
	@FXML
	ImageView studentOneCloudThree;
	@FXML
	ImageView studentTwoCloudThree;
	@FXML
	ImageView studentThreeCloudThree;
	@FXML
	ImageView studentFourCloudThree;
	@FXML
	Label numBlueStudentsIsland0;
	@FXML
	Label numPinkStudentsIsland0;
	@FXML
	Label numYellowStudentsIsland0;
	@FXML
	Label numGreenStudentsIsland0;
	@FXML
	Label numRedStudentsIsland0;
	@FXML
	Label numBlueStudentsIsland1;
	@FXML
	Label numPinkStudentsIsland1;
	@FXML
	Label numYellowStudentsIsland1;
	@FXML
	Label numGreenStudentsIsland1;
	@FXML
	Label numRedStudentsIsland1;
	@FXML
	Label numBlueStudentsIsland2;
	@FXML
	Label numPinkStudentsIsland2;
	@FXML
	Label numYellowStudentsIsland2;
	@FXML
	Label numGreenStudentsIsland2;
	@FXML
	Label numRedStudentsIsland2;
	@FXML
	Label numBlueStudentsIsland3;
	@FXML
	Label numPinkStudentsIsland3;
	@FXML
	Label numYellowStudentsIsland3;
	@FXML
	Label numGreenStudentsIsland3;
	@FXML
	Label numRedStudentsIsland3;
	@FXML
	Label numBlueStudentsIsland4;
	@FXML
	Label numPinkStudentsIsland4;
	@FXML
	Label numYellowStudentsIsland4;
	@FXML
	Label numGreenStudentsIsland4;
	@FXML
	Label numRedStudentsIsland4;
	@FXML
	Label numBlueStudentsIsland5;
	@FXML
	Label numPinkStudentsIsland5;
	@FXML
	Label numYellowStudentsIsland5;
	@FXML
	Label numGreenStudentsIsland5;
	@FXML
	Label numRedStudentsIsland5;
	@FXML
	Label numBlueStudentsIsland6;
	@FXML
	Label numPinkStudentsIsland6;
	@FXML
	Label numYellowStudentsIsland6;
	@FXML
	Label numGreenStudentsIsland6;
	@FXML
	Label numRedStudentsIsland6;
	@FXML
	Label numBlueStudentsIsland7;
	@FXML
	Label numPinkStudentsIsland7;
	@FXML
	Label numYellowStudentsIsland7;
	@FXML
	Label numGreenStudentsIsland7;
	@FXML
	Label numRedStudentsIsland7;
	@FXML
	Label numBlueStudentsIsland8;
	@FXML
	Label numPinkStudentsIsland8;
	@FXML
	Label numYellowStudentsIsland8;
	@FXML
	Label numGreenStudentsIsland8;
	@FXML
	Label numRedStudentsIsland8;
	@FXML
	Label numBlueStudentsIsland9;
	@FXML
	Label numPinkStudentsIsland9;
	@FXML
	Label numYellowStudentsIsland9;
	@FXML
	Label numGreenStudentsIsland9;
	@FXML
	Label numRedStudentsIsland9;
	@FXML
	Label numBlueStudentsIsland10;
	@FXML
	Label numPinkStudentsIsland10;
	@FXML
	Label numYellowStudentsIsland10;
	@FXML
	Label numGreenStudentsIsland10;
	@FXML
	Label numRedStudentsIsland10;
	@FXML
	Label numBlueStudentsIsland11;
	@FXML
	Label numPinkStudentsIsland11;
	@FXML
	Label numYellowStudentsIsland11;
	@FXML
	Label numGreenStudentsIsland11;
	@FXML
	Label numRedStudentsIsland11;

	public void printMessageInformation(PlanningPhaseMessage planningPhaseMessage){
		List<ImageView> assistantCardsImageView = Arrays.asList(assistantZero, assistantOne, assistantTwo,
				assistantThree, assistantFour, assistantFive, assistantSix, assistantSeven, assistantEight, assistantNine);

		GameDTO gameState = planningPhaseMessage.getGameState();
		setGameState(gameState);

		ArrayList<AssistantCardDTO> playedAssistantCards = gameState.getTurn().getPlayedCards();
		ArrayList<AssistantCardDTO> hand = gameState.getCurrentPlayer().getHand();

		for(int i = 0; i < hand.size(); i++){
			insertAssistantImage(assistantCardsImageView.get(i), hand.get(i));
		}
	}

	//assistant cards

	public void insertAssistantImage(ImageView assistantImageView, AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantImageView.setImage(view);
	}

	public void chooseAssistantCard(MouseEvent event){
		String name = event.getPickResult().getIntersectedNode().getId();
		int chosenNumber = -1;

		if(name.equals("assistantZero")){
			chosenNumber = 0;
			assistantZero.setVisible(false);
		}
		if(name.equals("assistantOne")){
			chosenNumber = 1;
			assistantOne.setVisible(false);
		}
		if(name.equals("assistantTwo")){
			chosenNumber = 2;
			assistantTwo.setVisible(false);
		}
		if(name.equals("assistantThree")){
			chosenNumber = 3;
			assistantThree.setVisible(false);
		}
		if(name.equals("assistantFour")){
			chosenNumber = 4;
			assistantFour.setVisible(false);
		}
		if(name.equals("assistantFive")){
			chosenNumber = 5;
			assistantFive.setVisible(false);
		}
		if(name.equals("assistantSix")){
			chosenNumber = 6;
			assistantSix.setVisible(false);
		}
		if(name.equals("assistantSeven")){
			chosenNumber = 7;
			assistantSeven.setVisible(false);
		}
		if(name.equals("assistantEight")){
			chosenNumber = 8;
			assistantEight.setVisible(false);
		}
		if(name.equals("assistantNine")){
			chosenNumber = 9;
			assistantNine.setVisible(false);
		}

		ControllerGUI.getInstance().sendResponse(new PlayAssistantCardResponse(chosenNumber));
		ControllerGUI.getInstance().startLoading();
	}

	public void setGameState(GameDTO gameState){
		List<IslandGUI> islandInfoList = Arrays.asList(
				new IslandGUI(islandZero, redStudentsIsland0, greenStudentsIsland0, blueStudentsIsland0, pinkStudentsIsland0, yellowStudentsIsland0, numRedStudentsIsland0, numGreenStudentsIsland0, numBlueStudentsIsland0, numPinkStudentsIsland0, numYellowStudentsIsland0, towersIsland0, numTowersIsland0),
				new IslandGUI(islandOne, redStudentsIsland1, greenStudentsIsland1, blueStudentsIsland1, pinkStudentsIsland1, yellowStudentsIsland1, numRedStudentsIsland1, numGreenStudentsIsland1, numBlueStudentsIsland1, numPinkStudentsIsland1, numYellowStudentsIsland1, towersIsland1, numTowersIsland1),
				new IslandGUI(islandTwo, redStudentsIsland2, greenStudentsIsland2, blueStudentsIsland2, pinkStudentsIsland2, yellowStudentsIsland2, numRedStudentsIsland2, numGreenStudentsIsland2, numBlueStudentsIsland2, numPinkStudentsIsland2, numYellowStudentsIsland2, towersIsland2, numTowersIsland2),
				new IslandGUI(islandThree, redStudentsIsland3, greenStudentsIsland3, blueStudentsIsland3, pinkStudentsIsland3, yellowStudentsIsland3, numRedStudentsIsland3, numGreenStudentsIsland3, numBlueStudentsIsland3, numPinkStudentsIsland3, numYellowStudentsIsland3, towersIsland3, numTowersIsland3),
				new IslandGUI(islandFour, redStudentsIsland4, greenStudentsIsland4, blueStudentsIsland4, pinkStudentsIsland4, yellowStudentsIsland4, numRedStudentsIsland4, numGreenStudentsIsland4, numBlueStudentsIsland4, numPinkStudentsIsland4, numYellowStudentsIsland4, towersIsland4, numTowersIsland4),
				new IslandGUI(islandFive, redStudentsIsland5, greenStudentsIsland5, blueStudentsIsland5, pinkStudentsIsland5, yellowStudentsIsland5, numRedStudentsIsland5, numGreenStudentsIsland5, numBlueStudentsIsland5, numPinkStudentsIsland5, numYellowStudentsIsland5, towersIsland5, numTowersIsland5),
				new IslandGUI(islandSix, redStudentsIsland6, greenStudentsIsland6, blueStudentsIsland6, pinkStudentsIsland6, yellowStudentsIsland6, numRedStudentsIsland6, numGreenStudentsIsland6, numBlueStudentsIsland6, numPinkStudentsIsland6, numYellowStudentsIsland6, towersIsland6, numTowersIsland6),
				new IslandGUI(islandSeven, redStudentsIsland7, greenStudentsIsland7, blueStudentsIsland7, pinkStudentsIsland7, yellowStudentsIsland7, numRedStudentsIsland7, numGreenStudentsIsland7, numBlueStudentsIsland7, numPinkStudentsIsland7, numYellowStudentsIsland7, towersIsland7, numTowersIsland7),
				new IslandGUI(islandEight, redStudentsIsland8, greenStudentsIsland8, blueStudentsIsland8, pinkStudentsIsland8, yellowStudentsIsland8, numRedStudentsIsland8, numGreenStudentsIsland8, numBlueStudentsIsland8, numPinkStudentsIsland8, numYellowStudentsIsland8, towersIsland8, numTowersIsland8),
				new IslandGUI(islandNine, redStudentsIsland9, greenStudentsIsland9, blueStudentsIsland9, pinkStudentsIsland9, yellowStudentsIsland9, numRedStudentsIsland9, numGreenStudentsIsland9, numBlueStudentsIsland9, numPinkStudentsIsland9, numYellowStudentsIsland9, towersIsland9, numTowersIsland9),
				new IslandGUI(islandTen, redStudentsIsland10, greenStudentsIsland10, blueStudentsIsland10, pinkStudentsIsland10, yellowStudentsIsland10, numRedStudentsIsland10, numGreenStudentsIsland10, numBlueStudentsIsland10, numPinkStudentsIsland10, numYellowStudentsIsland10, towersIsland10, numTowersIsland10),
				new IslandGUI(islandEleven, redStudentsIsland11, greenStudentsIsland11, blueStudentsIsland11, pinkStudentsIsland11, yellowStudentsIsland11, numRedStudentsIsland11, numGreenStudentsIsland11, numBlueStudentsIsland11, numPinkStudentsIsland11, numYellowStudentsIsland11, towersIsland11, numTowersIsland11)
		);

		List<ImageView> motherIslandImageView = Arrays.asList(motherNatureIsland0, motherNatureIsland1, motherNatureIsland2,
				motherNatureIsland3, motherNatureIsland4, motherNatureIsland5, motherNatureIsland6, motherNatureIsland7,
				motherNatureIsland8, motherNatureIsland9, motherNatureIsland10, motherNatureIsland11);

		//dashboard player two

		List<ImageView> entranceImagesPone = Arrays.asList(hallStudentOnePone,hallStudentTwoPone,hallStudentThreePone,
				hallStudentFourPone,hallStudentFivePone,hallStudentSixPone,hallStudentSevenPone,
				hallStudentEightPone,hallStudentNinePone);

		List<ImageView> redStudentsTablePone = Arrays.asList(studRedOnePone,studRedTwoPone,studRedThreePone,studRedFourPone,
				studRedFivePone,studRedSixPone,studRedSevenPone,studRedEightPone,studRedNinePone,studRedTenPone);
		List<ImageView> greenStudentsTablePone = Arrays.asList(studGreenOnePone,studGreenTwoPone,studGreenThreePone,studGreenFourPone,
				studGreenFivePone,studGreenSixPone,studGreenSevenPone,studGreenEightPone,studGreenNinePone,studGreenTenPone);
		List<ImageView> blueStudentsTablePone = Arrays.asList(studBlueOnePone,studBlueTwoPone,studBlueThreePone,studBlueFourPone,
				studBlueFivePone,studBlueSixPone,studBlueSevenPone,studBlueEightPone,studBlueNinePone,studBlueTenPone);
		List<ImageView> pinkStudentsTablePone = Arrays.asList(studPinkOnePone,studPinkTwoPone,studPinkThreePone,studPinkFourPone,
				studPinkFivePone,studPinkSixPone,studPinkSevenPone,studPinkEightPone,studPinkNinePone,studPinkTenPone);
		List<ImageView> yellowStudentsTablePone = Arrays.asList(studYellowOnePone,studYellowTwoPone,studYellowThreePone,studYellowFourPone,
				studYellowFivePone,studYellowSixPone,studYellowSevenPone,studYellowEightPone,studYellowNinePone,studYellowTenPone);

		HashMap<String, ImageView> professorsPone = new HashMap<>();
		professorsPone.put("RED", professorRedPone);
		professorsPone.put("GREEN", professorGreenPone);
		professorsPone.put("BLUE", professorBluePone);
		professorsPone.put("PINK", professorPinkPone);
		professorsPone.put("YELLOW", professorYellowPone);

		List<ImageView> towerImagesPone = Arrays.asList(towerOnePone,towerTwoPone,towerThreePone,towerFourPone,
				towerFivePone,towerSixPone,towerSevenPone,towerEightPone);


		//dashboard player two

		List<ImageView> entranceImagesPTwo = Arrays.asList(hallStudentOnePTwo,hallStudentTwoPTwo,hallStudentThreePTwo,
				hallStudentFourPTwo,hallStudentFivePTwo,hallStudentSixPTwo,hallStudentSevenPTwo,
				hallStudentEightPTwo,hallStudentNinePTwo);

		List<ImageView> redStudentsTablePTwo = Arrays.asList(studRedOnePTwo,studRedTwoPTwo,studRedThreePTwo,studRedFourPTwo,
				studRedFivePTwo,studRedSixPTwo,studRedSevenPTwo,studRedEightPTwo,studRedNinePTwo,studRedTenPTwo);
		List<ImageView> greenStudentsTablePTwo = Arrays.asList(studGreenOnePTwo,studGreenTwoPTwo,studGreenThreePTwo,studGreenFourPTwo,
				studGreenFivePTwo,studGreenSixPTwo,studGreenSevenPTwo,studGreenEightPTwo,studGreenNinePTwo,studGreenTenPTwo);
		List<ImageView> blueStudentsTablePTwo = Arrays.asList(studBlueOnePTwo,studBlueTwoPTwo,studBlueThreePTwo,studBlueFourPTwo,
				studBlueFivePTwo,studBlueSixPTwo,studBlueSevenPTwo,studBlueEightPTwo,studBlueNinePTwo,studBlueTenPTwo);
		List<ImageView> pinkStudentsTablePTwo = Arrays.asList(studPinkOnePTwo,studPinkTwoPTwo,studPinkThreePTwo,studPinkFourPTwo,
				studPinkFivePTwo,studPinkSixPTwo,studPinkSevenPTwo,studPinkEightPTwo,studPinkNinePTwo,studPinkTenPTwo);
		List<ImageView> yellowStudentsTablePTwo = Arrays.asList(studYellowOnePTwo,studYellowTwoPTwo,studYellowThreePTwo,studYellowFourPTwo,
				studYellowFivePTwo,studYellowSixPTwo,studYellowSevenPTwo,studYellowEightPTwo,studYellowNinePTwo,studYellowTenPTwo);

		HashMap<String, ImageView> professorsPTwo = new HashMap<>();
		professorsPTwo.put("RED", professorRedPTwo);
		professorsPTwo.put("GREEN", professorGreenPTwo);
		professorsPTwo.put("BLUE", professorBluePTwo);
		professorsPTwo.put("PINK", professorPinkPTwo);
		professorsPTwo.put("YELLOW", professorYellowPTwo);

		List<ImageView> towerImagesPTwo = Arrays.asList(towerOnePTwo,towerTwoPTwo,towerThreePTwo,towerFourPTwo,
				towerFivePTwo,towerSixPTwo,towerSevenPTwo,towerEightPTwo);

		//dashboard player three

		List<ImageView> entranceImagesPThree = Arrays.asList(hallStudentOnePThree,hallStudentTwoPThree,hallStudentThreePThree,
				hallStudentFourPThree,hallStudentFivePThree,hallStudentSixPThree,hallStudentSevenPThree,
				hallStudentEightPThree,hallStudentNinePThree);

		List<ImageView> redStudentsTablePThree = Arrays.asList(studRedOnePThree,studRedTwoPThree,studRedThreePThree,studRedFourPThree,
				studRedFivePThree,studRedSixPThree,studRedSevenPThree,studRedEightPThree,studRedNinePThree,studRedTenPThree);
		List<ImageView> greenStudentsTablePThree = Arrays.asList(studGreenOnePThree,studGreenTwoPThree,studGreenThreePThree,studGreenFourPThree,
				studGreenFivePThree,studGreenSixPThree,studGreenSevenPThree,studGreenEightPThree,studGreenNinePThree,studGreenTenPThree);
		List<ImageView> blueStudentsTablePThree = Arrays.asList(studBlueOnePThree,studBlueTwoPThree,studBlueThreePThree,studBlueFourPThree,
				studBlueFivePThree,studBlueSixPThree,studBlueSevenPThree,studBlueEightPThree,studBlueNinePThree,studBlueTenPThree);
		List<ImageView> pinkStudentsTablePThree = Arrays.asList(studPinkOnePThree,studPinkTwoPThree,studPinkThreePThree,studPinkFourPThree,
				studPinkFivePThree,studPinkSixPThree,studPinkSevenPThree,studPinkEightPThree,studPinkNinePThree,studPinkTenPThree);
		List<ImageView> yellowStudentsTablePThree = Arrays.asList(studYellowOnePThree,studYellowTwoPThree,studYellowThreePThree,studYellowFourPThree,
				studYellowFivePThree,studYellowSixPThree,studYellowSevenPThree,studYellowEightPThree,studYellowNinePThree,studYellowTenPThree);

		HashMap<String, ImageView> professorsPThree = new HashMap<>();
		professorsPThree.put("RED", professorRedPThree);
		professorsPThree.put("GREEN", professorGreenPThree);
		professorsPThree.put("BLUE", professorBluePThree);
		professorsPThree.put("PINK", professorPinkPThree);
		professorsPThree.put("YELLOW", professorYellowPThree);

		List<ImageView> towerImagesPThree = Arrays.asList(towerOnePThree,towerTwoPThree,towerThreePThree,towerFourPThree,
				towerFivePThree,towerSixPThree);

		List<ImageView> cloudOne = Arrays.asList(studentOneCloudOne, studentTwoCloudOne, studentThreeCloudOne, studentFourCloudOne);
		List<ImageView> cloudTwo = Arrays.asList(studentOneCloudTwo, studentTwoCloudTwo, studentThreeCloudTwo, studentFourCloudTwo);
		List<ImageView> cloudThree = Arrays.asList(studentOneCloudThree, studentTwoCloudThree, studentThreeCloudThree, studentFourCloudThree);

		List<List<ImageView>> cloudList = Arrays.asList(cloudOne, cloudTwo, cloudThree);

		//TODO character cards???


		//print islands
		ArrayList<IslandDTO> islandList = gameState.getIslands();

		int index = 0;
		for(; index < islandList.size(); index++){
			printIsland(islandInfoList.get(index), islandList.get(index));
		}
		for(; index < 12; index++){
			setIslandNotVisible(islandInfoList.get(index));
		}

		//mother nature

		Image motherNatureImage = new Image("MotherNature.png");
		motherIslandImageView.get(gameState.getMotherNaturePosition()).setImage(motherNatureImage);

		//dashboards

		ArrayList<String> nicknameList = gameState.getPlayerNicknames();
		HashMap<String, DashboardDTO> dashboardList = gameState.getDashboards();
		HashMap<String, DashboardGUI> dashboardGUIList = new HashMap<>();


		dashboardGUIList.put(nicknameList.get(0), new DashboardGUI(entranceImagesPone, redStudentsTablePone, greenStudentsTablePone, blueStudentsTablePone, pinkStudentsTablePone, yellowStudentsTablePone, professorsPone, towerImagesPone));
		dashboardGUIList.put(nicknameList.get(1), new DashboardGUI(entranceImagesPTwo, redStudentsTablePTwo, greenStudentsTablePTwo, blueStudentsTablePTwo, pinkStudentsTablePTwo, yellowStudentsTablePTwo, professorsPTwo, towerImagesPTwo));
		if(gameState.getPlayersNumber() == 3)
			dashboardGUIList.put(nicknameList.get(2), new DashboardGUI(entranceImagesPThree, redStudentsTablePThree, greenStudentsTablePThree, blueStudentsTablePThree, pinkStudentsTablePThree, yellowStudentsTablePThree, professorsPThree, towerImagesPThree));
		else
			dashboardGUIList.put(null, new DashboardGUI(entranceImagesPThree, redStudentsTablePThree, greenStudentsTablePThree, blueStudentsTablePThree, pinkStudentsTablePThree, yellowStudentsTablePThree, professorsPThree, towerImagesPThree));

		HashMap<String, String> towerColors = gameState.getTowerColor();

		String firstPlayerNick = nicknameList.get(0);
		String secondPlayerNick = nicknameList.get(1);

		printDashboard(dashboardList.get(firstPlayerNick), dashboardGUIList.get(firstPlayerNick), firstPlayerNick,
				gameState.getPlayersNumber(), gameState.getProfessors(), towerColors.get(firstPlayerNick));

		printDashboard(dashboardList.get(secondPlayerNick), dashboardGUIList.get(secondPlayerNick), secondPlayerNick,
				gameState.getPlayersNumber(), gameState.getProfessors(), towerColors.get(secondPlayerNick));

		if(gameState.getPlayersNumber() == 3){
			String thirdPlayerNick = nicknameList.get(2);
			printDashboard(dashboardList.get(thirdPlayerNick), dashboardGUIList.get(thirdPlayerNick), thirdPlayerNick,
					gameState.getPlayersNumber(), gameState.getProfessors(), towerColors.get(thirdPlayerNick));
		}
		else
			hidePlayerThree(dashboardGUIList.get(null));


		HashMap<String, Integer> coins = gameState.getCoins();
		printCoinsPOne(coins.get(nicknameList.get(0)));
		printCoinsPTwo(coins.get(nicknameList.get(1)));
		if(gameState.getPlayersNumber() == 3)
			printCoinsPThree(coins.get(nicknameList.get(2)));

		//clouds
		ArrayList<CloudDTO> clouds = gameState.getClouds();

		for(int i = 0; i < clouds.size(); i++){
			CloudDTO currentCloud = clouds.get(i);
			List<ImageView> currentCloudGUI = cloudList.get(i);

			for(int j = 0; j < currentCloud.getStudents().size(); j++){
				printCloud(currentCloudGUI.get(j), currentCloud.getStudents().get(j));
			}
		}
	}

	//islands

	public void printIsland(IslandGUI islandGUI, IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		islandGUI.getStudentsLabel().get("RED").setText(studentsOnIsland.get("RED").toString());
		islandGUI.getStudentsLabel().get("GREEN").setText(studentsOnIsland.get("GREEN").toString());
		islandGUI.getStudentsLabel().get("BLUE").setText(studentsOnIsland.get("BLUE").toString());
		islandGUI.getStudentsLabel().get("PINK").setText(studentsOnIsland.get("PINK").toString());
		islandGUI.getStudentsLabel().get("YELLOW").setText(studentsOnIsland.get("YELLOW").toString());

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image towerImage = new Image(islandDTO.getDominatorColor() + "Tower.png");
			islandGUI.getTowerImage().setImage(towerImage);
		}

		islandGUI.getTowerLabel().setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setIslandNotVisible(IslandGUI islandGUI){
		islandGUI.getIsland().setVisible(false);

		islandGUI.getStudentsImage().forEach((color, image) -> image.setVisible(false));
		islandGUI.getStudentsLabel().forEach((color, label) -> label.setVisible(false));

		islandGUI.getTowerImage().setVisible(false);
		islandGUI.getTowerLabel().setVisible(false);
	}

	//dashboards

	public void printDashboard(DashboardDTO dashboardDTO, DashboardGUI dashboardGUI, String playerNickname, int playersNumber, HashMap<String, String> professors, String towerColor){
		//entrance
		List<ImageView> entranceStudentImages = dashboardGUI.getEntranceImages();
		ArrayList<String> entranceStudentColors = new ArrayList<>();
		dashboardDTO.getEntrance().forEach((color, value) -> {
			for(int i = 0; i < value; i++){
				entranceStudentColors.add(color);
			}
		});

		for(int i = 0; i < entranceStudentColors.size(); i++){
			printEntranceStudent(entranceStudentImages.get(i), entranceStudentColors.get(i));
		}

		//tables
		HashMap<String, List<ImageView>> tablesStudentImages = dashboardGUI.getTablesImages();
		HashMap<String, Integer> tablesStudents = dashboardDTO.getTables();

		tablesStudents.forEach((color, value) -> {
			List<ImageView> currentColorTable = tablesStudentImages.get(color);
			for(int i = 0; i < value; i++){
				printTableStudent(currentColorTable.get(i), color);
			}
		});

		//professors
		HashMap<String, ImageView> professorsImages = dashboardGUI.getProfessorsImages();
		professors.forEach((color, nickname) -> {
			if(playerNickname.equals(nickname))
				printProfessor(professorsImages.get(color), color);
		});

		//towers
		List<ImageView> towerImages = dashboardGUI.getTowerImages();
		int numberOfTowers = dashboardDTO.getNumberOfTowers();

		for(int i = 0; i < numberOfTowers; i++){
			printTower(towerImages.get(i), towerColor);
		}
	}

	//dashboards

	public void printEntranceStudent(ImageView entranceStudent, String color){
		Image studentImage = new Image(color + "Stud.png");
		entranceStudent.setImage(studentImage);
	}

	public void printTableStudent(ImageView tableStudent, String color){
		Image studentImage = new Image(color + "Stud.png");
		tableStudent.setImage(studentImage);
	}

	public void printProfessor(ImageView tableStudent, String color){
		Image profImage = new Image(color + "Prof.png");
		tableStudent.setImage(profImage);
	}

	public void printTower(ImageView tower, String color){
		Image towerImage = new Image(color + "Tower.png");
		tower.setImage(towerImage);
	}

	public void printCloud(ImageView cloud, String color){
		Image studImage = new Image(color + "Stud.png");
		cloud.setImage(studImage);
	}

	//coins

	public void printCoinsPOne(Integer coins){
		coinPlayerOne.setText(coins.toString());
	}

	public void printCoinsPTwo(Integer coins){
		coinPlayerTwo.setText(coins.toString());
	}

	public void printCoinsPThree(Integer coins){
		coinPlayerThree.setText(coins.toString());
	}

	//hide dashboard

	public void hidePlayerThree(DashboardGUI dashboardGUI){
		//dashboard image
		dashboardPlayerThree.setVisible(false);

		//cloud image
		cloudThree.setVisible(false);

		//coin image
		coinPlayer3.setVisible(false);
		coinPlayerThree.setVisible(false);
		coinImagePlayer3.setVisible(false);

		//entrance
		dashboardGUI.getEntranceImages().forEach(image -> image.setVisible(false));

		//tables
		dashboardGUI.getTablesImages().forEach((color, imageList) -> {
			imageList.forEach(image -> image.setVisible(false));
		});

		//towers
		dashboardGUI.getTowerImages().forEach(image -> image.setVisible(false));

		//coins
		coinPlayerThree.setVisible(false);
	}
}
