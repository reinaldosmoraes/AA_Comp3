package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexao.Conexao;
import entidades.Veiculo;

public class VeiculoMD {

	private Connection connection;
	
	public VeiculoMD() throws ClassNotFoundException {
		connection = (Connection) new Conexao().getConnection();
	}
	
	//Adiciona Veiculo no BD
	public void adiciona(Veiculo veiculo) {
		
		
		//Checar se o usuario ja é um motorista
		String sql2 = "update usuario set motorista = 1 where id = ?";
		
		PreparedStatement stmt2;
	
		try {
			stmt2 = (PreparedStatement) connection.prepareStatement(sql2);
			// seta os valores
			stmt2.setInt(1, veiculo.getIdMotorista());
			// executa
			stmt2.execute();
			stmt2.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		//Inserção do veiculo
		String sql = "insert into veiculo " +
		"(modelo, placa, cor, idmotorista)" +
		" values (?,?,?,?)";

		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setString(1, veiculo.getModelo());
			stmt.setString(2, veiculo.getPlaca());
			stmt.setString(3, veiculo.getCor());
			stmt.setInt(4, veiculo.getIdMotorista());
				
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}
	
	
	//Listar
	public List<Veiculo> getLista(String email){
		try{
			List<Veiculo> veiculos = new ArrayList<Veiculo>();
			String sql = "select * from veiculo v, usuario u where u.email = ? and v.idmotorista = u.id";
			PreparedStatement stmt =  (PreparedStatement) connection.prepareStatement(sql);
				
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Veiculo veiculo = new Veiculo(rs.getInt("id"), rs.getString("modelo"), rs.getString("placa"), 
						rs.getString("cor"), rs.getInt("idMotorista"));
				
				veiculos.add(veiculo);			
			}
			rs.close();
			stmt.close();
				
			return veiculos;		
			
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//Busca o veiculo a partir do id
	public Veiculo encontra(int id){
			
		Veiculo veiculo = new Veiculo();

		String sql = "select * from veiculo where id = " + id;
			
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
					
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setIdMotorista(rs.getInt("idmotorista"));
			}
				
			rs.close();
			stmt.close();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return veiculo;
	}
			
	//Atualiza no banco
	public void atualiza(Veiculo veiculo){
		if(veiculo == null) return;
		
		String sql = "update veiculo set cor = ? where id = ?";
			
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, veiculo.getCor());
			stmt.setInt(2, veiculo.getIdVeiculo());
					
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
