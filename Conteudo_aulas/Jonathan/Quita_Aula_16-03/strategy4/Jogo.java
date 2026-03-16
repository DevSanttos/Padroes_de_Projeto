package strategy4;

import strategy4.jogo.Mecha;

public class Jogo {

	public static void main(String[] args) throws Exception {
		System.out.println("Iniciou");
		
		Mecha m1 = new Mecha();
		m1.mover(10, 30);
		m1.mover(30, 50);
		
		m1.entrarModoVoo();
		
		m1.mover(40, 80);
		m1.mover(20, 10);
		
		m1.entrarModoCombate();

		m1.mover(50, 30);
		m1.mover(20, 50);
	}

}
