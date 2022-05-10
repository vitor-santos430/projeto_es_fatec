import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		String user = "root";
		String senha = "";
		
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/db_sistema_clube";
			conn = DriverManager.getConnection(url,user, senha);
			JOptionPane.showMessageDialog(null,"Banco conectado");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}
