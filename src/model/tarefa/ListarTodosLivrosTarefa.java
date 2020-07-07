package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.LivroDAO;
import model.javabean.Livro;

public class ListarTodosLivrosTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Livro> lista = new LivroDAO().listarTodos();
		request.setAttribute("livro", lista);
		return "listaLivro";
	}

}
