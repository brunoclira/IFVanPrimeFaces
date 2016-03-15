package br.edu.ifpb.DAO;

/**
 * author by: Leonardo Silva de Souza;
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.convert.IntegerConverter;

import br.edu.ifpb.domain.Passageiro;
import br.edu.ifpb.domain.Van;

public class CadeiraVanDAO {
	public void comprar_lugar(Van van) {
		String sql = "UPDATE van SET cpf_id='" + van.getCpf()
				+ "',estado='busy',tipo_passagem='" + van.getTipo() + "'"
				+ ",valor='" + van.getValor() + "'WHERE cadeira="
				+ van.getCadeira() + ";";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.execute();

			preparador.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void cancelarPassagem(String cpf) throws ClassNotFoundException {

		String sql = "UPDATE van SET cpf_id='',estado='free',tipo_passagem=' ',valor=' ' WHERE cpf_id='"
				+ cpf + "';";
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
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				teste = rs.getString("estado");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		if (teste.equals(livre)) {
			valor_teste = true;
		}
		if (teste.equals(ocupado)) {
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
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				vagas = rs.getInt("COUNT(*)");
		}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return vagas;

	}

	public int calcular_total_tipos_passagens(String valor)
			throws ClassNotFoundException {
		String sql = "SELECT COUNT(*) FROM van WHERE valor='" + valor + "';";
		int total = 0;
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt("COUNT(*)");

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return total;

	}

	public int cpf_valido(String cpf) throws ClassNotFoundException {
		String sql = "SELECT count(*)  FROM cliente C WHERE C.cpf='" + cpf
				+ "';";
		int quant = 0;
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet rs = preparador.executeQuery(sql);
			while (rs.next()) {
				quant = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return quant;

	}
	
	public List<Van> getLugares() throws ClassNotFoundException {

		List<Van> listaLugar = new ArrayList<Van>();

		String sql = "select* from van;";
		try {
			ConnectionFactory.openConnection();
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = preparador.executeQuery(sql);
			preparador.execute();
			preparador.close();

			while (rs.next()) {
				Van van = new Van();
				van.setCadeira(Integer.parseInt(rs.getString("cadeira")));
				van.setCpf(rs.getString("cpf_id"));
				van.setTipo(rs.getString("tipo_passagem"));
				van.setValor(rs.getString("valor"));
				van.setEstado(rs.getString("estado"));
				
				listaLugar.add(van);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaLugar;

	}

}