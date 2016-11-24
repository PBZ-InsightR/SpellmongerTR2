package testfx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import edu.insightr.spellmonger.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ozerioss on 14/10/2016.
 */
public class Controller implements Initializable{
    @FXML
    private ChoiceBox<String> gamechoice_box;

    /*@FXML
    private Button launch_button;

    @FXML
    private Button exit_button;*/

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        gamechoice_box.getItems().addAll("       IA vs IA       ", "      Player vs IA       ", "      Player vs Player      ");


    }

    public Controller()
    {


    }

}
