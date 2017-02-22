package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.InserirUsuarioCaronaRT;

/**
 * Servlet implementation class CrInserirUsuarioCarona
 */
@WebServlet("/CrInserirUsuarioCarona")
public class CrInserirUsuarioCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrInserirUsuarioCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("frInserirUsuarioCarona.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		InserirUsuarioCaronaRT rt = new InserirUsuarioCaronaRT();
		rt.tratar(email, id, response);
	}

}
