package roteiroTransacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import conexao.WSConnection;
import persistencia.LogradouroMD;
import entidades.Logradouro;

public class CriarLogradouroRT {
	JSONObject json = new JSONObject();
	public void tratarGet(String cep, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if(cep.length() != 8){
			response.sendRedirect("erro.jsp");
		}else{
		json = WSConnection.fromUrl(cep);
		
		String estado = json.getString("uf");
		String distrito = json.getString("bairro");
		String cidade = json.getString("localidade");
		String endereco = json.getString("logradouro") + ", " + json.getString("complemento");
	
		request.setAttribute("Lograd", json);
		RequestDispatcher rd = request.getRequestDispatcher("frCriarLogradouro-2.jsp?cep=" + cep + 
				"&estado=" + estado +
				"&distrito=" + distrito + 
				"&cidade=" + cidade +
				"&endereco=" + endereco);
		rd.forward(request, response);
		}
	}
	public void tratar(String cep, Integer numero, HttpServletResponse response) throws IOException{
		
		//validação
		//viacep e marcar como disabled os campos, entao nao precisa validar
		String estado = json.getString("uf");
		String distrito = json.getString("bairro");
		String cidade = json.getString("localidade");
		String endereco = json.getString("logradouro") + ", " + json.getString("complemento");
	
		//criação do objeto
		Logradouro logradouro = new Logradouro(cep, estado, cidade, distrito, endereco, numero);
		
		try{
			
			LogradouroMD logradouroMD = new LogradouroMD();
			logradouroMD.adiciona(logradouro);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("CrListarLogradouro");
	}
	
}
