<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%!
int min =0;
int max =100;
int num =0;
boolean encontrado = false;
String es = "";

public int num_al(int lim_inf, int lim_sup){
	return (int)(Math.random()*(lim_sup-lim_inf+1)+lim_inf);
}
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adivinator</title>
</head>
<body>

<% if(encontrado){ // el numero lo hemos encontrado inicializamos y imprimimos el boton de volver.
	min =0;
	max =100;
	num =0;
	encontrado = false;
	es = "";
	%>
	<p>se ha encontrado el numero!!!</p>
	<p> empezar de nuevo</p>
	<form action="ServletAdivina1" method="Get">
	<input type="submit" value="Adiviname"/>
	</form>
	<% 
	
	}else{// no lo he encontrado
		
		if(es.equals("")){//primera vez
			num = num_al(min, max); // calculamos el numero random entre 0-100
			%><p>calculamos un nuevo numero</p>
			  <p>entre <%=min%> y <%=max%> = <%=num%></p>	 
			<%
			
		}else{
			es = request.getParameter("es");
			if(es.equals("1")){//mi numero es mayor que el calculado
				min = num;
				num  = num_al(min, max);
				%><p>es ">" </p>
				  <p>calculamos num entre <%=min%> y <%=max%> = <%=num%>	 
				<%
			}else{
				if(es.equals("2")){//mi numero es menor que el calculado 
					max=num;
					num  = num_al(min, max);
					%><p>es ">" </p>
					  <p>calculamos num entre <%=min%> y <%=max%> = <%=num%>	 
					<%
					
				}else{//es =
					encontrado= true;
					%>
					<p>Su Numero es: <%=num%> </p>
					<%		
				}
			}
			
		}
		%>
		<form action="InicioAdivinaConNumero.jsp" method="Get">
		<select name="es">
		<option value="1">Es Mayor</option>
		<option value="2">Es Menor</option>
		<option value="3">Es mi numero</option>
		</select>
		<input type="submit" value="go"/>
		</form>
		
		<% 
		
	}

%>





</body>
</html>