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

	/* � um usu�rio que t�m um ou mais ve�culos
	 * Pode criar um ou mais ve�culos a serem utilizados em carona.
	 * Apenas um motorista pode criar caronas.*/
}
