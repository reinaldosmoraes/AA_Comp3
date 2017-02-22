<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Listar Veículos</title>
	</head>
	<body>
		
		<h1>Lista de Veículos</h1>
		
		<div align="right">
			<a href="http://localhost:8080/AAComp3/frCriarVeiculo.jsp" class="item"><div class="ui green button"><i class="plus icon"></i> Adicionar</div></a>
		</div>
		<br>
		
		<div class="ui ordered middle aligned divided list">
		
			<%
						List<Veiculo> veiculos = (ArrayList<Veiculo>) request.getAttribute("Veiculo");
					
						for(Veiculo veiculo : veiculos){
						
					%>
			
		   	<div class="item">
		   	
		   		<div class="right floated content">
		      		<a class="ui teal button" href="CrAlterarVeiculo?id=<%=veiculo.getIdVeiculo()%>">Alterar</a>
		    	</div>
		   		
		   		<div class="content">
		   			<a class="header">Id de Veículo: <%=veiculo.getIdVeiculo()%></a>
		   			
		   			<div class="description">
		   			Modelo: <%=veiculo.getModelo()%><br>
		   			Placa: <%=veiculo.getPlaca()%><br>
		   			Cor: <%=veiculo.getCor()%><br>
		   			Id do Motorista: <%=veiculo.getIdMotorista()%><br>
		   			</div>
		   		</div>
		   	</div>
  			<%}%>
		</div>
		
	</body>
</html>