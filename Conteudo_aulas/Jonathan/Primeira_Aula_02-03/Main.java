import exercicio01.Pedido;

public class Main {
    public static void main(String[] args) {
        Pedido pedidoPf = new Pedido(100, "PF", "avista");
        Pedido pedidoPj = new Pedido(100, "PJ", "avista");

        System.out.println(pedidoPf.calcularValorFinal());
        System.out.println(pedidoPj.calcularValorFinal());
    }
}
