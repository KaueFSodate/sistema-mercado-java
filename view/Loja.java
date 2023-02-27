package view;

import controller.produtoController;
import dao.conexao;
import dao.produtoDAO;
import module.produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Loja extends JFrame{
    private JTextField tFId;
    private JTextField tFNome;

    private JButton btnVender;
    private JButton btnLimpar;

    private JButton btnPesquisar;
    private JPanel telaLoja;
    private JButton btnAlterar;
    private JSpinner tfQuanti;

    private JSpinner tFValor;
    private JSpinner tFTotal;
    private JButton btnCalcular;
    private JButton btnAdmin;

    public Loja() {

        setContentPane(telaLoja);  //Atributos da janela feitas pelo .form
        setTitle("Menu java");
        setSize(450, 330);
        setLocation(900, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                produto Produto =  new produto();
                Produto.setProduto(tFNome.getText());
                Produto.setQuantidadeVendas(Integer.parseInt(tfQuanti.getValue().toString()));
                Produto.setValor(Integer.parseInt(tFValor.getValue().toString()));
                Produto.setLucro(Integer.parseInt(tFTotal.getValue().toString()));

                produtoController produtoControl = new produtoController(null);
                produtoControl.cadastrar(Produto);

            }
        });

        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int idV = (Integer.parseInt(tFId.getText()));

                try {
                    Connection con = new conexao().getConnection();
                    produtoDAO produtoDAO = new produtoDAO(con);
                    produto Produto = produtoDAO.consultar(idV);
                    if (Produto == null) {

                    } else {
                        //tFId.setText(String.valueOf(prod.getidproduto()));
                        tFNome.setText(Produto.getProduto());
                        //tfQuanti.setValue(prod.getQuantidadeVendas());
                        tFValor.setValue(Produto.getValor());
                        //tFTotal.setValue(prod.getLucro());
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
                Produtoo.setidproduto(Integer.parseInt(tFId.getText()));
                Produtoo.setProduto(tFNome.getText());
                Produtoo.setQuantidadeVendas(Integer.parseInt(tfQuanti.getValue().toString()));
                Produtoo.setValor(Integer.parseInt(tFValor.getValue().toString()));

                produtoController produtoControl = new produtoController(null);
                produtoControl.alterar(Produtoo);

            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tFId.setText(String.valueOf(0));
                tFNome.setText("");
                tfQuanti.setValue(0);
                tFValor.setValue(0);
                tFTotal.setValue(0);
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                produto Produto =  new produto();
                Produto.setProduto(tFNome.getText());
                Produto.setQuantidadeVendas(Integer.parseInt(tfQuanti.getValue().toString()));
                Produto.setValor(Integer.parseInt(tFValor.getValue().toString()));
                int val = (int) tFValor.getValue();
                int quantid = (int) tfQuanti.getValue();
                Produto.setLucro(val * quantid);
                tFTotal.setValue(Produto.getLucro());

            }
        });
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADMIN telaAdmin = new ADMIN();
                telaAdmin.setVisible(true);
                setVisible(false);
            }
        });
    }

}
