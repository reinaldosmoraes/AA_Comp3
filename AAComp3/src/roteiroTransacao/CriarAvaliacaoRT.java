package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import entidades.Avaliacao;
import persistencia.AvaliacaoMD;

public class CriarAvaliacaoRT {
	
	public void tratar(Integer estrelas, Integer idUsuario, HttpServletResponse response) throws IOException{
			
		//valida��o de estrelas
		//usando select box, entao ela n�o � necess�ria, pois s� � permitida a entrada de valores v�lidos
		
		//cria��o do objeto
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
