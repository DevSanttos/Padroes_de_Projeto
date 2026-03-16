import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Livro {
	private String isbn;
	private String titulo;
	private String autor;
	private String editora;
	private int anoPublicacao;
	private String edicao;
	private List<String> categorias;
	private int numeroPaginas;
    private boolean disponivel;
    private String localizacaoFisica; // Prateleira, estante
    private String estadoConservacao; // Novo, Bom, Regular, Danificado
    private Date dataAquisicao;
    private double precoCompra;

	public Livro(String isbn, String titulo, String autor, List<String> categorias, boolean disponivel, String localizacaoFisica, String estadoConservacao, Date dataAquisicao, double precoCompra) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.categorias = categorias;
        this.disponivel = disponivel;
        this.localizacaoFisica = localizacaoFisica;
        this.estadoConservacao = estadoConservacao;
        this.dataAquisicao = dataAquisicao;
        this.precoCompra = precoCompra;
		// this.palavrasChave = new ArrayList<>();
		// this.historicoEmprestimos = new ArrayList<>();
		// this.disponivel = true;
		// this.totalEmprestimos = 0;
	}

    public String getLocalizacaoFisica() {
        return localizacaoFisica;
    }

    public void setLocalizacaoFisica(String localizacaoFisica) {
        this.localizacaoFisica = localizacaoFisica;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getEstadoConservacao() {
        return this.estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }    
}