package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Logradouro;

import persistencia.LogradouroMD;

public class ListarLogradouroRT {
	public void tratarGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
			request.setAttribute("Logras", listaLogradouro());
			
			RequestDispatcher rd = request.getRequestDispatcher("frListarLogradouros.jsp");
			rd.forward(request, response);
	
	}
	public List<Logradouro> listaLogradouro(){
		List<Logradouro> logs = new ArrayList<Logradouro>();
		LogradouroMD md;
		try {
			md = new LogradouroMD();
			logs = md.getLista();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logs;
		
	}
}
