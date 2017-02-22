package roteiroTransacao;

import java.io.IOException;

import persistencia.GrupoMD;
import entidades.Grupo;

public class AlterarGrupoRT {
	
	private Grupo grupo;
	
	public AlterarGrupoRT(Grupo grupo){
		this.grupo = grupo;
	}

	public void execute() throws IOException{
		
		//validação
		
		
		GrupoMD grupoMD = null;
		
		try {
			grupoMD = new GrupoMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grupoMD.atualiza(grupo);
	}
}
