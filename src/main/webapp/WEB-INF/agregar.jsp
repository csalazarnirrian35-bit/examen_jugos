<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Jugo</title>
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
	<h2>Agregar jugo</h2>
		
		<form:form action="/agregar" method="POST" modelAttribute="jugo">
			
			<form:label path="titulo">Nombre</form:label>
			<form:input path="titulo" type="text"/>
			<form:errors path="titulo"/>
			
			<form:label path="descripcion">Descripción</form:label>
			<form:textarea path="descripcion"></form:textarea> 
			<form:errors path="descripcion"/>
			
			<form:label path="ingrediente">Ingredientes</form:label>
			<form:textarea path="ingrediente"></form:textarea> 
			<form:errors path="ingrediente"/>
			
			<form:label path="instruccion">Instrucciones</form:label>
			<form:textarea path="instruccion"></form:textarea> 
			<form:errors path="instruccion"/>
			
			<form:label path="portada">URL</form:label>
			<form:input path="portada" type="url"/>
			<form:errors path="portada"/>
			
			
			<input type="submit" value="Agregar">
			
			
		</form:form>
	
	
</body>
</html>