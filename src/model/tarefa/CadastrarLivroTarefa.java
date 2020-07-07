package model.tarefa;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LivroDAO;
import model.javabean.Livro;

public class CadastrarLivroTarefa implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Livro livro = new Livro(
				request.getParameter("titulo"),
				request.getParameter("autor"),
				request.getParameter("descricao"),
				request.getParameter("ano"),
				request.getParameter("editora"),
				request.getParameter("idioma"),
				request.getParameter("isbn"),
				request.getParameter("foto"),
				Integer.parseInt(request.getParameter("idAdministrador")));
		// enviar dados para o DAO persistir
		new LivroDAO().salvar(livro);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns Cadastro de livro efetuada com sucesso");
		return "cadastroLivro";
	}

}
