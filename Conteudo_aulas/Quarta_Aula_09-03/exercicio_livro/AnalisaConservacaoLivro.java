public class AnalisaConservacaoLivro {
    Livro livro;

    public AnalisaConservacaoLivro(Livro livro) {
        this.livro = livro;
    }
    
    public void avaliarConservacao() {
		// Regras de avaliacao fisica 
		int pontuacao = 0;

		// Verificar capa
		pontuacao += verificarCapa();

		// Verificar lombada
		pontuacao += verificarLombada();

		// Verificar paginas
		pontuacao += verificarPaginas();

		// Classificar estado
		if (pontuacao >= 90) {
			livro.getEstadoConservacao().equals("NOVO");
		} else if (pontuacao >= 70) {
            livro.getEstadoConservacao().equals("BOM");
		} else if (pontuacao >= 50) {
            livro.getEstadoConservacao().equals("REGULAR");
		} else {
            livro.getEstadoConservacao().equals("DANIFICADO");
		}
	}

	private int verificarCapa() {
		return 25; // Simulacao
	}

	private int verificarLombada() {
		return 25; // Simulacao
	}

	private int verificarPaginas() {
		int descontos = 0;
		if (livro.getNumeroPaginas() > 500) {
			descontos += 5; // Livros grandes desgastam mais
		}
		return 30 - descontos;
	}

	public void aplicarConservacao() {
		// Procedimentos de restauracao 
		if ("DANIFICADO".equals(livro.getEstadoConservacao())) {
			System.out.println("Encaminhar para restauracao");
		} else if ("REGULAR".equals(livro.getEstadoConservacao())) {
			System.out.println("Aplicar reparos simples");
		}
	}

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }


}