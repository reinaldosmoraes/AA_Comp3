package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.CriarLogradouroRT;

/**
 * Servlet implementation class CrCriarLogradouro
 */
@WebServlet("/CrCriarLogradouro")
public class CrCriarLogradouro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CriarLogradouroRT rt = new CriarLogradouroRT();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrCriarLogradouro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cep = request.getParameter("cep");
		rt.tratarGet(cep, request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cep = request.getParameter("cep");

		int numero = Integer.parseInt(request.getParameter("numero"));
		
		rt.tratar(cep, numero, response);
	}
}
