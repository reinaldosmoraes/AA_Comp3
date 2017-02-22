package entidades;

public class GrupoUsuario {

	private int idGrupoUsuario;
	private int idGrupo;
	private int idUsuario;
	
	//construtor
	public GrupoUsuario(int idGrupo, int idUsuario){
		this.idGrupo = idGrupo;
		this.idUsuario = idUsuario;
	}
	
	//get de idGrupoUsuario
	public int getIdGrupoUsuario() {
		return idGrupoUsuario;
	}

	//get e set de idGrupo
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	//get e set de idUsuario
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
