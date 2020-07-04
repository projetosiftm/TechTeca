package model.javabean;

public class Usuario extends Pessoa {
	public Usuario() {
		super();
	}
	public Usuario(int id, String nome, String telefone, String email) {
		super(id, nome, telefone, email);
	}
	public Usuario(String nome, String telefone, String email) {
		super(nome, telefone, email);
	}
}