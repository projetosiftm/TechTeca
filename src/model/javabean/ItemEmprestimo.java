package model.javabean;

public class ItemEmprestimo {
	private Integer id, idExemplar, idEmprestimo;

	public ItemEmprestimo() {

	}

	public ItemEmprestimo(Integer idExemplar, Integer idEmprestimo) {
		this.idExemplar = idExemplar;
		this.idEmprestimo = idEmprestimo;
	}

	public ItemEmprestimo(Integer id, Integer idExemplar, Integer idEmprestimo) {
		super();
		this.id = id;
		this.idExemplar = idExemplar;
		this.idEmprestimo = idEmprestimo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(Integer idExemplar) {
		this.idExemplar = idExemplar;
	}

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	
	
	

}