package controladores;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import roteiroTransacao.CriarParadaRT;

/**
 * Servlet implementation class CrCriarParada
 */
@WebServlet("/CrCriarParada")
public class CrCriarParada extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CriarParadaRT rt = new CriarParadaRT();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrCriarParada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rt.tratarGet(response, request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idLogradouro = Integer.parseInt(request.getParameter("idLogradouro"));
		int idCarona = Integer.parseInt(request.getParameter("idCarona"));
		
		
		rt.tratar(idLogradouro, idCarona, response, request);
	}
}
