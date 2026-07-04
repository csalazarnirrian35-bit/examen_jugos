<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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
	<h2>Login</h2>
	
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">
	
	<form:label path="correo">Correo</form:label>
	<form:input path="correo" type="email" /> 
	<form:errors path="correo" />
	
	<form:label path="password">Contraseña</form:label>
	<form:input path="password" type="password" /> 
	<form:errors path="password" />
	
	<input type="submit" value="Login" />
	</form:form>

	
	
</body>
</html>