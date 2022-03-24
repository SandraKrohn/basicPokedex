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
import java.sql.Blob;

public class SearchController {
    // creating table for displaying Pokemon details
    public TableView<Dex> tablePokedex;
    public TableColumn<Dex, Integer> number;
    public TableColumn<Dex, String> name;
    public TableColumn<Dex, String> type1;
    public TableColumn<Dex, String> type2;
    public TableColumn<Dex, String> entry;
    // public TableColumn<Dex, Blob> picture;

    PokedexModel pokedexModel = new PokedexModel();

    // list of Pokemon details
    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<Dex, Integer>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Dex, String>("name"));
        type1.setCellValueFactory(new PropertyValueFactory<Dex, String>("type1"));
        type2.setCellValueFactory(new PropertyValueFactory<Dex, String>("type2"));
        entry.setCellValueFactory(new PropertyValueFactory<Dex, String>("entry"));
        // this picture stuff doesn't quite work yet (':
        // picture.setCellValueFactory(new PropertyValueFactory<Dex, Blob>("picture"));

        ObservableList<Dex> dexSearchList = pokedexModel.search(Pokedex.searchName);
        tablePokedex.setItems(dexSearchList);
    }

    // button for returning to start screen
    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Pokedex.instance.loadView("PokedexView");
    }
}
