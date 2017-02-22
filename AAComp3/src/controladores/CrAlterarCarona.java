package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Carona;
import roteiroTransacao.AlterarCaronaRT;
import roteiroTransacao.BuscarCaronaRT;

/**
 * Servlet implementation class CrAlterarCarona
 */
@WebServlet("/CrAlterarCarona")
public class CrAlterarCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	Carona carona;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrAlterarCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		id = Integer.parseInt(request.getParameter("id"));
		
		BuscarCaronaRT buscarCaronaRT = new BuscarCaronaRT(id);
		
		carona = buscarCaronaRT.execute();
		
		RequestDispatcher rd = request.getRequestDispatcher("frAlterarCarona.jsp?id=" + id + 
				"&idVeiculo=" + carona.getIdVeiculo() +
				"&data=" + carona.getData() + 
				"&hora=" + carona.getHora() + 
				"&idLogradouroOrigem=" + carona.getIdLogradouroOrigem() +
				"&idLogradouroDestino=" + carona.getIdLogradouroDestino());
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Carona carona = new Carona();
		
		carona.setIdCarona(id);
		carona.setIdVeiculo(Integer.parseInt(request.getParameter("idVeiculo")));
		carona.setData(request.getParameter("data"));
		carona.setHora(request.getParameter("hora"));
		carona.setIdLogradouroOrigem(Integer.parseInt(request.getParameter("idLogradouroOrigem")));
		carona.setIdLogradouroDestino(Integer.parseInt(request.getParameter("idLogradouroDestino")));
		
		AlterarCaronaRT alterarCaronaRT = new AlterarCaronaRT(carona);
		alterarCaronaRT.execute();
		
		response.sendRedirect("CrListarCarona");
	}

}