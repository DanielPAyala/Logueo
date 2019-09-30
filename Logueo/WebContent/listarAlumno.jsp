<%@page import="entidad.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alumnos</title>
<script src="https://kit.fontawesome.com/a3d97ebb91.js" crossorigin="anonymous"></script>
</head>
<body>
	<% List<Alumno> da = (List<Alumno>)request.getAttribute("data"); %>
	
	<h2 align="center">LISTADO DE ALUMNOS</h2>
	<p align="center"><a href="registrarAlumno.jsp"> + Nuevo Registro</a></p>
	
	<table border="2" align="center" width="75%">
		<tr>
			<th>CODIGO</th>
			<th>NOMBRES</th>
			<th>PATERNO</th>
			<th>MATERNO</th>
			<th>EDAD</th>
			<th colspan="2">ACCIONES</th>
		</tr>
		<% 
		if(da != null){
			for(Alumno a:da){
		%>
		
		<tr>
			<td><%= a.getCodigo() %></td>
			<td><%= a.getNombre() %></td>
			<td><%= a.getPaterno() %></td>
			<td><%= a.getMaterno() %></td>
			<td><%= a.getEdad() %></td>
			<td colspan="2" align="center">
				<a href="ServletAlumno?tipo=buscar&cod=<%= a.getCodigo() %>"><i class="far fa-edit"></i></a>
				<a href="ServletAlumno?tipo=eliminar&cod=<%= a.getCodigo() %>"><i class="far fa-trash-alt"></i></a>
			</td>
		</tr>
		
		<%
			}
		}
		%>
	</table>
</body>
</html>