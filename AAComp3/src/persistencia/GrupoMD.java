package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Grupo;
import entidades.GrupoUsuario;
import entidades.Usuario;

public class GrupoMD {

	private Connection connection;
	private int aux;
	
	public GrupoMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	public int getLastId(){
		int i = 0;
		String sql = "select id from grupo order by id desc limit 1";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				i=rs.getInt("id");
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		return i;
	}
	//Adiciona Grupo na tabela grupo e usuario criador do grupo na tabela grupousuario, colocando o criador como membro do grupo
	public void adiciona(Grupo grupo) throws ClassNotFoundException {

		String sql = "insert into grupo " +
			"(nome, descricao, regras, limite, idusuariocriador)" +
			" values (?,?,?,?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setString(1, grupo.getNome());
			stmt.setString(2, grupo.getDescricao());	
			stmt.setString(3, grupo.getRegras());
			stmt.setInt(4, grupo.getLimite());
			stmt.setInt(5, grupo.getIdUsuarioCriador());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	
		//Inserindo na tabela grupousuario
		//achando ultimo id da tabela grupo, que foi o inserido no momento
		List<Grupo> grupos = new ArrayList<Grupo>();
		GrupoMD dao;
		dao = new GrupoMD();
		int i = dao.getLastId();
		for(Grupo grupo1 : grupos){			
			setAux(grupo1.getIdGrupo());
		}
		
		GrupoUsuario grupoUsuario = new GrupoUsuario(i, grupo.getIdUsuarioCriador());
		
		String sql2 = "insert into grupousuario " +
				"(idgrupo, idusuario,regraaceita)" +
				" values (?,?,0)";
		
		PreparedStatement stmt2;
	
		try {
			stmt2 = (PreparedStatement) connection.prepareStatement(sql2);
			// seta os valores
			stmt2.setInt(1,grupoUsuario.getIdGrupo());
			stmt2.setInt(2, grupoUsuario.getIdUsuario());
			// executa
			stmt2.execute();
			stmt2.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	//Listar
	public List<Grupo> getLista(String email){
		try{
			List<Grupo> grupos = new ArrayList<Grupo>();
			String sql = "select * from grupo as g, grupousuario as gu, usuario as u where u.email = ? and u.id=gu.idUsuario and gu.idGrupo=g.id";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, email);	
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Grupo grupo = new Grupo(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), 
						rs.getString("regras"), rs.getInt("limite"), rs.getInt("idusuariocriador"));
					
				grupos.add(grupo);			
			}
			rs.close();
			stmt.close();
				
			return grupos;		
		
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	
	//lista de usuarios membros do grupo
	public List<Usuario> getListaUsuarios(int id){
	try{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "select * from grupousuario as gu, usuario as u where gu.idgrupo = " + id + " and u.id = gu.idusuario";
		PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Usuario usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"), rs.getInt("motorista"));
				
			usuarios.add(usuario);			
		}
		rs.close();
		stmt.close();
				
		return usuarios;		
		
	}catch (SQLException e){
		throw new RuntimeException(e);
		}
	}
	
	//Busca o grupo a partir do id
	public Grupo encontra(int id){
		
		Grupo grupo = new Grupo();

		String sql = "select * from grupo where id = " + id;
		
		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				grupo.setNome(rs.getString("nome"));
				grupo.setDescricao(rs.getString("descricao"));
				grupo.setRegras(rs.getString("regras"));
				grupo.setLimite(rs.getInt("limite"));
				grupo.setIdUsuarioCriador(rs.getInt("idusuariocriador"));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return grupo;
	}
	
	//Atualiza no banco
	public void atualiza(Grupo grupo){
		if(grupo == null) return;
		
		String sql = "update grupo set nome = ?, descricao = ?, limite = ? where id = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, grupo.getNome());
			stmt.setString(2, grupo.getDescricao());
			stmt.setInt(3, grupo.getLimite());	
			stmt.setInt(4, grupo.getIdGrupo());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	//Insere um usuário no grupo
	public void inserirUsuario(int idGrupo, int idUsuario){
		String sql = "insert into grupousuario (idGrupo,idUsuario) values (?,?)";
		//prepared statement para inserção
				PreparedStatement stmt;
				try {
					stmt = (PreparedStatement) connection.prepareStatement(sql);
					// seta os valores
					stmt.setInt(1, idGrupo);
					stmt.setInt(2, idUsuario);
					// executa
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
	}
	
	public int getAux() {
		return aux;
	}
	public void setAux(int aux) {
		this.aux = aux;
	}
}
