package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CredenciaisDAO;
import model.javabean.Credenciais;

public class ListarTodosTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Credenciais> lista = new CredenciaisDAO().listarTodos();
		request.setAttribute("usuarios", lista);
		return "listaUsuarios";
	}

}
