package strategy3.loja;

import java.util.ArrayList;
import java.util.List;

public class Venda {

	private List<ItemVenda> itens = new ArrayList<>();
	private ValidaDesconto estrategiaDesconto;

    public Venda(ValidaDesconto estrategiaDesconto) {
        this.estrategiaDesconto = estrategiaDesconto;
    }

	public void add(ItemVenda item) {
		itens.add(item);
	}
	
	public double getValorTotalBruto() {
		double res = 0;
		for (ItemVenda item:itens)
			res += item.getPrecoUnit()*item.getQtdade();
		return res;
	}
	
	public double getValorTotalAPagar() {
		return estrategiaDesconto.aplicarDesconto(this);
	}

	public double pagar() {
		return 0;
	}
	
}
