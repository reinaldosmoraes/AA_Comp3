package entidades;

public class Logradouro {

	private int idLogradouro;
	private String cep;
	private String estado;
	private String cidade;
	private String distrito;
	private String endereco;

	private int numero;

	
	/* Para se criar um logradouro um usuário deve informar o CEP
	 
	* O sistema deverá encontrar o endereço usando a api https://viacep.com.br/ e armazenar o cep, o
	estado, a cidade, o distrito e o endereço. Contudo, antes do sistema armazenar, o usuário deverá
	informar o número.
	
	* Após criado, um logradouro não pode ser alterado ou removido.*/
	
	//construtor vazio
	public Logradouro(){
		
	}
	
	//construtor
	public Logradouro(String cep, String estado, String cidade, String distrito, String endereco, int numero){
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.numero = numero;
	}
	
	//construtor com id para leitura no banco
		public Logradouro(int idLogradouro, String cep, String estado, String cidade, String distrito, String endereco, int numero){
			this.idLogradouro = idLogradouro;
			this.cep = cep;
			this.estado = estado;
			this.cidade = cidade;
			this.distrito = distrito;
			this.endereco = endereco;
			this.numero = numero;
	}
		
	//get e set de idLogradouro
	public int getIdLogradouro() {
		return idLogradouro;
	}
	public void setIdLogradouro(int idLogradouro) {
		this.idLogradouro = idLogradouro;
	}
	
	//get e set de cep
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	//get e set de estado
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	//get e set de cidade
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	//get e set de distrito
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	//get e set de endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	//get e set de numero
	public int getNumero() {
		return numero;
	}	
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
