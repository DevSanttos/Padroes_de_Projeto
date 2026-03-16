import java.util.Date;
import java.util.List;

public class GerenciaEmprestimo {
	
	private int totalEmprestimos;
	private Date dataUltimoEmprestimo;
	private List<Emprestimo> historicoEmprestimos;
    private Livro livro;

    public GerenciaEmprestimo(Date dataUltimoEmprestimo, int totalEmprestimos, Livro livro) {
        this.dataUltimoEmprestimo = dataUltimoEmprestimo;
        this.totalEmprestimos = totalEmprestimos;
        this.livro = livro;
    }

    public void emprestar(String nomeUsuario, String matricula) {
		if (!livro.isDisponivel()) {
			throw new IllegalStateException("Livro nao disponivel para emprestimo");
		}

		if (totalEmprestimosHoje(matricula) >= 3) {
			throw new IllegalStateException("Usuario atingiu limite de emprestimos");
		}

		if (usuarioTemMulta(matricula) > 10) {
			throw new IllegalStateException("Usuario com multas pendentes");
		}

		// Registrar emprestimo
		Emprestimo emprestimo = new Emprestimo(nomeUsuario, matricula, new Date());
		historicoEmprestimos.add(emprestimo);
		livro.setDisponivel(false);
		totalEmprestimos++;
		dataUltimoEmprestimo = new Date();

		Date dataDevolucao = calcularDataDevolucao(matricula);
		System.out.println("Emprestado para " + nomeUsuario + " - Devolucao: " + dataDevolucao);
	}

	private int totalEmprestimosHoje(String matricula) {
		int hoje = 0;
		for (Emprestimo e : historicoEmprestimos) {
			if (e.getMatricula().equals(matricula) && e.getDataEmprestimo().getDate() == new Date().getDate()) {
				hoje++;
			}
		}
		return hoje;
	}

	private double usuarioTemMulta(String matricula) {
		double totalMulta = 0;
		for (Emprestimo e : historicoEmprestimos) {
			if (e.getMatricula().equals(matricula) && e.getDataDevolucao() == null) {
				long diasAtraso = (new Date().getTime() - e.getDataPrevista().getTime()) / (1000 * 60 * 60 * 24);
				if (diasAtraso > 0) {
					totalMulta += diasAtraso * 1.50; 
				}
			}
		}
		return totalMulta;
	}

	private Date calcularDataDevolucao(String matricula) {
		// Prazo de devolucao que muda conforme tipo de usuario e tipo de biblioteca (universitaria, publica ou particular)
		Date dataPrevista = new Date();
        
		if (matricula.startsWith("PROF")) {
			// Professores tem 30 dias
			dataPrevista.setDate(dataPrevista.getDate() + 30);
		} else if (matricula.startsWith("ALU")) {
			// Alunos tem 15 dias
			dataPrevista.setDate(dataPrevista.getDate() + 15);
		} else {
			// Publico geral tem 10 dias
			dataPrevista.setDate(dataPrevista.getDate() + 10);
		}

		return dataPrevista;
	}

	public void devolver(String matricula) {
		for (Emprestimo e : historicoEmprestimos) {
			if (e.getMatricula().equals(matricula) && e.getDataDevolucao() == null) {
				e.setDataDevolucao(new Date());
				livro.setDisponivel(true);

				// Verificar atraso
				long diasAtraso = (e.getDataDevolucao().getTime() - e.getDataPrevista().getTime())
						/ (1000 * 60 * 60 * 24);
				if (diasAtraso > 0) {
					double multa = diasAtraso * 1.50;
					System.out.println("Devolucao com atraso de " + diasAtraso + " dias");
					System.out.println("Multa a pagar: R$" + multa);
				}
				break;
			}
		}
	}

	public void renovar(String matricula) {
		for (Emprestimo e : historicoEmprestimos) {
			if (e.getMatricula().equals(matricula) && e.getDataDevolucao() == null) {
				if (e.getRenovacoes() < 2) { // Limite de renovacoes 
					e.setRenovacoes(e.getRenovacoes() + 1);
					Date novaData = e.getDataPrevista();
					novaData.setDate(novaData.getDate() + 7); 
					e.setDataPrevista(novaData);
					System.out.println("Renovado com sucesso. Nova data: " + novaData);
				} else {
					throw new IllegalStateException("Limite de renovacoes atingido");
				}
				break;
			}
		}
	}

    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }

    public void setTotalEmprestimos(int totalEmprestimos) {
        this.totalEmprestimos = totalEmprestimos;
    }

    public Date getDataUltimoEmprestimo() {
        return dataUltimoEmprestimo;
    }

    public void setDataUltimoEmprestimo(Date dataUltimoEmprestimo) {
        this.dataUltimoEmprestimo = dataUltimoEmprestimo;
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void setHistoricoEmprestimos(List<Emprestimo> historicoEmprestimos) {
        this.historicoEmprestimos = historicoEmprestimos;
    }
}