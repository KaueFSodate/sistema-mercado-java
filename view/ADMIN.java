package view;

import dao.conexao;
import dao.produtoDAO;
import module.produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ADMIN extends JFrame {
    private JPanel telaAdmin;
    private JTextField tFId;
    private JTextField tFNome;
    private JSpinner tFValor;
    private JSpinner tFQuantEstoque;
    private JSpinner tFQuantidadeVenda;
    private JSpinner tFLUCRO;
    private JButton btnPesquisar;
    private JButton btnAlterar;
    private JButton btnCalcular;
    private JButton btnExcluir;
    private JButton btnLimpar;
    private JButton btnAdicionar;

    public ADMIN() {

        setContentPane(telaAdmin);  //Atributos da janela feitas pelo .form
        setTitle("Menu ADMIN");
        setSize(450, 330);
        setLocation(900, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(tFId.getText());

                try {
                    Connection con = new conexao().getConnection();
                    produtoDAO ProdutoDAO = new produtoDAO(con);
                    produto prod = ProdutoDAO.consultar(id);
                    if (prod == null) {

                    } else {
                        //tFId.setText(String.valueOf(prod.getidproduto()));
                        tFNome.setText(prod.getProduto());
                        tFValor.setValue(prod.getValor());
                        tFQuantEstoque.setValue(prod.getQuantidadeEstoque());
                        tFQuantidadeVenda.setValue(prod.getQuantidadeVendas());
                        tFLUCRO.setValue(prod.getLucro());
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                produto Produtoo =  new produto();
                //Produtoo.setidproduto(Integer.parseInt(tFId.getText()));
                Produtoo.setProduto(tFNome.getText());
                Produtoo.setQuantidadeEstoque(Integer.parseInt(tFQuantEstoque.getValue().toString()));
                Produtoo.setQuantidadeVendas(Integer.parseInt(tFQuantidadeVenda.getValue().toString()));
                Produtoo.setValor(Integer.parseInt(tFValor.getValue().toString()));
                Produtoo.setLucro(Integer.parseInt(tFLUCRO.getValue().toString()));

                try {
                    Connection con = new conexao().getConnection(); // Cria a conexao
                    produtoDAO prod = new produtoDAO(con);
                    prod.alterar(Produtoo);
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tFId.setText(String.valueOf(0));
                tFNome.setText("");
                tFQuantEstoque.setValue(0);
                tFQuantidadeVenda.setValue(0);
                tFValor.setValue(0);
                tFLUCRO.setValue(0);
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                produto Produto =  new produto();
                Produto.setProduto(tFNome.getText());
                Produto.setQuantidadeVendas(Integer.parseInt(tFQuantidadeVenda.getValue().toString()));
                Produto.setValor(Integer.parseInt(tFValor.getValue().toString()));
                int val = (int) tFValor.getValue();
                int quantid = (int) tFQuantidadeVenda.getValue();
                Produto.setLucro(val * quantid);
                tFLUCRO.setValue(Produto.getLucro());
            }
        });

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                produto Produto =  new produto();
                Produto.setProduto(tFNome.getText());
                Produto.setValor(Integer.parseInt(tFValor.getValue().toString()));
                Produto.setQuantidadeEstoque(Integer.parseInt(tFQuantEstoque.getValue().toString()));
                Produto.setQuantidadeVendas(Integer.parseInt(tFQuantidadeVenda.getValue().toString()));
                Produto.setLucro(Integer.parseInt(tFLUCRO.getValue().toString()));

                try {
                    Connection con = new conexao().getConnection(); // Cria a conexao
                    produtoDAO prod = new produtoDAO(con);
                    prod.salvar(Produto);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

}

