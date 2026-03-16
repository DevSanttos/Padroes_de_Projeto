package strategy1;
import strategy1.pedido.ItemPedido;
import strategy1.pedido.PedidoV1;
import strategy1.pedido.PedidoV2;
import strategy1.pedido.Produto;
import strategy1.strategy.CalculoSedex;
import strategy1.strategy.CalculoTransportadora;
import strategy1.strategy.EFrete;

public class SistemaV1 {

	public static void main(String[] args) throws Exception {

		Produto p1 = new Produto("Chocolate", 0.1, 0.01);
		Produto p2 = new Produto("Leite", 1, 0.3);
		
		PedidoV1 pv1 = new PedidoV1(EFrete.SEDEX);
		pv1.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv1.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv1.calcularFrete());
		
		PedidoV1 pv1_2 = new PedidoV1(EFrete.TRANSPORTADORA);
		pv1_2.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv1_2.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv1_2.calcularFrete());

		PedidoV1 pv1_3 = new PedidoV1(EFrete.COMUM);
		pv1_3.addItemPedido(new ItemPedido(p1, 10, 0.9));
		pv1_3.addItemPedido(new ItemPedido(p2, 24, 1.5));
		System.out.println(pv1_3.calcularFrete());
	}

}
