<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>AA de Comp3</title>
	</head>
	
	<body>
		
		<div class="ui secondary pointing menu">
	
  		<a class="item active" href="http://localhost:8080/AAComp3/home.jsp" class="item" target="iframe">
    	Home
 		</a>
  		
  		<a class="item" href="CrListarVeiculo" target="iframe">
    	Veículo
  		</a>
  		
  		<a class="item" href="CrListarCarona" target="iframe">
    	Carona
  		</a>
  		
  		<a class="item" href="CrListarParada" target="iframe">
    	Parada
  		</a>
  		
  		<a class="item" href="CrListarGrupo" target="iframe">
    	Grupo
  		</a>
  
  		<a class="item" href="CrListarLogradouro" target="iframe">
    	Logradouro
  		</a>
  		
  		
    	<div class="right menu" >
    		<a class="item" href="http://localhost:8080/AAComp3/logout.jsp" >
      		Logout
    		</a>
  		</div>
  		
	</div>
	
	<div align="center" class="ui segment">
  		
  		<iframe name="iframe" width=70% height=768 frameborder='0' src='http://localhost:8080/AAComp3/home.jsp'></iframe>
  		
	</div>
			
	</body>
</html>