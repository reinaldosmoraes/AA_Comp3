package entidades;

public class Carona {

	private int idCarona;
	private int idGrupo;
	private int idVeiculo;
	private String data;
	private String hora;
	private int idLogradouroOrigem;
	private int idLogradouroDestino;
	
	//construtor vazio
	public Carona(){
		
	}
	
	//contrutor
	public Carona(int idGrupo, int idVeiculo, String data, String hora, int idLogradouroOrigem, int idLogradouroDestino){
		this.idGrupo = idGrupo;
		this.idVeiculo = idVeiculo;
		this.data = data;
		this.hora = hora;
		this.idLogradouroOrigem = idLogradouroOrigem;
		this.idLogradouroDestino = idLogradouroDestino;		
	}
	
	//contrutor com id para leitura no banco
	public Carona(int idCarona, int idGrupo, int idVeiculo, String data, String hora, int idLogradouroOrigem, int idLogradouroDestino){
		this.idCarona = idCarona;
		this.idGrupo = idGrupo;
		this.idVeiculo = idVeiculo;
		this.data = data;
		this.hora = hora;
		this.idLogradouroOrigem = idLogradouroOrigem;
		this.idLogradouroDestino = idLogradouroDestino;		
	}
		
	//get e set de idCarona
	public int getIdCarona() {
		return idCarona;
	}
	public void setIdCarona(int idCarona) {
		this.idCarona = idCarona;
	}

	/*O usuário pode alterar o veículo de uma carona, desde que não reduza o número de vagas disponíveis*/
	//get e set de veiculo
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	//get e set de data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	//get e set de logradouroOrigem
	public int getIdLogradouroOrigem() {
		return idLogradouroOrigem;
	}
	
	//get e set de logradouroDestino
	public int getIdLogradouroDestino() {
		return idLogradouroDestino;
	}
	
	//get e set de idLogradouroOrigem
	public void setIdLogradouroOrigem(int idLogradouroOrigem) {
		this.idLogradouroOrigem = idLogradouroOrigem;
	}
	public void setIdLogradouroDestino(int idLogradouroDestino) {
		this.idLogradouroDestino = idLogradouroDestino;
	}

	//get e set de hora
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	
}
