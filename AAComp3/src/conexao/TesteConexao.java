package conexao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TesteConexao {
public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			Connection connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
