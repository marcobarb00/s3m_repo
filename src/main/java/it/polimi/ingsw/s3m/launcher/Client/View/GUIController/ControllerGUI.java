package it.polimi.ingsw.s3m.launcher.Client.View.GUIController;

import it.polimi.ingsw.s3m.launcher.Client.Response.NewRoomResponse;
import it.polimi.ingsw.s3m.launcher.Client.Response.PlayCharacterCardResponse;
import it.polimi.ingsw.s3m.launcher.Client.View.GUI.*;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerGUI{

	private ClientGUI thread;
	private static ControllerGUI INSTANCE;
	private Stage primaryStage;
	private final Stage secondaryStage;
	private LoadingScreenGUI loadingScreenGUI;
	private ErrorGUI errorGui;
	private NewRoomGUI newRoomGUI;
	private EnterRoomGUI enterRoomGUI;
	private NotificationGUI notificationGUI;
	private JesterGUI jesterGUI;
	private ArrayList<String> jesterStudents;
	private MinstrelGUI minstrelGUI;
	private MushroomerGUI mushroomerGUI;
	private final NewRoomResponse newRoomResponse = new NewRoomResponse();
	private PlayCharacterCardResponse playCharacterCardResponse = new PlayCharacterCardResponse();
	private PlayCharacterCardGUI playCharacterCardGUI;
	private PlanningPhaseGUI planningPhaseGUI;
	private MoveStudentsPhaseGUI moveStudentsPhaseGUI;
	private PutStudentOnTableGUI putStudentOnTableGUI;
	private PutStudentOnIslandGUI putStudentOnIslandGUI;
	private MotherNaturePhaseGUI motherNaturePhaseGUI;
	private MoveMotherNatureGUI moveMotherNatureGUI;
	private CloudPhaseGUI cloudPhaseGUI;

	private ControllerGUI(){
		secondaryStage = new Stage();
		secondaryStage.setTitle("Eriantys");
		secondaryStage.getIcons().add(new Image("eriantysImage.png"));
		//secondaryStage.setResizable(false);
	}

	public static ControllerGUI getInstance(){
		if(INSTANCE == null)
			INSTANCE = new ControllerGUI();
		return INSTANCE;
	}

	public NewRoomResponse getNewRoomResponse(){
		return newRoomResponse;
	}

	public void startGame(Stage primaryStage){

		this.primaryStage = primaryStage;
		primaryStage.initStyle(StageStyle.UNDECORATED);
		/*
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FirstImage.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root));
		primaryStage.centerOnScreen();
		primaryStage.show();
		*/
		thread = new ClientGUI();
		thread.start();
		loadingScreenGUI = new LoadingScreenGUI(secondaryStage);
		secondaryStage.setOnCloseRequest(e -> Platform.runLater(() -> {
			Platform.exit();
			System.exit(0);
		}));
	}

	public PlayCharacterCardResponse getPlayCharacterCardResponse(){
		return playCharacterCardResponse;
	}

	public void setJesterStudents(ArrayList<String> jesterStudents){
		this.jesterStudents = jesterStudents;
	}

	public ArrayList<String> getJesterStudents(){
		return jesterStudents;
	}

	public void threadSleep(int millis){
		try{
			Thread.sleep(millis);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void closePrimaryStage(){
		Platform.runLater(() -> {
			primaryStage.close();
		});
	}

	private void setScene(Parent root){
		Scene gameScene = new Scene(root);
		Platform.runLater(() -> {
			secondaryStage.setScene(gameScene);
			//secondaryStage.centerOnScreen();
			//secondaryStage.setResizable(false);
			secondaryStage.show();
			loadingScreenGUI.stop();
		});
	}

	public void launchNotification(NotificationMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Notification.fxml"));
			Parent notificationGui = loader.load();
			this.notificationGUI = loader.getController();
			this.notificationGUI.insert(message);
			setScene(notificationGui);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchLogin(LoginMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Login.fxml"));
			Parent loginGUI = loader.load();
			setScene(loginGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchNewRoom(NewRoomMessage message){
		launchNumOfPlayerGui();
	}

	public void launchNumOfPlayerGui(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("NumOfPlayers.fxml"));
			Parent showNumOfPlayers = loader.load();
			setScene(showNumOfPlayers);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchGameConfigMessage(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GameConfig.fxml"));
			Parent gameConfigGUI = loader.load();
			setScene(gameConfigGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchSetNickname(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("SetNickname.fxml"));
			Parent setNicknameGUI = loader.load();
			setScene(setNicknameGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchEnterRoom(EnterRoomMessage enterRoomMessage){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("EnterRoom.fxml"));
			Parent enterRoom = loader.load();
			enterRoomGUI = loader.getController();
			enterRoomGUI.setCreatedRoom(enterRoomMessage);
			setScene(enterRoom);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void closeSocket(){
		thread.close();
	}


	public void sendResponse(Response response){
		thread.communicate(response);

	}

	public void startLoading(){
		loadingScreenGUI.start();
	}

	public void launchError(ErrorMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Error.fxml"));
			Parent error = loader.load();
			this.errorGui = loader.getController();
			this.errorGui.insert(message);
			setScene(error);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchPlanningPhase(PlanningPhaseMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PlanningPhase.fxml"));
			Parent playCharacterCard = loader.load();
			planningPhaseGUI = loader.getController();
			planningPhaseGUI.printMessageInformation(message);
			setScene(playCharacterCard);
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void launchMoveStudentsPhase(StudentsPhaseMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MoveStudentsPhase.fxml"));
			Parent moveStudents = loader.load();
			moveStudentsPhaseGUI = loader.getController();
			moveStudentsPhaseGUI.printMessageInformation(message);
			setScene(moveStudents);
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void launchMotherNaturePhase(MotherNaturePhaseMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MotherNaturePhase.fxml"));
			Parent motherNature = loader.load();
			motherNaturePhaseGUI = loader.getController();
			motherNaturePhaseGUI.printMessageInformation(message);
			setScene(motherNature);
		}catch(IOException e){
			e.printStackTrace();
		}

	}

	public void launchCloudPhase(CloudPhaseMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CloudPhase.fxml"));
			Parent cloud = loader.load();
			cloudPhaseGUI = loader.getController();
			cloudPhaseGUI.printMessageInformation(message);
			setScene(cloud);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchPutStudentOnTable(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PutStudentOnTable.fxml"));
			Parent setStudentOnTableGUI = loader.load();
			setScene(setStudentOnTableGUI);
			putStudentOnTableGUI = loader.getController();
			putStudentOnTableGUI.putStudentOnTable();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchPutStudentOnIsland(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("PutStudentOnIsland.fxml"));
			Parent setStudentOnIslandGUI = loader.load();
			setScene(setStudentOnIslandGUI);
			putStudentOnIslandGUI = loader.getController();
			putStudentOnIslandGUI.putStudentOnIsland();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchMoveMotherNature(MoveMotherNatureMessage moveMotherNatureMessage){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MoveMotherNature.fxml"));
			Parent setMotherNatureOnIslandGUI = loader.load();
			setScene(setMotherNatureOnIslandGUI);
			moveMotherNatureGUI = loader.getController();
			moveMotherNatureGUI.printMessageInformation(moveMotherNatureMessage);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchPlayCharacterCard(PlayCharacterCardMessage message){
		playCharacterCardResponse = new PlayCharacterCardResponse();
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CharacterCardActivation.fxml"));
			Parent playCharacterCard = loader.load();
			playCharacterCardGUI = loader.getController();
			playCharacterCardGUI.inizialize(message);
			setScene(playCharacterCard);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void sendCharacterCardResponse(){
		this.sendResponse(ControllerGUI.getInstance().getPlayCharacterCardResponse());
		this.startLoading();
	}

	public void launchMushroomer(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Mushroomer.fxml"));
			Parent setMushroomerGUI = loader.load();
			mushroomerGUI = loader.getController();
			mushroomerGUI.showMushroomerInfo();
			setScene(setMushroomerGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchMinstrel(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Minstrel.fxml"));
			Parent setMinstrelGUI = loader.load();
			minstrelGUI = loader.getController();
			minstrelGUI.showMinstrelInfo();
			setScene(setMinstrelGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchJester(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Jester.fxml"));
			Parent setJesterGUI = loader.load();
			jesterGUI = loader.getController();
			jesterGUI.showJesterInfo();
			setScene(setJesterGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
