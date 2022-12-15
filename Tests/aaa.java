import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

    /**
     *
     * @author Ghansham
     */
    public class aaa extends Application {

        @Override
        public void start(Stage primaryStage) {

            Text text1 = new Text("Text 1");
            text1.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
            Text text2 = new Text("Text 2");
            text2.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));



            ComboBox combo = new ComboBox();
            combo.getItems().addAll(text1,text2);


            StackPane root = new StackPane();

            root.getChildren().add(combo);

            Scene scene = new Scene(root, 300, 250);

            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

