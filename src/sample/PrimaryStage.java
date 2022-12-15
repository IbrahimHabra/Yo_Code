package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.awt.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class PrimaryStage extends Stage {
    public PrimaryStage(){
        MainScene mainScene = new MainScene(Enums.screenWidth, Enums.screenHeight);
        Scene scene = new Scene(mainScene,
                Enums.screenWidth, Enums.screenHeight,Enums.colors[4]);
        scene.getStylesheets().add("sample/style/SBS.css");
        setScene(scene);

        setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().width/1.75 + Toolkit.getDefaultToolkit().getScreenSize().width/27.64);
        setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().height/1.45 + Toolkit.getDefaultToolkit().getScreenSize().height/14.88);
        widthProperty().addListener(((observable, oldValue, newValue) -> {
            mainScene.width = newValue.doubleValue();
            mainScene.reTide(mainScene.width,mainScene.height);
        }));

        setOnCloseRequest((WindowEvent e) -> System.exit(5));



        heightProperty().addListener(((observable, oldValue, newValue) -> {
            mainScene.height = newValue.doubleValue();
            mainScene.reTide(mainScene.width,mainScene.height);
        }));

        mainScene.newButton.setOnAction((ActionEvent e) -> {
            MainScene.html = Main.loadPageAsString();
            MainScene.engine.loadContent("");
            MainScene.engine.loadContent(MainScene.html);
            MainScene.engine.reload();
            ProjectSitting.launch();
        });

        mainScene.deleteButton.setOnAction(e -> {
            DeleteUI.exit();
            DeleteUI.launch();
        });
        show();
    }

    private static PrimaryStage primaryStage = new PrimaryStage();

    public static Stage get(){
        return primaryStage;
    }

    public static void exit(){
        primaryStage.hide();
    }

    public static void Show(){primaryStage.show();}

}
