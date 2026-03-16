package strategy4.jogo;

public class Mecha {

	private int modo = 2;

	public void mover(int x, int y) throws Exception {
		if (modo == 1) {
			
			Thread.sleep(100); // chega mais rapido ao destino
			System.out.println("Voando");
			
		} else {
			if (modo == 2) {
				Thread.sleep(1000); // demora mais para chegar ao destino
				System.out.println("Andando");
			} else {
				if (modo == 3) {
					Thread.sleep(2000); // demora ainda mais para chegar ao destino
					System.out.println("Combatendo");
					
				}
			}
		}
	}
	
	public void entrarModoVoo() {
		this.modo = 1;
	}
	
	public void entrarModoAndar() {
		this.modo = 2;
	}
	
	public void entrarModoCombate() {
		this.modo = 3;
	}
	
}
