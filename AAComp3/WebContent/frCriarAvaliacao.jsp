<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Criar Avaliação</title>
	</head>
	<body>
	
		<h1>Criar Avaliação</h1>
 		<br>
 		
 		<form class="ui form" action="./CrCriarAvaliacao" method="post">
			<div class="field">
        		<label><h3>Avaliação (n de estrelas)</h3></label>
        		
        		<select name="estrelas" class="ui dropdown">
					<option value="1">1 estrela</option>
					<option value="2">2 estrelas</option>
					<option value="3">3 estrelas</option>
					<option value="4">4 estrelas</option>
					<option value="5">5 estrelas</option>
				</select>
        		
    		</div>
    		
    		<br>
    		
    		<div class="ui buttons">
				<a class="ui button" href="CrListarGrupo" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>

		</form>
	
	</body>
</html>