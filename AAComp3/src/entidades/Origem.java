package entidades;

public class Origem extends Parada{

	public Origem(int idParada, int idUsuario, int idLogradouro, int idCarona) {
		super(idUsuario, idLogradouro, idCarona);
		// TODO Auto-generated constructor stub
	}
	
	/*	* s� podem ser alterados se n�o existirem passageiros na carona.
		* Est�o associadas a carona como pontos de parada. */
}
