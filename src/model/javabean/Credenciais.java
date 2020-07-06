package model.javabean;

public class Credenciais {

	private Integer id;
	private Integer idPessoa;
	private String usuario;
	private String senha;
	
	
	public Credenciais(String usuario, int idPessoa) {
		this.usuario = usuario;
		this.idPessoa = idPessoa;
	}

	public Credenciais(Integer idPessoa, String usuario, String senha) {
		this.idPessoa = idPessoa;
		this.usuario = usuario;
		this.senha = senha;
	}


	public Credenciais(Integer id, Integer idPessoa, String usuario, String senha) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
