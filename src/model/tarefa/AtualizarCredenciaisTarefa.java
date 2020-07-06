package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CredenciaisDAO;
import model.javabean.Credenciais;

public class AtualizarCredenciaisTarefa implements Tarefa {

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
		Credenciais credenciais = new Credenciais(Integer.parseInt(request.getParameter("id")),
				Integer.parseInt(request.getParameter("idPessoa")),
				request.getParameter("usuario"),
				request.getParameter("senha"));
		new CredenciaisDAO().atualizar(credenciais);
		return "index";
	}

	private String exibeForm(HttpServletRequest request) {
		Credenciais credenciais = (Credenciais) new CredenciaisDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",credenciais);
		return "atualiza";
	}

}
