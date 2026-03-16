
import java.util.Date;

public class GerenciaAquisicao {
	private String fornecedor;
	
	private String notaFiscal;
    private Livro livro;

    public GerenciaAquisicao(String fornecedor, String notaFiscal, String tipoAquisicao) {
        this.fornecedor = fornecedor;
        this.notaFiscal = notaFiscal;
    }

    public void registrarAquisicao(String fornecedor, double preco, String notaFiscal, Livro livro) {
		this.fornecedor = fornecedor;
		livro.setPrecoCompra(preco);
		this.notaFiscal = notaFiscal;
		this.livro.setDataAquisicao(new Date());

		// Aplicar depreciacao inicial
		if ("Compra".equals(livro.getTipoAquisicao())) {
			if (preco > 100) {
				System.out.println("Livro de alto valor - necessidade de seguro");
			}
		} else if ("Doacao".equals(livro.getTipoAquisicao())) {
			validarDoacao();
		}
	}

    private void validarDoacao() {
		// Regras para aceitar doacoes
		if (livro.getAnoPublicacao() < 2000) {
			System.out.println("Livro muito antigo - avaliar estado de conservacao");
		}

		if (livro.getEstadoConservacao().equals("Danificado")) {
			throw new IllegalStateException("Doacao recusada - livro danificado");
		}
	}
    
    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}