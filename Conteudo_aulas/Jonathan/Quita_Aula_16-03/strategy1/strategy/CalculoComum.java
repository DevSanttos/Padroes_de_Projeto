package strategy1.strategy;

import strategy1.pedido.ItemPedido;
import strategy1.pedido.PedidoV2;

public class CalculoComum implements CalculoFrete {

	@Override
	public double calcular(PedidoV2 pedido) throws Exception {
		double total = 0;
		for (ItemPedido item:pedido.getItensPedido())
			total += item.getProduto().getPeso();
		return total * 0.5;
	}

}
