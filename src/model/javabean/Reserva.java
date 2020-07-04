package model.javabean;

import java.util.Date;

public class Reserva {
	
	private Integer id, idUsuario, idEmprestimo;
	private Date dateReserva;
	private String StatusReserva;
	
	public Reserva() {
	}
	
	public Reserva(Integer idUsuario, Integer idEmprestimo, Date dateReserva, String statusReserva) {
		this.idUsuario = idUsuario;
		this.idEmprestimo = idEmprestimo;
		this.dateReserva = dateReserva;
		StatusReserva = statusReserva;
	}
	
	public Reserva(Integer id, Integer idUsuario, Integer idEmprestimo, Date dateReserva, String statusReserva) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.idEmprestimo = idEmprestimo;
		this.dateReserva = dateReserva;
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

	public Date getDateReserva() {
		return dateReserva;
	}

	public void setDateReserva(Date dateReserva) {
		this.dateReserva = dateReserva;
	}

	public String getStatusReserva() {
		return StatusReserva;
	}

	public void setStatusReserva(String statusReserva) {
		StatusReserva = statusReserva;
	}

}
