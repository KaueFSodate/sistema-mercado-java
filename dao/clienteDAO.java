package dao;

import module.cliente;
import module.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class clienteDAO {

    private final Connection con;    // Conecta com a class dao.conexao do tipo Connection

    public clienteDAO(Connection con)
    {
        this.con = con;
    }

    public void cadastrar(cliente Cliente)
    {
        String sql = "INSERT INTO login(nome, senha) VALUES (?, ?);";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, Cliente.getNome());
            stmt.setString(2, Cliente.getSenha());

            stmt.execute(); // Realiza o comando no BD.
            con.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public boolean autenticar(cliente Cliente) {
        String sql = "SELECT *FROM login WHERE nome = ? AND senha = ?";  // Comando que ira ser inserido no BD.
        boolean check = false;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, Cliente.getNome());
            stmt.setString(2, Cliente.getSenha());

            ResultSet rs = stmt.executeQuery(); // Armazena o resultado do comando SELECT.

            return rs.next();// Se tiver algum resultado ira retornar true e se não tiver ira retornar false.




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
