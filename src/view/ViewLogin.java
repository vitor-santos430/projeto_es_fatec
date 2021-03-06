package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Usuario;
import utils.ConectaBanco;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public void login() throws SQLException {
		String email = txtEmail.getText();
		String senha = new String(txtPassword.getPassword());
		
		Usuario us = new Usuario();
		
		int result_login = us.logar(email, senha);
		switch(result_login) {
			case 1: 
				Menu mn = new Menu();
				mn.setVisible(true);
			break;
			case 2: 
				JOptionPane.showMessageDialog(null, "Senha inválida.");
			break;
			case 3:
				JOptionPane.showMessageDialog(null, "Usuário inválido.");
			break;
			default:
				JOptionPane.showMessageDialog(null, "Algo deu errado, tente novamente.");
			break;
		}
	}
    
	
	public ViewLogin() {
		setResizable(false);
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// setar janela pro meio da tela 
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 0, 0));
		btnEntrar.setBounds(174, 205, 117, 25);
		contentPane.add(btnEntrar);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(102, 133, 252, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Usuario");
		lblEmail.setBounds(102, 116, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(102, 159, 70, 15);
		contentPane.add(lblSenha);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(102, 174, 252, 19);
		contentPane.add(txtPassword);
		
		JLabel lblLoginSistemaDe = new JLabel("Sistema de Clube");
		lblLoginSistemaDe.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
		lblLoginSistemaDe.setBounds(78, 42, 301, 37);
		contentPane.add(lblLoginSistemaDe);
		
		txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						login();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						login();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}