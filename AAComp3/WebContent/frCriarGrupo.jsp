<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Criar Grupo</title>
	</head>
	
	<body>
	
		<h1>Criar Grupo</h1>
 		<br>
 		
 		<form class="ui form" action="./CrCriarGrupo" method="post">
			<div class="field">
        		<label><h3>Nome</h3></label>
    			<input type="text" name="nome" placeholder="Nome"  maxlength="50" required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Descrição</h3></label>
    			<input type="text" name="descricao" placeholder="Descrição" maxlength="100" required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Regras</h3></label>
    			<input type="text" name="regras" placeholder="Regras" maxlength="100" required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Limite de avaliações ruins para inativar o usuario</h3></label>
        		<input type="number" name="limite" min="1" required>    			
    		</div>
    		
			<div class="ui buttons">
				<a class="ui button" href="CrListarGrupo" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>

		</form>
		
	</body>
</html>