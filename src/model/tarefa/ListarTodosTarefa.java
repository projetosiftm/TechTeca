package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UsuarioDAO;
import model.javabean.Usuario;

public class ListarTodosTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Usuario> lista = new UsuarioDAO().listarTodos();
		request.setAttribute("usuarios", lista);
		return "listaUsuarios";
	}

}
