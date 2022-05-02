package br.com.empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoConexao {

    private static Connection connect = null;

    private BancoConexao() {

    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/campomagico?user=root&password=309350");
        }
        return connect;
    }
}