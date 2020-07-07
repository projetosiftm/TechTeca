package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LivroDAO;
import model.javabean.Livro;



public class AtualizarLivroTarefa implements Tarefa {
	
	
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
		Livro livro = new Livro(Integer.parseInt(request.getParameter("id")),
				request.getParameter("titulo"),
				request.getParameter("autor"),
				request.getParameter("descricao"),
				request.getParameter("ano"),
				request.getParameter("editora"),
				request.getParameter("idioma"),
				request.getParameter("isbn"),
				request.getParameter("foto"),
				Integer.parseInt(request.getParameter("idAdministrador")));
		new LivroDAO().atualizar(livro);
		return "atualizarLivro";
	}

private String exibeForm(HttpServletRequest request) {
		Livro livro = (Livro) new LivroDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",livro);
		return "atualizarLivro";
	}

}


