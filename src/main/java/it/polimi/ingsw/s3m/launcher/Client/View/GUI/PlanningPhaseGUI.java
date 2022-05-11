package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import it.polimi.ingsw.s3m.launcher.Client.Response.PlayAssistantCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUIController.ControllerGUI;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.AssistantCardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.DashboardDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.GameDTO;
import it.polimi.ingsw.s3m.launcher.Communication.DTO.IslandDTO;
import it.polimi.ingsw.s3m.launcher.Server.Exception.IncorrectOperationException;
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
import java.util.Objects;


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

	public void printMessageInformation(PlanningPhaseMessage planningPhaseMessage){
		GameDTO gameState = planningPhaseMessage.getGameState();
		setGameState(gameState);

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
		//TODO character cards???


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

	public void printIslandZero(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland0.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland0.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland0.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland0.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland0.setText(studentsOnIsland.get("YELLOW").toString());

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image towerImage = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland0.setImage(towerImage);
		}

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

	public void printIslandOne(IslandDTO islandDTO){
		HashMap<String, Integer> studentsOnIsland = islandDTO.getStudents();
		numRedStudentsIsland1.setText(studentsOnIsland.get("RED").toString());
		numGreenStudentsIsland1.setText(studentsOnIsland.get("GREEN").toString());
		numBlueStudentsIsland1.setText(studentsOnIsland.get("BLUE").toString());
		numPinkStudentsIsland1.setText(studentsOnIsland.get("PINK").toString());
		numYellowStudentsIsland1.setText(studentsOnIsland.get("YELLOW").toString());

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland1.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland2.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland3.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland4.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland5.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland6.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland7.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland8.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland9.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland10.setImage(image);
		}

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

		if(!Objects.equals(islandDTO.getDominatorColor(), "")){
			Image image = new Image(islandDTO.getDominatorColor() + "Tower.jpeg");
			towersIsland11.setImage(image);
		}

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

	public void printDashboardOne(DashboardDTO dashboardDTO, String playerNickname, int playersNumber, HashMap<String, String> professors, String towerColor){
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

	//tables p1
	public void printTableStudentOnePOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenSixPone.setImage(studentImage);
	}public void printTableStudentSevenPOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOnePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkTenPone.setImage(studentImage);
	}
	public void printTableStudentOnePOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowOnePone.setImage(studentImage);
	}
	public void printTableStudentTwoPOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowTwoPone.setImage(studentImage);
	}
	public void printTableStudentThreePOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowThreePone.setImage(studentImage);
	}
	public void printTableStudentFourPOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowFourPone.setImage(studentImage);
	}
	public void printTableStudentFivePOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowFivePone.setImage(studentImage);
	}
	public void printTableStudentSixPOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowSixPone.setImage(studentImage);
	}
	public void printTableStudentSevenPOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowSevenPone.setImage(studentImage);
	}
	public void printTableStudentEightPOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowEightPone.setImage(studentImage);
	}
	public void printTableStudentNinePOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowNinePone.setImage(studentImage);
	}
	public void printTableStudentTenPOneYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowTenPone.setImage(studentImage);
	}


	//tables p2
	public void printTableStudentOnePTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenSixPTwo.setImage(studentImage);
	}public void printTableStudentSevenPTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoPink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkTenPTwo.setImage(studentImage);
	}
	public void printTableStudentOnePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowOnePTwo.setImage(studentImage);
	}
	public void printTableStudentTwoPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowTwoPTwo.setImage(studentImage);
	}
	public void printTableStudentThreePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowThreePTwo.setImage(studentImage);
	}
	public void printTableStudentFourPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowFourPTwo.setImage(studentImage);
	}
	public void printTableStudentFivePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowFivePTwo.setImage(studentImage);
	}
	public void printTableStudentSixPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowSixPTwo.setImage(studentImage);
	}
	public void printTableStudentSevenPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowSevenPTwo.setImage(studentImage);
	}
	public void printTableStudentEightPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowEightPTwo.setImage(studentImage);
	}
	public void printTableStudentNinePTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowNinePTwo.setImage(studentImage);
	}
	public void printTableStudentTenPTwoYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowTenPTwo.setImage(studentImage);
	}





	//tables p3
	public void printTableStudentOnePThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeRed(){
		Image studentImage = new Image("REDStud.jpeg");
		studRedTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenSixPThree.setImage(studentImage);
	}public void printTableStudentSevenPThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeGreen(){
		Image studentImage = new Image("GREENStud.jpeg");
		studGreenTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeBlue(){
		Image studentImage = new Image("BLUEStud.jpeg");
		studBlueTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreePink(){
		Image studentImage = new Image("PINKStud.jpeg");
		studPinkTenPThree.setImage(studentImage);
	}
	public void printTableStudentOnePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowOnePThree.setImage(studentImage);
	}
	public void printTableStudentTwoPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowTwoPThree.setImage(studentImage);
	}
	public void printTableStudentThreePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowThreePThree.setImage(studentImage);
	}
	public void printTableStudentFourPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowFourPThree.setImage(studentImage);
	}
	public void printTableStudentFivePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowFivePThree.setImage(studentImage);
	}
	public void printTableStudentSixPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowSixPThree.setImage(studentImage);
	}
	public void printTableStudentSevenPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowSevenPThree.setImage(studentImage);
	}
	public void printTableStudentEightPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowEightPThree.setImage(studentImage);
	}
	public void printTableStudentNinePThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowNinePThree.setImage(studentImage);
	}
	public void printTableStudentTenPThreeYellow(){
		Image studentImage = new Image("YELLOWStud.jpeg");
		studYellowTenPThree.setImage(studentImage);
	}




	//assistant cards
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
		assistantThree.setImage(view);
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
		ControllerGUI.getInstance().startLoading();
	}

	public void printRedProfessorPOne(){
		Image view = new Image("REDProf.jpeg");
		professorRedPone.setImage(view);
	}

	public void printGreenProfessorPOne(){
		Image view = new Image("GREENProf.jpeg");
		professorGreenPone.setImage(view);
	}

	public void printBlueProfessorPOne(){
		Image view = new Image("BLUEProf.jpeg");
		professorBluePone.setImage(view);
	}

	public void printPinkProfessorPOne(){
		Image view = new Image("PINKProf.jpeg");
		professorPinkPone.setImage(view);
	}

	public void printYellowProfessorPOne(){
		Image view = new Image("YELLOWProf.jpeg");
		professorYellowPone.setImage(view);
	}
	public void printRedProfessorPTwo(){
		Image view = new Image("REDProf.jpeg");
		professorRedPTwo.setImage(view);
	}

	public void printGreenProfessorPTwo(){
		Image view = new Image("GREENProf.jpeg");
		professorGreenPTwo.setImage(view);
	}

	public void printBlueProfessorPTwo(){
		Image view = new Image("BLUEProf.jpeg");
		professorBluePTwo.setImage(view);
	}

	public void printPinkProfessorPTwo(){
		Image view = new Image("PINKProf.jpeg");
		professorPinkPTwo.setImage(view);
	}

	public void printYellowProfessorPTwo(){
		Image view = new Image("YELLOWProf.jpeg");
		professorYellowPTwo.setImage(view);
	}
	public void printRedProfessorPThree(){
		Image view = new Image("REDProf.jpeg");
		professorRedPThree.setImage(view);
	}

	public void printGreenProfessorPThree(){
		Image view = new Image("GREENProf.jpeg");
		professorGreenPThree.setImage(view);
	}

	public void printBlueProfessorPThree(){
		Image view = new Image("BLUEProf.jpeg");
		professorBluePThree.setImage(view);
	}

	public void printPinkProfessorPThree(){
		Image view = new Image("PINKProf.jpeg");
		professorPinkPThree.setImage(view);
	}

	public void printYellowProfessorPThree(){
		Image view = new Image("YELLOWProf.jpeg");
		professorYellowPThree.setImage(view);
	}


	//towers
	public void printTowerOnePOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerOnePone.setImage(towerImage);
		}
	}

	public void printTowerTwoPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerTwoPone.setImage(towerImage);
		}
	}

	public void printTowerThreePOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerThreePone.setImage(towerImage);
		}
	}

	public void printTowerFourPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerFourPone.setImage(towerImage);
		}
	}

	public void printTowerFivePOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerFivePone.setImage(towerImage);
		}
	}

	public void printTowerSixPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerSixPone.setImage(towerImage);
		}
	}

	public void printTowerSevenPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerSevenPone.setImage(towerImage);
		}
	}

	public void printTowerEightPOne(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
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
			Image towerImage = new Image(color + "Tower.jpeg");
			towerOnePTwo.setImage(towerImage);
		}
	}

	public void printTowerTwoPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerTwoPTwo.setImage(towerImage);
		}
	}

	public void printTowerThreePTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerThreePTwo.setImage(towerImage);
		}
	}

	public void printTowerFourPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerFourPTwo.setImage(towerImage);
		}
	}

	public void printTowerFivePTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerFivePTwo.setImage(towerImage);
		}
	}

	public void printTowerSixPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerSixPTwo.setImage(towerImage);
		}
	}

	public void printTowerSevenPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerSevenPTwo.setImage(towerImage);
		}
	}

	public void printTowerEightPTwo(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerEightPTwo.setImage(towerImage);
		}
	}


	public void printTowerOnePThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerOnePThree.setImage(towerImage);
		}
	}

	public void printTowerTwoPThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerTwoPThree.setImage(towerImage);
		}
	}

	public void printTowerThreePThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerThreePThree.setImage(towerImage);
		}
	}

	public void printTowerFourPThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerFourPThree.setImage(towerImage);
		}
	}

	public void printTowerFivePThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
			towerFivePThree.setImage(towerImage);
		}
	}

	public void printTowerSixPThree(String color){
		if(!Objects.equals(color, "")){
			Image towerImage = new Image(color + "Tower.jpeg");
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
