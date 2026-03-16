package strategy1.pedido;
import java.util.ArrayList;
import java.util.List;

import strategy1.strategy.CalculoFrete;

public class PedidoV2 {

	public double calcularFrete() throws Exception {
		return frete.calcular(this);
	}
	
	private List<ItemPedido> itensPedido = new ArrayList<>();
	
	public void addItemPedido(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
	}
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	 
	private CalculoFrete frete;
	
	public PedidoV2(CalculoFrete calculoFrete) {
		this.frete = calculoFrete;
	}

	public CalculoFrete getCalculoFrete() {
		return frete;
	}


}
