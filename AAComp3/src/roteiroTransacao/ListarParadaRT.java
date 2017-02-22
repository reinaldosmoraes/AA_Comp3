package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Parada;
import persistencia.ParadaMD;
import persistencia.UsuarioMD;

public class ListarParadaRT {
	public void tratarGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		UsuarioMD md;
		try {
			md = new UsuarioMD();
			int i = md.encontraUsuario(email);
			request.setAttribute("Parada", listaParada(i));
			
			RequestDispatcher rd = request.getRequestDispatcher("frListarParadas.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public List<Parada> listaParada(int id){
		List<Parada> paradas = new ArrayList<Parada>();
		ParadaMD md;
		try {
			md = new ParadaMD();
			paradas = md.getLista(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return paradas;
		
	}
	
}
