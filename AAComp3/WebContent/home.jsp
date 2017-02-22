<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *, conexao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<!--  <p>Bem-vindo, ${email}</p>  --> 
		
		<h1>Meu Perfil</h1>
		
		<%
		
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();

		UsuarioMD md = new UsuarioMD();
		int id = md.encontraUsuario(email);
		Usuario usuario = md.encontra(id);
		%>
		
		<br>
		<div class="field">
		   	<h3><label>Nome: <%=usuario.getNome()%><br><br>
		   	Email: <%=usuario.getEmail()%><br><br>
		   	Telefone: <%=usuario.getTelefone()%><br><br>
		   	<br></label></h3>
		</div>
		
		<div class="right floated content">
			<a class="ui teal button" href="CrAlterarUsuario?id=<%=id%>">Alterar Perfil</a>
		</div>
	</body>
</html>