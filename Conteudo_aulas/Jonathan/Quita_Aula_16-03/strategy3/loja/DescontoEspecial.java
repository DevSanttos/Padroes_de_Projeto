package strategy3.loja;

public class DescontoEspecial implements ValidaDesconto {

    private double valorMinimo;
    private double valorDesconto;

    public DescontoEspecial(double valorDesconto, double valorMinimo) {
        this.valorDesconto = valorDesconto;
        this.valorMinimo = valorMinimo;
    }

    @Override
    public double aplicarDesconto(Venda venda) {
        double total = venda.getValorTotalBruto();
        
        if (total > valorMinimo) {
            return total - valorDesconto;
        }
        return total;
    }

}
