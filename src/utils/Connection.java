package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connection {
	public Connection conectaDB(){
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/db_sistema_clube?user=root&password=vidabela";
			conn = (Connection)DriverManager.getConnection(url);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return conn;
	}
}
