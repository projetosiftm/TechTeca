package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReservaDAO;

public class ExcluirReservaTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		new ReservaDAO().excluir(id);
		return "index";
	}

}
