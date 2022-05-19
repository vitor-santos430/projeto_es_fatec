package view;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
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
		
		ConectaBanco cb = new ConectaBanco();
		Connection  con  = cb.conexao();
		
		Statement stmt = null;
		
		ResultSet rs;
		
		rs = stmt.executeQuery("SELECT * FROM tb_login where usuario = '"+email+"'");
		if(rs.next()) {
			if(senha.equals(rs.getString("senha"))) {
				Menu mn = new Menu();
				mn.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Usuario não encontrado");
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