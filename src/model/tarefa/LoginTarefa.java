package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UsuarioDAO;
import model.javabean.Usuario;

public class LoginTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nomeUsuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Usuario usuario = new UsuarioDAO().busca(nomeUsuario, senha);

		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			return "index";
		} else {
			request.setAttribute("erro", "Nome de usuário/senha errado. Tente novamente.");
			return "index";
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tarefa Login";
	}
}
