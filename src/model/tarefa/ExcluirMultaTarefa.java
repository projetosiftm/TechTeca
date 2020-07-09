package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MultaDAO;

public class ExcluirMultaTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		new MultaDAO().excluir(id);
		return "listarTodasMultas";
	}

}
