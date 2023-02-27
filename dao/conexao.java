package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao{


    public Connection getConnection() throws SQLException { // Faz a conexao com o banco de dados.

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mercado", "root", "bnd43qhq");

        return con;
    }
}
