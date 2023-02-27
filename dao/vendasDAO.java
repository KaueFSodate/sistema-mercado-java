package dao;

import module.produto;
import module.vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class vendasDAO {

    private final Connection con;    // Conecta com a class dao.conexao do tipo Connection

    public vendasDAO(Connection con)
    {
        this.con = con;
    }

    public void salvar(vendas Vendas)
    {
        String sql = "INSERT INTO vendas(nome, valor, quant, lucro) VALUES (?, ?, ?, ?);";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, Vendas.getProduto());
            stmt.setInt(2, Vendas.getValor());
            stmt.setInt(3, Vendas.getQuantidadeVendas());
            stmt.setInt(4, Vendas.getLucro());

            stmt.execute(); // Realiza o comando no BD.
            con.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public vendas consultar(int idV)
    {
        vendas Vendas = new vendas();
        String sql = "SELECT *FROM vendas WHERE idvendas = ?";
        try
        {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idV);

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                Vendas.setIdvendas((rs.getInt("idvendas")));
                Vendas.setProduto(rs.getString("nome"));
                Vendas.setQuantidadeVendas(rs.getInt("quant"));
                Vendas.setValor(rs.getInt("valor"));
                Vendas.setLucro(rs.getInt("lucro"));
                return Vendas;
            }else
            {
                return null;
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}
