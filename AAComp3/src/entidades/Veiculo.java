package entidades;

public class Veiculo {

	private int idVeiculo;
	private String modelo;
	private String placa;
	private String cor;
	private int idMotorista;
	
	//construtor
	public Veiculo(String modelo, String placa, String cor, int idMotorista){
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.idMotorista = idMotorista;
	}
	
	//construtor com id para listar do banco
	public Veiculo(int idVeiculo, String modelo, String placa, String cor, int idMotorista){
		this.idVeiculo = idVeiculo;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.idMotorista = idMotorista;
	}

	//construtor vazio
	public Veiculo(){	
	}
	
	/*Apenas a cor pode ser alterada
	  O veículo não pode ser removido*/
	
	//get e set de idVeiculo
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	//get e set de modelo
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	//get e de placa
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	//get e set de cor
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	//get e set de motorista
	public int getIdMotorista() {
		return idMotorista;
	}
	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}

	

}
