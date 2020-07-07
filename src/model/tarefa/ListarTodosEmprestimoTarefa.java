package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmprestimoDAO;
import model.javabean.Emprestimo;

public class ListarTodosEmprestimoTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Emprestimo> lista = new EmprestimoDAO().listarTodos();
		request.setAttribute("emprestimo", lista);
		return "listaEmprestimo";
	}

}
