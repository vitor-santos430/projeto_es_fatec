import view.ViewLogin;

import java.util.List;

import javax.swing.JOptionPane;

import controller.Usuario;

public class Main {

	public static void main(String[] args) {
//		ViewLogin vl = new ViewLogin();
//		vl.setVisible(true);
		Usuario us1 = new Usuario();
		us1.setEmail("camila@email.com");
		us1.setSenha("cami123");
		us1.setNome("Camila");
		us1.setUsuarioAtivo(1);
		us1.setTipo(1);
		us1.setId(2);
		
		try {
			if(us1.cadastrar()) {
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuario");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		try {
			List<Usuario> usuarios = us1.listar();
			
			for(Usuario usuario : usuarios) {
				System.out.println("id: " + usuario.getId());
				System.out.println("email: " + usuario.getEmail());
				System.out.println("nome: " + usuario.getNome());
				System.out.println("Tipo: " + usuario.getTipo());
				System.out.println("Data do cadastro: " + usuario.getDataCadastro());
				System.out.println("Ativo: " + usuario.getUsuarioAtivo());
				System.out.println("*");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}