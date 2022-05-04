package it.polimi.ingsw.s3m.launcher.Client.View.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoadingScreenGUI {

    private Stage loadingStage;
    private ProgressIndicator loading;
    private TextArea notification;

    public LoadingScreenGUI(Stage secondaryStage) {
        loadingStage = new Stage();
        loadingStage.initStyle(StageStyle.TRANSPARENT);
        Label label = new Label("Loading");
        label.setFont(new Font(30));
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-background-color: transparent");
        loading = new ProgressIndicator();
        loading.setStyle("-fx-background-color: transparent");
        loading.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
        loading.setMinSize(200,200);
        notification = new TextArea();
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: transparent");
        vBox.getChildren().addAll(loading,label);
        vBox.setAlignment(Pos.CENTER);
        Scene loadingScene = new Scene(vBox);
        loadingScene.setFill(Color.TRANSPARENT);
        loadingStage.setScene(loadingScene);
    }

    public void write(String message) {
        notification.setText(message);
    }

    public void stop() {
        loadingStage.hide();
    }

    public void start() {
        loadingStage.show();
    }
}
