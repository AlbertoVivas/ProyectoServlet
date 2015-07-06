<%@ page import="java.util.List"%>
<%@ page import="tablas_Clases.Employees"%> 
<%@ page import="java.util.Iterator"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Department</title>
</head>
<body>

<table border="1">
<tr align="CENTER">
<td><b>Nombre</b></td>
<td><b>Apellido</b></td>
<td><b>Id departamento</b></td>
<td><b>Salario</b></td>
</tr>


<%
List<Employees> le =(List<Employees>)request.getAttribute("ListaEmpleados");
Iterator it = le.iterator();
while(it.hasNext()){
	Employees e =(Employees) it.next();
	%>
	<!--  <p> <%=e.imprimeme()%></p>-->
	<tr align="CENTER">
	<td><%=e.getFirstName()%></td>
	<td><%=e.getLastName() %></td>
	<td><%=e.getDepartments().getDepartmentId()%></td>
	<td><%=e.getSalary()%></td>
	</tr>
	<%
}
%>

</table>
<form action="ServletListaDepartamentos" method="Get">
<input type="submit" value="Volver"/>
</form>

</body>
</html>