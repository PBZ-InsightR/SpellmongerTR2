package testfx;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.insightr.spellmonger.*;
import edu.insightr.spellmonger.Card;

/**
 * Created by Ozerioss on 14/10/2016.
 * test java fx
 */
public class FxMain extends Application{

    Scene scene1, scene2;
    @FXML
    public Button launch_button;

    @FXML
    public Button exit_button;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("../fxstuff.fxml"));


        scene1 = new Scene(root,600,500);
        primaryStage.setTitle("Spellmonger");
        primaryStage.setScene(scene1);


        Parent root2 = FXMLLoader.load(getClass().getResource("../zero_player.fxml"));
        scene2 = new Scene(root2, 600, 500);

        launch_button = new Button();
        launch_button.setOnAction(
                e ->
                {   Stage secondaryStage = new Stage();
                    secondaryStage.setTitle("Game");
                    secondaryStage.setScene(scene2);
                    secondaryStage.show();
                }
        );
        //root.getChildrenUnmodifiable().addAll(launch_button);




        //primaryStage.setTitle("Game working");
        //primaryStage.setScene(scene2);
        primaryStage.show();


    }


    public static void main(String[] args)
    {
        launch(args);

    }
}
