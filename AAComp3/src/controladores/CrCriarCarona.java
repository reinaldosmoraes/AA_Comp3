package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.CriarCaronaRT;
import entidades.Carona;

/**
 * Servlet implementation class CrCriarCarona
 */
@WebServlet("/CrCriarCarona")
public class CrCriarCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrCriarCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("frCriarCarona.jsp?id=" + id);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idVeiculo = Integer.parseInt(request.getParameter("idVeiculo"));
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		int idLogradouroOrigem = Integer.parseInt(request.getParameter("idLogradouroOrigem"));
		int idLogradouroDestino = Integer.parseInt(request.getParameter("idLogradouroDestino"));

		Carona carona = new Carona(id, idVeiculo, data, hora, idLogradouroOrigem, idLogradouroDestino);
		
		CriarCaronaRT rt = new CriarCaronaRT();
		rt.tratar(carona, response);
		
	}

}
