package strategy1.strategy;

import strategy1.pedido.PedidoV2;

public interface CalculoFrete {

	double calcular(PedidoV2 pedido) throws Exception;
	
}
