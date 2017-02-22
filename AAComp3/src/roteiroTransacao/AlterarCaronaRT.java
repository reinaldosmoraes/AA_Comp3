package roteiroTransacao;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import persistencia.CaronaMD;
import entidades.Carona;

public class AlterarCaronaRT {
	
	private Carona carona;
	
	public AlterarCaronaRT(Carona carona){
		this.carona = carona;
	}

	public void execute(){
		
		//validação
		
		
		CaronaMD caronaMD = null;
		
		try {
			caronaMD = new CaronaMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		caronaMD.atualiza(carona);
	}
	public void tratarPost(Carona carona, HttpServletResponse response) throws IOException{
		
		
		
		
	}

}
