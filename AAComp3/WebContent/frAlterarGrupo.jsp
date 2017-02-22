<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Alterar Grupo</title>
	</head>
	
	<body>
	
		<h1>Alterar Grupo</h1>
 		<br>
 		
 		<form class="ui form" action="./CrAlterarGrupo" method="post">
 			<div class="disabled field">
        		<label><h3>Id do Grupo</h3></label>
    			<input type="number" name="id" value= <%=request.getParameter("id")%>>
    		</div>
    		
			<div class="field">
        		<label><h3>Nome</h3></label>
    			<input type="text" name="nome" value= <%=request.getParameter("nome")%>>
    		</div>
    		
    		<div class="field">
        		<label><h3>Descrição</h3></label>
    			<input type="text" name="descricao" value= <%=request.getParameter("descricao")%>>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Regras</h3></label>
    			<input type="text" name="regras" value= <%=request.getParameter("regras")%>>
    		</div>
    		
    		<div class="field">
        		<label><h3>Limite de avaliações ruins para inativar o usuario</h3></label>
    			<input type="number" name="limite" value= <%=request.getParameter("limite")%> min="1" required>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Usuário criador do Grupo</h3></label>
    			<input type="number" name="idUsuarioCriador" value= <%=request.getParameter("idusuariocriador")%>>
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