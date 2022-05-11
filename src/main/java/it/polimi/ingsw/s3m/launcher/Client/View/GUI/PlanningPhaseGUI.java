package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Server.Message.PlanningPhaseMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;


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

	public void printMessageInformation(PlanningPhaseMessage planningPhaseMessage){
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

	public void setGameState(GameDTO gameState){
		//character card

		//print islands
		ArrayList<IslandDTO> islandList = gameState.getIslands();
		int index = 0;
		try{
			printIslandZero(islandList.get(0));
			index++;
			printIslandOne(islandList.get(1));
			index++;
			printIslandTwo(islandList.get(2));
			index++;
			printIslandThree(islandList.get(3));
			index++;
			printIslandFour(islandList.get(4));
			index++;
			printIslandFive(islandList.get(5));
			index++;
			printIslandSix(islandList.get(6));
			index++;
			printIslandSeven(islandList.get(7));
			index++;
			printIslandEight(islandList.get(8));
			index++;
			printIslandNine(islandList.get(9));
			index++;
			printIslandTen(islandList.get(10));
			index++;
			printIslandEleven(islandList.get(11));
		}catch(ArrayIndexOutOfBoundsException e){
			//all the island are printed
			if(index <= 0)
				setNotVisibleIslandZero();
			if(index <= 1)
				setNotVisibleIslandOne();
			if(index <= 2)
				setNotVisibleIslandTwo();
			if(index <= 3)
				setNotVisibleIslandThree();
			if(index <= 4)
				setNotVisibleIslandFour();
			if(index <= 5)
				setNotVisibleIslandFive();
			if(index <= 6)
				setNotVisibleIslandSix();
			if(index <= 7)
				setNotVisibleIslandSeven();
			if(index <= 8)
				setNotVisibleIslandEight();
			if(index <= 9)
				setNotVisibleIslandNine();
			if(index <= 10)
				setNotVisibleIslandTen();
			if(index <= 11)
				setNotVisibleIslandEleven();
		}

		//set mother nature position
		Image motherNatureImage = new Image("MotherNature.jpeg");
		switch(gameState.getMotherNaturePosition()){
			case 0:
				motherNatureIsland0.setImage(motherNatureImage);
				break;
			case 1:
				motherNatureIsland1.setImage(motherNatureImage);
				break;
			case 2:
				motherNatureIsland2.setImage(motherNatureImage);
				break;
			case 3:
				motherNatureIsland3.setImage(motherNatureImage);
				break;
			case 4:
				motherNatureIsland4.setImage(motherNatureImage);
				break;
			case 5:
				motherNatureIsland5.setImage(motherNatureImage);
				break;
			case 6:
				motherNatureIsland6.setImage(motherNatureImage);
				break;
			case 7:
				motherNatureIsland7.setImage(motherNatureImage);
				break;
			case 8:
				motherNatureIsland8.setImage(motherNatureImage);
				break;
			case 9:
				motherNatureIsland9.setImage(motherNatureImage);
				break;
			case 10:
				motherNatureIsland10.setImage(motherNatureImage);
				break;
			case 11:
				motherNatureIsland11.setImage(motherNatureImage);
				break;
		}

		//TODO print dashboards information
		//TODO print students in entrance
		//TODO print students on tables
		//TODO print remaining towers
		//TODO print professors
		//TODO print coins
		HashMap<String, DashboardDTO> dashboardList = gameState.getDashboards();
		ArrayList<String> nicknameList = gameState.getPlayerNicknames();
		
		printDashboardOne(dashboardList.get(nicknameList.get(0)), gameState.getPlayersNumber());
		printDashboardTwo();
		if(gameState.getPlayersNumber() == 3)
			printDashboardThree();
		else
			hideDashboardThree();
	}

	public void printIslandZero(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland0.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland0.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland0.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland0.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland0.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland0.setImage(image);

		numTowersIsland0.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandZero(){
		islandZero.setVisible(false);

		redStudentsIsland0.setVisible(false);
		greenStudentsIsland0.setVisible(false);
		blueStudentsIsland0.setVisible(false);
		pinkStudentsIsland0.setVisible(false);
		yellowStudentsIsland0.setVisible(false);

		numRedStudentsIsland0.setVisible(false);
		numGreenStudentsIsland0.setVisible(false);
		numBlueStudentsIsland0.setVisible(false);
		numPinkStudentsIsland0.setVisible(false);
		numYellowStudentsIsland0.setVisible(false);

		towersIsland0.setVisible(false);

		numTowersIsland0.setVisible(false);
	}

	public void printDashboardOne(DashboardDTO dashboardDTO, int playersNumber){
		ArrayList<String> entranceStudentColors = new ArrayList<>();
		dashboardDTO.getEntrance().forEach((color, value) -> {
			for(int i = 0; i < value; i++){
				entranceStudentColors.add(color);
			}
		});

		printEntranceStudentOnePOne(entranceStudentColors.get(0));
		printEntranceStudentTwoPOne(entranceStudentColors.get(1));
		printEntranceStudentThreePOne(entranceStudentColors.get(2));
		printEntranceStudentFourPOne(entranceStudentColors.get(3));
		printEntranceStudentFivePOne(entranceStudentColors.get(4));
		printEntranceStudentSixPOne(entranceStudentColors.get(5));
		printEntranceStudentSevenPOne(entranceStudentColors.get(6));
		
		if(playersNumber == 3){
			printEntranceStudentEightPOne(entranceStudentColors.get(7));
			printEntranceStudentNinePOne(entranceStudentColors.get(8));
		}
	}
	public void printDashboardTwo(DashboardDTO dashboardDTO, int playersNumber){
		ArrayList<String> entranceStudentColors = new ArrayList<>();
		dashboardDTO.getEntrance().forEach((color, value) -> {
			for(int i = 0; i < value; i++){
				entranceStudentColors.add(color);
			}
		});

		printEntranceStudentOnePTwo(entranceStudentColors.get(0));
		printEntranceStudentTwoPTwo(entranceStudentColors.get(1));
		printEntranceStudentThreePTwo(entranceStudentColors.get(2));
		printEntranceStudentFourPTwo(entranceStudentColors.get(3));
		printEntranceStudentFivePTwo(entranceStudentColors.get(4));
		printEntranceStudentSixPTwo(entranceStudentColors.get(5));
		printEntranceStudentSevenPTwo(entranceStudentColors.get(6));

		if(playersNumber == 3){
			printEntranceStudentEightPTwo(entranceStudentColors.get(7));
			printEntranceStudentNinePTwo(entranceStudentColors.get(8));
		}
	}
	public void printDashboardThree(DashboardDTO dashboardDTO, int playersNumber){
		ArrayList<String> entranceStudentColors = new ArrayList<>();
		dashboardDTO.getEntrance().forEach((color, value) -> {
			for(int i = 0; i < value; i++){
				entranceStudentColors.add(color);
			}
		});

		printEntranceStudentOnePThree(entranceStudentColors.get(0));
		printEntranceStudentTwoPThree(entranceStudentColors.get(1));
		printEntranceStudentThreePThree(entranceStudentColors.get(2));
		printEntranceStudentFourPThree(entranceStudentColors.get(3));
		printEntranceStudentFivePThree(entranceStudentColors.get(4));
		printEntranceStudentSixPThree(entranceStudentColors.get(5));
		printEntranceStudentSevenPThree(entranceStudentColors.get(6));

		if(playersNumber == 3){
			printEntranceStudentEightPThree(entranceStudentColors.get(7));
			printEntranceStudentNinePThree(entranceStudentColors.get(8));
		}
	}

	public void printEntranceStudentOnePOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentOnePone.setImage(studentImage);
	}
	public void printEntranceStudentTwoPOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentTwoPone.setImage(studentImage);
	}
	public void printEntranceStudentThreePOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentThreePone.setImage(studentImage);
	}
	public void printEntranceStudentFourPOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentFourPone.setImage(studentImage);
	}
	public void printEntranceStudentFivePOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentFivePone.setImage(studentImage);
	}
	public void printEntranceStudentSixPOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentSixPone.setImage(studentImage);
	}
	public void printEntranceStudentSevenPOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentSevenPone.setImage(studentImage);
	}
	public void printEntranceStudentEightPOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentEightPone.setImage(studentImage);
	}
	public void printEntranceStudentNinePOne(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentNinePone.setImage(studentImage);
	}
	public void printEntranceStudentOnePTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentOnePTwo.setImage(studentImage);
	}
	public void printEntranceStudentTwoPTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentTwoPTwo.setImage(studentImage);
	}
	public void printEntranceStudentThreePTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentThreePTwo.setImage(studentImage);
	}
	public void printEntranceStudentFourPTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentFourPTwo.setImage(studentImage);
	}
	public void printEntranceStudentFivePTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentFivePTwo.setImage(studentImage);
	}
	public void printEntranceStudentSixPTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentSixPTwo.setImage(studentImage);
	}
	public void printEntranceStudentSevenPTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentSevenPTwo.setImage(studentImage);
	}
	public void printEntranceStudentEightPTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentEightPTwo.setImage(studentImage);
	}
	public void printEntranceStudentNinePTwo(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentNinePTwo.setImage(studentImage);
	}
	public void printEntranceStudentOnePThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentOnePThree.setImage(studentImage);
	}
	public void printEntranceStudentTwoPThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentTwoPThree.setImage(studentImage);
	}
	public void printEntranceStudentThreePThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentThreePThree.setImage(studentImage);
	}
	public void printEntranceStudentFourPThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentFourPThree.setImage(studentImage);
	}
	public void printEntranceStudentFivePThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentFivePThree.setImage(studentImage);
	}
	public void printEntranceStudentSixPThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentSixPThree.setImage(studentImage);
	}
	public void printEntranceStudentSevenPThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentSevenPThree.setImage(studentImage);
	}
	public void printEntranceStudentEightPThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentEightPThree.setImage(studentImage);
	}
	public void printEntranceStudentNinePThree(String color){
		Image studentImage = new Image(color + "Stud.jpeg");
		hallStudentNinePThree.setImage(studentImage);
	}






	public void printIslandOne(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland1.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland1.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland1.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland1.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland1.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland1.setImage(image);

		numTowersIsland1.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandOne(){
		islandOne.setVisible(false);

		redStudentsIsland1.setVisible(false);
		greenStudentsIsland1.setVisible(false);
		blueStudentsIsland1.setVisible(false);
		pinkStudentsIsland1.setVisible(false);
		yellowStudentsIsland1.setVisible(false);

		numRedStudentsIsland1.setVisible(false);
		numGreenStudentsIsland1.setVisible(false);
		numBlueStudentsIsland1.setVisible(false);
		numPinkStudentsIsland1.setVisible(false);
		numYellowStudentsIsland1.setVisible(false);

		towersIsland1.setVisible(false);

		numTowersIsland1.setVisible(false);
	}
	public void printIslandTwo(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland2.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland2.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland2.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland2.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland2.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland2.setImage(image);

		numTowersIsland2.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandTwo(){
		islandTwo.setVisible(false);

		redStudentsIsland2.setVisible(false);
		greenStudentsIsland2.setVisible(false);
		blueStudentsIsland2.setVisible(false);
		pinkStudentsIsland2.setVisible(false);
		yellowStudentsIsland2.setVisible(false);

		numRedStudentsIsland2.setVisible(false);
		numGreenStudentsIsland2.setVisible(false);
		numBlueStudentsIsland2.setVisible(false);
		numPinkStudentsIsland2.setVisible(false);
		numYellowStudentsIsland2.setVisible(false);

		towersIsland2.setVisible(false);

		numTowersIsland2.setVisible(false);
	}
	public void printIslandThree(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland3.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland3.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland3.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland3.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland3.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland3.setImage(image);

		numTowersIsland3.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandThree(){
		islandThree.setVisible(false);

		redStudentsIsland3.setVisible(false);
		greenStudentsIsland3.setVisible(false);
		blueStudentsIsland3.setVisible(false);
		pinkStudentsIsland3.setVisible(false);
		yellowStudentsIsland3.setVisible(false);

		numRedStudentsIsland3.setVisible(false);
		numGreenStudentsIsland3.setVisible(false);
		numBlueStudentsIsland3.setVisible(false);
		numPinkStudentsIsland3.setVisible(false);
		numYellowStudentsIsland3.setVisible(false);

		towersIsland3.setVisible(false);

		numTowersIsland3.setVisible(false);
	}
	public void printIslandFour(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland4.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland4.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland4.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland4.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland4.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland4.setImage(image);

		numTowersIsland4.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandFour(){
		islandFour.setVisible(false);

		redStudentsIsland4.setVisible(false);
		greenStudentsIsland4.setVisible(false);
		blueStudentsIsland4.setVisible(false);
		pinkStudentsIsland4.setVisible(false);
		yellowStudentsIsland4.setVisible(false);

		numRedStudentsIsland4.setVisible(false);
		numGreenStudentsIsland4.setVisible(false);
		numBlueStudentsIsland4.setVisible(false);
		numPinkStudentsIsland4.setVisible(false);
		numYellowStudentsIsland4.setVisible(false);

		towersIsland4.setVisible(false);

		numTowersIsland4.setVisible(false);
	}
	public void printIslandFive(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland5.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland5.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland5.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland5.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland5.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland5.setImage(image);

		numTowersIsland5.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandFive(){
		islandFive.setVisible(false);

		redStudentsIsland5.setVisible(false);
		greenStudentsIsland5.setVisible(false);
		blueStudentsIsland5.setVisible(false);
		pinkStudentsIsland5.setVisible(false);
		yellowStudentsIsland5.setVisible(false);

		numRedStudentsIsland5.setVisible(false);
		numGreenStudentsIsland5.setVisible(false);
		numBlueStudentsIsland5.setVisible(false);
		numPinkStudentsIsland5.setVisible(false);
		numYellowStudentsIsland5.setVisible(false);

		towersIsland5.setVisible(false);

		numTowersIsland5.setVisible(false);
	}
	public void printIslandSix(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland6.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland6.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland6.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland6.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland6.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland6.setImage(image);

		numTowersIsland6.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandSix(){
		islandSix.setVisible(false);

		redStudentsIsland6.setVisible(false);
		greenStudentsIsland6.setVisible(false);
		blueStudentsIsland6.setVisible(false);
		pinkStudentsIsland6.setVisible(false);
		yellowStudentsIsland6.setVisible(false);

		numRedStudentsIsland6.setVisible(false);
		numGreenStudentsIsland6.setVisible(false);
		numBlueStudentsIsland6.setVisible(false);
		numPinkStudentsIsland6.setVisible(false);
		numYellowStudentsIsland6.setVisible(false);

		towersIsland6.setVisible(false);

		numTowersIsland6.setVisible(false);
	}
	public void printIslandSeven(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland7.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland7.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland7.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland7.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland7.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland7.setImage(image);

		numTowersIsland7.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandSeven(){
		islandSeven.setVisible(false);

		redStudentsIsland7.setVisible(false);
		greenStudentsIsland7.setVisible(false);
		blueStudentsIsland7.setVisible(false);
		pinkStudentsIsland7.setVisible(false);
		yellowStudentsIsland7.setVisible(false);

		numRedStudentsIsland7.setVisible(false);
		numGreenStudentsIsland7.setVisible(false);
		numBlueStudentsIsland7.setVisible(false);
		numPinkStudentsIsland7.setVisible(false);
		numYellowStudentsIsland7.setVisible(false);

		towersIsland7.setVisible(false);

		numTowersIsland7.setVisible(false);
	}
	public void printIslandEight(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland8.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland8.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland8.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland8.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland8.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland8.setImage(image);

		numTowersIsland8.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandEight(){
		islandEight.setVisible(false);

		redStudentsIsland8.setVisible(false);
		greenStudentsIsland8.setVisible(false);
		blueStudentsIsland8.setVisible(false);
		pinkStudentsIsland8.setVisible(false);
		yellowStudentsIsland8.setVisible(false);

		numRedStudentsIsland8.setVisible(false);
		numGreenStudentsIsland8.setVisible(false);
		numBlueStudentsIsland8.setVisible(false);
		numPinkStudentsIsland8.setVisible(false);
		numYellowStudentsIsland8.setVisible(false);

		towersIsland8.setVisible(false);

		numTowersIsland8.setVisible(false);
	}
	public void printIslandNine(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland9.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland9.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland9.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland9.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland9.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland9.setImage(image);

		numTowersIsland9.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandNine(){
		islandNine.setVisible(false);

		redStudentsIsland9.setVisible(false);
		greenStudentsIsland9.setVisible(false);
		blueStudentsIsland9.setVisible(false);
		pinkStudentsIsland9.setVisible(false);
		yellowStudentsIsland9.setVisible(false);

		numRedStudentsIsland9.setVisible(false);
		numGreenStudentsIsland9.setVisible(false);
		numBlueStudentsIsland9.setVisible(false);
		numPinkStudentsIsland9.setVisible(false);
		numYellowStudentsIsland9.setVisible(false);

		towersIsland9.setVisible(false);

		numTowersIsland9.setVisible(false);
	}
	public void printIslandTen(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland10.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland10.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland10.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland10.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland10.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland10.setImage(image);

		numTowersIsland10.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandTen(){
		islandTen.setVisible(false);

		redStudentsIsland10.setVisible(false);
		greenStudentsIsland10.setVisible(false);
		blueStudentsIsland10.setVisible(false);
		pinkStudentsIsland10.setVisible(false);
		yellowStudentsIsland10.setVisible(false);

		numRedStudentsIsland10.setVisible(false);
		numGreenStudentsIsland10.setVisible(false);
		numBlueStudentsIsland10.setVisible(false);
		numPinkStudentsIsland10.setVisible(false);
		numYellowStudentsIsland10.setVisible(false);

		towersIsland10.setVisible(false);

		numTowersIsland10.setVisible(false);
	}
	public void printIslandEleven(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland11.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland11.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland11.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland11.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland11.setText(studentsOnIsland.get("YELLOW").toString());

		Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
		towersIsland11.setImage(image);

		numTowersIsland11.setText(String.valueOf(islandDTO.getNumberOfTowers()));
	}

	public void setNotVisibleIslandEleven(){
		islandEleven.setVisible(false);

		redStudentsIsland11.setVisible(false);
		greenStudentsIsland11.setVisible(false);
		blueStudentsIsland11.setVisible(false);
		pinkStudentsIsland11.setVisible(false);
		yellowStudentsIsland11.setVisible(false);

		numRedStudentsIsland11.setVisible(false);
		numGreenStudentsIsland11.setVisible(false);
		numBlueStudentsIsland11.setVisible(false);
		numPinkStudentsIsland11.setVisible(false);
		numYellowStudentsIsland11.setVisible(false);

		towersIsland11.setVisible(false);

		numTowersIsland11.setVisible(false);
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
