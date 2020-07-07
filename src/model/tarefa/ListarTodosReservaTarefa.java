package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReservaDAO;
import model.javabean.Reserva;

public class ListarTodosReservaTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Reserva> lista = new ReservaDAO().listarTodos();
		request.setAttribute("reserva", lista);
		return "listaReserva";
	}

}
