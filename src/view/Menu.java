package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu - Programa de Clube - v0.0.2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 327);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Quadras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final TelaQuadra tq = new TelaQuadra();
				tq.setVisible(true);
			}
		});
		btnNewButton.setBounds(99, 53, 117, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 25));
		lblMenu.setBounds(226, 12, 91, 30);
		contentPane.add(lblMenu);
		
		JButton btnNewButton_1 = new JButton("Clientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(315, 53, 117, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnManutencaoDeQuadras = new JButton("Manutencao de Quadras");
		btnManutencaoDeQuadras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final TelaManutencao tm = new TelaManutencao();
				tm.setVisible(true);
			}
		});
		btnManutencaoDeQuadras.setBounds(99, 149, 117, 56);
		contentPane.add(btnManutencaoDeQuadras);
		
		JButton btnReservaDeQuadras = new JButton("Reserva de Quadras");
		btnReservaDeQuadras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReservaDeQuadras.setBounds(315, 149, 117, 56);
		contentPane.add(btnReservaDeQuadras);
	}
}
