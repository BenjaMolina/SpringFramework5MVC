<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- JSTL -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Archivos estaticos -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources" var="urlPublic" /> <!-- variable -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a CineMovies</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Lista de Peliculas</h1>

		<%-- <ul>
			<c:forEach items="${peliculas}" var="pelicula">
				<li>${pelicula}</li>

			</c:forEach>
		</ul> --%>

		<div class="panel panel-default">
			<!-- <div class="panel-heading">Lista de Peliculas</div> -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<th>ID</th>
						<th>Titulo</th>
						<th>Duracion</th>
						<th>Clasificacion</th>
						<th>Genero</th>
						<th>Imagen</th>
						<th>Fecha de Estreno</th>
						<th>Estatus</th>
					</thead>
					<tbody>
						<c:forEach items="${peliculas}" var="pelicula">
							<tr>
								<td>${pelicula.id}</td>
								<td>${pelicula.titulo}</td>
								<td>${pelicula.duracion} min</td>
								<td>${pelicula.clasificacion}</td>
								<td>${pelicula.genero}</td>
								<td>
									<img width="80" alt="${pelicula.titulo}" src="${urlPublic}/images/${pelicula.imagen}">
								</td>
								<td>${pelicula.fechaEstreno}</td>
								<td>${pelicula.estatus}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>