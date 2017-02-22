package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.Grupo;
import persistencia.GrupoMD;


public class ListarGrupoRT {
	public void tratarGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		
			request.setAttribute("Grupo", listaGrupo(email));
			
			RequestDispatcher rd = request.getRequestDispatcher("frListarGrupos.jsp");
			rd.forward(request, response);
	
	}
	public List<Grupo> listaGrupo(String email){
		List<Grupo> grupos = new ArrayList<Grupo>();
		GrupoMD md;
		try {
			md = new GrupoMD();
			grupos = md.getLista(email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return grupos;
		
	}
}
