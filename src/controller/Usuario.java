package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utils.ConectaBanco;
import view.Menu;

public class Usuario {
	private int id;
	private String senha;
	private String email;
	private String nome;
	private int tipo;
	private String data_cadastro;
	private int usuario_ativo;
	private int st_status;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
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
	
	public void setUsuarioAtivo(int usuario_ativo) {
		this.usuario_ativo = usuario_ativo;
	}
	
	public int getUsuarioAtivo() {
		return this.usuario_ativo;
	}
	
	public void setStatus(int st_status) {
		this.st_status = st_status;
	}
	
	public int getStatus() {
		return st_status;
	}
	
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			ConectaBanco cb = new ConectaBanco();
			conn = cb.conexao();
			
			st = conn.prepareStatement("select * from usuario where st_status = 1");
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Usuario us = new Usuario();
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("email"));
				us.setSenha(rs.getString("senha"));
				us.setNome(rs.getString("nome"));
				us.setTipo(rs.getInt("tipo"));
				us.setDataCadastro(rs.getString("dataCadastro"));
				us.setUsuarioAtivo(rs.getInt("ativo"));
				us.setStatus(rs.getInt("st_status"));
				
				usuarios.add(us);
			}
			rs.close();
			st.close();
			
			return usuarios;
		}catch(SQLException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
		return usuarios;
	}
	
	public boolean cadastrar() {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			ConectaBanco cb = new ConectaBanco();
			conn = cb.conexao();
			
			st = conn.prepareStatement(
					"INSERT INTO usuario"
					+ "(senha, email, nome, tipo, dataCadastro, ativo, st_status)"
					+ "VALUES"
					+ "(?,?,?,?,?,?,1)");
			st.setString(1, this.senha);
			st.setString(2, this.email);
			st.setString(3, this.nome);
			st.setInt(4, this.tipo);
			st.setDate(5, java.sql.Date.valueOf("2013-09-04"));
			st.setInt(6, this.usuario_ativo);
			
			st.execute();
			
			st.close();
			return true;
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			return false;
		}
	}
	
	public boolean atualizar() {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			ConectaBanco cb = new ConectaBanco();
			conn = cb.conexao();
			
			st = conn.prepareStatement(
					"update usuario set"
					+ " email = ?,"
					+ " senha = ?,"
					+ " nome = ?,"
					+ " tipo = ?,"
					+ " dataCadastro = ?,"
					+ " ativo = ?"
					+ " where id = ?");
					
			st.setString(1, this.email);
			st.setString(2, this.senha);
			st.setString(3, this.nome);
			st.setInt(4, this.tipo);
			st.setDate(5, java.sql.Date.valueOf("2013-09-04"));
			st.setInt(6, this.usuario_ativo);
			st.setInt(7, this.id);
			st.execute();
			
			st.close();
			return true;
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			return false;
		}
	}
	
	public boolean deletar() {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			ConectaBanco cb = new ConectaBanco();
			conn = cb.conexao();
			
			st = conn.prepareStatement("update usuario set"
					+ " st_status = 0"
					+ " where id = ?");
			
			st.setInt(1, this.id);
			st.execute();
			
			st.close();
			
			return true;
		}catch(SQLException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
			return false;
		}
	}
	
	public int logar(String email, String senha) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
//		Statement stmt = conn.createStatement();
		
		ConectaBanco cb = new ConectaBanco();
		conn  = cb.conexao();
		
		st = conn.prepareStatement("SELECT * FROM usuario where email = ? and st_status = 1");
		st.setString(1, email);
		
		ResultSet rs;
		
		rs = st.executeQuery();
		
		if(rs.next()) {
			if(senha.equals(rs.getString("senha"))) {
				return 1;
			}else {
				return 2;
			}
		}else {
			// caso não exista o usuario
			return 3;
		}
	}
}
