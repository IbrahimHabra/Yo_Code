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
import javafx.scene.control.ChoiceDialog;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

public class ChoiceDialogExample
        extends Application {
		
	private ChoiceDialog<String> dialog;
	private Text actionStatus;
	private final String [] arrayData = {"First", "Second", "Third", "Fourth"};
	private List<String> dialogData;
	private static final String titleTxt = "JavaFX Dialogs Example";


	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle(titleTxt);	
		
		// Window label
		Label label = new Label("Choice Dialog");
		label.setTextFill(Color.DARKBLUE);
		label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
		HBox labelHb = new HBox();
		labelHb.setAlignment(Pos.CENTER);
		labelHb.getChildren().add(label);

		// Button
		Button choicebtn = new Button("Get Choice");
		choicebtn.setOnAction(new ChoiceButtonListener());
		HBox buttonHb = new HBox(10);
		buttonHb.setAlignment(Pos.CENTER);
		buttonHb.getChildren().addAll(choicebtn);
		
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
		
		// Initial dialog
		dialogData = Arrays.asList(arrayData);
		displayChoiceDialog();
	}
	
	private void displayChoiceDialog() {
		
		dialog = new ChoiceDialog<String>(dialogData.get(0), dialogData);
		dialog.setTitle(titleTxt);
		dialog.setHeaderText("Select your choice");

		Optional<String> result = dialog.showAndWait();
		String selected = "cancelled.";
		
		if (result.isPresent()) {

			selected = result.get();
		}
		
		actionStatus.setText("Selection: " + selected);
	}
	
	private class ChoiceButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {

			actionStatus.setText("");
			displayChoiceDialog();
		}
	}
}