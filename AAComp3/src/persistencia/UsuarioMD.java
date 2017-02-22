package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Usuario;

public class UsuarioMD {

	private Connection connection;
	
	public UsuarioMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona Usuario no BD
	public void adiciona(Usuario usuario) {

			String sql = "insert into usuario " +
			"(nome, email, telefone, motorista)" +
			" values (?,?,?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());	
			stmt.setString(3, usuario.getTelefone());
			stmt.setInt(4, usuario.getMotorista());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	
	
	//Listar
	public List<Usuario> getLista(){
		try{
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("telefone"), rs.getInt("motorista"));
				
				usuarios.add(usuario);			
			}
			rs.close();
			stmt.close();
			
			return usuarios;		
		
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//Busca o usuario a partir do id
	public Usuario encontra(int id){
			
		Usuario usuario = new Usuario();

		String sql = "select * from usuario where id = " + id;
			
		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setMotorista(rs.getInt("motorista"));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return usuario;
	}
	

	//Busca o usuario a partir do email
		public int encontraUsuario(String email){
			int i = 0;
			String sql = "select id from usuario where email =? ";
				
			// prepared statement para inserção
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, email);
				// executa
				ResultSet rs = stmt.executeQuery();
				// armazena
				while (rs.next()) {
					i = rs.getInt("id");
				
				}
				
				rs.close();
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			return i;
			
		}
		
	//Atualiza no banco
	public void atualiza(Usuario usuario){
		if(usuario == null) return;
		
		String sql = "update usuario set nome = ?, telefone = ? where id = ?";
			
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getTelefone());
			stmt.setInt(3, usuario.getIdUsuario());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
		
}
