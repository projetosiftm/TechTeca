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
	<h1>Lista de reservas</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL &&  tipoUsuario == 3}">
			<h1>Olá ${usuario.usuario}</h1>
		<a href="logout">Logout</a>
		<a href="login">Inicio</a>
		<a href="listarTodosReserva">Lista de Reserva</a>
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
			<th>Id Administrador</th>
			<th>Ano</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Descrição</th>
			<th>Editora</th>
			<th>Idioma</th>
			<th>Isbn</th>
			<th>Foto</th>
		</thead>
		<tbody>
			<c:forEach var="u" items="${reserva}">
				<tr>
					<td>${u.id}</td>
					<td>${u.idAdministrador}</td>
					<td>${u.ano}</td>
					<td>${u.titulo}</td>
					<td>${u.autor}</td>
					<td>${u.descricao}</td>
					<td>${u.editora}</td>
					<td>${u.idioma}</td>
					<td>${u.isbn}</td>
					<td><img width="100px" height="100px" src="../imagens/${u.foto}"></td>
					<td><a href="exibeFormReserva?id=${u.id}">Reservar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>






