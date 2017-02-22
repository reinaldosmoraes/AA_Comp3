package entidades;

public class Destino extends Parada{

	public Destino(int idParada, int idUsuario, int idLogradouro, int idCarona) {
		super(idUsuario, idLogradouro, idCarona);
		// TODO Auto-generated constructor stub
	}

	/*	* só podem ser alterados se não existirem passageiros na carona.
	* Estão associadas a carona como pontos de parada. */
}
