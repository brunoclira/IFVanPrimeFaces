
package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpb.domain.Van;

public class ComprarPassagemDAO {
	
public void salvar(Van v) throws ClassNotFoundException, SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE van SET cpf_id='" + v.getCpf() + "',estado='busy',tipo_passagem='" + v.getTipo() + "'"
				+ ",valor='" + v.getValor() + "'WHERE cadeira=" + v.getCadeira() + ";");
		
		ConnectionFactory.openConnection();
		Connection con = ConnectionFactory.getConnection();
		
		PreparedStatement preparador = con.prepareStatement(sql.toString());
		
		preparador.executeUpdate();
	}
}