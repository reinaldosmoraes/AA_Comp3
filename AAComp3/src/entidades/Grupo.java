package entidades;

public class Grupo {
	
	private int idGrupo;
	private String nome;
	private String descricao;
	private String regras;
	private int limite;
	private int idUsuarioCriador;
	
	//construtor
	public Grupo(String nome, String descricao, String regras, int limite, int idUsuarioCriador){
		this.nome = nome;
		this.descricao = descricao;
		this.regras = regras;
		this.limite = limite;
		this.idUsuarioCriador = idUsuarioCriador;
	}
	
	//construtor com id para leitura do banco
		public Grupo(int idGrupo, String nome, String descricao, String regras, int limite, int idUsuarioCriador){
			this.idGrupo = idGrupo;
			this.nome = nome;
			this.descricao = descricao;
			this.regras = regras;
			this.limite = limite;
			this.idUsuarioCriador = idUsuarioCriador;
	}
	
	//construtor vazio
	public Grupo(){
	}
		
	/*apenas o nome, a descrição e o limite mínimo podem ser alterados em um grupo*/
	
	//get e set de idGrupo
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	//get e set de nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	//get e set de descricao
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//get e set de limite
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	//get e set de regras
	public String getRegras() {
		return regras;
	}
	public void setRegras(String regras) {
		this.regras = regras;
	}

	//get e set de idUsuarioCriador
	public int getIdUsuarioCriador() {
		return idUsuarioCriador;
	}
	public void setIdUsuarioCriador(int idUsuarioCriador) {
		this.idUsuarioCriador = idUsuarioCriador;
	}

}
