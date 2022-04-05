package view;

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
	 */
	public void login() {
		String email = txtEmail.getText();
		String senha = new String(txtPassword.getPassword());
		
		if(email.equals("admin") && senha.equals("admin")) {
			JOptionPane.showMessageDialog(null, "Entrou");
		}else {
			JOptionPane.showMessageDialog(null, "Acesso negado");
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
				login();
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 0, 0));
		btnEntrar.setBounds(176, 209, 117, 25);
		contentPane.add(btnEntrar);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(102, 133, 252, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(102, 116, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(102, 159, 70, 15);
		contentPane.add(lblSenha);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(102, 174, 252, 19);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon("/home/vitor/Downloads/image-removebg-preview.png"));
		lblNewLabel.setBounds(81, 0, 300, 136);
		contentPane.add(lblNewLabel);
		
		txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
		
		txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}
		});
	}
}
