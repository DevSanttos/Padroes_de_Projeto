package strategy3;

import strategy3.loja.DescontoEspecial;
import strategy3.loja.DescontoPadrao;
import strategy3.loja.ItemVenda;
import strategy3.loja.Venda;


public class Sistema {

	public static void main(String[] args) {

		ItemVenda itemVenda1 = new ItemVenda(100, 3);
		ItemVenda itemVenda2 = new ItemVenda(50, 1);

		Venda venda1 = new Venda(new DescontoEspecial(20, 300));

		venda1.add(itemVenda1);
		venda1.add(itemVenda2);

		System.out.println("Valor com desconto especial: " + venda1.getValorTotalAPagar());

		/* -------------- */

		ItemVenda itemVenda3 = new ItemVenda(100, 1);

		Venda venda2 = new Venda(new DescontoPadrao(0.15));
		
		venda2.add(itemVenda3);

		System.out.println("Valor com desconto padrão: " + venda2.getValorTotalAPagar());
	}
}
