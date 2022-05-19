package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.ConectaBanco;

public class Quadra {
	
	public int numero;
	public float valorHora;
	public int tipo;
	public double horas[];
	public boolean possui_cobertura;
	public boolean possui_arquibancada;
	public boolean possui_banco;
	public boolean status;
	
	

	public Quadra() {
		numero = 0 ;
		valorHora = 0;
		tipo = 0;
		possui_cobertura = false;
		possui_arquibancada = false;
		possui_banco = false;
		status = false;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public float getValorHora() {
		return valorHora;
	}



	public void setValorHora(float f) {
		this.valorHora = f;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public boolean isPossui_cobertura() {
		return possui_cobertura;
	}



	public void setPossui_cobertura(boolean possui_cobertura) {
		this.possui_cobertura = possui_cobertura;
	}



	public boolean isPossui_arquibancada() {
		return possui_arquibancada;
	}



	public void setPossui_arquibancada(boolean possui_arquibancada) {
		this.possui_arquibancada = possui_arquibancada;
	}



	public boolean isPossui_banco() {
		return possui_banco;
	}



	public void setPossui_banco(boolean possui_banco) {
		this.possui_banco = possui_banco;
	}
	public boolean isStatus(boolean status) {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean cadastrarQuadra() {
		Connection conn= null;
		PreparedStatement st = null;
		try {
			ConectaBanco cb = new ConectaBanco();
			 conn = cb.conexao();
			
			st = conn.prepareStatement(
					"INSERT INTO quadra"
					+ "(numero, idTipoQuadra, dataCadastroQuadra , cobertura, banco, arquibancada, valorHora, st_status)"
					+ "VALUES"
					+ "(?,?,?,?,?,?,?,?)");
			st.setInt(1, this.numero);
			st.setInt(2, this.tipo);
			st.setDate(3, java.sql.Date.valueOf("2013-09-04"));
			st.setBoolean(4, this.possui_cobertura);
			st.setBoolean(5, this.possui_banco);
			st.setBoolean(6, this.possui_arquibancada);
			st.setFloat(7, this.valorHora);
			st.setBoolean(8, this.status);
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