import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Funcionario {
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String email;
	private String telefone;
	private String endereco;
	private String cargo;
	private double salarioBase;
	private Date dataAdmissao;
	private int horasExtras;
	private List<String> habilidades;
	private String nivelExperiencia; // Junior, Pleno, Senior
	private double notaUltimaAvaliacao;
	private Date dataUltimaAvaliacao;
	private String feedbackGestor;
	private int projetosEntregues;
	private int projetosAtrasados;
	private boolean planoSaude;
	private boolean valeRefeicao;
	private boolean valeTransporte;
	private double auxilioCreche;
	private double participacaoLucros;

	public Funcionario(String nome, String cpf, String cargo, double salarioBase) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salarioBase = salarioBase;
		this.dataAdmissao = new Date();
		this.habilidades = new ArrayList<>();
		this.projetosEntregues = 0;
		this.projetosAtrasados = 0;
	}

	// ==================== MÉTODOS DE CÁLCULO SALARIAL ====================
	public double calcularSalarioBruto() {
		double salario = salarioBase;

		// Adicional por cargo
		if ("GERENTE".equals(cargo)) {
			salario += salarioBase * 0.30;
		} else if ("SUPERVISOR".equals(cargo)) {
			salario += salarioBase * 0.15;
		} else if ("COORDENADOR".equals(cargo)) {
			salario += salarioBase * 0.10;
		}

		// Adicional por horas extras
		salario += horasExtras * (salarioBase / 160) * 1.5;

		// Adicional por tempo de casa
		long anosTrabalhados = (new Date().getTime() - dataAdmissao.getTime()) / (1000L * 60 * 60 * 24 * 365);
		if (anosTrabalhados >= 5) {
			salario += salarioBase * 0.05; // 5% após 5 anos
		} else if (anosTrabalhados >= 2) {
			salario += salarioBase * 0.02; // 2% após 2 anos
		}

		// Bônus por habilidades
		if (habilidades.contains("INGLES_AVANCADO")) {
			salario += 500;
		}
		if (habilidades.contains("CERTIFICACAO")) {
			salario += 1000;
		}

		return salario;
	}

	public double calcularINSS() {
		double salario = calcularSalarioBruto();

		// Tabela INSS 2024
		if (salario <= 1412.00) {
			return salario * 0.075;
		} else if (salario <= 2666.68) {
			return salario * 0.09;
		} else if (salario <= 4000.03) {
			return salario * 0.12;
		} else {
			return salario * 0.14;
		}
	}

	public double calcularIRRF() {
		double salario = calcularSalarioBruto() - calcularINSS();

		// Tabela IRRF 2024
		if (salario <= 2259.20) {
			return 0;
		} else if (salario <= 2826.65) {
			return salario * 0.075 - 169.44;
		} else if (salario <= 3751.05) {
			return salario * 0.15 - 381.44;
		} else if (salario <= 4664.68) {
			return salario * 0.225 - 662.77;
		} else {
			return salario * 0.275 - 896.00;
		}
	}

	public double calcularSalarioLiquido() {
		return calcularSalarioBruto() - calcularINSS() - calcularIRRF();
	}

	public void avaliarDesempenho(double nota, String feedback) {
		this.notaUltimaAvaliacao = nota;
		this.feedbackGestor = feedback;
		this.dataUltimaAvaliacao = new Date();

		// Calcular produtividade
		double produtividade = (double) projetosEntregues / (projetosEntregues + projetosAtrasados);

		// Bônus por desempenho
		if (nota >= 9.0 && produtividade > 0.9) {
			this.participacaoLucros = salarioBase * 0.5; // 50% de bônus
		} else if (nota >= 8.0 && produtividade > 0.8) {
			this.participacaoLucros = salarioBase * 0.3; // 30% de bônus
		} else if (nota >= 7.0 && produtividade > 0.7) {
			this.participacaoLucros = salarioBase * 0.1; // 10% de bônus
		} else {
			this.participacaoLucros = 0;
		}

		// Recomendar promoção
		if (nota >= 9.0 && "PLENO".equals(nivelExperiencia)) {
			System.out.println("Recomendar promoção para SÊNIOR");
		} else if (nota >= 8.0 && "JUNIOR".equals(nivelExperiencia)) {
			System.out.println("Recomendar promoção para PLENO");
		}
	}

	public String gerarRelatorioDesempenho() {
		double produtividade = (double) projetosEntregues / (projetosEntregues + projetosAtrasados);

		return "=== RELATÓRIO DE DESEMPENHO ===\n" + "Funcionário: " + nome + "\n" + "Cargo: " + cargo + "\n"
				+ "Nível: " + nivelExperiencia + "\n" + "Nota da última avaliação: " + notaUltimaAvaliacao + "\n"
				+ "Data da avaliação: " + dataUltimaAvaliacao + "\n" + "Projetos entregues: " + projetosEntregues + "\n"
				+ "Projetos atrasados: " + projetosAtrasados + "\n" + "Produtividade: "
				+ String.format("%.2f", produtividade * 100) + "%\n" + "Feedback: " + feedbackGestor + "\n"
				+ "Bônus recebido: R$" + participacaoLucros;
	}

	public double calcularCustoBeneficios() {
		double custoTotal = 0;

		if (planoSaude) {
			custoTotal += 350.00; // Custo do plano de saúde
		}

		if (valeRefeicao) {
			custoTotal += 600.00; // VR
		}

		if (valeTransporte) {
			custoTotal += 200.00; // VT
		}

		custoTotal += auxilioCreche;

		return custoTotal;
	}

	public void atualizarBeneficios(boolean plano, boolean vr, boolean vt, double creche) {
		this.planoSaude = plano;
		this.valeRefeicao = vr;
		this.valeTransporte = vt;
		this.auxilioCreche = creche;

		// Verificar elegibilidade
		if (planoSaude && salarioBase < 2000) {
			System.out.println("Funcionário elegível para plano de saúde coparticipativo");
		}

		// Desconto em folha
		double descontoBeneficios = 0;
		if (valeRefeicao) {
			descontoBeneficios += 60.00; // 10% de coparticipação
		}
		if (valeTransporte) {
			descontoBeneficios += 30.00; // 15% de coparticipação
		}

		System.out.println("Desconto em folha para benefícios: R$" + descontoBeneficios);
	}

	public void adicionarHabilidade(String habilidade) {
		this.habilidades.add(habilidade);

		// Atualizar nível baseado em habilidades
		if (habilidades.size() >= 5) {
			this.nivelExperiencia = "SENIOR";
		} else if (habilidades.size() >= 3) {
			this.nivelExperiencia = "PLENO";
		} else {
			this.nivelExperiencia = "JUNIOR";
		}
	}

	public void registrarProjeto(boolean entregueNoPrazo) {
		if (entregueNoPrazo) {
			this.projetosEntregues++;
		} else {
			this.projetosAtrasados++;
		}
	}

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNivelExperiencia() {
		return nivelExperiencia;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public List<String> getHabilidades() {
		return habilidades;
	}

	public double getNotaUltimaAvaliacao() {
		return notaUltimaAvaliacao;
	}

	public Date getDataUltimaAvaliacao() {
		return dataUltimaAvaliacao;
	}

	public String getFeedbackGestor() {
		return feedbackGestor;
	}

	public int getProjetosEntregues() {
		return projetosEntregues;
	}

	public int getProjetosAtrasados() {
		return projetosAtrasados;
	}

	public boolean isPlanoSaude() {
		return planoSaude;
	}

	public boolean isValeRefeicao() {
		return valeRefeicao;
	}

	public boolean isValeTransporte() {
		return valeTransporte;
	}

	public double getAuxilioCreche() {
		return auxilioCreche;
	}

	public double getParticipacaoLucros() {
		return participacaoLucros;
	}

}