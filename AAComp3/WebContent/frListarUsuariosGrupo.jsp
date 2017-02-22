<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 
		<title>Insert title here</title>
	</head>
	<body>
	
		<h1>Lista de Usuários no Grupo</h1>
		
		<div class="ui ordered middle aligned divided list">
		
			<%		if(Integer.parseInt(request.getAttribute("Reg").toString()) == 1){
					List<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("Membros");
				
					for(Usuario usuario : usuarios){
				
				%>
		
	   	<div class="item">
	   	
	   		<div class="right floated content">
	      		<a class="ui grey button" href="CrCriarAvaliacao?id=<%=usuario.getIdUsuario()%>">Avaliar</a>
	    	</div>
	   		
	   		<div class="content">
	   			<a class="header">Nome: <%=usuario.getNome()%></a>
	   			
	   			<a class="description">
	   				Email: <%=usuario.getEmail()%><br>
	   				Telefone: <%=usuario.getTelefone()%>
	   			</a>
	   			
	   		</div>
	   	</div>
		<%}%>
		</div>
		<h1>Lista de Caronas do Grupo</h1>
		<div class="ui ordered middle aligned divided list">
		
			<%
						List<Carona> caronas = (ArrayList<Carona>) request.getAttribute("Caronas");
						
						for(Carona carona : caronas){
						
					%>
	    	
		   	<div class="item">
		   		<div class="right floated content">
	      			<a class="ui grey button" href="CrSolicitarContato?id=<%=carona.getIdCarona()%>">Contatos Motorista</a>
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
  			<%}}else{%>
  			<div class="right floated content">
		      		<a class="ui teal button" href="CrAceitarRegras?id=<%=request.getParameter("id")%>">Aceite Regras do Grupo</a>
		    	</div>
  			<% }%>
		</div>
		
	</body>
</html>