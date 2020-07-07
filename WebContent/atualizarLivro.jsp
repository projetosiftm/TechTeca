<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Livro</title>
</head>
<body>
	<h1>Arquitetura de referência</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL && tipoUsuario == 1}">
		<h1>Olá ${usuario.usuario}</h1>
		<a href="logout">Logout</a>
		<a href="listarTodosLivros">Listar todos livros</a>
		<a href="exibeFormLivro">Cadastrar livro</a>
		</c:when>

		<c:otherwise>
			<c:if test="${erro != NULL}">${erro}</c:if>

			<form action="/sistema/frontcontroller/login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	<c:if test="${!empty usuario }">
		<form action="atualizarLivro" method="POST">
			Id:<input name="id" value="${entidade.id}"> 
			Id Administrador: <input name="idAdministrador" value="${entidade.idAdministrador}"> 
			Ano: <input name="ano" value="${entidade.ano}"> 
			Titulo: <input name="titulo" value="${entidade.titulo}"> 
			Autor: <input name="autor" value="${entidade.autor}"> 
			Descrição: <input name="descricao" value="${entidade.descricao}"> 
			Editora: <input name="editora" value="${entidade.editora}"> 
			Idioma: <input name="idioma" value="${entidade.idioma}"> 
			Isbn: <input name="isbn" value="${entidade.isbn}"> 
			Foto: <input name="foto" value="${entidade.foto}"> 
			<input type="submit" value="Atualizar">
		</form>
	</c:if>
</body>
</html>