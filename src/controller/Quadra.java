package controller;

import java.util.ArrayList;
import java.util.List;

public class Quadra {
	private List quadras = new ArrayList();
	
	public void cadastrar(String codigo, double preco, String tipo, String tamanho) {
		String data = codigo + ";" + preco + ";" + tipo + ";" + tamanho; 
		this.quadras.add(data);
	}
	
	public List listar() {
		return this.quadras;
	}
	
}
