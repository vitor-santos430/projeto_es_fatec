package controller;

public class Quadra {
	
	public String nome;
	public String id;
	public String tipo;
	public double horas[];
	public boolean possui_cobertura;
	public boolean possui_arquibancada;
	public boolean possui_banco;
	
	

	public Quadra() {
		nome = " " ;
		id = " ";
		tipo = " ";
		possui_cobertura = false;
		possui_arquibancada = false;
		possui_banco = false;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
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
		
	
	

}