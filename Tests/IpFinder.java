import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class IpFinder extends Application {
    Pane backgroundPane;
    Label label, labelResult, labelDevelopedBy;
    TextField textField;
    Button buttonFind;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        backgroundPane = new Pane();
        label = new Label("Enter Domain");
        textField = new TextField();
        buttonFind = new Button("Get IP");
        labelResult = new Label("");
        labelDevelopedBy = new Label("Developed by harmash.com");
        // هنا قمنا بتحديد حجم كل شيء سيتم إضافته في الحاوية الرئيسية التي سنضعها في النافذة
        backgroundPane.setPrefSize(600, 340);
        label.setPrefSize(200, 30);
        textField.setPrefSize(200, 36);
        buttonFind.setPrefSize(200, 36);
        labelResult.setPrefSize(600, 30);
        labelDevelopedBy.setPrefSize(600, 30);
        // هنا قمنا بتحديد مكان ظهور كل شيء سيتم إضافته في الحاوية الرئيسية التي سنضعها في النافذة
        label.setTranslateX(200);
        label.setTranslateY(75);
        textField.setTranslateX(200);
        textField.setTranslateY(115);
        buttonFind.setTranslateX(200);
        buttonFind.setTranslateY(165);
        labelResult.setTranslateX(0);
        labelResult.setTranslateY(225);
        labelDevelopedBy.setTranslateX(0);
        labelDevelopedBy.setTranslateY(300);
        // يظهر في وسطهم labelDevelopedBy و labelResult ,textField ,label هنا قمنا بجعل نص الكائنات
        label.setAlignment(Pos.CENTER);
        textField.setAlignment(Pos.CENTER);
        labelResult.setAlignment(Pos.CENTER);
        labelDevelopedBy.setAlignment(Pos.CENTER);
        // ( نوع خطه, حجمه, سمكه, لونه ) label هنا قمنا يتعديل تصميم الكائن
        label.setStyle(
                "-fx-font1-family: Arial;"
                        + "-fx-font1-size: 20px;"
                        + "-fx-text-fill: white;"
                        + "-fx-font1-weight: bold;"
        );
        // ( نوع خطه, حجمه, سمكه, لونه, مع تحديد لون و سمك حدوده و لون خلفيته ) textField هنا قمنا يتعديل تصميم الكائن
        textField.setStyle(
                "-fx-font1-family: Arial;"
                        + "-fx-font1-size: 16px;"
                        + "-fx-text-fill: lightgrey;"
                        + "-fx-border-color: gray;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2px;"
                        + "-fx-background-color: black;"
        );
        // ( نوع خطه, حجمه, سمكه, لونه, مع تحديد لون و سمك حدوده و لون خلفيته ) buttonFind هنا قمنا يتعديل تصميم الكائن
        buttonFind.setStyle(
                "-fx-font1-family: Arial;"
                        + "-fx-font1-size: 16px;"
                        + "-fx-text-fill: lightgrey;"
                        + "-fx-border-color: gray;"
                        + "-fx-border-style: solid;"
                        + "-fx-border-width: 2px;"
                        + "-fx-background-color: #333;"
                        + "-fx-cursor: hand;"
        );
        // ( نوع خطه, حجمه, سمكه ) labelResult هنا قمنا يتعديل تصميم الكائن
        labelResult.setStyle(
                "-fx-font1-family: Arial;"
                        + "-fx-font1-size: 18px;"
                        + "-fx-font1-weight: bold;"
        );
        // ( نوع خطه, حجمه, سمكه, لونه ) labelDevelopedBy هنا قمنا يتعديل تصميم الكائن
        labelDevelopedBy.setStyle(
                "-fx-font1-family: Arial;"
                        + "-fx-font1-size: 16px;"
                        + "-fx-text-fill: Blue;"
                        + "-fx-font1-weight: bold;"
        );

        // buttonFind هنا قمنا بتحديد ما سيحدث عند النقر على الكائن
        buttonFind.setOnAction((ActionEvent) -> {
            // url سيتم تخزين النص الموجود في مربع النص في الكائن
            String url = textField.getText();
            // labelResult إذا لم يكن مربع النص فارغاً سيحاول البرنامج الإتصال بالنت و جلب عنوان الموقع المذكور و وضعه كنص للكائن
            if (!url.isEmpty()) {
                try {
                    InetAddress address = InetAddress.getByName(url);
                    String ip = address.getHostAddress();
                    labelResult.setText(ip);
                    labelResult.setTextFill(Color.GREEN);
                }
                catch (UnknownHostException ex) {
                    labelResult.setText("Invalid URL or Network is Down");
                    labelResult.setTextFill(Color.RED);
                }
            }
            // إذا كان مربع النص فارغاً عند النقر على الزر, سيتم إظهار النص التالي و تلوينه بالأحمر
            else {
                labelResult.setText("Please enter a valid URL in the above field");
                labelResult.setTextFill(Color.RED);
            }
        });
        // في النافذة Root Node و الذي ننوي جعله الـ Group هنا قمنا بإنشاء كائن من الكلاس
        Group root = new Group();
        // هنا قمنا بإضافة جميع الأشياء التي قمنا بإنشائها في النافذة
        root.getChildren().add(backgroundPane);
        root.getChildren().add(label);
        root.getChildren().add(textField);
        root.getChildren().add(buttonFind);
        root.getChildren().add(labelResult);
        root.getChildren().add(labelDevelopedBy);
        // فيها و تحديد حجمها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root, 600, 340);
        // هنا وضعنا عنوان للنافذة
        primaryStage.setTitle("Ip Finder");
        // أي وضعنا محتوى النافذة الذي قمنا بإنشائه للنافذة .stage في كائن الـ scene هنا وضعنا كائن الـ
        primaryStage.setScene(scene);
        // هنا قمنا بإظهار النافذة
        primaryStage.show();
        // هنا جعلنا المستخدم غير قادر على تكبير أو تصغير حجم النافذة بنفسه
        primaryStage.setResizable(false);
    }
}
