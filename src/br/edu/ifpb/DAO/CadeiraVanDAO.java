package br.edu.ifpb.DAO;

/**
 * author by: Leonardo Silva de Souza;
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpb.domain.Van;

public class CadeiraVanDAO {
	public void comprar_lugar(Van van) {
		// monta sql
		// String sql = "INSERT INTO van(cadeira,cpf_id,estado)VALUES(?,?,?)";
		String sql = "UPDATE van SET cpf_id='" + van.getCpf()
				+ "',estado='busy',tipo_passagem='" + van.getTipo() + "'"
				+ ",valor='" + van.getValor() + "'WHERE cadeira="
				+ van.getCadeira() + ";";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			// con= Conexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);
			// preparador.setString(1, van.getCpf());
			// preparador.setInt(2, van.getCadeira());
			// preparador.setString(3, van.getTipo());

			preparador.execute();

			preparador.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancelarPassagem(String cpf) throws ClassNotFoundException {

		String sql = "UPDATE van SET cpf_id='',estado='free',tipo_passagem=' ',valor=' ' WHERE cpf_id='"
				+ cpf + "';";
		// System.out.println(sql);
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.executeUpdate(sql);

		} catch (SQLException e) {

		}

	}

	public boolean lugar_na_van(int lugar) throws ClassNotFoundException {
		String sql = "SELECT V.estado FROM van V WHERE V.cadeira=" + lugar
				+ ";";
		String teste = null;
		String livre = "free";
		String ocupado = "busy";
		boolean valor_teste = false;
		try {
			// /System.out.println(sql);
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			// con= Conexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				teste = rs.getString("estado");

			}
			// System.out.println(teste);
		} catch (SQLException e) {
			System.out.println(e);
		}

		// System.out.println("TESTE " + teste);

		if (teste.equals(livre)) {
			valor_teste = true;
			// / System.out.println("t1");
		}
		if (teste.equals(ocupado)) {
			// / System.out.println("t2");
			valor_teste = false;
		}

		return valor_teste;

	}

	public int quantidade_do_tipo_da_passagem(String tipo)
			throws ClassNotFoundException {
		System.out.println(tipo);
		String sql = "SELECT COUNT(*) FROM van WHERE tipo_passagem='" + tipo
				+ "';";
		int vagas = 0;
		try {
			System.out.println(sql);
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			// con= Conexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				vagas = rs.getInt("COUNT(*)");

			}
			// System.out.println(teste);
		} catch (SQLException e) {
			System.out.println(e);
		}

		// System.out.println("TESTE " + teste);

		return vagas;

	}

	public int calcular_total_tipos_passagens(String valor)
			throws ClassNotFoundException {
		// System.out.println(lugar);
		String sql = "SELECT COUNT(*) FROM van WHERE valor='" + valor + "';";
		int total = 0;
		try {
			// System.out.println(sql);
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			// con= Conexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt("COUNT(*)");

			}
			// System.out.println(teste);
		} catch (SQLException e) {
			System.out.println(e);
		}

		// System.out.println("TESTE " + teste);

		return total;

	}

	public int cpf_valido(String cpf) throws ClassNotFoundException {
		String sql = "SELECT count(*)  FROM cliente C WHERE C.cpf='" + cpf
				+ "';";
		// System.out.println(sql);
		int quant = 0;
		try {
			// /System.out.println(sql);
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			// con= Conexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				quant = rs.getInt("COUNT(*)");

			}
			// System.out.println(quant);
		} catch (SQLException e) {
			System.out.println(e);
		}

		// System.out.println("TESTE " + teste);
		/*
		 * if (teste.equals(livre)) { valor_teste = true; ///
		 * System.out.println("t1"); } if (teste.equals(ocupado)) { ///
		 * System.out.println("t2"); valor_teste = false; }
		 */
		return quant;

	}

}