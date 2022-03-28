package Pokedex.Controller;
import Pokedex.Model.DataModel;
import Pokedex.Model.Dex;
import Pokedex.Model.PokedexModel;
import Pokedex.Pokedex;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;

public class ShowAllController {
    public TableView<Dex> tablePokedex;
    public TableColumn<Dex, Integer> number;
    public TableColumn<Dex, Hyperlink> name;

    PokedexModel pokedexModel = new PokedexModel();

    // list of Pokemon (number and name)
    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<Dex, Integer>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Dex, Hyperlink>("name"));

        ObservableList<Dex> dexList = pokedexModel.read();
        tablePokedex.setItems(dexList);

        tablePokedex.setOnMouseClicked(event -> {
            try {
                getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void getName() throws IOException {
        String name = tablePokedex.getSelectionModel().getSelectedItem().getName();
        System.out.println(name);
        DataModel.dex = pokedexModel.search(name);
        Pokedex.instance.loadView("SearchView");
    }

    // button for returning to start screen
    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Pokedex.instance.loadView("PokedexView");
    }

    // binding back button to backspace key
    public void keyListener(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            onButtonBackClick(new ActionEvent());
            keyEvent.consume();
        }
    }
}
