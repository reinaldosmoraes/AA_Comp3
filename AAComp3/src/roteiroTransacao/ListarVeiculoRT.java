package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import entidades.Veiculo;

import persistencia.VeiculoMD;

public class ListarVeiculoRT {
	public void tratarGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		
			request.setAttribute("Veiculo", listaVeiculo(email));
			
			RequestDispatcher rd = request.getRequestDispatcher("frListarVeiculos.jsp");
			rd.forward(request, response);
	
	}
	public List<Veiculo> listaVeiculo(String email){
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		VeiculoMD md;
		try {
			md = new VeiculoMD();
			veiculos = md.getLista(email);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return veiculos;
		
	}
}
