package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Quadra;

public class Reserva extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva frame = new Reserva();
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
	public Reserva() {
		setTitle("Reserva de Quadra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int i;
		
		JComboBox comboBox = new JComboBox();
		Quadra quadra = new Quadra();
		List<Quadra> quadras = new ArrayList();
		quadras = quadra.listarQuadra();
		
		
		
		comboBox.setBounds(41, 119, 357, 24);
		contentPane.add(comboBox);
		for(i=0;i < quadras.size(); i++) {
		comboBox.addItem("Numero: " + quadras.get(i).numero + " Valor por Hora: " + quadras.get(i).valorHora + " Tipo: " + quadras.get(i).tipo);
		}
		
		
		JButton btnReservarHorario = new JButton("Reservar Horario");
		btnReservarHorario.setBounds(371, 279, 154, 25);
		contentPane.add(btnReservarHorario);
	}
}
