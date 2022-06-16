package view;

import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Manutencao;
import utils.ConectaBanco;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class TelaManutencao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblCadastroDeManutencao = new JLabel("Cadastro de Manutenção");
	private JTextField txtNumeroQuadra;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTextField txtDescricao;
	private int type;
	private boolean status;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaManutencao frame = new TelaManutencao();
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
	public TelaManutencao() {
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Cadastro de Manuten\u00E7\u00E3o de Quadras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCadastroDeManutencao.setFont(new Font("Times New Roman", Font.BOLD, 20));
		//lblCadastroDemanutencao.setBounds(106, 12, 261, 17);
		contentPane.add(lblCadastroDeManutencao);
		
		JLabel lblNome = new JLabel("Numero:");
		lblNome.setBounds(15, 44, 70, 17);
		contentPane.add(lblNome);
		
		txtNumeroQuadra = new JTextField();
		txtNumeroQuadra.setColumns(10);
		txtNumeroQuadra.setBounds(88, 41, 114, 19);
		contentPane.add(txtNumeroQuadra);
		
		txtDataInicial = new JTextField();
		txtDataInicial.setColumns(10);
		txtDataInicial.setBounds(88, 41, 114, 19);
		contentPane.add(txtDataInicial);
		
		txtDataFinal = new JTextField();
		txtDataFinal.setColumns(10);
		txtDataFinal.setBounds(88, 41, 114, 19);
		contentPane.add(txtDataFinal);
		
		txtDescricao = new JTextField();
		txtDataFinal.setColumns(10);
		txtDataFinal.setBounds(88, 41, 114, 19);
		contentPane.add(txtDataFinal);
		
		JButton btnCadastrarManutencao = new JButton("Cadastrar Manuten\u00E7\u00E3o");
		btnCadastrarManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Manutencao manutencao = new Manutencao();
				
				// Passando os valores 
				manutencao.setIdQuadra   (Integer.parseInt(txtNumeroQuadra.getText()));
				manutencao.setDataInicial(txtDataInicial.getText());
				manutencao.setDataFinal  (txtDataFinal.getText());
				manutencao.setDescricao  (txtDescricao.getText());
				
				
								
				if (manutencao.cadastrarManutencao()){
					JOptionPane.showMessageDialog(null, "A Manutenção da quadra foi cadastrada com sucesso", "Cadastro de Manutenção de Quadra", JOptionPane.INFORMATION_MESSAGE);
				
					txtNumeroQuadra.setText(" ");
					txtDataInicial.setText (" ");
					txtDataFinal.setText   (" ");
					txtDescricao.setText   (" ");
				
				}else {
					JOptionPane.showMessageDialog(null, "Manutenção já cadastrada","Cadastro de Manutenção de Quadra", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		
		
		btnCadastrarManutencao.setBounds(26, 214, 163, 25);
		contentPane.add(btnCadastrarManutencao);
		
		JLabel lblNewLabel = new JLabel("Data Inicial");
		lblNewLabel.setBounds(15, 82, 63, 14);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField txtDataInicial = new JFormattedTextField();
		txtDataInicial.setBounds(88, 72, 114, 20);
		contentPane.add(txtDataInicial);
		
		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(15, 117, 63, 14);
		contentPane.add(lblDataFinal);
		
		JFormattedTextField txtDataFinal = new JFormattedTextField();
		txtDataFinal.setBounds(88, 107, 114, 20);
		contentPane.add(txtDataFinal);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(15, 142, 63, 14);
		contentPane.add(lblDescrio);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(88, 138, 267, 56);
		contentPane.add(textArea);
		
					
				}
	}

