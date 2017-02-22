package roteiroTransacao;

import persistencia.GrupoMD;
import entidades.Grupo;

public class BuscarGrupoRT {

	private int id;
	
	public BuscarGrupoRT(int id){
		this.id = id;
	}
	
	public Grupo execute(){
		
		//validação
		
		
		//intancia o MD
		GrupoMD grupoMD = null;
		try {
			grupoMD = new GrupoMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Grupo grupo = grupoMD.encontra(id);
	
		return grupo;
	}
}
