package entidades;

public class Motorista extends Usuario{

	public Motorista(String nome, String email, String telefone, int motorista) {
		super(nome, email, telefone, motorista);
		// TODO Auto-generated constructor stub
	}
	
	public Motorista(int idUsuario, String nome, String email, String telefone, int motorista) {
		super(nome, email, telefone, motorista);
		// TODO Auto-generated constructor stub
	}

	/* É um usuário que têm um ou mais veículos
	 * Pode criar um ou mais veículos a serem utilizados em carona.
	 * Apenas um motorista pode criar caronas.*/
}
