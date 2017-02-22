package roteiroTransacao;

import java.io.IOException;

import persistencia.UsuarioMD;
import entidades.Usuario;

public class AlterarUsuarioRT {
	
private Usuario usuario;
	
	public AlterarUsuarioRT(Usuario usuario){	
		this.usuario = usuario;		
	}

	public void execute() throws IOException{
		
		//validação
		
		
		UsuarioMD usuarioMD = null;
		
		try {
			usuarioMD = new UsuarioMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuarioMD.atualiza(usuario);
	}
}
