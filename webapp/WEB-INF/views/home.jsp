<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a CineMovies</title>
</head>
<body>
	<h1>Lista de Peliculas</h1>
	
	<ul>
		<c:forEach
			items="${peliculas}"
			var="pelicula"
		>
			<li> ${pelicula} </li>
			
		</c:forEach>
	</ul>
</body>
</html>