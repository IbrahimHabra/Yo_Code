import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class SVGMasker extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SVGPath path = new SVGPath();
        path.setContent("m 131.07143,433.07649 c 359.64286,0 360,0.35714 360,0.35714 l 4.28571,1.07143 5.71429,2.5 4.64286,2.85714 4.64285,5 4.64286,7.14286 1.42857,4.28572 1.42857,7.5 -1.07142,10 -1.42858,4.64285 -3.21428,5 -4.64286,5.35715 -5.35714,3.57142 -6.42857,2.85715 -2.85715,1.07143 -3.92857,0.71428 -360.35714,0 -3.21429,-1.07143 -3.92857,-1.42857 -3.57143,-1.78571 -5.71428,-3.30358 -3.21429,-3.48214 -2.05357,-2.67857 -2.67857,-4.28571 -0.98214,-2.76786 -1.69643,-4.01786 -0.44643,-4.375 0.0893,-4.46428 0.35715,-4.375 0.17857,-2.41072 1.60714,-3.57143 1.42857,-3.57143 1.60715,-2.41071 2.32142,-3.03571 2.94643,-3.39286 3.75,-2.67857 3.48215,-1.96429 5.26785,-2.32143 3.57143,-0.44643 z");
        /*path.setTranslateX(-path.getBoundsInLocal().getMinX());
        path.setTranslateY(-path.getBoundsInLocal().getMinY());*/
        System.out.println(path.getBoundsInLocal());
        stage.setScene(new Scene(new Group(path)));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}