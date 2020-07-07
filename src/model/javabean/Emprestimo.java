package model.javabean;

import java.util.Date;

public class Emprestimo {
	private Integer id, idFuncionario, idUsuario;
	private String dateEmprestimo, dataDevolucao;

	public Emprestimo() {
	}

	public Emprestimo(String dateEmprestimo ,String dataDevolucao,Integer idFuncionario, Integer idUsuario) {
		this.idFuncionario = idFuncionario;
		this.idUsuario = idUsuario;
		this.dateEmprestimo = dateEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Emprestimo(Integer id,String dateEmprestimo ,String dataDevolucao,Integer idFuncionario, Integer idUsuario) {
		super();
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.idUsuario = idUsuario;
		this.dateEmprestimo = dateEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDateEmprestimo() {
		return dateEmprestimo;
	}

	public void setDateEmprestimo(String dateEmprestimo) {
		this.dateEmprestimo = dateEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}