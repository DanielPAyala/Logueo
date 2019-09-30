<%@page import="entidad.Alumno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Alumno</title>
</head>
<body>
	<% Alumno obj = (Alumno)request.getAttribute("registro"); %>
	
	<form action="ServletAlumno?tipo=actualizar" name="frmactualizar" method="post">
		<input type="hidden" name="txt_cod" value="<%= obj.getCodigo() %>"/>
		<table border="1" align="center">
			<tr>
				<td>Nombre: </td>
				<td><input type="text" name="txt_nom"  value="<%= obj.getNombre() %>"/></td>
			</tr>
			<tr>
				<td>Paterno: </td>
				<td><input type="text" name="txt_pat" value="<%= obj.getPaterno() %>"/></td>
			</tr>
			<tr>
				<td>Materno: </td>
				<td><input type="text" name="txt_mat" value="<%= obj.getMaterno() %>"/></td>
			</tr>
			<tr>
				<td>Edad: </td>
				<td><input type="text" name="txt_edad" value="<%= obj.getEdad() %>"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Actualizar"/></td>
			</tr>
		</table>
	</form>
</body>
</html>