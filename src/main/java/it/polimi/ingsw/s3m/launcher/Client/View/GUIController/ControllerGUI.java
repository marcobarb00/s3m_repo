package it.polimi.ingsw.s3m.launcher.Client.View.GUIController;

import it.polimi.ingsw.s3m.launcher.Client.Response.NewRoomResponse;
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

public class ControllerGUI{

	private ClientGUI thread;
	private static ControllerGUI INSTANCE;
	private Stage primaryStage;
	private Stage secondaryStage;
	private LoadingScreenGUI loadingScreenGUI;
	private ErrorGUI errorGui;
	private NewRoomGUI newRoomGUI;
	private EnterRoomGUI enterRoomGUI;
	private NotificationGUI notificationGUI;
	private NewRoomResponse newRoomResponse = new NewRoomResponse();
	private GameStateGUI islandsAndDashboardGUI;

	private ControllerGUI(){
		secondaryStage = new Stage();
		secondaryStage.setTitle("Eriantys");
		secondaryStage.getIcons().add(new Image("eriantysImage.png"));
		secondaryStage.setResizable(false);

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
		Parent root = null;
		try{
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FirstImage.fxml"));
		}catch(IOException e){
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root));
		primaryStage.centerOnScreen();
		primaryStage.show();
		thread = new ClientGUI(this);
		thread.start();
		loadingScreenGUI = new LoadingScreenGUI(secondaryStage);
		secondaryStage.setOnCloseRequest(e -> Platform.runLater(() -> {
			Platform.exit();
			System.exit(0);
		}));
	}

	public void threadSleep(int millis){
		try{
			thread.sleep(millis);
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
			secondaryStage.centerOnScreen();
			secondaryStage.setResizable(false);
			secondaryStage.show();
			loadingScreenGUI.stop();
		});
	}

	public void launchNotification(NotificationMessage message){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Notification.fxml"));
			Parent notificationGui = (Parent) loader.load();
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
			Parent loginGUI = (Parent) loader.load();
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
			Parent showNumOfPlayers = (Parent) loader.load();
			setScene(showNumOfPlayers);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchGameConfigMessage(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GameConfig.fxml"));
			Parent gameConfigGUI = (Parent) loader.load();
			setScene(gameConfigGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchSetNickname(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("SetNickname.fxml"));
			Parent setNicknameGUI = (Parent) loader.load();
			setScene(setNicknameGUI);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void launchEnterRoom(EnterRoomMessage enterRoomMessage){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("EnterRoom.fxml"));
			Parent enterRoom = (Parent) loader.load();
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
			Parent error = (Parent) loader.load();
			this.errorGui = loader.getController();
			this.errorGui.insert(message);
			setScene(error);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

    /*public void IslandsAndDashboard(GameStateMessage gameStateMessage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(".fxml"));
            Parent showGame = (Parent) loader.load();
            islandsAndDashboardGUI = loader.getController();
            if (gameStateMessage instanceof GameStateMessage) {
                islandsAndDashboardGUI.update((GameStateMessage) gameStateMessage, secondaryStage);
                currentIslandsAndDashboardGUI = (GameStateMessage) gameStateMessage;
            }
            islandsAndDashboardGUI.inizializeForAction(currentIslandsAndDashboardGUI, secondaryStage);
            setScene(showGame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
