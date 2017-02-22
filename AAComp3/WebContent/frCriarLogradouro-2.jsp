<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util. *, entidades. *, persistencia. *,org.json.*"%>
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
 		<% JSONObject json = (JSONObject)request.getAttribute("Lograd");
 		%>
 		<form class="ui form" action="./CrCriarLogradouro" method="post">
			<div class="disabled field">
        		<label><h3>Cep (sem hífen)</h3></label>
    			<input type="text" name="cep" placeholder="CEP" value= <%=request.getParameter("cep")%> required>
    		</div>
    		<div class="disabled field">
        		<label><h3>Estado</h3></label>
    			<input type="text" name="estado" placeholder="Estado" value= <%=json.getString("uf")%> required>
    		</div>
    		
    	<!--  
    		<div class="disabled field">
        		<label><h3>Cidade</h3></label>
    			<input type="text" name="cidade" placeholder="Cidade" value= <%=json.getString("localidade")%> required>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Distrito</h3></label>
    			<input type="text" name="distrito" placeholder="Distrito" value= <%=json.getString("bairro")%> required>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Endereço</h3></label>
    			<input type="text" name="endereco" placeholder="Endereço" value= <%=json.getString("logradouro") + ", " + json.getString("complemento")%> required>
    		</div>  -->
    		
    		<div class="field">
        		<label><h3>Número</h3></label>
    			<input type="number" name="numero" placeholder="Número" required>
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