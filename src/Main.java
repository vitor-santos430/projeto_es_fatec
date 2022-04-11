import java.util.List;

import controller.Horario;
import controller.Quadra;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quadra quadra1 = new Quadra();
		quadra1.cadastrar("A5BC", 10.50, "Tênis", "30 metros quadrados");
		quadra1.cadastrar("A4BD", 12.50, "Beach tênis", "20 metros quadrados");
		
		List quadras = quadra1.listar();
		
		for(int iterator = 0; iterator < quadras.size(); iterator++) {
			System.out.println(quadras.get(iterator));
		}
		
		Horario horario1 = new Horario();
		horario1.adicionar("6:30", "7:00", "7:30", "8:00");
		horario1.listar();
		
		
		
		
	}

}
