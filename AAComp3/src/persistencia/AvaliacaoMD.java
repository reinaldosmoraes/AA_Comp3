package persistencia;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Avaliacao;

public class AvaliacaoMD {
	
	private Connection connection;
	
	public AvaliacaoMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona Avaliacao no BD
	public void adiciona(Avaliacao avaliacao) {

			String sql = "insert into avaliacao " +
			"(idUsuario, estrelas)" +
			" values (?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setInt(1, avaliacao.getIdUsuario());
			stmt.setInt(2, avaliacao.getEstrelas());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	

}
