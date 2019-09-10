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
	
	<h2>Tabla de peliculas</h2>
	<table border="1">
		<thead>
			<th>ID</th>
			<th>Titulo</th>
			<th>Duracion</th>
			<th>Clasificacion</th>
			<th>Genero</th>
		</thead>
		<tbody>
			<c:forEach items="${peliculas}" var="pelicula">
				<tr>
					<td> ${pelicula.id} </td>
					<td> ${pelicula.titulo} </td>
					<td> ${pelicula.duracion} min</td>
					<td> ${pelicula.clasificacion} </td>
					<td> ${pelicula.genero} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>