package model.tarefa;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReservaDAO;
import model.javabean.Reserva;



public class AtualizarReservaTarefa implements Tarefa {
	
	
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
		Reserva reserva = new Reserva(Integer.parseInt(request.getParameter("id")),
				request.getParameter("dataReserva"), 
				request.getParameter("statusReserva"),
				Integer.parseInt(request.getParameter("idUsuario")),
				Integer.parseInt(request.getParameter("idEmprestimo"))
				);
		new ReservaDAO().atualizar(reserva);
		return "reserva";
	}

private String exibeForm(HttpServletRequest request) {
		Reserva reserva = (Reserva) new ReservaDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",reserva);
		return "atualizarReserva";
	}

}


