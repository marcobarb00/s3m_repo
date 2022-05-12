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
		
		//TODO character cards???


		//print islands
		ArrayList<IslandDTO> islandList = gameState.getIslands();

		int index = 0;
		for(; index < islandList.size(); index++){
			printIsland(islandInfoList.get(index), islandList.get(index));
		}
		for(; index < 11; index++){
			setIslandNotVisible(islandInfoList.get(index));
		}

		//mother nature

		Image motherNatureImage = new Image("MotherNature.png");
		motherIslandImageView.get(gameState.getMotherNaturePosition()).setImage(motherNatureImage);
		
		//dashboards

		HashMap<String, DashboardDTO> dashboardList = gameState.getDashboards();
		ArrayList<String> nicknameList = gameState.getPlayerNicknames();
		HashMap<String, String> towerColors = gameState.getTowerColor();
		
		printDashboardOne(dashboardList.get(nicknameList.get(0)), nicknameList.get(0), gameState.getPlayersNumber(),
				gameState.getProfessors(), towerColors.get(nicknameList.get(0)));

		printDashboardTwo(dashboardList.get(nicknameList.get(1)), nicknameList.get(1), gameState.getPlayersNumber(),
				gameState.getProfessors(), towerColors.get(nicknameList.get(1)));
		if(gameState.getPlayersNumber() == 3)
			printDashboardThree(dashboardList.get(nicknameList.get(2)), nicknameList.get(2), gameState.getPlayersNumber(),
					gameState.getProfessors(), towerColors.get(nicknameList.get(2)));
		else
			hideDashboardThree();


		HashMap<String, Integer> coins = gameState.getCoins();
		printCoinsPOne(coins.get(nicknameList.get(0)));
		printCoinsPTwo(coins.get(nicknameList.get(0)));
		printCoinsPThree(coins.get(nicknameList.get(0)));
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

	public void printDashboardOne(DashboardDTO dashboardDTO, String playerNickname, int playersNumber, HashMap<String, String> professors, String towerColor){
		//TODO b
		List<ImageView> entranceImages = Arrays.asList(hallStudentOnePone, );

		List<ImageView> redStudentsTable = Arrays.asList(studRedOnePone, );
		List<ImageView> greenStudentsTable = Arrays.asList(studGreenOnePone, );
		//...

		List<ImageView> towerImages = Arrays.asList(towerOnePone, );

		DashboardGUI

		//print entrance
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

		//print tables
		HashMap<String, Integer> tables = dashboardDTO.getTables();
		if(tables.get("RED") >= 1)
			printTableStudentOnePOneRed();
		if(tables.get("RED") >= 2)
			printTableStudentTwoPOneRed();
		if(tables.get("RED") >= 3)
			printTableStudentThreePOneRed();
		if(tables.get("RED") >= 4)
			printTableStudentFourPOneRed();
		if(tables.get("RED") >= 5)
			printTableStudentFivePOneRed();
		if(tables.get("RED") >= 6)
			printTableStudentSixPOneRed();
		if(tables.get("RED") >= 7)
			printTableStudentSevenPOneRed();
		if(tables.get("RED") >= 8)
			printTableStudentEightPOneRed();
		if(tables.get("RED") >= 9)
			printTableStudentNinePOneRed();
		if(tables.get("RED") >= 10)
			printTableStudentTenPOneRed();

		if(tables.get("GREEN") >= 1)
			printTableStudentOnePOneGreen();
		if(tables.get("GREEN") >= 2)
			printTableStudentTwoPOneGreen();
		if(tables.get("GREEN") >= 3)
			printTableStudentThreePOneGreen();
		if(tables.get("GREEN") >= 4)
			printTableStudentFourPOneGreen();
		if(tables.get("GREEN") >= 5)
			printTableStudentFivePOneGreen();
		if(tables.get("GREEN") >= 6)
			printTableStudentSixPOneGreen();
		if(tables.get("GREEN") >= 7)
			printTableStudentSevenPOneGreen();
		if(tables.get("GREEN") >= 8)
			printTableStudentEightPOneGreen();
		if(tables.get("GREEN") >= 9)
			printTableStudentNinePOneGreen();
		if(tables.get("GREEN") >= 10)
			printTableStudentTenPOneGreen();

		if(tables.get("BLUE") >= 1)
			printTableStudentOnePOneBlue();
		if(tables.get("BLUE") >= 2)
			printTableStudentTwoPOneBlue();
		if(tables.get("BLUE") >= 3)
			printTableStudentThreePOneBlue();
		if(tables.get("BLUE") >= 4)
			printTableStudentFourPOneBlue();
		if(tables.get("BLUE") >= 5)
			printTableStudentFivePOneBlue();
		if(tables.get("BLUE") >= 6)
			printTableStudentSixPOneBlue();
		if(tables.get("BLUE") >= 7)
			printTableStudentSevenPOneBlue();
		if(tables.get("BLUE") >= 8)
			printTableStudentEightPOneBlue();
		if(tables.get("BLUE") >= 9)
			printTableStudentNinePOneBlue();
		if(tables.get("BLUE") >= 10)
			printTableStudentTenPOneBlue();

		if(tables.get("PINK") >= 1)
			printTableStudentOnePOnePink();
		if(tables.get("PINK") >= 2)
			printTableStudentTwoPOnePink();
		if(tables.get("PINK") >= 3)
			printTableStudentThreePOnePink();
		if(tables.get("PINK") >= 4)
			printTableStudentFourPOnePink();
		if(tables.get("PINK") >= 5)
			printTableStudentFivePOnePink();
		if(tables.get("PINK") >= 6)
			printTableStudentSixPOnePink();
		if(tables.get("PINK") >= 7)
			printTableStudentSevenPOnePink();
		if(tables.get("PINK") >= 8)
			printTableStudentEightPOnePink();
		if(tables.get("PINK") >= 9)
			printTableStudentNinePOnePink();
		if(tables.get("PINK") >= 10)
			printTableStudentTenPOnePink();

		if(tables.get("YELLOW") >= 1)
			printTableStudentOnePOneYellow();
		if(tables.get("YELLOW") >= 2)
			printTableStudentTwoPOneYellow();
		if(tables.get("YELLOW") >= 3)
			printTableStudentThreePOneYellow();
		if(tables.get("YELLOW") >= 4)
			printTableStudentFourPOneYellow();
		if(tables.get("YELLOW") >= 5)
			printTableStudentFivePOneYellow();
		if(tables.get("YELLOW") >= 6)
			printTableStudentSixPOneYellow();
		if(tables.get("YELLOW") >= 7)
			printTableStudentSevenPOneYellow();
		if(tables.get("YELLOW") >= 8)
			printTableStudentEightPOneYellow();
		if(tables.get("YELLOW") >= 9)
			printTableStudentNinePOneYellow();
		if(tables.get("YELLOW") >= 10)
			printTableStudentTenPOneYellow();

		//print professors
		if(playerNickname.equals(professors.get("RED")))
			printRedProfessorPOne();
		if(playerNickname.equals(professors.get("GREEN")))
			printGreenProfessorPOne();
		if(playerNickname.equals(professors.get("BLUE")))
			printBlueProfessorPOne();
		if(playerNickname.equals(professors.get("PINK")))
			printPinkProfessorPOne();
		if(playerNickname.equals(professors.get("YELLOW")))
			printYellowProfessorPOne();

		
		//print towers
		int numberOfTowers = dashboardDTO.getNumberOfTowers();
		
		if(numberOfTowers >= 1)
			printTowerOnePOne(towerColor);
		if(numberOfTowers >= 2)
			printTowerTwoPOne(towerColor);
		if(numberOfTowers >= 3)
			printTowerThreePOne(towerColor);
		if(numberOfTowers >= 4)
			printTowerFourPOne(towerColor);
		if(numberOfTowers >= 5)
			printTowerFivePOne(towerColor);
		if(numberOfTowers >= 6)
			printTowerSixPOne(towerColor);
		if(numberOfTowers >= 7)
			printTowerSevenPOne(towerColor);
		if(numberOfTowers >= 8)
			printTowerEightPOne(towerColor);


	}

	public void printDashboardTwo(DashboardDTO dashboardDTO, String playerNickname, int playersNumber, HashMap<String, String> professors, String towerColor){
		//print entrance
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

		//print tables
		HashMap<String, Integer> tables = dashboardDTO.getTables();
		if(tables.get("RED") >= 1)
			printTableStudentOnePTwoRed();
		if(tables.get("RED") >= 2)
			printTableStudentTwoPTwoRed();
		if(tables.get("RED") >= 3)
			printTableStudentThreePTwoRed();
		if(tables.get("RED") >= 4)
			printTableStudentFourPTwoRed();
		if(tables.get("RED") >= 5)
			printTableStudentFivePTwoRed();
		if(tables.get("RED") >= 6)
			printTableStudentSixPTwoRed();
		if(tables.get("RED") >= 7)
			printTableStudentSevenPTwoRed();
		if(tables.get("RED") >= 8)
			printTableStudentEightPTwoRed();
		if(tables.get("RED") >= 9)
			printTableStudentNinePTwoRed();
		if(tables.get("RED") >= 10)
			printTableStudentTenPTwoRed();

		if(tables.get("GREEN") >= 1)
			printTableStudentOnePTwoGreen();
		if(tables.get("GREEN") >= 2)
			printTableStudentTwoPTwoGreen();
		if(tables.get("GREEN") >= 3)
			printTableStudentThreePTwoGreen();
		if(tables.get("GREEN") >= 4)
			printTableStudentFourPTwoGreen();
		if(tables.get("GREEN") >= 5)
			printTableStudentFivePTwoGreen();
		if(tables.get("GREEN") >= 6)
			printTableStudentSixPTwoGreen();
		if(tables.get("GREEN") >= 7)
			printTableStudentSevenPTwoGreen();
		if(tables.get("GREEN") >= 8)
			printTableStudentEightPTwoGreen();
		if(tables.get("GREEN") >= 9)
			printTableStudentNinePTwoGreen();
		if(tables.get("GREEN") >= 10)
			printTableStudentTenPTwoGreen();

		if(tables.get("BLUE") >= 1)
			printTableStudentOnePTwoBlue();
		if(tables.get("BLUE") >= 2)
			printTableStudentTwoPTwoBlue();
		if(tables.get("BLUE") >= 3)
			printTableStudentThreePTwoBlue();
		if(tables.get("BLUE") >= 4)
			printTableStudentFourPTwoBlue();
		if(tables.get("BLUE") >= 5)
			printTableStudentFivePTwoBlue();
		if(tables.get("BLUE") >= 6)
			printTableStudentSixPTwoBlue();
		if(tables.get("BLUE") >= 7)
			printTableStudentSevenPTwoBlue();
		if(tables.get("BLUE") >= 8)
			printTableStudentEightPTwoBlue();
		if(tables.get("BLUE") >= 9)
			printTableStudentNinePTwoBlue();
		if(tables.get("BLUE") >= 10)
			printTableStudentTenPTwoBlue();

		if(tables.get("PINK") >= 1)
			printTableStudentOnePTwoPink();
		if(tables.get("PINK") >= 2)
			printTableStudentTwoPTwoPink();
		if(tables.get("PINK") >= 3)
			printTableStudentThreePTwoPink();
		if(tables.get("PINK") >= 4)
			printTableStudentFourPTwoPink();
		if(tables.get("PINK") >= 5)
			printTableStudentFivePTwoPink();
		if(tables.get("PINK") >= 6)
			printTableStudentSixPTwoPink();
		if(tables.get("PINK") >= 7)
			printTableStudentSevenPTwoPink();
		if(tables.get("PINK") >= 8)
			printTableStudentEightPTwoPink();
		if(tables.get("PINK") >= 9)
			printTableStudentNinePTwoPink();
		if(tables.get("PINK") >= 10)
			printTableStudentTenPTwoPink();

		if(tables.get("YELLOW") >= 1)
			printTableStudentOnePTwoYellow();
		if(tables.get("YELLOW") >= 2)
			printTableStudentTwoPTwoYellow();
		if(tables.get("YELLOW") >= 3)
			printTableStudentThreePTwoYellow();
		if(tables.get("YELLOW") >= 4)
			printTableStudentFourPTwoYellow();
		if(tables.get("YELLOW") >= 5)
			printTableStudentFivePTwoYellow();
		if(tables.get("YELLOW") >= 6)
			printTableStudentSixPTwoYellow();
		if(tables.get("YELLOW") >= 7)
			printTableStudentSevenPTwoYellow();
		if(tables.get("YELLOW") >= 8)
			printTableStudentEightPTwoYellow();
		if(tables.get("YELLOW") >= 9)
			printTableStudentNinePTwoYellow();
		if(tables.get("YELLOW") >= 10)
			printTableStudentTenPTwoYellow();

		//print professors
		if(playerNickname.equals(professors.get("RED")))
			printRedProfessorPTwo();
		if(playerNickname.equals(professors.get("GREEN")))
			printGreenProfessorPTwo();
		if(playerNickname.equals(professors.get("BLUE")))
			printBlueProfessorPTwo();
		if(playerNickname.equals(professors.get("PINK")))
			printPinkProfessorPTwo();
		if(playerNickname.equals(professors.get("YELLOW")))
			printYellowProfessorPTwo();


		//print towers
		int numberOfTowers = dashboardDTO.getNumberOfTowers();

		if(numberOfTowers >= 1)
			printTowerOnePTwo(towerColor);
		if(numberOfTowers >= 2)
			printTowerTwoPTwo(towerColor);
		if(numberOfTowers >= 3)
			printTowerThreePTwo(towerColor);
		if(numberOfTowers >= 4)
			printTowerFourPTwo(towerColor);
		if(numberOfTowers >= 5)
			printTowerFivePTwo(towerColor);
		if(numberOfTowers >= 6)
			printTowerSixPTwo(towerColor);
		if(numberOfTowers >= 7)
			printTowerSevenPTwo(towerColor);
		if(numberOfTowers >= 8)
			printTowerEightPTwo(towerColor);


	}

	public void printDashboardThree(DashboardDTO dashboardDTO, String playerNickname, int playersNumber, HashMap<String, String> professors, String towerColor){
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

		//print tables
		HashMap<String, Integer> tables = dashboardDTO.getTables();
		if(tables.get("RED") >= 1)
			printTableStudentOnePThreeRed();
		if(tables.get("RED") >= 2)
			printTableStudentTwoPThreeRed();
		if(tables.get("RED") >= 3)
			printTableStudentThreePThreeRed();
		if(tables.get("RED") >= 4)
			printTableStudentFourPThreeRed();
		if(tables.get("RED") >= 5)
			printTableStudentFivePThreeRed();
		if(tables.get("RED") >= 6)
			printTableStudentSixPThreeRed();
		if(tables.get("RED") >= 7)
			printTableStudentSevenPThreeRed();
		if(tables.get("RED") >= 8)
			printTableStudentEightPThreeRed();
		if(tables.get("RED") >= 9)
			printTableStudentNinePThreeRed();
		if(tables.get("RED") >= 10)
			printTableStudentTenPThreeRed();

		if(tables.get("GREEN") >= 1)
			printTableStudentOnePThreeGreen();
		if(tables.get("GREEN") >= 2)
			printTableStudentTwoPThreeGreen();
		if(tables.get("GREEN") >= 3)
			printTableStudentThreePThreeGreen();
		if(tables.get("GREEN") >= 4)
			printTableStudentFourPThreeGreen();
		if(tables.get("GREEN") >= 5)
			printTableStudentFivePThreeGreen();
		if(tables.get("GREEN") >= 6)
			printTableStudentSixPThreeGreen();
		if(tables.get("GREEN") >= 7)
			printTableStudentSevenPThreeGreen();
		if(tables.get("GREEN") >= 8)
			printTableStudentEightPThreeGreen();
		if(tables.get("GREEN") >= 9)
			printTableStudentNinePThreeGreen();
		if(tables.get("GREEN") >= 10)
			printTableStudentTenPThreeGreen();

		if(tables.get("BLUE") >= 1)
			printTableStudentOnePThreeBlue();
		if(tables.get("BLUE") >= 2)
			printTableStudentTwoPThreeBlue();
		if(tables.get("BLUE") >= 3)
			printTableStudentThreePThreeBlue();
		if(tables.get("BLUE") >= 4)
			printTableStudentFourPThreeBlue();
		if(tables.get("BLUE") >= 5)
			printTableStudentFivePThreeBlue();
		if(tables.get("BLUE") >= 6)
			printTableStudentSixPThreeBlue();
		if(tables.get("BLUE") >= 7)
			printTableStudentSevenPThreeBlue();
		if(tables.get("BLUE") >= 8)
			printTableStudentEightPThreeBlue();
		if(tables.get("BLUE") >= 9)
			printTableStudentNinePThreeBlue();
		if(tables.get("BLUE") >= 10)
			printTableStudentTenPThreeBlue();

		if(tables.get("PINK") >= 1)
			printTableStudentOnePThreePink();
		if(tables.get("PINK") >= 2)
			printTableStudentTwoPThreePink();
		if(tables.get("PINK") >= 3)
			printTableStudentThreePThreePink();
		if(tables.get("PINK") >= 4)
			printTableStudentFourPThreePink();
		if(tables.get("PINK") >= 5)
			printTableStudentFivePThreePink();
		if(tables.get("PINK") >= 6)
			printTableStudentSixPThreePink();
		if(tables.get("PINK") >= 7)
			printTableStudentSevenPThreePink();
		if(tables.get("PINK") >= 8)
			printTableStudentEightPThreePink();
		if(tables.get("PINK") >= 9)
			printTableStudentNinePThreePink();
		if(tables.get("PINK") >= 10)
			printTableStudentTenPThreePink();

		if(tables.get("YELLOW") >= 1)
			printTableStudentOnePThreeYellow();
		if(tables.get("YELLOW") >= 2)
			printTableStudentTwoPThreeYellow();
		if(tables.get("YELLOW") >= 3)
			printTableStudentThreePThreeYellow();
		if(tables.get("YELLOW") >= 4)
			printTableStudentFourPThreeYellow();
		if(tables.get("YELLOW") >= 5)
			printTableStudentFivePThreeYellow();
		if(tables.get("YELLOW") >= 6)
			printTableStudentSixPThreeYellow();
		if(tables.get("YELLOW") >= 7)
			printTableStudentSevenPThreeYellow();
		if(tables.get("YELLOW") >= 8)
			printTableStudentEightPThreeYellow();
		if(tables.get("YELLOW") >= 9)
			printTableStudentNinePThreeYellow();
		if(tables.get("YELLOW") >= 10)
			printTableStudentTenPThreeYellow();

		//print professors
		if(playerNickname.equals(professors.get("RED")))
			printRedProfessorPThree();
		if(playerNickname.equals(professors.get("GREEN")))
			printGreenProfessorPThree();
		if(playerNickname.equals(professors.get("BLUE")))
			printBlueProfessorPThree();
		if(playerNickname.equals(professors.get("PINK")))
			printPinkProfessorPThree();
		if(playerNickname.equals(professors.get("YELLOW")))
			printYellowProfessorPThree();


		//print towers
		int numberOfTowers = dashboardDTO.getNumberOfTowers();

		if(numberOfTowers >= 1)
			printTowerOnePThree(towerColor);
		if(numberOfTowers >= 2)
			printTowerTwoPThree(towerColor);
		if(numberOfTowers >= 3)
			printTowerThreePThree(towerColor);
		if(numberOfTowers >= 4)
			printTowerFourPThree(towerColor);
		if(numberOfTowers >= 5)
			printTowerFivePThree(towerColor);
		if(numberOfTowers >= 6)
			printTowerSixPThree(towerColor);
	}

	public void printEntranceStudentOnePOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentOnePone.setImage(studentImage);
	}
	public void printEntranceStudentTwoPOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentTwoPone.setImage(studentImage);
	}
	public void printEntranceStudentThreePOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentThreePone.setImage(studentImage);
	}
	public void printEntranceStudentFourPOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentFourPone.setImage(studentImage);
	}
	public void printEntranceStudentFivePOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentFivePone.setImage(studentImage);
	}
	public void printEntranceStudentSixPOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentSixPone.setImage(studentImage);
	}
	public void printEntranceStudentSevenPOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentSevenPone.setImage(studentImage);
	}
	public void printEntranceStudentEightPOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentEightPone.setImage(studentImage);
	}
	public void printEntranceStudentNinePOne(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentNinePone.setImage(studentImage);
	}
	public void printEntranceStudentOnePTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentOnePTwo.setImage(studentImage);
	}
	public void printEntranceStudentTwoPTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentTwoPTwo.setImage(studentImage);
	}
	public void printEntranceStudentThreePTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentThreePTwo.setImage(studentImage);
	}
	public void printEntranceStudentFourPTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentFourPTwo.setImage(studentImage);
	}
	public void printEntranceStudentFivePTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentFivePTwo.setImage(studentImage);
	}
	public void printEntranceStudentSixPTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentSixPTwo.setImage(studentImage);
	}
	public void printEntranceStudentSevenPTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentSevenPTwo.setImage(studentImage);
	}
	public void printEntranceStudentEightPTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentEightPTwo.setImage(studentImage);
	}
	public void printEntranceStudentNinePTwo(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentNinePTwo.setImage(studentImage);
	}
	public void printEntranceStudentOnePThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentOnePThree.setImage(studentImage);
	}
	public void printEntranceStudentTwoPThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentTwoPThree.setImage(studentImage);
	}
	public void printEntranceStudentThreePThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentThreePThree.setImage(studentImage);
	}
	public void printEntranceStudentFourPThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentFourPThree.setImage(studentImage);
	}
	public void printEntranceStudentFivePThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentFivePThree.setImage(studentImage);
	}
	public void printEntranceStudentSixPThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentSixPThree.setImage(studentImage);
	}
	public void printEntranceStudentSevenPThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentSevenPThree.setImage(studentImage);
	}
	public void printEntranceStudentEightPThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentEightPThree.setImage(studentImage);
	}
	public void printEntranceStudentNinePThree(String color){
		Image studentImage = new Image(color + "Stud.png");
		hallStudentNinePThree.setImage(studentImage);
	}

	//tables p1
	public void printTableStudentOnePOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneRed(){
		Image studentImage = new Image("REDStud.png");
		studRedTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenSixPone.setImage(studentImage);
	}public void printTableStudentSevenPOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOnePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowTenPone.setImage(studentImage);
	}


	//tables p2
	public void printTableStudentOnePTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoRed(){
		Image studentImage = new Image("REDStud.png");
		studRedTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenSixPTwo.setImage(studentImage);
	}public void printTableStudentSevenPTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoPink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowTenPTwo.setImage(studentImage);
	}





	//tables p3
	public void printTableStudentOnePThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeRed(){
		Image studentImage = new Image("REDStud.png");
		studRedTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenSixPThree.setImage(studentImage);
	}public void printTableStudentSevenPThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeGreen(){
		Image studentImage = new Image("GREENStud.png");
		studGreenTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeBlue(){
		Image studentImage = new Image("BLUEStud.png");
		studBlueTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreePink(){
		Image studentImage = new Image("PINKStud.png");
		studPinkTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.png");
		studYellowTenPThree.setImage(studentImage);
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

	public void printRedProfessorPOne(){
		Image view = new Image("REDProf.png");
		professorRedPone.setImage(view);
	}

	public void printGreenProfessorPOne(){
		Image view = new Image("GREENProf.png");
		professorGreenPone.setImage(view);
	}

	public void printBlueProfessorPOne(){
		Image view = new Image("BLUEProf.png");
		professorBluePone.setImage(view);
	}

	public void printPinkProfessorPOne(){
		Image view = new Image("PINKProf.png");
		professorPinkPone.setImage(view);
	}

	public void printYellowProfessorPOne(){
		Image view = new Image("YELLOWProf.png");
		professorYellowPone.setImage(view);
	}
	public void printRedProfessorPTwo(){
		Image view = new Image("REDProf.png");
		professorRedPTwo.setImage(view);
	}

	public void printGreenProfessorPTwo(){
		Image view = new Image("GREENProf.png");
		professorGreenPTwo.setImage(view);
	}

	public void printBlueProfessorPTwo(){
		Image view = new Image("BLUEProf.png");
		professorBluePTwo.setImage(view);
	}

	public void printPinkProfessorPTwo(){
		Image view = new Image("PINKProf.png");
		professorPinkPTwo.setImage(view);
	}

	public void printYellowProfessorPTwo(){
		Image view = new Image("YELLOWProf.png");
		professorYellowPTwo.setImage(view);
	}
	public void printRedProfessorPThree(){
		Image view = new Image("REDProf.png");
		professorRedPThree.setImage(view);
	}

	public void printGreenProfessorPThree(){
		Image view = new Image("GREENProf.png");
		professorGreenPThree.setImage(view);
	}

	public void printBlueProfessorPThree(){
		Image view = new Image("BLUEProf.png");
		professorBluePThree.setImage(view);
	}

	public void printPinkProfessorPThree(){
		Image view = new Image("PINKProf.png");
		professorPinkPThree.setImage(view);
	}

	public void printYellowProfessorPThree(){
		Image view = new Image("YELLOWProf.png");
		professorYellowPThree.setImage(view);
	}


	//towers
	public void printTowerOnePOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerOnePone.setImage(towerImage);
		}
	}

	public void printTowerTwoPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerTwoPone.setImage(towerImage);
		}
	}

	public void printTowerThreePOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerThreePone.setImage(towerImage);
		}
	}

	public void printTowerFourPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerFourPone.setImage(towerImage);
		}
	}

	public void printTowerFivePOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerFivePone.setImage(towerImage);
		}
	}

	public void printTowerSixPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerSixPone.setImage(towerImage);
		}
	}

	public void printTowerSevenPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerSevenPone.setImage(towerImage);
		}
	}

	public void printTowerEightPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerEightPone.setImage(towerImage);
		}
	}

	public void printCoinsPOne(Integer coins){
		coinPlayerOne.setText(coins.toString());
	}

	public void printCoinsPTwo(Integer coins){
		coinPlayerTwo.setText(coins.toString());
	}

	public void printCoinsPThree(Integer coins){
		coinPlayerThree.setText(coins.toString());
	}

	public void printTowerOnePTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerOnePTwo.setImage(towerImage);
		}
	}

	public void printTowerTwoPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerTwoPTwo.setImage(towerImage);
		}
	}

	public void printTowerThreePTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerThreePTwo.setImage(towerImage);
		}
	}

	public void printTowerFourPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerFourPTwo.setImage(towerImage);
		}
	}

	public void printTowerFivePTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerFivePTwo.setImage(towerImage);
		}
	}

	public void printTowerSixPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerSixPTwo.setImage(towerImage);
		}
	}

	public void printTowerSevenPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerSevenPTwo.setImage(towerImage);
		}
	}

	public void printTowerEightPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerEightPTwo.setImage(towerImage);
		}
	}


	public void printTowerOnePThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerOnePThree.setImage(towerImage);
		}
	}

	public void printTowerTwoPThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerTwoPThree.setImage(towerImage);
		}
	}

	public void printTowerThreePThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerThreePThree.setImage(towerImage);
		}
	}

	public void printTowerFourPThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerFourPThree.setImage(towerImage);
		}
	}

	public void printTowerFivePThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerFivePThree.setImage(towerImage);
		}
	}

	public void printTowerSixPThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.png");
			towerSixPThree.setImage(towerImage);
		}
	}

	public void hideDashboardThree(){
		//dashboard image
		dashboardPlayerThree.setVisible(false);

		//entrance
		hallStudentOnePThree.setVisible(false);
		hallStudentTwoPThree.setVisible(false);
		hallStudentThreePThree.setVisible(false);
		hallStudentFourPThree.setVisible(false);
		hallStudentFivePThree.setVisible(false);
		hallStudentSixPThree.setVisible(false);
		hallStudentSevenPThree.setVisible(false);
		hallStudentEightPThree.setVisible(false);
		hallStudentNinePThree.setVisible(false);

		//tables
		studRedOnePThree.setVisible(false);
		studRedTwoPThree.setVisible(false);
		studRedThreePThree.setVisible(false);
		studRedFourPThree.setVisible(false);
		studRedFivePThree.setVisible(false);
		studRedSixPThree.setVisible(false);
		studRedSevenPThree.setVisible(false);
		studRedEightPThree.setVisible(false);
		studRedNinePThree.setVisible(false);
		studRedTenPThree.setVisible(false);

		studBlueOnePThree.setVisible(false);
		studBlueTwoPThree.setVisible(false);
		studBlueThreePThree.setVisible(false);
		studBlueFourPThree.setVisible(false);
		studBlueFivePThree.setVisible(false);
		studBlueSixPThree.setVisible(false);
		studBlueSevenPThree.setVisible(false);
		studBlueEightPThree.setVisible(false);
		studBlueNinePThree.setVisible(false);
		studBlueTenPThree.setVisible(false);

		studGreenOnePThree.setVisible(false);
		studGreenTwoPThree.setVisible(false);
		studGreenThreePThree.setVisible(false);
		studGreenFourPThree.setVisible(false);
		studGreenFivePThree.setVisible(false);
		studGreenSixPThree.setVisible(false);
		studGreenSevenPThree.setVisible(false);
		studGreenEightPThree.setVisible(false);
		studGreenNinePThree.setVisible(false);
		studGreenTenPThree.setVisible(false);

		studPinkOnePThree.setVisible(false);
		studPinkTwoPThree.setVisible(false);
		studPinkThreePThree.setVisible(false);
		studPinkFourPThree.setVisible(false);
		studPinkFivePThree.setVisible(false);
		studPinkSixPThree.setVisible(false);
		studPinkSevenPThree.setVisible(false);
		studPinkEightPThree.setVisible(false);
		studPinkNinePThree.setVisible(false);
		studPinkTenPThree.setVisible(false);

		studYellowOnePThree.setVisible(false);
		studYellowTwoPThree.setVisible(false);
		studYellowThreePThree.setVisible(false);
		studYellowFourPThree.setVisible(false);
		studYellowFivePThree.setVisible(false);
		studYellowSixPThree.setVisible(false);
		studYellowSevenPThree.setVisible(false);
		studYellowEightPThree.setVisible(false);
		studYellowNinePThree.setVisible(false);
		studYellowTenPThree.setVisible(false);

		//towers
		towerOnePThree.setVisible(false);
		towerTwoPThree.setVisible(false);
		towerThreePThree.setVisible(false);
		towerFourPThree.setVisible(false);
		towerFivePThree.setVisible(false);
		towerSixPThree.setVisible(false);

		//coins
		coinPlayerThree.setVisible(false);
	}


	public void chooseAssistant(MouseEvent mouseEvent) {

	}
}
