package Pokedex.Model;
import Pokedex.Pokedex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class PokedexModel {
    String url = "jdbc:mysql://localhost:3306/pokemon";
    String user = "root";
    String password = "";

    Connection connection;

    public PokedexModel() {
        connect();
    }

    // connecting to the database
    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // accessing DB and displaying number and name of all implemented Pokemon
    public ObservableList<Dex> read() {
        String sql = "SELECT * FROM pokedex;";
        ObservableList<Dex> dexList = FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int number = resultSet.getInt("id");String name = resultSet.getString("name");
                String type1 = resultSet.getString("type1");
                String type2 = resultSet.getString("type2");
                String entry = resultSet.getString("entry");
                String height = resultSet.getString("height");
                String weight = resultSet.getString("weight");
                InputStream imageFile = resultSet.getBinaryStream("image");
                Image image = new Image(imageFile);

                Dex pokemon = new Dex(number, name, type1, type2, height, weight, entry, image);
                dexList.add(pokemon);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dexList;
    }

    // searching for Pokemon and displaying detailed data
    public Dex search(String searchName) {
        String sql = "CALL searchByName(?)";
        Dex pokemon = new Dex();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int number = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type1 = resultSet.getString("type1");
                String type2 = resultSet.getString("type2");
                String height = resultSet.getString("height");
                String weight = resultSet.getString("weight");
                String entry = resultSet.getString("entry");
                InputStream imageFile = resultSet.getBinaryStream("image");
                Image image = new Image(imageFile);

                pokemon = new Dex(number, name, type1, type2, entry, height, weight, image);
                return pokemon;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
