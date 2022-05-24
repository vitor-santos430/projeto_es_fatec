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

import controller.Quadra;
import utils.ConectaBanco;
import javax.swing.JList;

public class TelaQuadra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblCadastroDeQuadra = new JLabel("Cadastro de Quadra");
	private JTextField txtNumeroQuadra;
	private JLabel lblTipo;
	private int type;
	private boolean status;

	
	private JTextField txtValorPorHora;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQuadra frame = new TelaQuadra();
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
	public TelaQuadra() {
		setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Quadras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCadastroDeQuadra.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCadastroDeQuadra.setBounds(106, 12, 261, 17);
		contentPane.add(lblCadastroDeQuadra);
		
		JLabel lblNome = new JLabel("Numero:");
		lblNome.setBounds(15, 44, 70, 17);
		contentPane.add(lblNome);
		
		txtNumeroQuadra = new JTextField();
		txtNumeroQuadra.setColumns(10);
		txtNumeroQuadra.setBounds(88, 41, 114, 19);
		contentPane.add(txtNumeroQuadra);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(15, 116, 70, 15);
		contentPane.add(lblTipo);
		
		JRadioButton radSaibro = new JRadioButton("Saibro");
		radSaibro.setBounds(141, 108, 82, 23);
		contentPane.add(radSaibro);
		
		JRadioButton radRapida = new JRadioButton("Rapida");
		radRapida.setBounds(232, 108, 82, 23);
		contentPane.add(radRapida);
		
		JRadioButton radBeachTenis = new JRadioButton("Beach tenis");
		radBeachTenis.setBounds(311, 108, 114, 23);
		contentPane.add(radBeachTenis);
		
		ButtonGroup tipo = new ButtonGroup();
		tipo.add(radBeachTenis);
		tipo.add(radSaibro);
		tipo.add(radRapida);
		txtValorPorHora = new JTextField();
		txtValorPorHora.setColumns(10);
		txtValorPorHora.setBounds(142, 78, 47, 19);
		contentPane.add(txtValorPorHora);
		
		JLabel lblValorPorHora = new JLabel("Valor por hora:");
		lblValorPorHora.setBounds(15, 80, 117, 17);
		contentPane.add(lblValorPorHora);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(15, 177, 59, 15);
		contentPane.add(lblStatus);
		
		JRadioButton radAtiva = new JRadioButton("ativa");
		radAtiva.setBounds(82, 173, 75, 23);
		contentPane.add(radAtiva);
		
		JRadioButton radInativa = new JRadioButton("inativa");
		radInativa.setBounds(165, 173, 82, 23);
		contentPane.add(radInativa);
		
		ButtonGroup situacao = new ButtonGroup();
		situacao.add(radAtiva);
		situacao.add(radInativa);
		
		
		JLabel lblEspecificacoes = new JLabel("Especificações:");
		lblEspecificacoes.setBounds(15, 150, 120, 15);
		contentPane.add(lblEspecificacoes);
		
		JCheckBox ckbCoberta = new JCheckBox("Coberta");
		ckbCoberta.setBounds(141, 142, 82, 23);
		contentPane.add(ckbCoberta);
		
		JCheckBox ckbBanco = new JCheckBox("Banco");
		ckbBanco.setBounds(232, 142, 70, 23);
		contentPane.add(ckbBanco);
		
		JCheckBox ckbArquibancada = new JCheckBox("Arquibancada");
		ckbArquibancada.setBounds(311, 142, 129, 23);
		contentPane.add(ckbArquibancada);
		
		JButton btnCadastrarQuadra = new JButton("Cadastrar Quadra");
		btnCadastrarQuadra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quadra quadra = new Quadra();
				quadra.setValorHora(Float.parseFloat(txtValorPorHora.getText()));
				quadra.setNumero(Integer.parseInt(txtNumeroQuadra.getText()));
				if (radSaibro.isSelected()) {
					type = 1;
				}
				else if(radRapida.isSelected()) {
					type = 2;
				}
				else {
					type = 3;
				}
				quadra.setTipo(type);
				if(ckbCoberta.isSelected()) 
					quadra.setPossui_cobertura(true);
				if(ckbBanco.isSelected())
					quadra.setPossui_banco(true);
				
				if(ckbArquibancada.isSelected()) 
					quadra.setPossui_arquibancada(true);
				
				if(radAtiva.isSelected()) {
					status = true;
				}
				
				else {
					status = false;
				}
				
				if (quadra.cadastrarQuadra()){
					
				
				
				
				JOptionPane.showMessageDialog(null, "A quadra foi cadastrada com sucesso", "Cadastro de quadra", JOptionPane.INFORMATION_MESSAGE);
				
				txtValorPorHora.setText(" ");
				txtNumeroQuadra.setText(" ");
				tipo.clearSelection();
				ckbBanco.setSelected(false);
				ckbCoberta.setSelected(false);
				ckbArquibancada.setSelected(false);
				
				}else {
					JOptionPane.showMessageDialog(null, "A quadra ja esta cadastrada","Cadastro de quadra", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				
			}
		});
		btnCadastrarQuadra.setBounds(45, 214, 163, 25);
		contentPane.add(btnCadastrarQuadra);
		
		JButton btnListarQuadras = new JButton("listar quadras");
		btnListarQuadras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quadra quadra = new Quadra();
				quadra.listarQuadra();
			
				
				
				
			}
		});
	
		btnListarQuadras.setBounds(253, 214, 150, 25);
		contentPane.add(btnListarQuadras);
		
		JList list = new JList();
		list.setBounds(15, 251, 423, 168);
		contentPane.add(list);
		
		
		
		
		
		
	
					
					
				}
	}

