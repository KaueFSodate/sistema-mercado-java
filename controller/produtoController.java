package controller;

import dao.conexao;
import dao.produtoDAO;
import dao.vendasDAO;
import module.produto;
import module.vendas;
import view.Login;
import view.Loja;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class produtoController {
    private Loja view;

    public produtoController(Loja view) {
        this.view = view;
    }

    public void cadastrar(produto Produto){
        try {
            Connection con = new conexao().getConnection(); // Cria a conexao
            produtoDAO prod = new produtoDAO(con);
            prod.salvar(Produto);
            JOptionPane.showMessageDialog(null, "Vendido com sucesso");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void alterar(produto Produto){

        try {
            Connection con = new conexao().getConnection(); // Cria a conexao
            produtoDAO prod = new produtoDAO(con);
            prod.alterar(Produto);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
