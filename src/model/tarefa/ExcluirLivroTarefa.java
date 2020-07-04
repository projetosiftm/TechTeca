package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LivroDAO;

public class ExcluirLivroTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		new LivroDAO().excluir(id);
		return "index";
	}

}
