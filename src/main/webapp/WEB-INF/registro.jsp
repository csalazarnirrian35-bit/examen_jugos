<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="/Styles.css">
</head>
<body>
	<nav>
		<ul class="navJugo">
			<li><a href="/">Login</a></li>
			<li><a href="/formulario/registro">Registro</a></li>
		</ul>
	</nav>
		
		
	<h1>Jugos</h1>
	<h2>Registro</h2>
	
		<form:form action="/procesa/registro" method="POST" modelAttribute="usuario">
	
			<form:label path="nombre">Nombre</form:label>
			<form:input path="nombre" type="text" /> 
			<form:errors path="nombre" />
			
			<form:label path="apellido">Apellido</form:label>
			<form:input path="apellido" type="text" /> 
			<form:errors path="apellido" />
			
			<form:label path="correo">Correo</form:label>
			<form:input path="correo" type="email" /> 
			<form:errors path="correo" />
			
			<form:label path="password">Contraseña</form:label>
			<form:input path="password" type="password" /> 
			<form:errors path="password" />
			
			<form:label path="confirmarPassword">Confirmar Contraseña</form:label>
			<form:input path="confirmarPassword" type="password" /> 
			<form:errors path="confirmarPassword" />
			
			<input type="submit" value="Registrarse" />
		
	
	
		</form:form>
	
	

</body>
</html>