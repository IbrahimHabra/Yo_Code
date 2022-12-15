package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
import static sample.MorseCodes.*;

public class MorseCode extends Stage {
    private static double width = Enums.screenWidth, height = Enums.screenHeight;
    private static SVGPath path = new SVGPath();
    private static javafx.scene.control.Label cipherLabel = new javafx.scene.control.Label(" "+ProjectSitting.ciTy+ " ");
    private static javafx.scene.control.Label yoCode = new javafx.scene.control.Label("yo-CODE ");
    private static javafx.scene.control.Label projectName = new javafx.scene.control.Label("  " + ProjectSitting.name + "  ");
    private static TextArea normal = new TextArea();
    private static TextArea edited = new TextArea();
    private static javafx.scene.control.Button save = new javafx.scene.control.Button("Save");
    private static javafx.scene.control.Label text = new javafx.scene.control.Label("Text :");
    private static javafx.scene.control.Label encrypted = new Label("Encrypted :");
    private static SVGPath yoCodeUI = new SVGPath();

    public MorseCode() {
        path.setContent("M10,15H0V0h25v0C25,8.3,18.3,15,10,15z");
        path.setFill(colors[3]);
        normal.setTooltip(new Tooltip(comments[2]));
        edited.setTooltip(new Tooltip(comments[3]));

        Group root = new Group();
        root.getChildren().addAll(yoCodeUI,path,cipherLabel,yoCode,projectName,normal,edited,save,text,encrypted);
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
        normal.setPrefSize(w/2.3,h/6.8375);
        edited.setPrefSize(w/2.3,h/6.8375);
        yoCode.setPrefSize(w/5.7,h/12.6);
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

        yoCode.setTranslateX(getWidth() -(yoCode.getPrefWidth()+yoCode.getPrefWidth()/3));
        projectName.setTranslateX(getWidth()/2- projectName.getPrefWidth()/2);
        projectName.setTranslateY(getHeight()*0.27);
        normal.setTranslateX(getWidth()*0.05);
        normal.setTranslateY(getHeight()*0.46);
        edited.setTranslateY(getHeight()*0.7);
        save.setTranslateX(getWidth()/1.3);
        save.setTranslateY(getHeight()*0.793);
        text.setTranslateY(getHeight()*0.4);
        encrypted.setTranslateX(getWidth()*0.05);
        encrypted.setTranslateY(getHeight()*0.6433);

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

        styling();
        save.setText("back");



        normal.setOnKeyReleased(e -> {
            if (normal.getText().equals("")){
                save.setText("back");
            }else save.setText("save");
            edited.setText(Coder(normal.getText()));
        });
        edited.setOnKeyReleased(e -> {
            if (edited.getText().equals("")){
                save.setText("back");
            }else save.setText("save");
            normal.setText(DeCoder(edited.getText()));
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
            else save(edited.getText().replace("_","   "),ProjectSitting.name,ProjectSitting.ciTy);
        });
        setMinWidth(Toolkit.getDefaultToolkit().getScreenSize().width/1.75 + Toolkit.getDefaultToolkit().getScreenSize().width/27.64);
        setMinHeight(Toolkit.getDefaultToolkit().getScreenSize().height/1.45 + Toolkit.getDefaultToolkit().getScreenSize().height/14.88);

    }

    private String Coder(String text) {
        if (text.equals("")) return "";
        else {
            text = (text.toLowerCase());
            StringBuilder d = new StringBuilder();
            String[] c;
            c = text.split("");
            for (String s : c) {
                if (s.equals("\n")) {
                    d.append("\n");
                    d.append(" ");
                    continue;
                }
                if (s.equals(" ")) {
                    d.append(space);
                    d.append(" ");
                    continue;
                }
                if (s.equals(".")) {
                    d.append(dot);
                    d.append(" ");
                    continue;
                }
                if (s.equals(",")) {
                    d.append(comma);
                    d.append(" ");
                    continue;
                }
                if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
                    d.append(numbers[s.charAt(0) - 48]);
                    d.append(" ");
                    continue;
                }
                if (s.charAt(0) >= 97 && s.charAt(0) <= 122) {
                    d.append(letters[s.charAt(0) - 97]);
                    d.append(" ");
                    continue;
                }
                if (s.charAt(0) < 48 || s.charAt(0) > 57 && s.charAt(0) < 97 || s.charAt(0) > 122) {
                    d.append("?");
                    d.append(" ");
                    continue;
                }
                d.append(s);
                d.append(" ");
            }
            return d.toString();
        }
    }

    private String DeCoder(String text) {
        String string = "";
        String[] codes = text.split(" ");
        for (String code : codes) {
            for (var j = 0; j < 26; j++) {
                if (code.equals(letters[j])) {
                    string += Character.toString((char)(( j + 97)));
                }
            }
            for (var j = 0; j < 10; j++) {
                if (code.equals(numbers[j])) {
                    string += Character.toString((char)( j + 48));
                }
            }
            switch (code) {
                case space:
                    string += (" ");
                    break;
                case comma:
                    string += (",");
                    break;
                case dot:
                    string += (".");
                    break;
                case "\n":
                    string += ("\n");
                    break;
                case "   ":
                    string += ("");
                    break;
            }
        }
        return (string);
    }

    private void reTidy(double newWidth,double newHeight){
        yoCodeUI.setScaleX(newWidth/3.0/2.8);
        yoCodeUI.setScaleY(newHeight*0.15);
        yoCodeUI.setTranslateX(newWidth- yoCodeUI.getScaleX()*3.0/2.8);
        yoCodeUI.setTranslateY(0);
        path.setScaleX(newWidth/24);
        path.setScaleY(newHeight/33);
        save.setPrefSize(newWidth/6.3,newHeight/20.2);
        normal.setPrefSize(newWidth/2.3,newHeight/6.8375);
        edited.setPrefSize(newWidth/2.3,newHeight/6.8375);
        //yoCode.setTranslateX(newWidth - (yoCode.getPrefWidth()+yoCode.getPrefWidth()/3));
        yoCode.setTranslateX(newWidth*0.82325 + newWidth/90);
        projectName.setTranslateX(newWidth/2- projectName.getPrefWidth()/2);
        projectName.setTranslateY(newHeight*0.31);
        normal.setTranslateY(newHeight*0.46);
        edited.setTranslateY(newHeight*0.7);
        save.setTranslateX(newWidth/1.3);
        save.setTranslateY(newHeight*0.793);
        text.setTranslateY(newHeight*0.4);
        encrypted.setTranslateY(newHeight*0.6433);
        projectName.setPrefHeight(newHeight/12.44);

    }

    private void styling (){
        yoCode.setTextFill(colors[0]);
        cipherLabel.setTextFill(colors[0]);
        projectName.setTextFill(colors[0]);
        text.setTextFill(colors[0]);
        encrypted.setTextFill(colors[0]);
        save.setTextFill(colors[0]);
        save.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(5), javafx.geometry.Insets.EMPTY)));
        projectName.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(1555), javafx.geometry.Insets.EMPTY)));
        cipherLabel.setBackground(new Background(new BackgroundFill(colors[1],new CornerRadii(3000),new Insets(0))));
    }

    private static MorseCode morseCode = new MorseCode();

    public static void launch(){
        morseCode = new MorseCode();
        morseCode.show();
    }

    public static void exit(){
        morseCode.hide();
    }

    private void save(String text, String projectName, String cipherName){
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
        key2[0] = "this cipher has no key";
        String finalText =
                "var texts = \"" + ProGenerator(text2) + "\";" +
                        "var projects = \"" + ProGenerator(project2) + "\";" +
                        "var ciphers = \"" + ProGenerator(cipher) + "\";" +
                        "var keys = \"" + ProGenerator(key2) + "\";";
        FileOutputStream fos ;
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
