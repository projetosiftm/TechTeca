package model.tarefa;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FabricaDeTarefa {

	static Map<String, Tarefa> tarefas = new HashMap<String, Tarefa>();
	static {
		tarefas.put("POST/login", new LoginTarefa());
		tarefas.put("GET/livro", new LivroTarefa());
		tarefas.put("GET/logout", new LogoutTarefa());
		tarefas.put("GET/exibeFormCadastroUsuario", new ExibeFormCadastroUsuarioTarefa());
		tarefas.put("POST/cadastrarUsuario", new CadastrarUsuarioTarefa());
		tarefas.put("GET/exibeFormLivro", new ExibeFormLivroTarefa());
		tarefas.put("POST/cadastrarLivro", new CadastrarLivroTarefa());
		tarefas.put("GET/listarTodos", new ListarTodosTarefa());
		Tarefa t = new AtualizaUsuarioTarefa();
		tarefas.put("GET/atualizar", t);
		tarefas.put("POST/atualizar", t);
		tarefas.put("GET/excluir", new ExcluirUsuarioTarefa());
	}

	public static Tarefa getTarefa(HttpServletRequest request) {
		Tarefa tarefa = tarefas.get(request.getMethod() + request.getPathInfo());
		if (tarefa != null)
			return tarefa;
		else
			return new NULLTarefa();
	}
}
