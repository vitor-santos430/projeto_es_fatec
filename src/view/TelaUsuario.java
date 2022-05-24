package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	public TelaUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setar janela pro meio da tela 
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeUsuario = new JLabel("Cadastro de usuario");
		lblCadastroDeUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDeUsuario.setBounds(154, 12, 187, 15);
		contentPane.add(lblCadastroDeUsuario);
		
		JLabel lblUsuario = new JLabel("Nome:");
		lblUsuario.setBounds(42, 78, 51, 15);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(87, 76, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(288, 76, 114, 19);
		contentPane.add(textField_1);
		
		JLabel lblLogin = new JLabel("Email:");
		lblLogin.setBounds(241, 78, 70, 15);
		contentPane.add(lblLogin);
		
		JLabel lblUsuario_1 = new JLabel("Nome:");
		lblUsuario_1.setBounds(42, 107, 51, 15);
		contentPane.add(lblUsuario_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 105, 114, 19);
		contentPane.add(textField_2);
		
		JLabel lblLogin_1 = new JLabel("Email:");
		lblLogin_1.setBounds(241, 107, 70, 15);
		contentPane.add(lblLogin_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(288, 105, 114, 19);
		contentPane.add(textField_3);
	}
}
