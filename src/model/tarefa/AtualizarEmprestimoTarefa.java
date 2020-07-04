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
				Integer.parseInt(request.getParameter("idFuncionario")),
				Integer.parseInt(request.getParameter("idUsuario")),
				java.sql.Date.valueOf(request.getParameter("dateEmprestimo")),
				java.sql.Date.valueOf(request.getParameter("dataDevolucao")));
		new EmprestimoDAO().atualizar(emprestimo);
		return "index";
	}

private String exibeForm(HttpServletRequest request) {
		Emprestimo emprestimo = (Emprestimo) new EmprestimoDAO().recuperarPorId(request.getParameter("id"));
		request.setAttribute("entidade",emprestimo);
		return "atualiza";
	}

}


