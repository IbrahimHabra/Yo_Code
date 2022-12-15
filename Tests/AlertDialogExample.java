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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;

public class AlertDialogExample
        extends Application {
		
	private TextField textFld;
	private Text actionStatus;
	private static final String titleTxt = "JavaFX Dialogs Example";

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle(titleTxt);	
		
		// Window label
		Label label = new Label("Alert Dialogs");
		label.setTextFill(Color.DARKBLUE);
		label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
		HBox labelHb = new HBox();
		labelHb.setAlignment(Pos.CENTER);
		labelHb.getChildren().add(label);
		
		// Text field
		Label txtLbl = new Label("Test.A Text field:");
		txtLbl.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
		textFld = new TextField();
		textFld.setMinHeight(30.0);
		textFld.setPromptText("Enter some text and save.");
		textFld.setPrefColumnCount(15);
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.getChildren().addAll(txtLbl, textFld);

		// Buttons
		Button infobtn = new Button("Info");
		infobtn.setOnAction(new InfoButtonListener());
		Button savebtn = new Button("Save");
		savebtn.setOnAction(new SaveButtonListener());
		Button clearbtn = new Button("Clear");
		clearbtn.setOnAction(new ClearButtonListener());
		HBox buttonHb = new HBox(10);
		buttonHb.setAlignment(Pos.CENTER);
		buttonHb.getChildren().addAll(infobtn, savebtn, clearbtn);
		
		// Status message text
		actionStatus = new Text();
		actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
		actionStatus.setFill(Color.FIREBRICK);
		
		// Vbox
		VBox vbox = new VBox(30);
		vbox.setPadding(new Insets(25, 25, 25, 25));
		vbox.getChildren().addAll(labelHb, hbox, buttonHb, actionStatus);
		
		// Scene
		Scene scene = new Scene(vbox, 500, 300); // w x h
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Initial
		actionStatus.setText("An example of Alert Dialogs. Enter some text and save.");
		infobtn.requestFocus();
	}
	
	private class InfoButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			// Show info alert dialog
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(titleTxt);
			alert.setHeaderText("Information Alert");
			String s ="This is an example of JavaFX 8 Dialogs. " + 
				"This is an Alert Dialog of Alert type - INFORMATION." + " \n \n" +
				"Other Alert types are: CONFIRMATION, ERROR, NONE and WARNING.";
			alert.setContentText(s);

			alert.show();
		}
	}
	
	private class SaveButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			// Show error alert dialog
			
			String txt = textFld.getText().trim();
			String msg = "Text saved: ";
			boolean valid = true;
			
			if ((txt.isEmpty()) || (txt.length() < 5)) {
				
				valid = false;
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle(titleTxt);
				String s = "Text should be at least 5 characters long. " + 
					"Enter valid text and save. ";
				alert.setContentText(s);

				alert.showAndWait();
				msg = "Invalid text entered: ";
			}

			actionStatus.setText(msg + txt);
			
			if (! valid) {
			
				textFld.requestFocus();
			}	
		}
	}

	private class ClearButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			// Show confirm alert dialog
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(titleTxt);
			String s = "Confirm to clear text in text field ! ";
			alert.setContentText(s);

			Optional<ButtonType> result = alert.showAndWait();
			
			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {

				textFld.setText("");
				actionStatus.setText("An example of Alert Dialogs. Enter some text and save.");
				textFld.requestFocus();
			}
		}
	}
}