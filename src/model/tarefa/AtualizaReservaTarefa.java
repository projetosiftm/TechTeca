package model.tarefa;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReservaDAO;
import model.javabean.Reserva;



public class AtualizaReservaTarefa implements Tarefa {
	
	
@Override
public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String retorno = "index";
		switch (request.getMethod()) {
		case "GET":
			retorno = exibeForm(request);
			break;
		case "POST":
			retorno = atualizaRegistro(request);
			break;
		}
		return retorno;
	}

private String atualizaRegistro(HttpServletRequest request) {
		Reserva reserva = new Reserva(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("idUsuario")),Integer.parseInt(request.getParameter("idEmprestimo")),java.sql.Date.valueOf(request.getParameter("dateReserva")), request.getParameter("statusReserva"));
		new ReservaDAO().atualizar(reserva);
		return "index";
	}

private String exibeForm(HttpServletRequest request) {
		Reserva reserva = (Reserva) new ReservaDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",reserva);
		return "atualiza";
	}

}


