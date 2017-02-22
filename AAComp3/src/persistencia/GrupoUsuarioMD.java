package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.GrupoUsuario;

public class GrupoUsuarioMD {
	
	private Connection connection;

	public GrupoUsuarioMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona GrupoUsuario no banco
	public void adiciona(GrupoUsuario grupoUsuario) {
		
		String sql = "insert into grupousuario " +
				"(idgrupo, idusuario)" +
				" values (?,?)";
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,grupoUsuario.getIdGrupo());
			stmt.setInt(2,grupoUsuario.getIdUsuario());
			
			// executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int regrasAceitas(int usuario, int grupo){
		String sql = "select regraaceita from grupousuario where idusuario = ? and idgrupo = ?";
		PreparedStatement stmt;
		int i=0;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,usuario);
			stmt.setInt(2,grupo);
	ResultSet rs = stmt.executeQuery();
			
			if(rs != null && rs.next()){
               i = rs.getInt("regraaceita");
            }
			
			rs.close();
			stmt.close();
			return i;
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		
	}
	public void aceitar(int usuario, int grupo){
		
		String sql = "update grupousuario set regraaceita = 1 where idusuario = ? and idgrupo = ?";
			
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, usuario);
			stmt.setInt(2, grupo);
			
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}
