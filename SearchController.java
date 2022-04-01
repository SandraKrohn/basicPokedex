package Pokedex.Controller;
import Pokedex.Model.DataModel;
import Pokedex.Pokedex;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;

public class SearchController {
    // creating table for displaying Pokemon details
    public Label labelEntry;
    public Label labelName;
    public Label labelType1;
    public Label labelType2;
    public Label labelHeight;
    public Label labelWeight;
    public Label labelNumber;
    public ImageView image;

    // list of Pokemon details displayed after search
    public void initialize() {
        labelEntry.setText(DataModel.dex.getEntry());
        labelName.setText(DataModel.dex.getName());
        labelType1.setText(DataModel.dex.getType1());

        if (DataModel.dex.getType2().equals("")) {
            labelType2.setText("-");
        } else {
            labelType2.setText(DataModel.dex.getType2());
        }

        labelHeight.setText(DataModel.dex.getHeight());
        labelWeight.setText(DataModel.dex.getWeight());
        labelNumber.setText(Integer.valueOf(DataModel.dex.getNumber()).toString());

        Image i = DataModel.dex.getImage();
        image.setImage(i);
    }

    // back-button
    public void onButtonBackClick(ActionEvent actionEvent) throws IOException {
        Pokedex.instance.loadView("StartView");
    }

    // binding back button to backspace key
    public void keyListener(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            onButtonBackClick(new ActionEvent());
            keyEvent.consume();
        }
    }
}
