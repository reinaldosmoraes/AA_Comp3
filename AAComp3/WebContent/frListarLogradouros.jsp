<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Listar Logradouros</title>
	</head>
	
	<body>
	
		<h1>Lista de Logradouros</h1>
		
		<div align="right">
			<a href="http://localhost:8080/AAComp3/frCriarLogradouro.jsp" class="item"><div class="ui green button"><i class="plus icon"></i> Adicionar</div></a>
		</div>
		<br>
		
		<div class="ui ordered middle aligned divided list">
		
			<%
						List<Logradouro> logradouros = (ArrayList<Logradouro>) request.getAttribute("Logras");
					
						for(Logradouro logradouro : logradouros){
					
					%>
			
		   	<div class="item">
		   	
		   		<div class="content">
		   			<a class="header">Id de Logradouro: <%=logradouro.getIdLogradouro()%></a>
		   			
		   			<div class="description">
		   			CEP: <%=logradouro.getCep()%><br>
		   			Estado: <%=logradouro.getEstado()%><br>
		   			Cidade: <%=logradouro.getCidade()%><br>
		   			CEP: <%=logradouro.getCep()%><br>
		   			Distrito: <%=logradouro.getDistrito()%><br>
		   			Endereço: <%=logradouro.getEndereco()%><br>
		   			Número: <%=logradouro.getNumero()%><br>
		   			</div>
		   		</div>
		   	</div>
  			<%}%>
		</div>
		
	</body>
</html>