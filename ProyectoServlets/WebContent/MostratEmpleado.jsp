<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Empleado</title>
</head>
<body>
<p>Ingrese la ID de un empleado</p>
<form action="ServletObtenerEmpleadoJsp" method="Get">
ID <input type ="text" name = "ID" />
<input type="submit" value="get"/>
</form>
<%
if (request.getAttribute("empleado")!=null){
%>
<p></p>
<table border="1" >
<tr ALIGN="center">
<td>Nombre</td>
<td>Apellido</td>
<td>Department Id</td>
<td>email</td>
<td>Salario</td>
</tr>

<tr ALIGN="center">
<td>${empleado.firstName}</td>
<td>${empleado.lastName}</td>
<td>${empleado.departments.departmentId}</td>
<td>${empleado.email}</td>
<td>${empleado.salary}</td>
</tr>

</table>

<%} %>
<form action="/ProyectoServlets/Login.html" method="Get">
<input type="submit" value="Volver"/>
</form>
</body>
</html>