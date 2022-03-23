package Pokedex.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class PokedexModel {
    String url = "jdbc:mysql://localhost:3306/pokemon";
    String user = "root";
    String password = "";

    Connection connection;

    public PokedexModel() {
        connect();
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Dex> read() {
        String sql = "SELECT * FROM pokedex;";
        ObservableList<Dex> dexList = FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Number: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                // System.out.println("Type 1: " + resultSet.getString("type1"));
                // System.out.println("Type 2: " + resultSet.getString("type2"));
                // System.out.println("Entry: " + resultSet.getString("entry"));

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
