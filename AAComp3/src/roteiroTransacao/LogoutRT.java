package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutRT {

	public void tratar(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		response.sendRedirect("index.jsp");
	}
}
