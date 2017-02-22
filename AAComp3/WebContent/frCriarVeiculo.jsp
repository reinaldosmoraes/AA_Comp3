<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Criar Veículo</title>
	</head>
	<body>
		
		<h1>Criar Veículo</h1>
 		<br>
 		
 		<form class="ui form" action="./CrCriarVeiculo" method="post">
			<div class="field">
        		<label><h3>Modelo</h3></label>
    			<input type="text" name="modelo" placeholder="Modelo" maxlength="50" required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Placa</h3></label>
    			<input type="text" name="placa" placeholder="Placa" maxlength="8" required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Cor</h3></label>
    			<input type="text" name="cor" placeholder="Cor" maxlength="20" required>
    		</div>
    		
    		
    		<div class="ui buttons">
				<a class="ui button" href="CrListarVeiculo" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>

		</form>
		
	</body>
</html>