<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Emprestimo</title>
</head>
<body>
<h1>Tech Teca</h1>
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

			<form action="login" method="post">
				Usuario:<input name="usuario"> Senha:<input name="senha">
				<input type="submit" value="ok">
			</form>
		</c:otherwise>
	</c:choose>
	<hr>
	${msg}
	<form action="cadastrarEmprestimo" method="post">
		Data Emprestimo:<input name="dateEmprestimo"> 
		Data Devolução:<input name="dataDevolucao">
		Id Funcionario: <input name="idFuncionario">
		Id Usuario:<input name="idUsuario">
		<input type="submit"
			value="ok">
	</form>
</body>
</html>