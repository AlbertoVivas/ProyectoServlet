<%@page import="src.AdivinameElNo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%/*int num = 0; int min = 0;int max=0; String es = ""; */%>
<p>Recuerda tu numero</p>
<%
Integer min =(Integer)application.getAttribute("min");
Integer max =(Integer)application.getAttribute("max");
Integer num =(Integer)application.getAttribute("num");
String es =(String)application.getAttribute("es");
	out.write("<br>valor es = ("+es+") <br>");
	out.write("min:"+min+" max: "+max+"<br>");
	if(es.equals("")){//primera vez
		out.write("primera vez<br>");
		num = AdivinameElNo.num_aleatorio(min,max);
		out.write("num aleatorio: "+num);
		application.setAttribute("num", num);
	}else{ //no es la primera vez
	
		if(es.equals(">")){
			min=num;
			application.setAttribute("min",min);
			min =(Integer)application.getAttribute("min");
			num = AdivinameElNo.num_aleatorio(min,max);
			application.setAttribute("num", num);
		}else{
			if(es.equals("<")){
				max=num;
				application.setAttribute("max",max);
				max =(Integer)application.getAttribute("max");
				num = AdivinameElNo.num_aleatorio(min,max);
				application.setAttribute("num", num);
			}else{
				if(es.equals("=")){
					min=0;
					max=100;
					num=0;
					es="";
					application.setAttribute("min",min);
					application.setAttribute("max",max);
					application.setAttribute("num",num);
					application.setAttribute("es",es);
					out.write("Numero Adivinado!!!!!!!!!!!!");
				}	
			}	
		}
		
			
	}
	






%>
<p>Tu numero es: <%=num%> ?</p>
	
<form action="ServletAdivinaInicio" method="Get">
<select name="es">
<option value="1">Es Mayor</option>
<option value="2">Es Menor</option>
<option value="3">Es mi numero</option>
</select>
<input type="submit" value="go"/>
</form>	


</body>
</html>