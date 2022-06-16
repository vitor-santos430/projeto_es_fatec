package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TesteJList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJList frame = new TesteJList();
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
	public TesteJList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] colunas = {"Nome", "Telefone", "Email"};
				Object [][] dados = {
					{"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
					{"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
					{"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
				};
				 table = new JTable(dados, colunas);
		        //add the table to the frame
		        contentPane.add(new JScrollPane(table));
				 table.setBounds(35, 12, 357, 188);
				 contentPane.add(table);
				 
				
			}
		});
		btnNewButton.setBounds(130, 213, 117, 25);
		contentPane.add(btnNewButton);
	}
}
