package model.javabean;

import java.util.Date;

public class Multa {

	private Integer id, idAdministrador, idEmprestimo, idItemEmprestimo;
	private Double valorMulta;
	private Date dataVencimentoMulta;
	
	
	public Multa() {
		super();
	}
	public Multa(Integer idAdministrador, Integer idEmprestimo, Integer idItemEmprestimo, Double valorMulta,
			Date dataVencimentoMulta) {
		super();
		this.idAdministrador = idAdministrador;
		this.idEmprestimo = idEmprestimo;
		this.idItemEmprestimo = idItemEmprestimo;
		this.valorMulta = valorMulta;
		this.dataVencimentoMulta = dataVencimentoMulta;
	}
	public Multa(Integer id, Integer idAdministrador, Integer idEmprestimo, Integer idItemEmprestimo, Double valorMulta,
			Date dataVencimentoMulta) {
		super();
		this.id = id;
		this.idAdministrador = idAdministrador;
		this.idEmprestimo = idEmprestimo;
		this.idItemEmprestimo = idItemEmprestimo;
		this.valorMulta = valorMulta;
		this.dataVencimentoMulta = dataVencimentoMulta;
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
	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public Integer getIdItemEmprestimo() {
		return idItemEmprestimo;
	}
	public void setIdItemEmprestimo(Integer idItemEmprestimo) {
		this.idItemEmprestimo = idItemEmprestimo;
	}
	public Double getValorMulta() {
		return valorMulta;
	}
	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}
	public Date getDataVencimentoMulta() {
		return dataVencimentoMulta;
	}
	public void setDataVencimentoMulta(Date dataVencimentoMulta) {
		this.dataVencimentoMulta = dataVencimentoMulta;
	}
	
	
	
}
