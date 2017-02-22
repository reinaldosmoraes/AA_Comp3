<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contatos Motorista</title>
</head>
<body>
 	<h1>Contatos Motorista</h1>
 	<h3>Email: <%=request.getParameter("email") %></h3>
 	<h3>Telefone: <%=request.getParameter("telefone") %></h3>
</body>
</html>