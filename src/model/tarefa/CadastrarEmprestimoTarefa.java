package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmprestimoDAO;
import model.javabean.Emprestimo;

public class CadastrarEmprestimoTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Emprestimo emprestimo = new Emprestimo(Integer.parseInt(request.getParameter("id")),
				Integer.parseInt(request.getParameter("idFuncionario")),
				Integer.parseInt(request.getParameter("idUsuario")),
				java.sql.Date.valueOf(request.getParameter("dateEmprestimo")),
				java.sql.Date.valueOf(request.getParameter("dataDevolucao")));
		// enviar dados para o DAO persistir
		new EmprestimoDAO().salvar(emprestimo);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns cadastro efetuado com sucesso");
		return "cadastroEmprestimo";
	}

}
