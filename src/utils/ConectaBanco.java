package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class ConectaBanco {
	public Statement conexao() {
		String user = "root";
		String senha = "";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/db_sistema_clube";
			conn = DriverManager.getConnection(url, user, senha);
			stmt = conn.createStatement();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}	
		
		return stmt;
	}
}
