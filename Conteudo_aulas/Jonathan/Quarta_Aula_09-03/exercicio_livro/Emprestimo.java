
import java.util.Date;

class Emprestimo {
	private String nomeUsuario;
	private String matricula;
	private Date dataEmprestimo;
	private Date dataPrevista;
	private Date dataDevolucao;
	private int renovacoes;
    
	public Emprestimo(String nomeUsuario, String matricula, Date dataEmprestimo) {
		this.nomeUsuario = nomeUsuario;
		this.matricula = matricula;
		this.dataEmprestimo = dataEmprestimo;
		this.renovacoes = 0;
		this.dataPrevista = new Date();
		this.dataPrevista.setDate(dataEmprestimo.getDate() + 14); // 14 dias padrao
	}

	public String getMatricula() {
		return matricula;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

    
	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date data) {
		this.dataDevolucao = data;
	}

	public void setDataPrevista(Date data) {
		this.dataPrevista = data;
	}

	public int getRenovacoes() {
		return renovacoes;
	}

	public void setRenovacoes(int r) {
		this.renovacoes = r;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
}