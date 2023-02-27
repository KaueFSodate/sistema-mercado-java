package view;

import controller.clienteController;
import dao.clienteDAO;
import dao.conexao;
import module.cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Login extends JFrame{
    private JTextField tFNome;
    private JTextField tFSenha;
    private JButton btnLogin;
    private JButton Limpar;
    private JPanel telaLogin;

    public Login() {

        setContentPane(telaLogin);  //Atributos da janela feitas pelo .form
        setTitle("Login");
        setSize(300, 330);
        setLocation(900, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cliente Cliente = new cliente();
                Cliente.setNome(tFNome.getText());
                Cliente.setSenha(tFSenha.getText());

                clienteController clienteControl = new clienteController(null);
                clienteControl.autenticar(Cliente);
                setVisible(false);

            }
        });

        Limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tFNome.setText("");
                tFSenha.setText("");

            }
        });
    }

    public static void main (String[] args)
    {
        Login tela = new Login();     // Vai iniciar a tela de login.
        tela.setVisible(true);
    }
}
