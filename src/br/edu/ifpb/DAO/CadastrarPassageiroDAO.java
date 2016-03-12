package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
