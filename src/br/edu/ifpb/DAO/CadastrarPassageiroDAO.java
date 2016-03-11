package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.DAO.ConnectionFactory;

public class CadastrarPassageiroDAO {
	
	public void salvar() throws ClassNotFoundException, SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO cliente ");
		sql.append("(nome,sobrenome,cpf,sexo,telefone,cidade,estado)");
		sql.append("VALUES(?,?,?,?,?,?,?)");
		
		ConnectionFactory.openConnection();
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement preparador = con.prepareStatement(sql.toString());
		
	}

}
