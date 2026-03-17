package composite1.solucao;


public abstract class MembroEmpresa {

	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract double getSalario(); 
	
}
