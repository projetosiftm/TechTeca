package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CredenciaisDAO;

public class ExcluirCredenciaisTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		new CredenciaisDAO().excluir(id);
		return "index";
	}

}
