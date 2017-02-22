package roteiroTransacao;

import java.io.IOException;

import persistencia.VeiculoMD;
import entidades.Veiculo;

public class AlterarVeiculoRT {
	
	private Veiculo veiculo;
	
	public AlterarVeiculoRT(Veiculo veiculo){	
		this.veiculo = veiculo;		
	}

	public void execute() throws IOException{
		
		//validação
		
		
		VeiculoMD veiculoMD = null;
		
		try {
			veiculoMD = new VeiculoMD();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		veiculoMD.atualiza(veiculo);
	}
}
