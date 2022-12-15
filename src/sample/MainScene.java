package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.concurrent.Worker.State;

import javax.swing.*;

import static sample.Enums.colors;

public class MainScene extends Group {








    static String html;
    Label logoLabel = new Label("Your Encrypts  ");
    Button newButton = new Button("+");
    SVGPath logoPath = new SVGPath();
    SVGPath yoCodeUI = new SVGPath();
    Label yoCode = new Label("yo-CODE ");
    public double width = Enums.screenWidth, height = Enums.screenHeight;
    Font font1 = Font.loadFont(MainScene.class.getResourceAsStream("Fonts/static/Comfortaa-SemiBold.ttf"),width/20);
    Font font2 = Font.loadFont(MainScene.class.getResourceAsStream("Fonts/static/Comfortaa-SemiBold.ttf"),width/34);
    static WebView webView = new WebView();
   static WebEngine engine = webView.getEngine();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    Button deleteButton = new Button("-\n ");
    public MainScene(double width, double height){



        webView.setTranslateX(0);
        webView.setTranslateY(height/3);
        webView.setPrefSize(width/1.23,height * 0.875);

        yoCode.setTranslateX(width / 1.4);
        yoCode.setTranslateY(height / 15);
        yoCode.setTextFill(colors[0]);
        yoCode.setFont(font2);

        logoLabel.setTranslateX(width/54.64);
        logoLabel.setTranslateY(width/54.64);

        newButton.setTranslateX(width / 1.1311068175545128346674027049407);
        newButton.setTranslateY(height / 1.2104563579973416038989809481613);

        logoLabel.setPrefSize(width/2.049,width/10.928);
        newButton.setPrefSize(width / 9.27,width / 9.27);
        deleteButton.setPrefSize(width / 10.1,width / 10.1);

        logoLabel.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(300),new Insets(0))));
        newButton.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(3000),new Insets(0))));
        deleteButton.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(3000),new Insets(0))));

        logoLabel.setFont(font1);
        newButton.setFont(font1);
        deleteButton.setFont(font1);


        logoLabel.setTextFill(colors[0]);
        newButton.setTextFill(colors[0]);
        deleteButton.setTextFill(colors[0]);

        yoCodeUI.setContent("M0,0L0,0h2.8v2.8l0,0C1.3,2.8,0,1.6,0,0z");
        yoCodeUI.setTranslateX(1500);
        yoCodeUI.setTranslateY(0);
        yoCodeUI.setScaleY(width *0.3);
        yoCodeUI.setScaleX(height *0.3);
        yoCodeUI.setFill(colors[2]);

        logoLabel.setAlignment(Pos.CENTER);
        logoPath.setContent("M0.1,2.8L0.1,2.8L0,0l2.8,0v0C2.8,1.5,1.6,2.8,0.1,2.8z");
        logoPath.setFill(colors[3]);
        logoPath.setScaleX(20);
        logoPath.setScaleY(20);
        deleteButton.setTextAlignment(TextAlignment.CENTER);
        deleteButton.setWrapText(true);

        deleteButton.setTranslateY(newButton.getTranslateY()-(deleteButton.getPrefHeight() + deleteButton.getPrefHeight()*0.2));
        deleteButton.setTranslateX(newButton.getTranslateX()+(newButton.getPrefWidth()-deleteButton.getPrefWidth())/2);



        html = Main.loadPageAsString();
        engine.loadContent(html);

        webView.getStylesheets().add("sample/style/scrollBarStyle.css");
        //webView.applyCss();
        engine.setJavaScriptEnabled(true);
        engine.onErrorProperty().addListener(e -> JOptionPane.showMessageDialog(null,e));
        //sample/style/scrollBarStyle.css

        engine.getLoadWorker().stateProperty().addListener(
                (ov, oldState, newState) -> {

                    if (newState == State.SUCCEEDED) {
                        System.out.println("called");
                    }

                });







        getChildren().addAll(logoPath,logoLabel,yoCodeUI,yoCode,webView,newButton,deleteButton);
        engine.setOnAlert(e -> {
            alert.setTitle("Done ");
            alert.setHeaderText("");
            alert.setContentText(e.getData());
            alert.show();
        });



    }

    protected void reTide(double newWidth,double newHeight){
        logoPath.setScaleX(newWidth*0.5);
        logoPath.setScaleY(newHeight*(2.2/8.0));
        newButton.setTranslateX(newWidth-newButton.getWidth()*1.5);
        newButton.setTranslateY(newHeight-newButton.getHeight()*1.5-17);
        yoCodeUI.setScaleX(newWidth/3.0/2.8);
        yoCodeUI.setScaleY(newHeight*0.15);
        yoCodeUI.setTranslateX(newWidth- yoCodeUI.getScaleX()*3.0/2.8);
        yoCodeUI.setTranslateY(0);
        yoCode.setTranslateX(newWidth - (yoCode.getWidth()+newWidth/30));
        yoCode.setTranslateY(newHeight /25  );
        webView.setTranslateX(0);
        webView.setTranslateY(newHeight/3);
        webView.setPrefSize(newWidth-(newWidth - newButton.getTranslateX() + newWidth*0.01),newHeight*0.935-webView.getTranslateY());
        deleteButton.setTranslateY(newButton.getTranslateY()-(deleteButton.getPrefHeight() + deleteButton.getPrefHeight()*0.16));
        deleteButton.setTranslateX(newButton.getTranslateX()+(newButton.getPrefWidth()-deleteButton.getPrefWidth())/2);
    }

    public static void reload(){
        MainScene.html = Main.loadPageAsString();
        MainScene.engine.loadContent("");
        MainScene.engine.loadContent(MainScene.html);
        MainScene.engine.reload();
    }


}
