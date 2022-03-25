package Pokedex.Controller;
import Pokedex.Model.DataModel;
import Pokedex.Model.Dex;
import Pokedex.Model.PokedexModel;
import Pokedex.Pokedex;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class SearchController {
    // creating table for displaying Pokemon details
    /*
    public TableView<Dex> tablePokedex;
    public TableColumn<Dex, Integer> number;
    public TableColumn<Dex, String> name;
    public TableColumn<Dex, String> type1;
    public TableColumn<Dex, String> type2;
    public TableColumn<Dex, String> entry; */
    public Label labelEntry;
    public Label labelName;
    public Label labelType1;
    public Label labelType2;
    public Label labelNumber;
    // public TableColumn<Dex, Blob> picture;

    // list of Pokemon details
    public void initialize() {
            labelEntry.setText(DataModel.dex.getEntry());
            labelName.setText(DataModel.dex.getName());
            labelType1.setText(DataModel.dex.getType1());
            labelType2.setText(DataModel.dex.getType2());
            labelNumber.setText(Integer.valueOf(DataModel.dex.getNumber()).toString());
    }

    // button for returning to start screen
    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Pokedex.instance.loadView("PokedexView");
    }
}
