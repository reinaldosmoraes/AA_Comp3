package controladores;
	
	import java.io.IOException;
	
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import roteiroTransacao.AlterarVeiculoRT;
	import roteiroTransacao.BuscarVeiculoRT;
	import entidades.Veiculo;
	
	/**
	 * Servlet implementation class CrAlterarVeiculo
	 */
	@WebServlet("/CrAlterarVeiculo")
	public class CrAlterarVeiculo extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private int id;
		Veiculo veiculo;
		
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CrAlterarVeiculo() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
			id = Integer.parseInt(request.getParameter("id"));

			BuscarVeiculoRT buscarVeiculoRT = new BuscarVeiculoRT(id);
			veiculo = buscarVeiculoRT.execute();
			
			RequestDispatcher rd = request.getRequestDispatcher("frAlterarVeiculo.jsp?id=" + id + 
					"&modelo=" + veiculo.getModelo() +
					"&placa=" + veiculo.getPlaca() + 
					"&cor=" + veiculo.getCor() +
					"&idmotorista=" + veiculo.getIdMotorista());
			rd.forward(request, response);
		
		}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			veiculo.setIdVeiculo(id);
			veiculo.setCor(request.getParameter("cor"));
			
			AlterarVeiculoRT alterarVeiculoRT = new AlterarVeiculoRT(veiculo);
			alterarVeiculoRT.execute();
		
			response.sendRedirect("CrListarVeiculo");
		}
	
	}