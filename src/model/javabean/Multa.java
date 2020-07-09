package model.javabean;


public class Multa {

	private Integer id, idAdministrador, idEmprestimo, idItemEmprestimo,idExemplar;
	private Double valorMulta;
	private String dataVencimentoMulta,foto,titulo,autor,isbn,dataEmprestimo,dataDevolucao,nome;
	
	
	public Multa() {
		super();
	}
	public Multa(String dataVencimentoMulta,Double valorMulta, Integer idAdministrador, Integer idEmprestimo, Integer idItemEmprestimo) {
		super();
		this.idAdministrador = idAdministrador;
		this.idEmprestimo = idEmprestimo;
		this.idItemEmprestimo = idItemEmprestimo;
		this.valorMulta = valorMulta;
		this.dataVencimentoMulta = dataVencimentoMulta;
	}
	public Multa(Integer id, String dataVencimentoMulta,Double valorMulta, Integer idAdministrador, Integer idEmprestimo, Integer idItemEmprestimo) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.idEmprestimo = idEmprestimo;
		this.idItemEmprestimo = idItemEmprestimo;
		this.valorMulta = valorMulta;
		this.dataVencimentoMulta = dataVencimentoMulta;
	}
	
	public Multa(Integer id, String foto,String titulo, String autor,String isbn, int idExemplar, String dataEmprestimo, String dataDevolucao, String nome, String dataVencimentoMulta, double valorMulta) {
		super();
		this.id = id;
		this.foto = foto;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.nome = nome;
		this.idExemplar = idExemplar;
		this.valorMulta = valorMulta;
		this.dataVencimentoMulta = dataVencimentoMulta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getIdExemplar() {
		return idExemplar;
	}
	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}
	public String getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public Integer getIdItemEmprestimo() {
		return idItemEmprestimo;
	}
	public void setIdItemEmprestimo(Integer idItemEmprestimo) {
		this.idItemEmprestimo = idItemEmprestimo;
	}
	public Double getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}
	public String getDataVencimentoMulta() {
		return dataVencimentoMulta;
	}
	public void setDataVencimentoMulta(String dataVencimentoMulta) {
		this.dataVencimentoMulta = dataVencimentoMulta;
	}
	
	
	
}
