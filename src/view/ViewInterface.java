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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class ViewInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInterface frame = new ViewInterface();
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
	public ViewInterface() {
		setTitle("Interface gráfica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// setar janela pro meio da tela 
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMostrarNome = new JButton("Mostrar nome");
		btnMostrarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				JOptionPane.showMessageDialog(null, "Seu nome é: " + nome);
			}
		});
		btnMostrarNome.setBounds(98, 121, 241, 25);
		contentPane.add(btnMostrarNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 90, 242, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblDigiteSeuNome = new JLabel("Digite seu nome");
		lblDigiteSeuNome.setBounds(97, 65, 217, 15);
		contentPane.add(lblDigiteSeuNome);
		
		JButton btnTrocarNome = new JButton("Trocar nome");
		btnTrocarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("João");
			}
		});
		btnTrocarNome.setBounds(98, 152, 241, 25);
		contentPane.add(btnTrocarNome);
	}
}
