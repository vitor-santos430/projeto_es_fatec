package controller;

import java.util.ArrayList;
import java.util.List;

public class Horario {
	private List horario = new ArrayList();

	public List getHorario() {
		return horario;
	}

	public void setHorario(List horario) {
		this.horario = horario;
	}

	public void adicionar(String v1, String v2, String v3, String v4) {
		String horarios = "Horários disponíveis:\n" + v1 + "\n" + v2 + "\n" + v3 + "\n" + v4;
		this.horario.add(horarios);
	}
	
	public List listar() {
		
		for(int iterator = 0; iterator < horario.size(); iterator++) {
			System.out.println(horario.get(iterator));
		}
		return horario;
		
	}

	

}
