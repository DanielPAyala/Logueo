<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="ISO-8859-1">
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <title>Login</title>
    </head>
    <body>
        <%
            String x = (String)request.getAttribute("msj");
            String a = "";
            if (x != null) {
                a = x;
            }
        %>  
        <form action="${pageContext.request.contextPath}/ServletEmpleado" name="frmsesion" method="POST">
            <table>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="txtlogin"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="txtpass"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" value="Iniciar"/>
                    </td>
                </tr>
            </table>
            <h5 align="center"><%= a %></h5>
        </form>
    </body>
</html>
