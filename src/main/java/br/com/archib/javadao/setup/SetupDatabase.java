package br.com.archib.javadao.setup;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String... args) throws SQLException {

        Connection connection = new ConnectionFactory().getConnection();

        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS movie (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(255) NOT NULL, PRIMARY KEY (id))";

        statement.executeUpdate(sql);

        System.out.println("setup finished");
    }

}
