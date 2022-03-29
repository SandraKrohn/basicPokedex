package Pokedex.Controller;

import Pokedex.Model.DataModel;
import Pokedex.Model.PokedexModel;
import Pokedex.Pokedex;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private TextField textName;
    PokedexModel pokedexModel = new PokedexModel();

    // retrieves input from text field and displays Pokemon details
    public void onButtonSearchClick() throws IOException {
        DataModel.dex = pokedexModel.search(textName.getText());

        // checks if DB contains searched item, displays an error notification if not
        if (DataModel.dex == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pokedex");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/images/pokeball.png"));
            alert.setHeaderText("Pokemon not found!");
            alert.setContentText("No results");
            alert.show();
        } else {
            Pokedex.instance.loadView("SearchView");
        }
    }
    // clicking this button shows a list of all implemented Pokemon (number and name)
    public void onButtonShowAllClick() throws IOException {
        Pokedex.instance.loadView("ShowAllView");
    }

    // binding search button to enter key
    public void keyListener(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            onButtonSearchClick();
            keyEvent.consume();
        }
    }
}
