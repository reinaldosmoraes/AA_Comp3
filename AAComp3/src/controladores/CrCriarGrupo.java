package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiroTransacao.CriarGrupoRT;

/**
 * Servlet implementation class CrCriarGrupo
 */
@WebServlet("/CrCriarGrupo")
public class CrCriarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrCriarGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String regras = request.getParameter("regras");
		int limite = Integer.parseInt(request.getParameter("limite"));
	
		CriarGrupoRT rt = new CriarGrupoRT();
		rt.tratar(nome, descricao, regras, limite, response, request);
	}

}
