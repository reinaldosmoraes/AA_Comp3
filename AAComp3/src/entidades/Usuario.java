package entidades;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String email;
	private String telefone;
	private int motorista; //0 nao é, 1 é motorista
	
	//construtor
	public Usuario(String nome, String email, String telefone, int motorista){
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.motorista = motorista;
	}
	
	//construtor com id para leitura no banco
	public Usuario(int idUsuario, String nome, String email, String telefone, int motorista){
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.motorista = motorista;
	}	
	
	//construtor vazio
	public Usuario(){
	}
	
	/*Apenas o nome e o telefone do usuário podem ser alterados*/

	//get e set de idUsuario
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	//get e set de nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	//get e set de telefone
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//get e set de email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//get e set de motorista
	public int getMotorista() {
		return motorista;
	}
	public void setMotorista(int motorista) {
		this.motorista = motorista;
	}

}
