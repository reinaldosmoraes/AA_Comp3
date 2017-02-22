package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import persistencia.CaronaMD;
import entidades.Carona;

public class CriarCaronaRT {
	
	public void tratar(Carona carona, HttpServletResponse response) throws IOException{
		
		try{
			
			CaronaMD caronaMD = new CaronaMD();
			caronaMD.adiciona(carona);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("CrListarCarona");
	}

}
