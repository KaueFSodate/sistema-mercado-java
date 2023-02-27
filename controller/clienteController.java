package controller;

import dao.clienteDAO;
import dao.conexao;
import module.cliente;
import view.Login;
import view.Loja;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class clienteController {
    private Login view;

    public clienteController(Login view) {
        this.view = view;
    }

    public void autenticar(cliente Cliente){

        try
        {
            Connection con = new conexao().getConnection(); // Cria a conexao
            clienteDAO ClienteDAO = new clienteDAO(con);    // Cria o objeto ProdutoDAO do tipo produtoDAO na qual tem como parametro a conexao com o meu BD.
            boolean existe = ClienteDAO.autenticar(Cliente); // Após o ClienteDAO estar com conexao e solicitado para que ele faça a função autenticar que esta no clienteDAO
            if (existe)
            { // Se 'existe' valor no SELECT da função autenticar ira retornar
                Loja telaMenu = new Loja();
                telaMenu.setVisible(true);
                JOptionPane.showMessageDialog(null, "Bem vindo!");
            } else
            { // Caso não 'existe' valor no SELECT
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
            }
        } catch (SQLException ex) // Caso retorne erro do banco de dados
        {
            throw new RuntimeException(ex);
        }


    }
}
