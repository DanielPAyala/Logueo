<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registrar Alumno</title>
</head>
<body>
	<form action="ServletAlumno?tipo=registrar" method="post">
		<table>
			<tr>
				<td>Nombre: </td>
				<td><input type="text" name="txt_nom"/></td>
			</tr>
			<tr>
				<td>Paterno: </td>
				<td><input type="text" name="txt_pat"/></td>
			</tr>
			<tr>
				<td>Materno: </td>
				<td><input type="text" name="txt_mat"/></td>
			</tr>
			<tr>
				<td>Edad: </td>
				<td><input type="text" name="txt_edad"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Registrar"/></td>
			</tr>
		</table>
	</form>
</body>
</html>