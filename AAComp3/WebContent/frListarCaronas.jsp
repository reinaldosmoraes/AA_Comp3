<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Lista de Caronas</title>
	</head>
	<body>
	
		<h1>Lista de Caronas</h1>
		
		<br>
		
		<div class="ui ordered middle aligned divided list">
		
			<%
						List<Carona> caronas = (ArrayList<Carona>) request.getAttribute("Car");
						
						for(Carona carona : caronas){
						
					%>
			
		   	<div class="item">
		   	
		   		<div class="right floated content">
		      		<a class="ui red button" href="CrTerminar?id=<%=carona.getIdCarona()%>">Terminou</a>
		    	</div>
		    	
		   		<div class="right floated content">
		      		<a class="ui teal button" href="CrAlterarCarona?id=<%=carona.getIdCarona()%>">Alterar</a>
		    	</div>
		    
		    	<div class="right floated content">
		      		<a class="ui green button" href="CrInserirUsuarioCarona?id=<%=carona.getIdCarona()%>">Inserir Usuario</a>
		    	</div>
		   		
		   		<div class="content">
		   			<a class="header">Id de Carona: <%=carona.getIdCarona()%></a>
		   			
		   			<div class="description">
		   			Id do Veículo: <%=carona.getIdVeiculo()%><br>
		   			Data: <%=carona.getData()%><br>
		   			Hora: <%=carona.getHora()%><br>
		   			Id do Logradouro de Origem: <%=carona.getIdLogradouroOrigem()%><br>
		   			Id do Logradouro de Destino: <%=carona.getIdLogradouroDestino()%><br>
		   			Id do Grupo: <%=carona.getIdGrupo()%><br>
		   			</div>
		   		</div>
		   	</div>
  			<%}%>
		</div>
		
	</body>
</html>