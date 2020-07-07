package model.tarefa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FabricaDeTarefa {

	static Map<String, Tarefa> tarefas = new HashMap<String, Tarefa>();
	static {
		tarefas.put("POST/login", new LoginTarefa());
		tarefas.put("GET/livro", new LivroTarefa());
		tarefas.put("GET/emprestimo", new EmprestimoTarefa());
		tarefas.put("GET/reserva", new ReservaTarefa());
		tarefas.put("GET/logout", new LogoutTarefa());
		tarefas.put("GET/exibeFormCadastroUsuario", new ExibeFormCadastroUsuarioTarefa());
		tarefas.put("POST/cadastrarUsuario", new CadastrarUsuarioTarefa());
		tarefas.put("GET/exibeFormLivro", new ExibeFormLivroTarefa());
		tarefas.put("POST/cadastrarLivro", new CadastrarLivroTarefa());
		tarefas.put("GET/exibeFormEmprestimo", new ExibeFormEmprestimoTarefa());
		tarefas.put("POST/cadastrarEmprestimo", new CadastrarEmprestimoTarefa());
		tarefas.put("GET/exibeFormReserva", new ExibeFormReservaTarefa());
		tarefas.put("POST/cadastrarReserva", new CadastrarReservaTarefa());
		tarefas.put("GET/listarTodos", new ListarTodosTarefa());
		tarefas.put("GET/listarTodosLivros", new ListarTodosLivrosTarefa());
		tarefas.put("GET/listarTodosEmprestimo", new ListarTodosEmprestimoTarefa());
		tarefas.put("GET/listarTodosReserva", new ListarTodosReservaTarefa());
		Tarefa t = new AtualizaUsuarioTarefa();
		tarefas.put("GET/atualizar", t);
		tarefas.put("POST/atualizar", t);
		Tarefa n = new AtualizarLivroTarefa();
		tarefas.put("GET/atualizarLivro", n);
		tarefas.put("POST/atualizarLivro", n);
		Tarefa e = new AtualizarEmprestimoTarefa();
		tarefas.put("GET/atualizarEmprestimo", e);
		tarefas.put("POST/atualizarEmprestimo", e);
		Tarefa r = new AtualizarReservaTarefa();
		tarefas.put("GET/atualizarReserva", r);
		tarefas.put("POST/atualizarReserva", r);
		tarefas.put("GET/excluir", new ExcluirUsuarioTarefa());
		tarefas.put("GET/excluir", new ExcluirLivroTarefa());
		tarefas.put("GET/excluir", new ExcluirEmprestimoTarefa());
		tarefas.put("GET/excluir", new ExcluirReservaTarefa());
	}

	public static Tarefa getTarefa(HttpServletRequest request) {
		Tarefa tarefa = tarefas.get(request.getMethod() + request.getPathInfo());
		if (tarefa != null)
			return tarefa;
		else
			return new NULLTarefa();
	}
}
