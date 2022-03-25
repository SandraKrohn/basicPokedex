package Pokedex.Controller;
import Pokedex.Model.Dex;
import Pokedex.Model.PokedexModel;
import Pokedex.Pokedex;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class ShowAllController {
    public TableView<Dex> tablePokedex;
    public TableColumn<Dex, Integer> number;
    public TableColumn<Dex, String> name;

    PokedexModel pokedexModel = new PokedexModel();

    // list of Pokemon (number and name)
    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<Dex, Integer>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Dex, String>("name"));

        ObservableList<Dex> dexList = pokedexModel.read();
        tablePokedex.setItems(dexList);
    }

    // button for returning to start screen
    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Pokedex.instance.loadView("PokedexView");
    }
}
