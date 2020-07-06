package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CredenciaisDAO;
import model.javabean.Credenciais;

public class CadastrarCredenciaisTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Credenciais credenciais = new Credenciais(Integer.parseInt(request.getParameter("idPessoa")),
				request.getParameter("usuario"),
				request.getParameter("senha"));
		// enviar dados para o DAO persistir
		new CredenciaisDAO().salvar(credenciais);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns usuario cadastrado com sucesso");
		return "cadastroCredenciais";
	}

}
