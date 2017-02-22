package roteiroTransacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.GrupoUsuarioMD;
import persistencia.UsuarioMD;

public class AceitarRegrasRT {
	
	//contrutor tratando o doGet do CrAceitarRegras
	public AceitarRegrasRT(int id, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		HttpSession sessao = request.getSession();
		String email = sessao.getAttribute("email").toString();
		UsuarioMD md;
		try {
			md = new UsuarioMD();
			int i = md.encontraUsuario(email);
			GrupoUsuarioMD gumd = new GrupoUsuarioMD();
			gumd.aceitar(i, id);
			
			RequestDispatcher rd = request.getRequestDispatcher("CrListarMembros?id=" + id );
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
