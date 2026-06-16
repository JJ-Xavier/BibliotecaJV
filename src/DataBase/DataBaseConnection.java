package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static DataBaseConnection instance;

    private Connection connection;

    private DataBaseConnection() {

        try {

            connection = DriverManager.getConnection(
                    "jdbc:sqlite:biblioteca.db"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataBaseConnection getInstance() {

        if (instance == null) {
            instance = new DataBaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
