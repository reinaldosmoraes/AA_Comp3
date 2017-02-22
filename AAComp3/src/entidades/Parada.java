package entidades;

public class Parada {

	private int idParada;
	private int idUsuario;
	private int idLogradouro;
	private int idCarona;
	
	//construtor
	public Parada(int idUsuario, int idLogradouro, int idCarona){
		this.idUsuario = idUsuario;
		this.idLogradouro = idLogradouro;
		this.idCarona = idCarona;
	}
	
	//construtor com id para leitura no banco
	public Parada(int idParada, int idUsuario, int idLogradouro, int idCarona){
		this.idParada = idParada;
		this.idUsuario = idUsuario;
		this.idLogradouro = idLogradouro;
		this.idCarona = idCarona;
	}
	
	//get de idParada
	public int getIdParada() {
		return idParada;
	}

	//get de idUsuario
	public int getIdUsuario() {
		return idUsuario;
	}

	//get de idLogradouro
	public int getIdLogradouro() {
		return idLogradouro;
	}

	//get de idCarona
	public int getIdCarona() {
		return idCarona;
	}
	
}
