<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tech Teca</title>
</head>
<body>
	<h1>Emprestimo de livro</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL && tipoUsuario == 2}">
		<h1>Ol� ${usuario.usuario}</h1>
		<a href="logout">Logout</a>
		<a href="login">Inicio</a>
		<a href="listarTodosEmprestimo">Lista de emprestimos</a>
		<a href="exibeFormEmprestimo">Cadastrar emprestimo</a>
		</c:when>	
		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="/sistema/frontcontroller/login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>

