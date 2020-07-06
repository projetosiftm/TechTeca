package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CredenciaisDAO;
import model.javabean.Credenciais;

public class LoginTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nomeUsuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		Credenciais credenciais = new CredenciaisDAO().busca(nomeUsuario, senha);

		if (credenciais != null) {
			request.getSession().setAttribute("usuario", credenciais);
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
