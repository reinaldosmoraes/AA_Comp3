package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Carona;
import entidades.Usuario;
public class CaronaMD {

	private Connection connection;
	
	public CaronaMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona Carona no BD
	public void adiciona(Carona carona) {

			String sql = "insert into carona " +
			"(idgrupo,idveiculo, data, hora, idlogradouroorigem, idlogradourodestino,terminou)" +
			" values (?,?,?,?,?,?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setInt(1, carona.getIdGrupo());
			stmt.setInt(2, carona.getIdVeiculo());
			stmt.setString(3, carona.getData());
			stmt.setString(4, carona.getHora());
			stmt.setInt(5, carona.getIdLogradouroOrigem());
			stmt.setInt(6, carona.getIdLogradouroDestino());
			stmt.setInt(7, 0);
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	public void marcarTerminado(int id){
		String sql = "update carona set terminou = 1 where id = ? ";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, id);
			
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public Usuario solicitarInformacoes(int id){
		Usuario usuario = new Usuario();
		String sql = "select * from usuario as u, carona as c, veiculo as v where c.id=? and c.idveiculo = v.id and v.idmotorista = u.id";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setMotorista(rs.getInt("motorista"));
			}
			rs.close();
			stmt.close();
				
			return usuario;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
			
	}
	//Listar
	public List<Carona> getLista(int id){
		try{
			List<Carona> caronas = new ArrayList<Carona>();
			String sql = "select * from carona as c, veiculo as v where c.idveiculo = v.id and v.idmotorista = ? and c.terminou = 0";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setInt(1, id);	
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				
				Carona carona = new Carona(rs.getInt("id"),rs.getInt("idgrupo"), rs.getInt("idveiculo"), rs.getString("data"), rs.getString("hora"), rs.getInt("idlogradouroorigem"), rs.getInt("idlogradourodestino"));
					
				caronas.add(carona);			
			}
			rs.close();
			stmt.close();
				
			return caronas;		
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Carona> getListaCaronaGrupo(int id){
		try{
			List<Carona> caronas = new ArrayList<Carona>();
			String sql = "select * from carona where idgrupo = ? and terminou = 0";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setInt(1, id);	
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				
				Carona carona = new Carona(rs.getInt("id"),rs.getInt("idgrupo"), rs.getInt("idveiculo"), rs.getString("data"), rs.getString("hora"), rs.getInt("idlogradouroorigem"), rs.getInt("idlogradourodestino"));
					
				caronas.add(carona);			
			}
			rs.close();
			stmt.close();
				
			return caronas;		
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//Busca o carona a partir do id
	public Carona encontra(int id){
			
		Carona carona = new Carona();
		String sql = "select * from carona where id = " + id;
			
		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				
				carona.setIdVeiculo(rs.getInt("idVeiculo"));
				carona.setData(rs.getString("data"));
				carona.setHora(rs.getString("hora"));
				carona.setIdLogradouroOrigem(rs.getInt("idLogradouroOrigem"));
				carona.setIdLogradouroDestino(rs.getInt("idLogradouroDestino"));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return carona;
	}
	
	//Atualiza no banco
	public void atualiza(Carona carona){
		if(carona == null) return;
		
		String sql = "update carona set idveiculo = ?, data = ?, hora = ?, idlogradouroorigem = ?, idlogradourodestino = ?  where id = ?";
			
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, carona.getIdVeiculo());
			stmt.setString(2, carona.getData());
			stmt.setString(3, carona.getHora());
			stmt.setInt(4, carona.getIdLogradouroOrigem());
			stmt.setInt(5, carona.getIdLogradouroDestino());
			stmt.setInt(6, carona.getIdCarona());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
