package roteiroTransacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.CaronaMD;
import persistencia.LogradouroMD;
import persistencia.ParadaMD;
import persistencia.UsuarioMD;
import entidades.Carona;
import entidades.Logradouro;
import entidades.Parada;

public class CriarParadaRT {
	public void tratarGet(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		request.setAttribute("Logs", listaLogradouro());
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		UsuarioMD md;
		try {
			md = new UsuarioMD();
			int i = md.encontraUsuario(email);
			request.setAttribute("Carona", listaCarona(i));
			
			RequestDispatcher rd = request.getRequestDispatcher("frCriarParada.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void tratar(Integer idLogradouro, Integer idCarona, HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		//validação
		//nao é necessaria aqui pois a jsp lista os  ids existentes no banco pra o usuario selecionar

		
		//Criação do objeto
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();

		try{
			UsuarioMD md = new UsuarioMD();
			int idUsuario = md.encontraUsuario(email);
			
			Parada parada = new Parada(idUsuario, idLogradouro, idCarona);
			
			ParadaMD paradaMD = new ParadaMD();
			paradaMD.adiciona(parada);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("CrListarParada");
	}
	public List<Logradouro> listaLogradouro(){
		List<Logradouro> logradouros = new ArrayList<Logradouro>();
		LogradouroMD md;
		try {
			md = new LogradouroMD();
			logradouros = md.getLista();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logradouros;
		
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
