package sample;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;


public class ProjectSitting extends Stage {
    static String name = "";
    static String ciTy = "";


    private static final Font font = Font.loadFont(ProjectSitting.class.getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"),18);
    private static final Label labelC = new Label("Cipher Type :");
    private static final Label labelN = new Label("Project Name :");
    private static final TextField pn = new TextField();
    private static final ComboBox<String> comboBox = new ComboBox<>();
    private static final Pane root = new Pane();
    static Scene scene = new Scene(root,360,276);
    static ProjectSitting projectSitting = new ProjectSitting();
    private static Separator separator;
    private static Button OK ;
    private static Button cancel ;


    public static void launch(){
        pn.setTooltip(new Tooltip(Enums.comments[7]));
        pn.setText("");
        comboBox.setValue("");
        root.setBackground(new Background(new BackgroundFill(Enums.colors[5], CornerRadii.EMPTY, Insets.EMPTY)));


        Tidy();
        labelN.setTranslateX(30);
        labelC.setTranslateX(30);
        pn.setTranslateX(30);
        comboBox.setTranslateX(30);

        labelN.setTranslateY(20);
        pn.setTranslateY(50);
        labelC.setTranslateY(90);
        comboBox.setTranslateY(120);

        comboBox.setPrefWidth(300);
        comboBox.setPrefHeight(40);

        separator.setTranslateY(185);
        separator.setTranslateX(30);
        separator.setPrefWidth(300);

        pn.setPrefWidth(300);

        OK.setTranslateX(30);
        OK.setTranslateY(205);
        OK.setPrefSize(140,50);
        cancel.setTranslateX(190);
        cancel.setTranslateY(205);
        cancel.setPrefSize(140,50);



    }

    private ProjectSitting(){
        initStyle(StageStyle.TRANSPARENT);
        separator  = new Separator(Orientation.HORIZONTAL);
        OK = new Button("OK");
        cancel = new Button("Cancel");
        setResizable(false);
        comboBox.getItems().addAll("Caesar Cipher","KeyLess Transposition Cipher","Morse Code","Momoalphabetic Cipher","Vigenere Cipher");
        comboBox.setStyle("");
        /*comboBox.setCellFactory(
                new Callback<>() {
                    @Override
                    public ListCell<String> call(ListView<String> param) {
                        return new ListCell<>() {
                            @Override
                            public void updateItem(String item,
                                                   boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    setText(item);
                                    setFont(Font.loadFont(this.getClass().getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"), 16.0)); //set your desired size
                                    setTextFill(Enums.colors[0]);
                                    setStyle("-fx-background-color:#"+Enums.colors[1].toString().substring(2,8)+";");
                                    setOnMouseEntered((MouseEvent e) -> setStyle("-fx-background-color:#"+Enums.colors[2].toString().substring(2,8)+";"));
                                    setOnMouseExited((MouseEvent e) -> setStyle("-fx-background-color:#"+Enums.colors[1].toString().substring(2,8)+";"));
                                } else {
                                    setText(null);
                                }
                            }
                        };
                    }

                });*/



        root.getChildren().addAll(labelC,labelN,pn,comboBox,separator,OK,cancel);
        setIconified(false);
        setTitle("New Project ");
        cancel.setOnAction(event -> {
            pn.setText("");
            comboBox.setValue("");
            hide();
        });

        comboBox.setButtonCell(new ListCell(){

            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                if(empty || item==null){
                    setStyle("-fx-text-fill: derive(-fx-control-inner-background,-30%)");
                } else {
                    setStyle("-fx-text-fill:#"+Enums.colors[0].toString().substring(2,8)+";");
                    setText(item.toString());
                }
            }

        });

        OK.setOnAction(e -> {
            switch (comboBox.getValue()){
                case "Caesar Cipher":{
                    ciTy = "Caesar Cipher";
                    name = (pn.getText().length() > 9 ?pn.getText().substring(0,8):pn.getText());
                    PrimaryStage.exit();
                    hide();
                    AddictiveCipher.launch();
                    break;
                }
                case "KeyLess Transposition Cipher":{
                    ciTy = "KeyLess Transposition";
                    name = (pn.getText().length() > 9 ?pn.getText().substring(0,8):pn.getText());
                    PrimaryStage.exit();
                    hide();
                    KeyLessTranspositionCipher.launch();
                    break;
                }
                case "Morse Code":{
                    ciTy = "Morse Code";
                    name = (pn.getText().length() > 9 ?pn.getText().substring(0,8):pn.getText());
                    PrimaryStage.exit();
                    this.hide();
                    MorseCode.launch();
                    break;
                }
                case "Momoalphabetic Cipher":{
                    ciTy = "Momoalphabetic";
                    name = (pn.getText().length() > 9 ?pn.getText().substring(0,8):pn.getText());
                    PrimaryStage.exit();
                    hide();
                    MomoalphapticCipher.launch();
                    break;
                }
                case "Vigenere Cipher":{
                    ciTy = "Vigenere Cipher";
                    name = (pn.getText().length() > 9 ?pn.getText().substring(0,8):pn.getText());
                    PrimaryStage.exit();
                    this.hide();
                    VigenereCipher.launch();
                    break;
                }

            }
        });
    }

    private static void Tidy(){
        //scene.getStylesheets().add("sample/style/comboBox.css");
        pn.setPromptText("Enter Project Name Here");
        pn.setFont(font);
        labelC.setFont(font);
        labelN.setFont(font);
        labelN.setTextFill(Enums.colors[0]);
        labelC.setTextFill(Enums.colors[0]);
        OK.setStyle("-fx-background-color:"+Enums.colors[2].toString().substring(2,8)+";");
        cancel.setStyle("-fx-background-color:"+Enums.colors[2].toString().substring(2,8)+";");
        OK.setTextFill(Enums.colors[0]);
        cancel.setTextFill(Enums.colors[0]);
        OK.setFont(font);
        cancel.setFont(font);
        scene.getStylesheets().add("sample/style/style.css");
        projectSitting.setScene(scene);
        projectSitting.show();
        projectSitting.setAlwaysOnTop(true);
        projectSitting.setAlwaysOnTop(false);
        comboBox.setStyle("-fx-background-color:#"+Enums.colors[1].toString().substring(2,8)+";-fx-text-fill:#"+Enums.colors[0].toString().substring(2,8)+";");
        pn.setStyle("-fx-background-color:#"+Enums.colors[1].toString().substring(2,8)+";-fx-text-fill:#"+Enums.colors[0].toString().substring(2,8)+";");


    }


}
