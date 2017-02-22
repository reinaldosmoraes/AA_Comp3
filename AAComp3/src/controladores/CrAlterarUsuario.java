package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.AlterarUsuarioRT;
import roteiroTransacao.BuscarUsuarioRT;
import entidades.Usuario;

/**
 * Servlet implementation class CrAlterarUsuario
 */
@WebServlet("/CrAlterarUsuario")
public class CrAlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	Usuario usuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrAlterarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		id = Integer.parseInt(request.getParameter("id"));
		
		BuscarUsuarioRT buscarUsuarioRT = new BuscarUsuarioRT(id);
		usuario = buscarUsuarioRT.execute();
		
		RequestDispatcher rd = request.getRequestDispatcher("frAlterarUsuario.jsp?id=" + id + 
				"&nome=" + usuario.getNome() +
				"&email=" + usuario.getEmail() + 
				"&telefone=" + usuario.getTelefone() +
				"&motorista=" + usuario.getMotorista());
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		usuario.setIdUsuario(id);
		usuario.setNome(request.getParameter("nome"));
		usuario.setTelefone(request.getParameter("telefone"));
		
		AlterarUsuarioRT alterarUsuarioRT = new AlterarUsuarioRT(usuario);
		alterarUsuarioRT.execute();
		
		response.sendRedirect("home.jsp");
	}

}
