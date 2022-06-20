package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Usuario;

import javax.swing.SwingConstants;
import javax.swing.JTable;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tbUsuario;

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
		setTitle("Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setar janela pro meio da tela 
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JLabel lblCadastroDeUsuario = new JLabel("Usuário");
		lblCadastroDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeUsuario.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroDeUsuario.setBounds(248, 12, 80, 15);
		contentPane.add(lblCadastroDeUsuario);
		
		Usuario us1 = new Usuario();
		List<Usuario> usuarios = us1.listar();
		
		String[] colunas = {"", };
		
		tbUsuario = new JTable(usuarios);
		usuarios.addColumn("");
		tbUsuario.setBounds(32, 102, 529, 194);
		contentPane.add(tbUsuario);
	}
}
