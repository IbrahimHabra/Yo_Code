import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Optional;
import javafx.util.Callback;

public class DialogExample
        extends Application {

	private Text actionStatus;
	private static final String titleTxt = "JavaFX Dialogs Example";

	public static void main(String [] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle(titleTxt);	
		
		// Window label
		Label label = new Label("Test.A Dialog");
		label.setTextFill(Color.DARKBLUE);
		label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
		HBox labelHb = new HBox();
		labelHb.setAlignment(Pos.CENTER);
		labelHb.getChildren().add(label);

		// Button
		Button btn = new Button("Click to Show Dialog");
		btn.setOnAction(new DialogButtonListener());
		HBox buttonHb = new HBox(10);
		buttonHb.setAlignment(Pos.CENTER);
		buttonHb.getChildren().addAll(btn);
		
		// Status message text
		actionStatus = new Text();
		actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
		actionStatus.setFill(Color.FIREBRICK);
		
		// Vbox
		VBox vbox = new VBox(30);
		vbox.setPadding(new Insets(25, 25, 25, 25));;
		vbox.getChildren().addAll(labelHb, buttonHb, actionStatus);
		
		// Scene
		Scene scene = new Scene(vbox, 500, 250); // w x h
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class DialogButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			displayDialog();
		}
	}
	
	private void displayDialog() {
	
		actionStatus.setText("");
		
		// Custom dialog
		Dialog<PhoneBook> dialog = new Dialog<>();
		dialog.setTitle(titleTxt);
		dialog.setHeaderText("This is a dialog. Enter info and \n" +
			"press Okay (or click title bar 'X' for cancel).");
		dialog.setResizable(true);

		// Widgets
		Label label1 = new Label("Name: ");
		Label label2 = new Label("Phone: ");
		TextField text1 = new TextField();
		TextField text2 = new TextField();
		
		// Create layout and add to dialog
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 35, 20, 35));
		grid.add(label1, 1, 1); // col=1, row=1
		grid.add(text1, 2, 1);
		grid.add(label2, 1, 2); // col=1, row=2
		grid.add(text2, 2, 2);
		dialog.getDialogPane().setContent(grid);
		
		// Add button to dialog
		ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk );

		// Result converter for dialog
		dialog.setResultConverter(new Callback<ButtonType, PhoneBook>() {
			@Override
			public PhoneBook call(ButtonType b) {

				if (b == buttonTypeOk) {

					return new PhoneBook(text1.getText(), text2.getText());
				}

				return null;
			}
		});
		
		// Show dialog
		Optional<PhoneBook> result = dialog.showAndWait();
		
		if (result.isPresent()) {

			actionStatus.setText("Result: " + result.get());
		}
	}
	
	private class PhoneBook {
	
		private String name;
		private String phone;
		
		PhoneBook(String s1, String s2) {
		
			name = s1;
			phone = s2;
		}
		
		@Override
		public String toString() {
		
			return (name + ", " + phone);
		}
	}
}