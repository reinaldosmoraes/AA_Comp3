<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Criar Parada</title>
	</head>
	<body>
	
		<h1>Criar Parada</h1>
 		<br>
 		
 		<form class="ui form" action="./CrCriarParada" method="post">
			<foreach />
    		<div class="field">
        		<label><h3>Logradouro</h3></label>
	    		<select class="ui dropdown" name="idLogradouro">		
					<%
					List<Logradouro> log = (ArrayList<Logradouro>) request.getAttribute("Logs");
					  
					
					for(Logradouro logradouro : log){
					%>
						<option value="<%=logradouro.getIdLogradouro()%>"><%=logradouro.getEndereco() + ", " + logradouro.getNumero()%> </option>
					<%}%>	
				</select>    		
    		</div>
    		
    		
    		<div class="field">
        		<label><h3>Carona</h3></label>
    			<select class="ui dropdown" name="idCarona">				
					<%
					List<Carona> caronas = (ArrayList<Carona>) request.getAttribute("Carona");
					
					Logradouro logradouroOrigem = new Logradouro();
					Logradouro logradouroDestino = new Logradouro();
					
					for(Carona carona : caronas){
						for(Logradouro logra : log){
							if(logra.getIdLogradouro() == carona.getIdLogradouroOrigem()){
								logradouroOrigem = logra;
								}
							if(logra.getIdLogradouro() == carona.getIdLogradouroDestino()){
								logradouroDestino = logra;
								}
						}
						
						%>
						<option value="<%=carona.getIdCarona()%>">Origem: <%=logradouroOrigem.getEndereco() + ", " + logradouroOrigem.getNumero() + "; Destino: " + logradouroDestino.getEndereco() + ", " + logradouroDestino.getNumero()%> </option>
						<%}%>	
				</select>				
    		</div>
    		
    		<br>
    		
			<div class="ui buttons">
				<a class="ui button" href="CrListarParada" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>
		</form>
	
	</body>
</html>