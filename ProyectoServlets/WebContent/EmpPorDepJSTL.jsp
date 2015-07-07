<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.util.List,tablas_Clases.Departments,practica1.hibernate.DepartamentosHibernate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Emp*Dep JSTL</title>
</head>
<body>
<table border="1" bordercolor="#0000FF">
  <tr align="center">
    <th bgcolor="#00BFFF">Nombre</th>
    <th bgcolor="#00BFFF">Apellido</th>
    <th bgcolor="#00BFFF">Telefono</th>
    <th bgcolor="#00BFFF">email</th>
    <th bgcolor="#00BFFF">Salario</th>
    <th bgcolor="#00BFFF">Comision(%)</th>
    <th bgcolor="#00BFFF">Job ID</th>
    <th bgcolor="#00BFFF">Dep ID</th>
    <th bgcolor="#00BFFF">Ini contrato</th>
  </tr>
  
  <c:forEach items="${ListaEmpleados}" var="emp" >
 
  <tr align="center">
    <td><c:out value="${emp.firstName}"></c:out> </td>
    <td><c:out value="${emp.lastName}"></c:out></td>
    <td><c:out value="${emp.phoneNumber}"></c:out></td>
    <td><c:out value="${emp.email}"></c:out></td>
    <td><c:out value="${emp.salary}"></c:out></td>
    <td><c:out value="${emp.commissionPct}"></c:out></td>
    <td><c:out value="${emp.jobs.jobId}"></c:out></td>
    <td><c:out value="${emp.departments.departmentId}"></c:out></td>
    <td><c:out value="${emp.hireDate}"></c:out></td>
  </tr>
 </c:forEach> 
  
</table>



<form action="http://172.16.1.57:8090/ProyectoServlets/ServletListaDepartamentosJsp" method="Get">
<input type="submit" value="Volver"/>
</form>

</body>
</html>