package dao;

import module.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class produtoDAO
{
    private final Connection con;    // Conecta com a class dao.conexao do tipo Connection
    public produtoDAO(Connection con)
    {
        this.con = con;
    }

    public void salvar(produto Produto)
    {
        String sql = "INSERT INTO produto(nome, valor, quantEstoque, quantVendas) VALUES (?, ?, ?, ?);";
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, Produto.getProduto());
            stmt.setInt(2, Produto.getValor());
            stmt.setInt(3, Produto.getQuantidadeEstoque());
            stmt.setInt(4, Produto.getQuantidadeVendas());
            //stmt.setInt(5, Produto.getLucro());

            stmt.execute(); // Realiza o comando no BD.
            con.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public produto consultar(int iDP)
    {

        produto Produto = new produto();
        String sql = "SELECT *FROM produto WHERE idproduto = ?";
        try
        {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, iDP);

            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                Produto.setidproduto((rs.getInt("idproduto")));
                Produto.setProduto(rs.getString("nome"));
                Produto.setQuantidadeVendas(rs.getInt("quantVendas"));
                Produto.setQuantidadeEstoque(rs.getInt("quantEstoque"));
                Produto.setValor(rs.getInt("valor"));
                Produto.setLucro(rs.getInt("lucro"));
                return Produto;
            }else
            {
                return null;
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void alterar(produto Produto)
    {

        try
        {
            String sql = "UPDATE produto SET nome = '"+Produto.getProduto()+"', valor = '"+Produto.getValor()+"', quantVendas = '"+Produto.getValor()+"' WHERE (idproduto = '"+Produto.getidproduto()+"')";
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.executeUpdate(); // Realiza o comando no BD.
            stmt.close();
            con.close();

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
