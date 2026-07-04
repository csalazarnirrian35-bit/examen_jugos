<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Jugo</title>
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
	<h3>${jugo.titulo} - agregado por ${nombreCompleto}</h3>
	<h5>Descripción</h5>
	<p>${jugo.descripcion}</p>
	<h5>Ingredientes</h5>
	<p>${jugo.ingrediente}</p>
	<h5>Instrucciones</h5>
	<p>${jugo.instruccion}</p>
	<img src="${jugo.portada}" />
	
	<a href="/formulario/editar/${jugo.id}">Editar</a>
	

</body>
</html>