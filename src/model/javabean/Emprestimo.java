package model.javabean;

import java.util.Date;

public class Emprestimo {
	private Integer id, idFuncionario, idUsuario;
	private Date dateEmprestimo, dataDevolucao;

	public Emprestimo() {
	}

	public Emprestimo(Integer idFuncionario, Integer idUsuario, Date dateEmprestimo, Date dataDevolucao) {
		this.idFuncionario = idFuncionario;
		this.idUsuario = idUsuario;
		this.dateEmprestimo = dateEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Emprestimo(Integer id, Integer idFuncionario, Integer idUsuario, Date dateEmprestimo, Date dataDevolucao) {
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

	public Date getDateEmprestimo() {
		return dateEmprestimo;
	}

	public void setDateEmprestimo(Date dateEmprestimo) {
		this.dateEmprestimo = dateEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}