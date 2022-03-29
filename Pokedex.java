package Pokedex;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;

public class Pokedex extends Application {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;
    public static Pokedex instance;
    BorderPane rootLayout;
    public Stage primaryStage;

    public static void run(String[] args) {
        launch();
    }

    // setting stage stats
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        instance = this;

        primaryStage.setTitle("Pokedex");
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setResizable(false);

        setIcon();
        initRootLayout();
        loadView("StartView");

        primaryStage.show();
    }

    public void setIcon() {
        InputStream iconStream = getClass().getResourceAsStream("/images/pokeball.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);
    }

    // setting initial view
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Pokedex/View/PokedexView.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadView(String newView) throws IOException {
        String viewPath = "/Pokedex/View/" + newView + ".fxml";

        rootLayout.getChildren().remove(rootLayout.getCenter());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewPath));

        Pane pane= loader.load();
        rootLayout.setCenter(pane);
    }

    public void shutdown() {
        Platform.exit();
        System.exit(0);
    }

    public void showAboutBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pokedex");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/images/pokeball.png"));
        alert.setHeaderText("App created by S. K., March 2022");
        alert.setContentText("Disclaimer: Pokemon doesn't belong to me, I'm just borrowing a few.");
        alert.show();
    }
}
