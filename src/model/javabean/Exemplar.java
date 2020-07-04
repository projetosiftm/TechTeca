package model.javabean;

public class Exemplar {
	
	private Integer id, idLivro;
	private String disponibilidade;
	
	public Exemplar() {
		
	}
	
	public Exemplar(int idLivro, String disponibilidade) {
		this.idLivro = idLivro;
		this.disponibilidade = disponibilidade;
	}

	public Exemplar(int id,int idLivro, String disponibilidade) {
		this.id = id;
		this.idLivro = idLivro;
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
