<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tech Teca</title>
</head>
<body>
	<h1>Lista de Multas</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL && tipoUsuario == 2}">
		<h1>Olá ${usuario.usuario}</h1>
		<a href="logout">Logout</a>
		<a href="login">Inicio</a>
		<a href="listarTodasMultas">Multas</a>
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
			<th>Foto</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Isbn</th>
			<th>Cod. Exemplar</th>
			<th>Data Emprestimo </th>
			<th>Data Devolucao </th>
			<th>Nome do Cliente</th>
			<th>Data Vencimento Multa</th>
			<th>Valor Multa</th>
	
		</thead>
		<tbody>
			<c:forEach var="u" items="${multa}">
				<tr>
				    <td><img width="100px" height="100px" src="../imagens/${u.foto}"></td>	
					<td>${u.titulo}</td>
					<td>${u.autor}</td>
					<td>${u.isbn}</td>
					<td>${u.idExemplar}</td>
					<td>${u.dataEmprestimo}</td>
					<td>${u.dataDevolucao}</td>
					<td>${u.nome}</td>
					<td>${u.dataVencimentoMulta}</td>
					<td>${u.valorMulta}</td>
					<td><a href="excluir?id=${u.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>






