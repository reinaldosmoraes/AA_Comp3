<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Listar Paradas</title>
	</head>
	<body>
		<h1>Lista de Paradas</h1>
		
		<div align="right">
			<a href="CrCriarParada" class="item"><div class="ui green button"><i class="plus icon"></i> Adicionar</div></a>
		</div>
		<br>
		
		<div class="ui ordered middle aligned divided list">
		
			<%
						List<Parada> paradas = (ArrayList<Parada>) request.getAttribute("Parada");
						for(Parada parada : paradas){
						
					%>
			
		   	<div class="item">
		   	
		   		<div class="right floated content">
		      		<a class="ui red button" href="CrRemoverParada?id=<%=parada.getIdParada()%>">Remover</a>
		    	</div>
		   		
		   		<div class="content">
		   			<a class="header">Id de Parada: <%=parada.getIdParada()%></a>
		   			
		   			<div class="description">
		   			Id do Usuário: <%=parada.getIdUsuario()%><br>
		   			Id do Logradouro: <%=parada.getIdLogradouro()%><br>
		   			Id do Carona: <%=parada.getIdCarona()%><br>
		   			</div>
		   		</div>
		   	</div>
  			<%}%>
		</div>
	</body>
</html>