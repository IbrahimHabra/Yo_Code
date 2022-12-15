package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import static sample.Enums.*;

public class AddictiveCipher extends Stage{
    private static double width = Enums.screenWidth, height = Enums.screenHeight;


    private SVGPath path = new SVGPath();
    private javafx.scene.control.Label cipherLabel = new javafx.scene.control.Label(" "+ProjectSitting.ciTy +" ");
    private javafx.scene.control.Label yoCode = new javafx.scene.control.Label("yo-CODE ");
    private javafx.scene.control.Label projectName = new javafx.scene.control.Label("  " + ProjectSitting.name + "  ");
    private ToggleButton codeDecode = new ToggleButton("Encrypt");
    private Spinner key = new Spinner(0,25,0);
    private javafx.scene.control.TextArea normal = new javafx.scene.control.TextArea();
    private javafx.scene.control.TextArea edited = new javafx.scene.control.TextArea();
    private javafx.scene.control.Button save = new javafx.scene.control.Button("Save");
    private javafx.scene.control.Label text = new javafx.scene.control.Label("Text :");
    private javafx.scene.control.Label encrypted = new Label("Encrypted :");
    private SVGPath yoCodeUI = new SVGPath();


    public AddictiveCipher() {
        normal.setTooltip(new Tooltip(comments[0]));
        edited.setTooltip(new Tooltip(comments[0]));
        key.setTooltip(new Tooltip(comments[1]));
        path.setContent("M10,15H0V0h25v0C25,8.3,18.3,15,10,15z");
        path.setFill(colors[3]);

        Group root = new Group();
        root.getChildren().addAll(yoCodeUI,path,cipherLabel,yoCode,projectName,codeDecode,normal,edited,save,text,encrypted,key);
        Scene scene = new Scene(root,screenWidth,screenHeight);
        scene.setFill(colors[4]);
        setWidth(screenWidth);
        setHeight(screenHeight);
        double w = getWidth(),h = getHeight();
        Font font1 = Font.loadFont(this.getClass().getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"),w/48);
        Font font2 = Font.loadFont(this.getClass().getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"),w/70);
        Font font4 = Font.loadFont(this.getClass().getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"),w/54);
        Font font5 = Font.loadFont(MainScene.class.getResourceAsStream("Fonts/static/Comfortaa-SemiBold.ttf"),width/35);
        Font font6 = Font.loadFont(this.getClass().getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"),w/30);
        Font font7 = Font.loadFont(this.getClass().getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"),width/20);


        setScene(scene);

        reTidy(getWidth(),getHeight());
        cipherLabel.setTranslateX(width/54.64);
        cipherLabel.setTranslateY(width/54.64);
        path.setScaleX(getWidth()/24);
        path.setScaleY(getHeight()/33);
        save.setPrefSize(w/6.3,h/20.2);
        codeDecode.setPrefSize(w/6.3,h/20.2);
        normal.setPrefSize(w/2.3,h/6.8375);
        edited.setPrefSize(w/2.3,h/6.8375);
        yoCode.setPrefSize(w/5.7,h/12.6);
        key.setPrefSize(w/6.3,h/20.2);
        projectName.setPrefHeight(h/12.04);
        projectName.setPrefWidth((w/11)*projectName.getText().length()/3.4);
        cipherLabel.setPrefHeight(h/8.64);

        cipherLabel.setTranslateX(getWidth()*0.03);
        cipherLabel.setTranslateY(getWidth()*0.03);
        path.setTranslateY(0);
        path.setTranslateX(0);
        yoCode.setTranslateY(h/25);
        normal.setTranslateX(getWidth()*0.05);
        edited.setTranslateX(getWidth()*0.05);
        text.setTranslateX(getWidth()*0.05);
        encrypted.setTranslateX(getWidth()*0.05);
        key.setTranslateX(getWidth()*0.725);

        yoCode.setTranslateX(getWidth() -(yoCode.getPrefWidth()+yoCode.getPrefWidth()/3));
        projectName.setTranslateX(getWidth()/2- projectName.getPrefWidth()/2);
        projectName.setTranslateY(getHeight()*0.27);
        codeDecode.setTranslateX(getWidth()/1.3);
        codeDecode.setTranslateY(getHeight()*0.7);
        normal.setTranslateX(getWidth()*0.05);
        normal.setTranslateY(getHeight()*0.46);
        edited.setTranslateY(getHeight()*0.7);
        save.setTranslateX(getWidth()/1.3);
        save.setTranslateY(getHeight()*0.793);
        text.setTranslateY(getHeight()*0.4);
        encrypted.setTranslateX(getWidth()*0.05);
        encrypted.setTranslateY(getHeight()*0.6433);
        key.setTranslateX(getWidth()/1.3);
        key.setTranslateY(getHeight()*0.5);

        yoCodeUI.setContent("M0,0L0,0h2.8v2.8l0,0C1.3,2.8,0,1.6,0,0z");
        yoCodeUI.setTranslateX(1500);
        yoCodeUI.setTranslateY(0);
        yoCodeUI.setScaleY(width *0.3);
        yoCodeUI.setScaleX(height *0.3);
        yoCodeUI.setFill(colors[2]);
        yoCode.setTranslateX(w*0.82325);
        yoCode.setTranslateY(h*0.03436);

        yoCode.setFont(font5);
        projectName.setFont(font6);
        codeDecode.setFont(font4);
        normal.setFont(font2);
        edited.setFont(font2);
        save.setFont(font4);
        text.setFont(font1);
        encrypted.setFont(font1);
        cipherLabel.setFont(font7);

        projectName.setAlignment(Pos.CENTER);
        projectName.setTextAlignment(TextAlignment.CENTER);
        normal.setWrapText(true);
        edited.setWrapText(true);
        key.setPromptText("Cipher here");


        styling();
        edited.setDisable(true);
        save.setText("back");


        key.setOnMouseClicked(e -> {
            try {
                if(!codeDecode.isSelected()){edited.setText(Addictive_Cipher(normal.getText(),(int)key.getValue()));}
                else{normal.setText(De_Addictive_Cipher(edited.getText(),(int)key.getValue()));}

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        normal.setOnKeyReleased(e -> {
            if (normal.getText().equals("")){
                save.setText("back");
            }else save.setText("save");
            edited.setText(Addictive_Cipher(normal.getText(), (int) key.getValue()));
        });
        edited.setOnKeyReleased(e -> {
            if (edited.getText().equals("")){
                save.setText("back");
            }else save.setText("save");
            normal.setText(De_Addictive_Cipher(edited.getText(), (int) key.getValue()));
        });
        widthProperty().addListener((observable,oldValue,newValue) ->{
            width = newValue.doubleValue();
            reTidy(width,height);
        });
        heightProperty().addListener((observable,oldValue,newValue) -> {
            height = newValue.doubleValue();
            reTidy(width,newValue.doubleValue());
        });
        save.setOnAction(e -> {
            System.out.println(getWidth());
            System.out.println(getHeight());
            if (normal.getText().equals("")){
                PrimaryStage.Show();
                MainScene.engine.reload();
                exit();}
            else save(edited.getText(),ProjectSitting.name,ProjectSitting.ciTy,(int) key.getValue());
        });
        codeDecode.setOnAction(e -> {
            if (codeDecode.isSelected()){
                normal.setDisable(true);
                edited.setDisable(false);
                codeDecode.setText("Decryption");
            }
            else {
                normal.setDisable(false);
                edited.setDisable(true);
                codeDecode.setText("Encrypt");
            }
        });
        setOnCloseRequest(e -> PrimaryStage.Show());


        setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().width/1.75 + Toolkit.getDefaultToolkit().getScreenSize().width/27.64);
        setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().height/1.45 + Toolkit.getDefaultToolkit().getScreenSize().height/14.88);



    }

    private  String Addictive_Cipher(String text, int cipher){
        char[] c =text.toCharArray();
        var key = cipher%26;
        for(var i = 0;i<c.length;i++){
            c[i] = AddMove(c[i], key);
        }
        StringBuilder result = new StringBuilder();

        for (char value : c) {
            result.append(value);
        }

        return result.toString();
    }

    float editor1;

    private  char AddMove(Character character,int key){
        if(character>=65&&character<=90){
            editor1 = (character+key);
            if(editor1 <=90){
                return (char)(editor1);
            }else{
                return (char)(editor1 %90+64);
            }
        }else if(character>=97&&character<=122){
            editor1 = (character+key);
            if(editor1 <=122){
                return (char) editor1;
            }else{
                return (char)(editor1 %122+96);
            }
        }else if(character>=48&&character<=57){
            editor1 = (character+key);
            if(editor1 <=57){
                return (char)(editor1);
            }else{
                return (char)(editor1 %57+47);
            }
        }else{
            return character;
        }
    }

    private String De_Addictive_Cipher(String text, int cipher){
        char[] c =text.toCharArray();
        var key = cipher%26;
        key = key * -1;
        for(var i = 0;i<c.length;i++){
            c[i] = DeAddMove(c[i], key);
        }
        StringBuilder result = new StringBuilder();

        for (char value : c) {
            result.append(value);
        }

        return result.toString();
    }

    float editor2;

    private char DeAddMove(Character character,int key){
        if(character>=65&&character<=90){
            editor2 = (character+key);
            if(editor2>=65){
                return (char)(editor2);
            }else{
                return (char)(editor2+(26));
            }
        }else if(character>=97&&character<=122){
            editor2 = (character+key);
            if(editor2>=97){
                return (char) editor2;
            }else{
                return (char)(editor2+(26));
            }
        }else if(character>=48&&character<=57){
            editor2 = (character+key);
            if(editor2>=48){
                return (char)(editor2);
            }else{
                return (char)(editor2+(10));
            }
        }else{
            return character;
        }
    }

    private void reTidy(double newWidth,double newHeight){
        yoCodeUI.setScaleX(newWidth/3.0/2.8);
        yoCodeUI.setScaleY(newHeight*0.15);
        yoCodeUI.setTranslateX(newWidth- yoCodeUI.getScaleX()*3.0/2.8);
        yoCodeUI.setTranslateY(0);
        path.setScaleX(newWidth/24);
        path.setScaleY(newHeight/33);
        save.setPrefSize(newWidth/6.3,newHeight/20.2);
        codeDecode.setPrefSize(newWidth/6.3,newHeight/20.2);
        normal.setPrefSize(newWidth/2.3,newHeight/6.8375);
        edited.setPrefSize(newWidth/2.3,newHeight/6.8375);
        key.setPrefSize(newWidth/6.3,newHeight/20.2);
        //yoCode.setTranslateX(newWidth - (yoCode.getPrefWidth()+yoCode.getPrefWidth()/3));
        yoCode.setTranslateX(newWidth*0.82325 + newWidth/90);
        projectName.setTranslateX(newWidth/2- projectName.getPrefWidth()/2);
        projectName.setTranslateY(newHeight*0.31);
        codeDecode.setTranslateX(newWidth/1.3);
        codeDecode.setTranslateY(newHeight*0.7);
        normal.setTranslateY(newHeight*0.46);
        edited.setTranslateY(newHeight*0.7);
        save.setTranslateX(newWidth/1.3);
        save.setTranslateY(newHeight*0.793);
        text.setTranslateY(newHeight*0.4);
        encrypted.setTranslateY(newHeight*0.6433);
        key.setTranslateX(newWidth/1.3);
        key.setTranslateY(newHeight*0.5);
        projectName.setPrefHeight(newHeight/12.44);

    }

    private void styling (){
        yoCode.setTextFill(colors[0]);
        cipherLabel.setTextFill(colors[0]);
        projectName.setTextFill(colors[0]);
        text.setTextFill(colors[0]);
        encrypted.setTextFill(colors[0]);
        save.setTextFill(colors[0]);
        codeDecode.setTextFill(colors[0]);
        save.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(5), Insets.EMPTY)));
        codeDecode.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(5),Insets.EMPTY)));
        projectName.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(1555),Insets.EMPTY)));
        cipherLabel.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(3000),new Insets(0))));
    }

    private static AddictiveCipher addictiveCipher = new AddictiveCipher();

    public static void launch(){
        addictiveCipher = new AddictiveCipher();
        addictiveCipher.show();
    }

    public static void exit(){
        addictiveCipher.hide();
    }

    private void save(String text,String projectName,String cipherName,int key){
        String[] texts;
        String[] projects;
        String[] ciphers;
        String[] keys;
        String jsText;
        String htmlText = Main.loadPageAsString();

        int length;
        jsText = htmlText.substring(9,htmlText.indexOf("</script>"));

        texts = jsText.substring(jsText.indexOf("var texts = \"") + 13,jsText.indexOf("\";var projects = \"")).split(encSym);
        projects = jsText.substring(jsText.indexOf("\";var projects = \"")+18,jsText.indexOf("\";var ciphers = ")).split(encSym);
        ciphers = jsText.substring(jsText.indexOf("\";var ciphers = ")+17,jsText.indexOf("\";var keys = \"")).split(encSym);
        keys = jsText.substring(jsText.indexOf("\";var keys = \"") + 14,jsText.lastIndexOf("\";")).split(encSym);
        length = keys.length;
        String[] text2 = new String[length+1],project2 = new String[length+1],cipher = new String[length+1],key2 = new String[length+1];
        System.arraycopy(texts, 0, text2, 1, length - 1 + 1);
        text2[0] = text.replaceAll(encSym,"");
        System.arraycopy(projects, 0, project2, 1, length - 1 + 1);
        project2[0] = projectName.replaceAll(encSym,"");
        System.arraycopy(ciphers, 0, cipher, 1, length - 1 + 1);
        cipher[0] = cipherName;
        System.arraycopy(keys, 0, key2, 1, length - 1 + 1);
        key2[0] = String.valueOf(key);
                String finalText =
                "var texts = \"" + ProGenerator(text2) + "\";" +
                "var projects = \"" + ProGenerator(project2) + "\";" +
                "var ciphers = \"" + ProGenerator(cipher) + "\";" +
                "var keys = \"" + ProGenerator(key2) + "\";";
        FileOutputStream  fos ;
        try {
            fos = new FileOutputStream(pathOfXML);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            osw.write(before + finalText + after);
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrimaryStage.Show();
        MainScene.reload();
        exit();
    }

    private String ProGenerator(String[] array){
        String finalText = "";
        for (String s : array) {
            finalText += s + encSym;
        }
        finalText = finalText.substring(0,finalText.lastIndexOf(encSym));
        return finalText;
    }

}
