package roteiroTransacao;

import persistencia.VeiculoMD;
import entidades.Veiculo;

public class BuscarVeiculoRT {

	private int id;
	
	public BuscarVeiculoRT(int id){
		this.id = id;		
	}
	
	public Veiculo execute(){
		
		//validação
		
		
		//intancia o MD
		VeiculoMD veiculoMD = null;
		try {
			veiculoMD = new VeiculoMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Veiculo veiculo = veiculoMD.encontra(id);
	
		return veiculo;
	}
}
