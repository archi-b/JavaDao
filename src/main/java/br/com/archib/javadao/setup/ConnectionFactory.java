package br.com.archib.javadao.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public final String URL = "jdbc:mysql://localhost:3306/movie?serverTimezone=America/Sao_Paulo";
    public final String USER = "root";
    public final String PASSWORD = "123456";
    public final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private Connection createConnection() throws ClassNotFoundException {
        Connection connection = null;

        try {
            Class.forName(DRIVER_CLASS);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public Connection getConnection() {
        try {
            return createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
