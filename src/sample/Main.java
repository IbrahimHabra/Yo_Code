package sample;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static sample.Enums.*;


public class Main extends Application {



    public void start(Stage primaryStage){
        Font.loadFont(getClass().getResourceAsStream("style/Comfortaa.ttf"), 16);
        this.getClass().getResourceAsStream("../../../XMLRequest.js");

        primaryStage = PrimaryStage.get();
        primaryStage.setTitle("yo_CODE");
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String loadPageAsString(){
        String stringBuilder = "";
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(pathOfXML));
            BufferedReader reader = new BufferedReader(isr);
            int c ;

            while((c = reader.read()) != -1){
                stringBuilder += (char)c;
            }
        }  catch (IOException e) {
            FileOutputStream fos ;
            try {
                fos = new FileOutputStream(pathOfXML);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                osw.write(allText);
                osw.flush();
                osw.close();
                return loadPageAsString();
                } catch (IOException ignored) {
            }
        }
        return stringBuilder;
    }
}
