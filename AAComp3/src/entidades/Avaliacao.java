package entidades;

public class Avaliacao {
	
	private int idAvaliacao;
	private int estrelas;
	private int idUsuario;
	
	//construtor
	public Avaliacao(int estrelas, int idUsuario){
		this.estrelas = estrelas;
		this.idUsuario = idUsuario;
	}

	//get de idAvaliacao
	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	//get e set de estrelas
	public int getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}
	
	//get de idUsuario
	public int getIdUsuario() {
		return idUsuario;
	}
		
}
