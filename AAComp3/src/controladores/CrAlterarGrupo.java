package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.AlterarGrupoRT;
import roteiroTransacao.BuscarGrupoRT;
import entidades.Grupo;

/**
 * Servlet implementation class CrAlterarGrupo
 */
@WebServlet("/CrAlterarGrupo")
public class CrAlterarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
	Grupo grupo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrAlterarGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		id = Integer.parseInt(request.getParameter("id"));
		
		BuscarGrupoRT buscarGrupoRT = new BuscarGrupoRT(id);
		grupo = buscarGrupoRT.execute();
		
		RequestDispatcher rd = request.getRequestDispatcher("frAlterarGrupo.jsp?id=" + id + 
				"&nome=" + grupo.getNome() +
				"&descricao=" + grupo.getDescricao() + 
				"&regras=" + grupo.getRegras() +
				"&limite=" + grupo.getLimite() + 
				"&idusuariocriador=" + grupo.getIdUsuarioCriador());
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		grupo.setIdGrupo(id);
		grupo.setNome(request.getParameter("nome"));
		grupo.setDescricao(request.getParameter("descricao"));
		grupo.setLimite(Integer.parseInt(request.getParameter("limite")));
		
		AlterarGrupoRT alterarGrupoRT = new AlterarGrupoRT(grupo);
		alterarGrupoRT.execute();
		
		response.sendRedirect("CrListarGrupo");
	}

}
