<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util. *, entidades. *, persistencia. *"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="semantic/semantic.min.css"> 	
		<script src="semantic/semantic.min.js"></script>
		<title>Listar Grupos</title>
	</head>
	<body>
		<h1>Lista de Grupos</h1>
		
		<div align="right">
			<a href="http://localhost:8080/AAComp3/frCriarGrupo.jsp" class="item"><div class="ui green button"><i class="plus icon"></i> Adicionar</div></a>
		</div>
		<br>
		
		<div class="ui ordered middle aligned divided list">
		
			<%
						HttpSession sessao = request.getSession();
						List<Grupo> grupos = (ArrayList<Grupo>)  request.getAttribute("Grupo");

						for(Grupo grupo : grupos){
						
					%>
			
		   	<div class="item">
		   	
		   		<div class="right floated content">
		      		<a class="ui teal button" href="CrAlterarGrupo?id=<%=grupo.getIdGrupo()%>">Alterar</a>
		    	</div>
		    	
		    	<div class="right floated content">
		      		<a class="ui grey button" href="CrListarMembros?id=<%=grupo.getIdGrupo()%>">Ver Informações</a>
		    	</div>
		    	
		    	<div class="right floated content">
		    		<a class="ui orange button" href="CrInserirUsuarioGrupo?id=<%=grupo.getIdGrupo()%>">Inserir membro</a>
		    	</div>
		    	<%if(sessao.getAttribute("motorista").toString().equals("1")){ %>
		    	<div class="right floated content">
		    		<a class="ui brown button" href="CrCriarCarona?id=<%=grupo.getIdGrupo()%>">Criar Carona</a>
		    	</div>
		   		<%} %>
		   		<div class="content">
		   			<a class="header">Id do Grupo: <%=grupo.getIdGrupo()%></a>
		   			
		   			<div class="description">
		   			Nome: <%=grupo.getNome()%><br>
		   			Descrição: <%=grupo.getDescricao()%><br>
		   			Regras: <%=grupo.getRegras()%><br>
		   			Limite: <%=grupo.getLimite()%><br>
		   			Id do Usuário criador: <%=grupo.getIdUsuarioCriador()%><br>
		   			</div>
		   		</div>
		   	</div>
  			<%}%>
		</div>
	</body>
</html>