package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;

public class LoginMD {
private Connection connection;
	
	public LoginMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	public int logar(String email){
		int i = 2;
		String consulta ="select motorista from usuario where email=?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(consulta);
				
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
               i = rs.getInt("motorista");
            }
			
			rs.close();
			stmt.close();
			return i;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		
	}
}
