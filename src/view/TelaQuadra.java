package view;

import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class TelaQuadra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblCadastroDeQuadra = new JLabel("Cadastro de Quadra");
	private JTextField txtId;
	private JTextField txtNome;
	private JLabel lblTipo;
	private String type;

	private ArrayList<Quadra> quadras = new ArrayList<Quadra>();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCadastroDeQuadra.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCadastroDeQuadra.setBounds(106, 12, 261, 17);
		contentPane.add(lblCadastroDeQuadra);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(15, 53, 25, 17);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(88, 52, 47, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 86, 56, 17);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(88, 83, 114, 19);
		contentPane.add(txtNome);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(15, 119, 70, 15);
		contentPane.add(lblTipo);
		
		JRadioButton radSaibro = new JRadioButton("Saibro");
		radSaibro.setBounds(141, 115, 82, 23);
		contentPane.add(radSaibro);
		
		JRadioButton radRapida = new JRadioButton("Rapida");
		radRapida.setBounds(232, 115, 82, 23);
		contentPane.add(radRapida);
		
		JRadioButton radBeachTenis = new JRadioButton("Beach tenis");
		radBeachTenis.setBounds(311, 115, 114, 23);
		contentPane.add(radBeachTenis);
		
		ButtonGroup tipo = new ButtonGroup();
		tipo.add(radBeachTenis);
		tipo.add(radSaibro);
		tipo.add(radRapida);
		
		
		JLabel lblEspecificacoes = new JLabel("Especificações:");
		lblEspecificacoes.setBounds(12, 150, 120, 15);
		contentPane.add(lblEspecificacoes);
		
		JCheckBox ckbCoberta = new JCheckBox("Coberta");
		ckbCoberta.setBounds(141, 146, 82, 23);
		contentPane.add(ckbCoberta);
		
		JCheckBox ckbBanco = new JCheckBox("Banco");
		ckbBanco.setBounds(232, 146, 70, 23);
		contentPane.add(ckbBanco);
		
		JCheckBox ckbArquibancada = new JCheckBox("Arquibancada");
		ckbArquibancada.setBounds(311, 146, 129, 23);
		contentPane.add(ckbArquibancada);
		
		JButton btnCadastrarQuadra = new JButton("Cadastrar Quadra");
		btnCadastrarQuadra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quadra quadra = new Quadra();
				quadra.setId(txtId.getText());
				quadra.setNome(txtNome.getText());
				if (radSaibro.isSelected()) {
					type = "Saibro";
				}
				else if(radRapida.isSelected()) {
					type = "Rapida";
				}
				else {
					type = "Beach Tenis";
				}
				quadra.setTipo(type);
				if(ckbCoberta.isSelected()) 
					quadra.setPossui_cobertura(true);
				if(ckbBanco.isSelected())
					quadra.setPossui_banco(true);
				
				if(ckbArquibancada.isSelected()) 
					quadra.setPossui_arquibancada(true);
				quadras.add(quadra);
				
				JOptionPane.showMessageDialog(null, "A quadra foi cadastrada com sucesso", "Cadastro de quadra", JOptionPane.INFORMATION_MESSAGE);
				
				txtId.setText(" ");
				txtNome.setText(" ");
				tipo.clearSelection();
				ckbBanco.setSelected(false);
				ckbCoberta.setSelected(false);
				ckbArquibancada.setSelected(false);
			}
		});
		btnCadastrarQuadra.setBounds(26, 214, 163, 25);
		contentPane.add(btnCadastrarQuadra);
		
		
		
		JButton btnQuadrasCadastradas = new JButton("Quadras Cadastradas");
		btnQuadrasCadastradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < quadras.size(); i++) {
					System.out.println("Id: "+ quadras.get(i).getId());
					System.out.println("Nome: "+ quadras.get(i).getNome());
					System.out.println("Tipo: "+ quadras.get(i).getTipo());
					System.out.println("Coberta: "+ quadras.get(i).isPossui_cobertura());
					System.out.println("Arquibancada: "+ quadras.get(i).isPossui_arquibancada());
					System.out.println("Banco: "+ quadras.get(i).isPossui_banco());
					
					
					
				}
			}
		});
		btnQuadrasCadastradas.setBounds(215, 214, 208, 25);
		contentPane.add(btnQuadrasCadastradas);
		
		
		
	}
}
