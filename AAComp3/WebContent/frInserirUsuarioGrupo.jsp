<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Adicionar Usuário</title>
</head>
<body>
	<form id="form1" name="form1" class="ui form" action="./CrInserirUsuarioGrupo" method="post" >
		
    		<div class="field">
        		<label><h3>Email</h3></label>
    			<input type="text" id="email" name="email" maxlength="60" placeholder="Email" required>
    		</div>
    		
    		<div class="ui buttons">
				<a class="ui button" href="CrListarGrupo" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>
		
		</form>
</body>
</html>