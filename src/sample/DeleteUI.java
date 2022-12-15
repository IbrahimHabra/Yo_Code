package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static sample.Enums.pathOfXML;
import static sample.Enums.encSym;

public class DeleteUI extends Stage {
    String[] texts;
    String[] projects;
    String[] ciphers;
    String[] keys;
    String htmlText = Main.loadPageAsString();
    String jsText;
    int length;

    public DeleteUI() {
        jsText = htmlText.substring(9,htmlText.indexOf("</script>"));
        System.out.println(jsText);


        texts = jsText.substring(jsText.indexOf("var texts = \"") + 13,jsText.indexOf("\";var projects = \"")).split(encSym);
        projects = jsText.substring(jsText.indexOf("\";var projects = \"")+18,jsText.indexOf("\";var ciphers = ")).split(encSym);
        ciphers = jsText.substring(jsText.indexOf("\";var ciphers = ")+17,jsText.indexOf("\";var keys = \"")).split(encSym);
        keys = jsText.substring(jsText.indexOf("\";var keys = \"") + 14,jsText.lastIndexOf("\";")).split(encSym);
        length = keys.length;

        Button buttonDelete = new Button("Delete Selected");
        Button cancel = new Button("Cancel");
        Button save = new Button("Done");

        TableView<TableData> table = new TableView();

        ObservableList<TableData> data = FXCollections.observableArrayList();
        for (int i = 0; i < texts.length; i++) {
            data.add(new TableData(projects[i],ciphers[i],texts[i],keys[i]));
        }


        TableColumn<TableData, String> columnName = new TableColumn<>("Name");
        columnName.setCellValueFactory( new PropertyValueFactory<>("name") );
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());


        TableColumn<TableData, String> columnCipher = new TableColumn<>("Cipher");
        columnCipher.setCellValueFactory( new PropertyValueFactory<>("cipher") );
        columnCipher.setCellFactory(TextFieldTableCell.forTableColumn());


        TableColumn<TableData, String> columnText = new TableColumn<>("Text");
        columnText.setCellValueFactory( new PropertyValueFactory<>("text") );
        columnText.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<TableData,String> columnKey = new TableColumn<>("Key");
        columnKey.setCellValueFactory(new PropertyValueFactory<>("key"));
        columnKey.setCellFactory(TextFieldTableCell.forTableColumn());



        table.setEditable(true);
        table.getColumns().addAll(columnName, columnCipher, columnText ,columnKey);
        table.setItems(data);
        table.getSelectionModel().setSelectionMode( SelectionMode.SINGLE );

        table.setPrefSize(560, 200);
        columnName.setPrefWidth(112);
        columnCipher.setPrefWidth(168);
        columnText.setPrefWidth(168);
        columnKey.setPrefWidth(112);
        buttonDelete.setPrefSize(560, 30);
        cancel.setPrefSize(260, 30);
        save.setPrefSize(260,30);

        table.setTranslateX(20);
        table.setTranslateY(25);
        buttonDelete.setTranslateX(20);
        buttonDelete.setTranslateY(250);
        cancel.setTranslateX(320);
        cancel.setTranslateY(305);
        save.setTranslateX(20);
        save.setTranslateY(305);


        Group root = new Group();
        root.getChildren().add(table);
        root.getChildren().add(buttonDelete);
        root.getChildren().add(cancel);
        root.getChildren().add(save);

        Font font = Font.loadFont(DeleteUI.class.getResourceAsStream("Fonts/static/Comfortaa-Bold.ttf"), 15);
        buttonDelete.setFont(font);
        cancel.setFont(font);
        save.setFont(font);





        Scene scene = new Scene(root, 600, 350);
        scene.getStylesheets().add("sample/style/styleDel.css");
        scene.setFill(Enums.colors[4]);


        setTitle("Projects Management");
        setResizable(false);
        setScene(scene);

        buttonDelete.setOnAction(Action -> {table.getItems().removeAll(
                table.getSelectionModel().getSelectedItems() );
                length--;
        });
        cancel.setOnAction(Action -> hide());
        save.setOnAction(Action -> {
            String result1 = "";
            for (int i = 0; i < length; i++) {
                result1 += (String.valueOf(table.getColumns().get(0).getCellObservableValue(i)).substring(23,String.valueOf(table.getColumns().get(0).getCellObservableValue(i)).lastIndexOf("]")));
                result1 += encSym;
            }result1 = result1.substring(0,result1.lastIndexOf(encSym));
            String result2 = "";
            for (int i = 0; i < length; i++) {
                result2 += (String.valueOf(table.getColumns().get(1).getCellObservableValue(i)).substring(23,String.valueOf(table.getColumns().get(1).getCellObservableValue(i)).lastIndexOf("]")));
                result2 += encSym;
            }result2 = result2.substring(0,result2.lastIndexOf(encSym));
            String result3 = "";
            for (int i = 0; i < length; i++) {
                result3 += (String.valueOf(table.getColumns().get(2).getCellObservableValue(i)).substring(23,String.valueOf(table.getColumns().get(2).getCellObservableValue(i)).lastIndexOf("]")));
                result3 += encSym;
            }result3 = result3.substring(0,result3.lastIndexOf(encSym));
            String result4 = "";
            for (int i = 0; i < length; i++) {
                result4 += (String.valueOf(table.getColumns().get(3).getCellObservableValue(i)).substring(23,String.valueOf(table.getColumns().get(3).getCellObservableValue(i)).lastIndexOf("]")));
                result4 += encSym;
            }result4 = result4.substring(0,result4.lastIndexOf(encSym));


            String result;

            result = "var texts = \"" + result3 + "\";" +
                    "var projects = \"" + result1 + "\";" +
                    "var ciphers = \"" + result2 + "\";" +
                    "var keys = \"" + result4 + "\";";

            System.out.println(result);

            try {
                FileOutputStream fos = new FileOutputStream(pathOfXML);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                osw.append(Enums.before)
                        .append(result)
                        .append(Enums.after);
                osw.flush();
                osw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            MainScene.reload();
            hide();
        });



    }
    private static DeleteUI deleteUI = new DeleteUI();
    public static void launch() {
        deleteUI.show();
    }
    public static void exit(){
        deleteUI.hide();
        deleteUI = new DeleteUI();

    }

}
