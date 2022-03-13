package Pokedex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Pokedex extends Application {
    public static Pokedex instance;
    BorderPane rootLayout;
    Stage primaryStage;

    public static void run(String[] args) {
        launch();
    }

    // setting stage stats
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage =primaryStage;
        instance = this;

        primaryStage.setTitle("Pokedex");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setResizable(false);

        setIcon();
        initRootLayout();

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
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("/Pokedex/View/PokedexView.fxml"));
            rootLayout =loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
