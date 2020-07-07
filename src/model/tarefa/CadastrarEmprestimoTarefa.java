package model.tarefa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EmprestimoDAO;
import model.javabean.Emprestimo;

public class CadastrarEmprestimoTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// recuperar os parametros do formulario
		Emprestimo emprestimo = new Emprestimo(
				request.getParameter("dateEmprestimo"),
				request.getParameter("dataDevolucao"),
				Integer.parseInt(request.getParameter("idFuncionario")),
				Integer.parseInt(request.getParameter("idUsuario")));
		// enviar dados para o DAO persistir
		new EmprestimoDAO().salvar(emprestimo);
		//retornar o nome da view
		request.setAttribute("msg", "parabéns cadastro efetuado com sucesso");
		return "cadastroEmprestimo";
	}

}
