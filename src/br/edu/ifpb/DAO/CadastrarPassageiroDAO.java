package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.edu.ifpb.DAO.ConnectionFactory;
import br.edu.ifpb.domain.Passageiro;

public class CadastrarPassageiroDAO {
	
	public void salvar(Passageiro p) throws ClassNotFoundException, SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO cliente ");
		sql.append("(nome,sobrenome,cpf,sexo,telefone,cidade,estado)");
		sql.append("VALUES(?,?,?,?,?,?,?)");
		
		ConnectionFactory.openConnection();
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement preparador = con.prepareStatement(sql.toString());
		preparador.setString(1, p.getNome());
		preparador.setString(2, p.getSobrenome());
		preparador.setString(3, p.getCpf());
		preparador.setString(4, p.getSexo());
		preparador.setString(5, p.getTelefone());
		preparador.setString(6, p.getCidade());
		preparador.setString(7, p.getEstado());
		
		preparador.executeUpdate();
	}
	
	public List<Passageiro> getUsuarios() throws ClassNotFoundException {

		List<Passageiro> listaUsu = new ArrayList<Passageiro>();

		String sql = "select* from usuario;";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);
			preparador.execute();
			preparador.close();

			while (rs.next()) {
				Passageiro passageiro = new Passageiro();
				passageiro.setSobrenome(rs.getString("nome"));
				passageiro.setCidade(rs.getString("data_nascimento"));
				passageiro.setCpf(rs.getString("matricula"));

				
				listaUsu.add(passageiro);

				// System.out.println(rs.getString("titulo"));
				// rs.close();
				// preparador.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaUsu;

	}

}
