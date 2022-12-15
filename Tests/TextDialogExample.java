import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Optional;

public class TextDialogExample
        extends Application {
		
	private TextInputDialog dialog;
	private Text actionStatus;
	private final String defaultVal = "Default text";
	private static final String titleTxt = "JavaFX Dialogs Example";

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle(titleTxt);	
		
		// Window label
		Label label = new Label("Text Input Dialog");
		label.setTextFill(Color.DARKBLUE);
		label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
		HBox labelHb = new HBox();
		labelHb.setAlignment(Pos.CENTER);
		labelHb.getChildren().add(label);

		// Button
		Button textbtn = new Button("Get Text");
		textbtn.setOnAction(new TextButtonListener());
		HBox buttonHb = new HBox(10);
		buttonHb.setAlignment(Pos.CENTER);
		buttonHb.getChildren().addAll(textbtn);
		
		// Status message text
		actionStatus = new Text();
		actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
		actionStatus.setFill(Color.FIREBRICK);
		
		// Vbox
		VBox vbox = new VBox(30);
		vbox.setPadding(new Insets(25, 25, 25, 25));
		vbox.getChildren().addAll(labelHb, buttonHb, actionStatus);
		
		// Scene
		Scene scene = new Scene(vbox, 500, 250); // w x h
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Initial dialog
		displayTextDialog();
	}
	
	private void displayTextDialog() {
		
		dialog = new TextInputDialog(defaultVal);
		dialog.setTitle(titleTxt);
		dialog.setHeaderText("Enter some text, or use default value.");

		Optional<String> result = dialog.showAndWait();
		String entered = "none.";
		
		if (result.isPresent()) {

			entered = result.get();
		}

		actionStatus.setText("Text entered: " + entered);
	}
	
	private class TextButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			actionStatus.setText("");
			displayTextDialog();
		}
	}
}