package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.UsuarioMD;
import persistencia.VeiculoMD;
import entidades.Veiculo;

public class CriarVeiculoRT {
	
	public CriarVeiculoRT(String modelo, String placa, String cor, HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		//validação
		//só testa se está vazio. Tem que colocar máscara na placa
		if(modelo == "" || placa == "" || cor == ""){
			response.sendRedirect("erro.jsp");
		}
		else{
			//Criação do objeto e chamada do MD
			HttpSession sessao = request.getSession();
			String email = sessao.getAttribute("email").toString();
			
			int idMotorista;
			
			try{
				UsuarioMD usuarioMD = new UsuarioMD();
				idMotorista = usuarioMD.encontraUsuario(email);
				
				Veiculo veiculo = new Veiculo(modelo, placa, cor, idMotorista);
				
				VeiculoMD veiculoMD = new VeiculoMD();
				veiculoMD.adiciona(veiculo);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			sessao.setAttribute("motorista", 1);
			response.sendRedirect("CrListarVeiculo");
		}
		
	}

}
