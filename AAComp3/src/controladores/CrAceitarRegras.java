package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.AceitarRegrasRT;

/**
 * Servlet implementation class CrAceitarRegras
 */
@WebServlet("/CrAceitarRegras")
public class CrAceitarRegras extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrAceitarRegras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i = Integer.parseInt(request.getParameter("id"));
		
		new AceitarRegrasRT(i, response, request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
