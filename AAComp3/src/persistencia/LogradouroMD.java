package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Logradouro;

public class LogradouroMD {

	private Connection connection;
	
	public LogradouroMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona Logradouro no BD
	public void adiciona(Logradouro logradouro) {

			String sql = "insert into logradouro " +
			"(cep, estado, cidade, distrito, endereco, numero)" +
			" values (?,?,?,?,?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setString(1, logradouro.getCep());
			stmt.setString(2, logradouro.getEstado());
			stmt.setString(3, logradouro.getCidade());
			stmt.setString(4, logradouro.getDistrito());
			stmt.setString(5, logradouro.getEndereco());
			stmt.setInt(6, logradouro.getNumero());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	
	
	//Listar
	public List<Logradouro> getLista(){
		try{
			List<Logradouro> logradouros = new ArrayList<Logradouro>();
			String sql = "select * from logradouro";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Logradouro logradouro = new Logradouro(rs.getInt("id"), rs.getString("cep"), rs.getString("estado"), 
						rs.getString("cidade"), rs.getString("distrito"), rs.getString("endereco"), rs.getInt("numero"));
					
				logradouros.add(logradouro);			
			}
			rs.close();
			stmt.close();
			
			return logradouros;		
		
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//buscar logradouro por id
	public Logradouro encontra(int id){
		
		Logradouro logradouro = new Logradouro();

		String sql = "select * from logradouro where id = " + id;
			
		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				
				logradouro.setCep(rs.getString("cep"));
				logradouro.setEstado(rs.getString("estado"));
				logradouro.setCidade(rs.getString("cidade"));
				logradouro.setDistrito(rs.getString("distrito"));
				logradouro.setEndereco(rs.getString("endereco"));
				logradouro.setNumero(rs.getInt("numero"));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return logradouro;
	}
	
}
