package roteiroTransacao;

import persistencia.CaronaMD;
import entidades.Carona;

public class BuscarCaronaRT {

	private int id;
	
	public BuscarCaronaRT(int id){
		this.id = id;
	}
	
	public Carona execute(){
		
		//validação
		
		
		CaronaMD caronaMD = null;
		try {
			caronaMD = new CaronaMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Carona carona = caronaMD.encontra(id);
		
		return carona;
	}
}
