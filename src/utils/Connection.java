package utils;

//import java.sql.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Connection {
	public Connection conectaDB(){
		Connection conn = null;
		
		try 
		{
			String url = "jdbc:mysql://localhost/db_sistema_clube?user=root&password=";
			conn = (Connection)DriverManager.getConnection(url);
			
			System.out.println("Conectado");
		}
		catch(SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return conn;
	}
}
