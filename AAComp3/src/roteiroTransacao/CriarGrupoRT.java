package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.GrupoMD;
import persistencia.UsuarioMD;
import entidades.Grupo;

public class CriarGrupoRT {

	public void tratar(String nome, String descricao, String regras, int limite, HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		//validação
		if(nome == "" || descricao == "" || regras == ""){
			response.sendRedirect("erro.jsp");
		}
		else{
			//Criação do objeto e chamada do MD
			HttpSession sessao = request.getSession();
			String email = sessao.getAttribute("email").toString();
			
			try{
				UsuarioMD md = new UsuarioMD();
				int idUsuarioCriador = md.encontraUsuario(email);
				GrupoMD grupoMD = new GrupoMD();
				Grupo grupo = new Grupo(nome, descricao, regras, limite, idUsuarioCriador);
				grupoMD.adiciona(grupo);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("CrListarGrupo");
		}
	}
}
