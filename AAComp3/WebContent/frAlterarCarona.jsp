<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Alterar Carona</title>
	</head>
	<body>
	<h1>Alterar Carona</h1>
 		<br>
 		
 		<form class="ui form" action="./CrAlterarCarona" method="post">
 			<div class="disabled field">
        		<label><h3>Id da Carona</h3></label>
    			<input type="number" name="id" value=<%=request.getParameter("id")%> required>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Id do Veiculo</h3></label>
    			<input type="number" name="idVeiculo" value=<%=request.getParameter("idVeiculo")%> required>
    		</div>
    		
			<div class="field">
        		<label><h3>Data</h3></label>
    			<input type="date" name="data" value=<%=request.getParameter("data")%> required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Hora</h3></label>
    			<input type="time" name="hora" value=<%=request.getParameter("hora")%> required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Id de logradouro de origem</h3></label>
    			<input type="number" name="idLogradouroOrigem" value=<%=request.getParameter("idLogradouroOrigem")%> required>
    		</div>
    		
    		<div class="field">
        		<label><h3>Id de logradouro de destino</h3></label>
    			<input type="number" name="idLogradouroDestino" value=<%=request.getParameter("idLogradouroDestino")%> required>
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