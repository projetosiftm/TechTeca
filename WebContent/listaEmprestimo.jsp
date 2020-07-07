<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar todos</title>
</head>
<body>
	<h1>Arquitetura de referência</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL &&  tipoUsuario == 2}">
			<h1>Olá ${usuario.usuario}</h1>
		<a href="logout">Logout</a>
		<a href="listarTodosEmprestimo">Lista de emprestimos</a>
		<a href="exibeFormEmprestimo">Cadastrar emprestimo</a>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	<table border=1>
		<thead>
			<th>Id</th>
			<th>Data Emprestimo</th>
			<th>Data Devolução</th>
			<th>Id Funcionario</th>
			<th>Id Usuario</th>
		</thead>
		<tbody>
			<c:forEach var="u" items="${emprestimo}">
				<tr>
					<td>${u.id}</td>
					<td>${u.dateEmprestimo}</td>
					<td>${u.dataDevolucao}</td>
					<td>${u.idFuncionario}</td>
					<td>${u.idUsuario}</td>
					<td><a href="atualizarEmprestimo?id=${u.id}">Atualizar</a><a href="excluir?id=${u.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>






