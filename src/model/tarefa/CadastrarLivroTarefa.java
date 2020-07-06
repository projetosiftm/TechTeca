package model.tarefa;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LivroDAO;
import model.javabean.Livro;

public class CadastrarLivroTarefa implements Tarefa {
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Livro livro = new Livro(
				Integer.parseInt(request.getParameter("idAdministrador")),
				sdf1.parse(request.getParameter("ano")),
				request.getParameter("titulo"),
				request.getParameter("autor"),
				request.getParameter("descricao"),
				request.getParameter("editora"),
				request.getParameter("idioma"),
				request.getParameter("isbn"),
				request.getParameter("foto"));
		// enviar dados para o DAO persistir
		new LivroDAO().salvar(livro);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns Cadastro de livro efetuada com sucesso");
		return "cadastroLivro";
	}

}
