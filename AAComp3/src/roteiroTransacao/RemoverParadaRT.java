package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import persistencia.ParadaMD;

public class RemoverParadaRT {
	
	public void tratar(Integer idParada, HttpServletResponse response) throws IOException{
		try {
			ParadaMD paradaMD = new ParadaMD();

			paradaMD.remove(idParada);
			response.sendRedirect("CrListarParada");
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
}
