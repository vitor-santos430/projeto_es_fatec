package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectaBanco {
	public Connection conexao() {
		String user = "root";
		String senha = "";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/clube";
			conn = DriverManager.getConnection(url, user, senha);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		
		return conn;
	}
}
