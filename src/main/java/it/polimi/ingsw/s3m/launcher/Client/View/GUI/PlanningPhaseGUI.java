package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


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
	ImageView coinImage;
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

	//public void AssistantChoiceGUI(){}

	public void printMessageInformation(PlanningPhaseMessage planningPhaseMessage, Stage secondaryStage){
		GameDTO gameState = planningPhaseMessage.getGameState();
		ArrayList<AssistantCardDTO> playedAssistantCards = gameState.getTurn().getPlayedCards();
		ArrayList<AssistantCardDTO> hand = gameState.getCurrentPlayer().getHand();

		try{
			insertAssistantZero(hand.get(0));
			insertAssistantOne(hand.get(1));
			insertAssistantTwo(hand.get(2));
			insertAssistantThree(hand.get(3));
			insertAssistantFour(hand.get(4));
			insertAssistantFive(hand.get(5));
			insertAssistantSix(hand.get(6));
			insertAssistantSeven(hand.get(7));
			insertAssistantEight(hand.get(8));
			insertAssistantNine(hand.get(9));
		}catch(ArrayIndexOutOfBoundsException e){
			return;
		}
	}

	public void insertAssistantZero(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantZero.setImage(view);
	}

	public void insertAssistantOne(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantOne.setImage(view);
	}

	public void insertAssistantTwo(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantTwo.setImage(view);
	}

	public void insertAssistantThree(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantFour.setImage(view);
	}

	public void insertAssistantFour(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantFour.setImage(view);
	}

	public void insertAssistantFive(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantFive.setImage(view);
	}

	public void insertAssistantSix(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantSix.setImage(view);
	}

	public void insertAssistantSeven(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantSeven.setImage(view);
	}

	public void insertAssistantEight(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantEight.setImage(view);
	}

	public void insertAssistantNine(AssistantCardDTO assistantCardDTO){
		Image view = new Image(assistantCardDTO.getType() + ".jpg");
		assistantNine.setImage(view);
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
		hide();
		ControllerGUI.getInstance().startLoading();
	}

	private void hide(){
		vBoxAssistantCard.setVisible(false);
	}


	public void chooseAssistant(MouseEvent mouseEvent) {

	}
}
