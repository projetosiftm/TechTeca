package model.javabean;

public class Exemplar {
	
	private Integer id;
	private String disponibilidade;
	
	private Livro livro;
	public Exemplar() {
		
	}
	
	public Exemplar(Livro livro, String disponibilidade) {
		this.livro = livro;
		this.disponibilidade = disponibilidade;
	}

	public Exemplar(int id,Livro livro, String disponibilidade) {
		this.id = id;
		this.livro = livro;
		this.disponibilidade = disponibilidade;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
	
}
