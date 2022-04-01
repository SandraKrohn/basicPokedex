package Pokedex.Controller;
import Pokedex.Model.DataModel;
import Pokedex.Model.PokedexModel;
import Pokedex.Pokedex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class PokedexController {
    public void onMenuExitClick() throws IOException {
        Pokedex.instance.shutdown();
    }

    public void onMenuAboutClick(ActionEvent actionEvent) {
        Pokedex.instance.showAboutBox();
    }
}
