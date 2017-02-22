package roteiroTransacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.CaronaMD;
import persistencia.UsuarioMD;

public class TerminarRT {
	public void tratarGet(int id, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		UsuarioMD md;
		CaronaMD cmd;
		try {
			md = new UsuarioMD();
			cmd = new CaronaMD();
			cmd.marcarTerminado(id);
			int i = md.encontraUsuario(email);
		
			
			RequestDispatcher rd = request.getRequestDispatcher("CrListarCarona?id=" + i );
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
