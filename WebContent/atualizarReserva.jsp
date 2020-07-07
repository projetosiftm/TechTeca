<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Emprestimo</title>
</head>
<body>
	<h1>Arquitetura de referência</h1>
	<hr>
	<c:choose>
		<c:when test="${usuario != NULL && tipoUsuario == 2}">
		<h1>Olá ${usuario.usuario}</h1>
	<a href="logout">Logout</a>
		<a href="listarTodosReserva">Lista de Reserva</a>
		<a href="exibeFormReserva">Cadastrar Reserva</a>
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
		<form action="atualizarReserva" method="POST">
			Id:<input name="id" value="${entidade.id}"> 
			Data Reserva: <input name="dataReserva" value="${entidade.dataReserva}"> 
			Status Reserva: <input name="statusReserva" value="${entidade.statusReserva}"> 
			Id Usuario: <input name="idUsuario" value="${entidade.idUsuario}"> 
			Id Emprestimo: <input name="idEmprestimo" value="${entidade.idEmprestimo}"> 
			<input type="submit" value="Atualizar">
		</form>
	</c:if>
</body>
</html>