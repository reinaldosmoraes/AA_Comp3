package roteiroTransacao;

import persistencia.UsuarioMD;
import entidades.Usuario;

public class BuscarUsuarioRT {

private int id;
	
	public BuscarUsuarioRT(int id){
		this.id = id;		
	}
	
	public Usuario execute(){
		
		//validação
		
		
		//intancia o MD
		UsuarioMD usuarioMD = null;
		try {
			usuarioMD = new UsuarioMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario usuario = usuarioMD.encontra(id);
	
		return usuario;
	}
}
