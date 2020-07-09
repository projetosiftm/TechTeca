package model.javabean;

import java.util.Date;

public class Livro {

	private Integer id, idAdministrador;
	private String titulo, autor, descricao, editora, idioma, isbn, foto,ano, statusReserva;


	public Livro() {
		super();
	}

	public Livro(String titulo, String autor, String descricao, String ano, String editora, String idioma,String isbn, String foto, int idAdministrador) {
		this.idAdministrador = idAdministrador;
		this.ano = ano;
		this.titulo = titulo;
		this.autor = autor;
		this.descricao = descricao;
		this.editora = editora;
		this.idioma = idioma;
		this.isbn = isbn;
		this.foto = foto;
	}

	public Livro(Integer id, String titulo, String autor, String descricao, String ano, String editora, String idioma,String isbn, String foto, Integer idAdministrador) {
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.ano = ano;
		this.titulo = titulo;
		this.autor = autor;
		this.descricao = descricao;
		this.editora = editora;
		this.idioma = idioma;
		this.isbn = isbn;
		this.foto = foto;
	}
	
	
	public Livro(String foto,String titulo, String autor, String descricao, String ano, String editora, String idioma,String isbn,  String statusReserva) {
		this.ano = ano;
		this.titulo = titulo;
		this.autor = autor;
		this.descricao = descricao;
		this.editora = editora;
		this.idioma = idioma;
		this.isbn = isbn;
		this.foto = foto;
		this.statusReserva = statusReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(String statusReserva) {
		this.statusReserva = statusReserva;
	}
	
	
	

}
