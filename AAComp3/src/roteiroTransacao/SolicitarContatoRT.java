package roteiroTransacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import persistencia.CaronaMD;


public class SolicitarContatoRT {
	public void tratarGet(int id, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		
		CaronaMD md;
		try {
			md = new CaronaMD();
			Usuario usuario = md.solicitarInformacoes(id);
			String telefone = usuario.getTelefone();
			String email = usuario.getEmail();
			System.out.println(telefone + email);
			RequestDispatcher rd = request.getRequestDispatcher("frContatosMotorista.jsp?email=" + email +
					"&telefone="+ telefone);
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
