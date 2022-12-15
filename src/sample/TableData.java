package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.util.Callback;

public class TableData {

    SimpleStringProperty name;
    SimpleStringProperty cipher;
    SimpleStringProperty text;
    SimpleStringProperty key;

    public TableData() {
        this.name = new SimpleStringProperty("");
        this.cipher = new SimpleStringProperty("");
        this.text = new SimpleStringProperty("");
        this.key = new SimpleStringProperty("");
    }

    public TableData(String name, String cipher, String text, String key) {
        this.name = new SimpleStringProperty(name);
        this.cipher = new SimpleStringProperty(cipher);
        this.text = new SimpleStringProperty(text);
        this.key = new SimpleStringProperty(key);
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getCipher() {
        return cipher.getValue();
    }

    public void setCipher(String cipher) {
        this.cipher = new SimpleStringProperty(cipher);
    }

    public String getText() {
        return text.getValue();
    }

    public void setText(String text) {
        this.text = new SimpleStringProperty(text);
    }

       public void setKey(String key) {
        this.key.set(key);
    }

    public String getKey() {
        return key.get();
    }
}