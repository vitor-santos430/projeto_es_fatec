import view.ViewLogin;

import javax.swing.JOptionPane;

import controller.Usuario;

public class Main {

	public static void main(String[] args) {
//		ViewLogin vl = new ViewLogin();
//		vl.setVisible(true);
		Usuario us1 = new Usuario();
		us1.setEmail("vitor@email.com");
		us1.setSenha("1234");
		us1.setNome("Vitor");
		us1.setUsuarioAtivo(true);
		us1.setTipo(1);
		try {
			us1.cadastrar();
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
