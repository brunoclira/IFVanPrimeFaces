package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.edu.ifpb.domain.Usuario;

public class UsuarioDAO {

	public void cadastrarUsuario(Usuario ususuario) throws ClassNotFoundException {

		String sql = "INSERT INTO usuarios values(?,?,?,?);";

		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			preparador.setString(1, ususuario.getNome());
			preparador.setString(2, ususuario.getUsername());
			preparador.setString(3, ususuario.getEmail());
			preparador.setString(4, ususuario.getSenha());

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean validarUsuario(Usuario usuario) throws ClassNotFoundException {

		String sql = "select* from usuarios WHERE usuario ='" + usuario.getUsername() + "'and senha='"
				+ usuario.getSenha() + "';";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);
			preparador.execute();
			preparador.close();

			while (rs.next()) {
				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
}
