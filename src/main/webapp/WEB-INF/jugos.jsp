<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jugos</title>
<link rel="stylesheet" href="/Styles.css">
</head>
<body>
	<nav>
		<ul class="navJugo">
			<li><a href="/jugos">Jugos</a></li>
			<li><a href="/formulario/agregar">Agregar jugo</a></li>
			<li><a href="/logout">Logout</a></li>
		</ul>
	</nav>
	
	<h1>Jugos</h1>
	<h2>Bienvenido de vuelta ${nombreCompleto}</h2>
	<c:forEach var="jugo" items="${jugos}">
	<h4>${jugo.titulo}</h4>
	<img src="${jugo.portada}" />
	
	<span class="bnt">
	<a href="/detalle/${jugo.id}">Detalle</a>
	
	<form:form action="/eliminar/${jugo.id}" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="Eliminar"/>
	</form:form>
	</c:forEach>
	</span>
	
	

</body>
</html>