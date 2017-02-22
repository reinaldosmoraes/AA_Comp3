package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Carona;
import persistencia.CaronaMD;
import persistencia.UsuarioMD;

public class ListarCaronaRT {
	public void tratarGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		UsuarioMD md;
		try {
			md = new UsuarioMD();
			int i = md.encontraUsuario(email);
			request.setAttribute("Car", listaCarona(i));
			
			RequestDispatcher rd = request.getRequestDispatcher("frListarCaronas.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public List<Carona> listaCarona(int id){
		List<Carona> caronas = new ArrayList<Carona>();
		CaronaMD md;
		try {
			md = new CaronaMD();
			caronas = md.getLista(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caronas;
		
	}

}
