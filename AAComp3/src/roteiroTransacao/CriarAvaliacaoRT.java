package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import entidades.Avaliacao;
import persistencia.AvaliacaoMD;

public class CriarAvaliacaoRT {
	
	public void tratar(Integer estrelas, Integer idUsuario, HttpServletResponse response) throws IOException{
			
		//validação de estrelas
		//usando select box, entao ela não é necessária, pois só é permitida a entrada de valores válidos
		
		//criação do objeto
		Avaliacao avaliacao = new Avaliacao(estrelas, idUsuario);
		try {
			AvaliacaoMD md = new AvaliacaoMD();
			md.adiciona(avaliacao);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("CrListarGrupo");
	}
}
