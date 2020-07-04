package model.javabean;

public class Funcionario extends Pessoa{
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String telefone, String email) {
		super(nome,telefone,email);
	}

	public Funcionario(int id, String nome, String telefone, String email) {
	super(id,nome,telefone,email);
}
	
}
