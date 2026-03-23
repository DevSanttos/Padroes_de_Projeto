package strategy1.pedido;
import java.util.ArrayList;
import java.util.List;
import strategy1.strategy.EFrete;

public class PedidoV1 {

	public double calcularFrete() throws Exception {
		// Utilização do padrão Strategy, uma vez que temos vários condicionais aninhados.
		switch (frete) {
			case EFrete.SEDEX : 
				double total = 0;
				for (ItemPedido item:getItensPedido())
					total += item.getProduto().getPeso();
				return total * 3;
			
			case EFrete.TRANSPORTADORA : 
				double totalDim = 0;
				double totalPeso = 0;
				for (ItemPedido item:getItensPedido()) {
					totalDim += item.getProduto().getDimensoes();
					totalPeso += item.getProduto().getPeso();
				}
				return (totalDim * 0.3) + (totalPeso * 1.2);

			case EFrete.COMUM : 
				total = 0;
				for (ItemPedido item:getItensPedido())
					total += item.getProduto().getPeso();
				return total * 0.5;
		}
		return 0;
	}
	
	private List<ItemPedido> itensPedido = new ArrayList<>();
	
	public void addItemPedido(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
	}
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	 
	private EFrete frete;
	
	public PedidoV1(EFrete frete) {
		this.frete = frete;
	}

	public EFrete getFrete() {
		return frete;
	}
}
