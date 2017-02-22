<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Criar Logradouro</title>
	</head>
	<body>
		<h1>Criar Logradouro</h1>
 		<br>
 		
 		<form class="ui form" action="./CrCriarLogradouro" method="get">
 		
			<div class="field">
        		<label><h3>Cep (sem hífen)</h3></label>
    			<input id="cep" type="number" minlength="8" maxlength="8" name="cep"  placeholder="CEP" required>
    		</div>
    		
    		
    		<br>
    		<div class="ui buttons">
				<a class="ui button" href="CrListarLogradouro" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>

		</form>
	
	</body>
</html>