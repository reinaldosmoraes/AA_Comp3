<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>AA de Comp3</title>
	
	</head>

<body>
	<br>
	<h2><center>Atividade Acadêmica de Compuatação 3</center></h2>
	<h3><center>Bianca Albuquerque e Reinaldo Moraes<br>UFRRJ - 2016.2</center></h3>
	
	
	<form id="form1" name="form1" class="ui form" action="./CrLogin" method="post">  		
    		<div class="field">
        		<label><h3>Email</h3></label>
    			<input type="text" id="email" name="email" maxlength="60" placeholder="Email">
    		</div>
    		
    		
    		
    		<div align="center" >
  				<button type="submit" class="ui positive button">Login</button>
			</div>
		
		</form>
		<div class="ui horizontal divider">
   			 Ou
  		</div>
  		<div align="center" >
    	<a class="ui button" href="http://localhost:8080/AAComp3/frCriarUsuario.jsp"  style="color: #2F4F4F">Cadastro</a>
  		</div>
	
</body>
</html>