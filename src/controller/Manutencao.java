package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.ConectaBanco;

public class Manutencao {
	

	
	public int     id;
	public int     idQuadra;
	public String  dataInicial;
	public String  dataFinal;
	public String  descricao;
	public boolean finalizada;
	public String  dataCadastro;
    public int     idUsuario;
	  
	  

	public Manutencao() {
	
	}



	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getIdQuadra() {
		return idQuadra;
	}





	public void setIdQuadra(int idQuadra) {
		this.idQuadra = idQuadra;
	}





	public String getDataInicial() {
		return dataInicial;
	}





	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}





	public String getDataFinal() {
		return dataFinal;
	}





	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}





	public String descricao() {
		return descricao;
	}





	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}





	public boolean isFinalizada() {
		return finalizada;
	}





	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}





	public String getDataCadastro() {
		return dataCadastro;
	}





	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}





	public int getIdUsuario() {
		return idUsuario;
	}





	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}





	public boolean cadastrarManutencao() {
		Connection conn= null;
		PreparedStatement st = null;
		try {
			ConectaBanco cb = new ConectaBanco();
			 conn = cb.conexao();
			
			st = conn.prepareStatement(
					"INSERT INTO manutencao"
					+ "(idQuadra, dataInicial, dataFinal , descricao, dataCadastro, idusuario)"
					+ "VALUES"
					+ "(?,?,?,?,?,?)");
			st.setInt   (1, this.idQuadra);
			st.setDate  (2, java.sql.Date.valueOf(this.dataInicial));
			st.setDate  (3, java.sql.Date.valueOf(this.dataFinal));
			st.setString(4, this.descricao);
			st.setDate  (5, java.sql.Date.valueOf(this.dataCadastro));
			st.setInt   (6, this.idUsuario);
			
			st.execute();
			
			
			
			
			st.close();
			return true;
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		return false;
	}
	
	
		
	
	

}