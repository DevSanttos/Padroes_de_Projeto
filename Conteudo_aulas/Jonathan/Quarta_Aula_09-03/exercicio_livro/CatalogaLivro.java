import java.util.Date;
import java.util.List;

public class CatalogaLivro {
	private String cdd; // Classificacao Decimal de Dewey
	private String cdu; // Classificacao Decimal Universal
	private String cutter;
	private List<String> palavrasChave;
    private Livro livro;
    
    public CatalogaLivro(String cdd, String cdu, String cutter) {
        this.cdd = cdd;
        this.cdu = cdu;
        this.cutter = cutter;
    }

    public void catalogarLivro() {
		// Regras de catalogacao que mudam conforme padroes biblioteconomicos
		gerarClassificacaoCDD();
		gerarClassificacaoCDU();
		gerarNotacaoCutter();
		extrairPalavrasChave();
		definirLocalizacaoFisica();
	}

    private void gerarClassificacaoCDD() {
		// Regras da Classificacao Decimal de Dewey (atualizada periodicamente)
		if ("Ficcao Cientifica".equals(livro.getCategorias())) {
			this.cdd = "813.0876";
		} else if ("Romance".equals(livro.getCategorias().get(0))) {
			this.cdd = "813.085";
		} else if ("Biografia".equals(livro.getCategorias().get(0))) {
			this.cdd = "920";
		} else if ("Historia".equals(livro.getCategorias().get(0))) {
			this.cdd = "900";
		} else if ("Poesia".equals(livro.getCategorias().get(0))) {
			this.cdd = "811";
		}

		// Regras para subcategorias (mudam conforme nova edicao do Dewey)
		if (livro.getCategorias().size() > 1) {
			String subcategoria = livro.getCategorias().get(1);
			if ("Brasil".equals(subcategoria) && "900".equals(cdd)) {
				this.cdd = "981";
			}
		}
	}

    private void gerarClassificacaoCDU() {
		// Regras da Classificacao Decimal Universal (mudam conforme padroes
		// internacionais)
		if ("Ficcao Cientifica".equals(livro.getCategorias().get(0))) {
			this.cdu = "821.111-311.9";
		} else if ("Romance".equals(livro.getCategorias().get(0))) {
			this.cdu = "821.111-31";
		} else if ("Biografia".equals(livro.getCategorias().get(0))) {
			this.cdu = "929";
		}
	}

	private void gerarNotacaoCutter() {
		// Regras da Tabela Cutter-Sanborn (mudam conforme novas tabelas)
		String autorUpper = livro.getAutor().toUpperCase();
		char primeiraLetra = autorUpper.charAt(0);

		// Tabela Cutter simplificada (que pode ser substituida por versao mais
		// completa)
		switch (primeiraLetra) {
		case 'A':
			this.cutter = "A111";
			break;
		case 'B':
			this.cutter = "B222";
			break;
		case 'C':
			this.cutter = "C333";
			break;
		case 'D':
			this.cutter = "D444";
			break;
		case 'E':
			this.cutter = "E555";
			break;
		default:
			this.cutter = primeiraLetra + "999";
		}

		// Adicionar letra do titulo
		this.cutter += livro.getTitulo().toUpperCase().charAt(0);
	}

    private void extrairPalavrasChave() {
		// Regras de indexacao 
		palavrasChave.clear();

		// Extrair do titulo (stopwords sao ignoradas)
		String[] palavras = livro.getTitulo().split(" ");
		for (String palavra : palavras) {
			if (palavra.length() > 3 && !isStopWord(palavra)) {
				palavrasChave.add(palavra.toLowerCase());
			}
		}

		// Adicionar autor como palavra-chave
		palavrasChave.add(livro.getAutor().toLowerCase());

		// Adicionar categorias como palavras-chave
		for (String categoria : livro.getCategorias()) {
			palavrasChave.add(categoria.toLowerCase());
		}
	}

    private boolean isStopWord(String palavra) {
		List<String> stopwords = List.of("e", "de", "da", "do", "em", "para", "com", "um", "uma");
		return stopwords.contains(palavra.toLowerCase());
	}

	public double calcularValorPatrimonial() {
		// Regras de depreciacao contabil (mudam conforme normas)
		int idade = new Date().getYear() - livro.getDataAquisicao().getYear();
		double valorDepreciado = livro.getPrecoCompra();

		// Depreciacao anual (regra que muda)
		for (int i = 0; i < idade; i++) {
			valorDepreciado *= 0.9; // 10% ao ano
		}

		// Livros raros podem valorizar (regra especial)
		if (livro.getAnoPublicacao() < 1950 && "Bom".equals(livro.getEstadoConservacao())) {
			valorDepreciado = livro.getPrecoCompra() * (1 + (idade * 0.05)); // Valorizacao
		}

		return valorDepreciado;
	}

    private void definirLocalizacaoFisica() {
		// Regras de localizacao na biblioteca (mudam com reorganizacao do espaco)
		if ("Ficcao Cientifica".equals(livro.getCategorias())) {
			livro.setLocalizacaoFisica("ESTANTE FICcaO - PRATELEIRA 3");
		} else if ("Romance".equals(livro.getCategorias())) {
            livro.setLocalizacaoFisica("ESTANTE ROMANCE - PRATELEIRA 2");
		} else if ("Infantil".equals(livro.getCategorias())) {
            livro.setLocalizacaoFisica("SETOR INFANTIL - PRATELEIRA 1");
		} else {
            livro.setLocalizacaoFisica("ESTANTE GERAL - PRATELEIRA 5");
		}
	}

    public String getCdd() {
        return cdd;
    }

    public void setCdd(String cdd) {
        this.cdd = cdd;
    }

    public String getCdu() {
        return cdu;
    }

    public void setCdu(String cdu) {
        this.cdu = cdu;
    }

    public String getCutter() {
        return cutter;
    }

    public void setCutter(String cutter) {
        this.cutter = cutter;
    }

    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(List<String> palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
}