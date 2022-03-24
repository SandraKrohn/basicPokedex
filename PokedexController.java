package Pokedex.Controller;
import Pokedex.Pokedex;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;

public class PokedexController {
    // retrieves input from text field and displays Pokemon details
    @FXML
    private TextField textName;
    public void onButtonSearchClick() throws IOException {
        Pokedex.searchName = textName.getText();
        Pokedex.instance.loadView("SearchView");
    }

    // clicking this button shows a list of all implemented Pokemon (number and name)
    public void onButtonShowAllClick() throws IOException {
        Pokedex.instance.loadView("ShowAllView");
    }
}
