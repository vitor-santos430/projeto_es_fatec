package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import utils.ConectaBanco;

public class Usuario {
	private int id;
	private String senha;
	private String email;
	private String nome;
	private int tipo;
	private String data_cadastro;
	private boolean usuario_ativo;
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return this.tipo;
	}
	
	public void setDataCadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	public String getDataCadastro() {
		return this.data_cadastro;
	}
	
	public void setUsuarioAtivo(boolean usuario_ativo) {
		this.usuario_ativo = usuario_ativo;
	}
	
	public boolean getUsuarioAtivo() {
		return this.usuario_ativo;
	}
	
	public boolean cadastrar() {
		Connection conn= null;
		PreparedStatement st = null;
		
		try {
			ConectaBanco cb = new ConectaBanco();
			 conn = cb.conexao();
			
			st = conn.prepareStatement(
					"INSERT INTO usuario"
					+ "(senha, email, nome, tipo, dataCadastro, ativo)"
					+ "VALUES"
					+ "(?,?,?,?,?,?)");
			st.setString(1, this.senha);
			st.setString(2, this.email);
			st.setString(3, this.nome);
			st.setInt(4, this.tipo);
			st.setDate(5, java.sql.Date.valueOf("2013-09-04"));
			st.setBoolean(6, this.usuario_ativo);
			
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
