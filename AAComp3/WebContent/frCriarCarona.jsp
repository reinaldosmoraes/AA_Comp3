<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Criar Carona</title>
	</head>
	<body>
		
		<h1>Criar Carona</h1>
 		<br>
 		
 		<form class="ui form" action="./CrCriarCarona" method="post">
			<div class="field">
        		<label><h3>Id de Veículo</h3></label>
    			<input type="number" name="idVeiculo" placeholder="Id de Veículo">
    		</div>
    		
    		<div class="field">
        		<label><h3>Data</h3></label>
    			<input type="date" name="data" placeholder="Data ">
    		</div>
    		
    		<div class="field">
        		<label><h3>Hora</h3></label>
    			<input type="time" name="hora" placeholder="Hora">
    		</div>
    		
    		<div class="field">
        		<label><h3>Id de logradouro de origem</h3></label>
    			<input type="number" name="idLogradouroOrigem" placeholder="Id de Logradouro de Origem">
    		</div>
    		
    		<div class="field">
        		<label><h3>Id de logradouro de destino</h3></label>
    			<input type="number" name="idLogradouroDestino" placeholder="Id de Logradouro de Destino">
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Id Grupo</h3></label>
    			<input type="number" name="idGrupo" value=<%=request.getParameter("id")%> placeholder="Id Grupo">
    		</div>
    		
    		<br>
    		
			<div class="ui buttons">
				<a class="ui button" href="CrListarCarona" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>

		</form>
		
	</body>
</html>