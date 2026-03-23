package strategy3.loja;

public class DescontoPadrao implements ValidaDesconto {

    private double percentual;

    public DescontoPadrao(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(Venda venda) {
        double total = venda.getValorTotalBruto();
        return total - (total * percentual);
    }      
}
