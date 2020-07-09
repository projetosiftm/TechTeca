package model.tarefa;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MultaDAO;
import model.javabean.Multa;

public class ListarTodasMultasTarefa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Multa> lista = new MultaDAO().listarTodos();
		request.setAttribute("multa", lista);
		return "listaMulta";
	}

}
