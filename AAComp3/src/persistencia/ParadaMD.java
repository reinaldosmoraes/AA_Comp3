package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Parada;

public class ParadaMD {

	private Connection connection;
	
	public ParadaMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona Parada no BD
	public void adiciona(Parada parada) {

			String sql = "insert into parada " +
			"(idusuario, idlogradouro, idcarona)" +
			" values (?,?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setInt(1, parada.getIdUsuario());
			stmt.setInt(2, parada.getIdLogradouro());
			stmt.setInt(3, parada.getIdCarona());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	
	//Listar
	public List<Parada> getLista(int id){
		try{
			List<Parada> paradas = new ArrayList<Parada>();
			String sql = "select * from parada where idusuario=?";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Parada parada = new Parada(rs.getInt("id"), rs.getInt("idusuario"), rs.getInt("idlogradouro"), rs.getInt("idcarona"));
					
				paradas.add(parada);			
			}
			rs.close();
			stmt.close();
				
			return paradas;		
		
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//Remove Parada do BD
		public void remove(int idParada){
			
			String sql = "delete from parada where id = ?"; 
			
			PreparedStatement stmt;
			
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				// seta os valores
				stmt.setInt(1, idParada);
							
				// executa
				stmt.execute();
				stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		
		public void usuarioParada(int usuario, int parada){
			String sql = "insert into paradausuario " +
					"(idusuario, idparada)" +
					" values (?,?)";

				//prepared statement para inserção
				PreparedStatement stmt;
				try {
					stmt = (PreparedStatement) connection.prepareStatement(sql);
						
					stmt.setInt(1, usuario);
					stmt.setInt(2, parada);
						
					// executa
					stmt.execute();
					stmt.close();
				} catch (SQLException e) {

					throw new RuntimeException(e);
				}
		}
	
}
