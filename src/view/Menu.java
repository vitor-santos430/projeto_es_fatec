package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Menu - Programa de Clube - v0.0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnNewButton.setBounds(131, 123, 117, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMenu.setBounds(251, 53, 48, 15);
		contentPane.add(lblMenu);
		
		JButton btnNewButton_1 = new JButton("Clientes");
		btnNewButton_1.setBounds(309, 123, 117, 56);
		contentPane.add(btnNewButton_1);
	}
}
