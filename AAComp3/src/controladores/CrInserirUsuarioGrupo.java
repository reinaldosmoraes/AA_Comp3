package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.InserirUsuarioGrupoRT;

/**
 * Servlet implementation class CrInserirUsuarioGrupo
 */
@WebServlet("/CrInserirUsuarioGrupo")
public class CrInserirUsuarioGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrInserirUsuarioGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher rd = request.getRequestDispatcher("frInserirUsuarioGrupo.jsp?id=" + id);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email").toString();
	
		InserirUsuarioGrupoRT rt = new InserirUsuarioGrupoRT();
		rt.tratar(email, id, response);
	}
}

