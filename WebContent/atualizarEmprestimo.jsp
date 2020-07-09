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
	<h1>Atualizar Emprestimo</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL && tipoUsuario == 2}">
		<h1>Olá ${usuario.usuario}</h1>
	<a href="logout">Logout</a>
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
	<hr>
	<c:if test="${!empty usuario}">
		<form action="atualizarEmprestimo" method="POST">
			Id:<input name="id" value="${entidade.id}"> 
			Data Emprestimo: <input name="dateEmprestimo" value="${entidade.dateEmprestimo}"> 
			Data Devolução: <input name="dataDevolucao" value="${entidade.dataDevolucao}"> 
			Id Funcionario: <input name="idFuncionario" value="${entidade.idFuncionario}"> 
			Id Usuario: <input name="idUsuario" value="${entidade.idUsuario}"> 
			<input type="submit" value="Atualizar">
		</form>
	</c:if>
</body>
</html>