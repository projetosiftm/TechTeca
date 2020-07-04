package model.javabean;

public class Administrador extends Pessoa{
	public Administrador() {
		super();
	}
	public Administrador(String nome, String telefone, String email) {
		super(nome,telefone,email);
	}

	public Administrador(int id, String nome, String telefone, String email) {
	super(id,nome,telefone,email);
}
	
}
