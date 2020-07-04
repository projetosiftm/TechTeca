package model.javabean;

public class ItemReserva {

	private Integer id, idReserva, idExemplar, idLivro;

	public ItemReserva() {

	}

	public ItemReserva(Integer idReserva, Integer idExemplar, Integer idLivro) {
		this.idReserva = idReserva;
		this.idExemplar = idExemplar;
		this.idLivro = idLivro;
	}

	public ItemReserva(Integer id, Integer idReserva, Integer idExemplar, Integer idLivro) {
		super();
		this.id = id;
		this.idReserva = idReserva;
		this.idExemplar = idExemplar;
		this.idLivro = idLivro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(Integer idExemplar) {
		this.idExemplar = idExemplar;
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

}