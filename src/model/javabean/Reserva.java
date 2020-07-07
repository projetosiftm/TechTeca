package model.javabean;

import java.util.Date;

public class Reserva {
	
	private Integer id, idUsuario, idEmprestimo;
	private String StatusReserva,dataReserva;
	
	public Reserva() {
	}
	
	public Reserva(String dataReserva,String statusReserva,Integer idUsuario, Integer idEmprestimo) {
		this.idUsuario = idUsuario;
		this.idEmprestimo = idEmprestimo;
		this.dataReserva = dataReserva;
		StatusReserva = statusReserva;
	}
	
	public Reserva(Integer id,String dataReserva,String statusReserva,Integer idUsuario, Integer idEmprestimo) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idEmprestimo = idEmprestimo;
		this.dataReserva = dataReserva;
		StatusReserva = statusReserva;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public String getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getStatusReserva() {
		return StatusReserva;
	}

	public void setStatusReserva(String statusReserva) {
		StatusReserva = statusReserva;
	}

}
