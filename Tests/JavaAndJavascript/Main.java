package JavaAndJavascript;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        webView.setPrefSize(600,400);
        Pane root = new Pane(webView);
        engine.load(this.getClass().getResource("Test.html").toExternalForm());
        engine.setOnAlert(e -> {
            JOptionPane.showMessageDialog(null,e.getData());
        });
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }
}
