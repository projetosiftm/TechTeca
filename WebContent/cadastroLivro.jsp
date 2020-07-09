<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tech Teca</title>
</head>
<body>
<h1>Cadastro de livros</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL && tipoUsuario == 1}">
		<h1>Ol� ${usuario.usuario}</h1>
		<a href="logout">Logout</a>
		<a href="login">Inicio</a>
		<a href="listarTodosLivros">Listar todos livros</a>
		<a href="exibeFormLivro">Cadastrar livro</a>
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
	${msg}
	<form action="cadastrarLivro" method="post">
		Titulo:<input name="titulo"> Autor:<input name="autor">
		Descri��o <input name="descricao"> Ano:<input name="ano">
		Editora:<input name="editora">Idioma:<input name="idioma">
		Isbn:<input name="isbn">foto:<input name="foto">id_adm:<input name="idAdministrador"><input type="submit"
			value="ok">
	</form>
</body>
</html>