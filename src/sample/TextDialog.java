package sample;

import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class TextDialog {
    public static String showDialog(String text,String title, String defaultVal){
        TextInputDialog dialog = new TextInputDialog(defaultVal);
        dialog.setTitle(title);
        dialog.setHeaderText(text);
        Optional<String> result = dialog.showAndWait();
        String entered = "none.";
        if (result.isPresent()) {
            entered = result.get();
        }
        return entered;
    }
}
