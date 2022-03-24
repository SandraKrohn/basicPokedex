package Pokedex.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

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
    // ObservableList erbt von ArrayList und ist fuer Tabellen zustaendig
    // Klasse in Diamond Notation angeben
    public ObservableList<Dex> read() {
        String sql = "SELECT * FROM pokedex;";
        ObservableList<Dex> dexList = FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // System.out.println("Number: " + resultSet.getInt("id"));
                // System.out.println("Name: " + resultSet.getString("name"));

                int number = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type1 = resultSet.getString("type1");
                String type2 = resultSet.getString("type2");
                String entry = resultSet.getString("entry");

                Dex pokemon = new Dex(number, name, type1, type2, entry);
                dexList.add(pokemon);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dexList;
    }

    // search & display of individual Pokemon
    public ObservableList<Dex> search(String searchName) {
        System.out.println(searchName);
        String sql = "CALL searchByName(?)";
        ObservableList<Dex> dexList = FXCollections.observableArrayList();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // System.out.println("Name: " + resultSet.getString("name"));

                int number = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type1 = resultSet.getString("type1");
                String type2 = resultSet.getString("type2");
                String entry = resultSet.getString("entry");

                Dex pokemon = new Dex(number, name, type1, type2, entry);
                dexList.add(pokemon);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dexList;
    }
}
