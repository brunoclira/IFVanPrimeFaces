package br.edu.ifpb.bean;

import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.DAO.CadastrarPassageiroDAO;
import br.edu.ifpb.domain.Passageiro;

//@SessionScoped
@ManagedBean

public class UsuariosBean {
	private List<Passageiro> listaPassageiros;
	
	public List<Passageiro> getListaPassageiros() {
		Passageiro passageiro = new Passageiro();
		CadastrarPassageiroDAO passageiroDao = new CadastrarPassageiroDAO();
		// ArrayList<Usuario> usulist=new ArrayList<>();

		try {
			listaPassageiros = (ArrayList<Passageiro>) passageiroDao.getUsuarios();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaPassageiros;
	}

	public void setListaPassageiros(List<Passageiro> listaPassageiros) {
		this.listaPassageiros = listaPassageiros;
	}

	private Passageiro passageiros;

	public Passageiro getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Passageiro passageiros) {
		this.passageiros = passageiros;
	}
	
	public UsuariosBean(){
		this.passageiros=new Passageiro();
	}
	
	
	
	
	

}
