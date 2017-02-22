<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<script type="text/javascript">
			/* Máscaras ER */
			function mascara(o,f){
				v_obj=o
				v_fun=f
				setTimeout("execmascara()",1)
			}
			function execmascara(){
				v_obj.value=v_fun(v_obj.value)
			}
			function mtel(v){
				v=v.replace(/\D/g,""); //Remove tudo o que não é dígito
				v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
				v=v.replace(/(\d)(\d{4})$/,"$1-$2"); //Coloca hífen entre o quarto e o quinto dígitos
				return v;
			}
			function id( el ){
				return document.getElementById( el );
			}
			window.onload = function(){
				id('telefone').onkeypress = function(){
					mascara( this, mtel );
				}
			}
		</script>
		<title>Alterar Usuário</title>
	</head>
	<body>
		
		<h1>Alterar Usuário</h1>
 		<br>
 		
 		<form class="ui form" action="./CrAlterarUsuario" method="post">
 			<div class="disabled field">
        		<label><h3>Id do Usuário</h3></label>
    			<input type="number" name="id" value= <%=request.getParameter("id")%>>
    		</div>
    		
			<div class="field">
        		<label><h3>Nome</h3></label>
    			<input type="text" name="nome" value= <%=request.getParameter("nome")%> required>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>Email</h3></label>
    			<input type="text" name="email" value= <%=request.getParameter("email")%>>
    		</div>
    		
    		<div class="field">
        		<label><h3>Telefone</h3></label>
    			<input type="text" name="telefone" value= <%=request.getParameter("telefone")%> id="telefone" minlength="14" maxlength="15" placeholder="(XX)XXXXX-XXXX" required>
    		</div>
    		
    		<div class="disabled field">
        		<label><h3>É Motorista? 0 ou 1</h3></label>
    			<input type="number" name="motorista" value= <%=request.getParameter("motorista")%>>
    		</div>
    		 		
    		<br>
    		
			<div class="ui buttons">
				<a class="ui button" href="http://localhost:8080/AAComp3/home.jsp" target="iframe" style="color: #2F4F4F">Cancelar</a>
  				<div class="or" data-text="ou"></div>
  				<button type="submit" class="ui positive button">Salvar</button>
			</div>

		</form>
		
	</body>
</html>