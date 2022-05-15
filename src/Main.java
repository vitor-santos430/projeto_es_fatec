<<<<<<< HEAD
import utils.Connection;
=======
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;
>>>>>>> 7b4872de547180863dc0302ed5235d2b06c560fc

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		Connection conn = new Connection();
		conn.conectaDB();
=======
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
		
>>>>>>> 7b4872de547180863dc0302ed5235d2b06c560fc
	}

}
