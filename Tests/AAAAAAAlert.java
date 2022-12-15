import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;

public class AAAAAAAlert extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        URL url = this.getClass().getResource("jaja.html");
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url.toExternalForm());
        webEngine.setOnAlert(event -> showAlert(event.getData()));


        Group root = new Group();
        root.getChildren().add(webView);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void showAlert(String message) {
        Dialog<Void> alert = new Dialog<>();
        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();
    }

}
