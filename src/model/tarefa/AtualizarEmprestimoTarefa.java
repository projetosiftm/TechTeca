package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmprestimoDAO;
import model.javabean.Emprestimo;



public class AtualizarEmprestimoTarefa implements Tarefa {
	
	
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
		Emprestimo emprestimo = new Emprestimo(Integer.parseInt(request.getParameter("id")),
				request.getParameter("dateEmprestimo"),
				request.getParameter("dataDevolucao"),
				Integer.parseInt(request.getParameter("idFuncionario")),
				Integer.parseInt(request.getParameter("idUsuario")));
		new EmprestimoDAO().atualizar(emprestimo);
		return "emprestimo";
	}

private String exibeForm(HttpServletRequest request) {
		Emprestimo emprestimo = (Emprestimo) new EmprestimoDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",emprestimo);
		return "atualizarEmprestimo";
	}

}


