package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UsuarioDAO;
import model.javabean.Usuario;

public class AtualizaUsuarioTarefa implements Tarefa {

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
		Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), request.getParameter("usuario"), request.getParameter("senha"));
		new UsuarioDAO().atualizar(usuario);
		return "index";
	}

	private String exibeForm(HttpServletRequest request) {
		Usuario usuario = (Usuario) new UsuarioDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",usuario);
		return "atualiza";
	}

}
