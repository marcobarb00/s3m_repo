package it.polimi.ingsw.s3m.launcher.Client.View.GuiController;

import it.polimi.ingsw.s3m.launcher.Client.View.GUI.*;
import it.polimi.ingsw.s3m.launcher.Communication.Response;
import it.polimi.ingsw.s3m.launcher.Server.Message.ErrorMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.LoginMessage;
import it.polimi.ingsw.s3m.launcher.Server.Message.NotificationMessage;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerGUI {

    private ClientGUI thread;
    private static ControllerGUI INSTANCE;
    private Stage primaryStage;
    private Stage secondaryStage;
    private LoadingScreenGUI loadingScreenGUI;
    private ErrorGUI errorGui;
    private NewRoomGUI newRoomGUI;
    private NotificationGUI notificationGUI;
    private NewRoomGUI numOfPlayerGUI;

    private ControllerGUI() {
        secondaryStage = new Stage();
        secondaryStage.setTitle("Eriantys");
        secondaryStage.getIcons().add(new Image("eriantysImage.png"));
        secondaryStage.setResizable(false);

    }

    public static ControllerGUI getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ControllerGUI();
        return INSTANCE;
    }

    public void startGame(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("FirstImage.fxml"));
        } catch (IOException e) {
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

    public void threadSleep(int millis) {
        try {
            thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closePrimaryStage() {
        Platform.runLater(() -> {
            primaryStage.close();
        });
    }


    private void setScene(Parent root)  {
        Scene gameScene = new Scene(root);
        Platform.runLater(() -> {
            secondaryStage.setScene(gameScene);
            secondaryStage.centerOnScreen();
            secondaryStage.setResizable(false);
            secondaryStage.show();
            loadingScreenGUI.stop();
        });
    }

    public void launchNotification(NotificationMessage object) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Notification.fxml"));
            Parent notificationGui = (Parent) loader.load();
            this.notificationGUI = loader.getController();
            this.notificationGUI.insert(object);
            setScene(notificationGui);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void launchNumOfPlayerGui() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("EnterRoom.fxml"));
            Parent showNumOfPlayers = (Parent) loader.load();
            setScene(showNumOfPlayers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void launchNewRoom(LoginMessage object) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("EnterRoom.fxml"));
            Parent root = (Parent) loader.load();
            newRoomGUI = loader.getController();
            newRoomGUI.setCreatedRoom((LoginMessage) object, secondaryStage);
            setScene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void launchGameConfigMessage(GameConfigMessage message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("GameConfig.fxml"));
            Parent gameConfig = (Parent) loader.load();
            setScene(gameConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public void closeSocket() {
        thread.close();
    }

    public void sendObject(Response response) {
        thread.communicate(response);

    }

    public void startLoading() {
        loadingScreenGUI.start();
    }

    public void launchError(ErrorMessage message) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Error.fxml"));
            Parent error = (Parent) loader.load();
            this.errorGui = loader.getController();
            this.errorGui.insert(message);
            setScene(error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
