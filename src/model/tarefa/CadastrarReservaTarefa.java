package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReservaDAO;
import model.javabean.Reserva;

public class CadastrarReservaTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Reserva reserva = new Reserva(
				request.getParameter("dataReserva"), 
				request.getParameter("statusReserva"),
				Integer.parseInt(request.getParameter("idUsuario")),
				Integer.parseInt(request.getParameter("idEmprestimo")));
		// enviar dados para o DAO persistir
		new ReservaDAO().salvar(reserva);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns Reserva efetuada com sucesso");
		return "cadastroReserva";
	}

}
