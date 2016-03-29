package br.edu.ifpb.bean;

import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.Passageiro;

//@SessionScoped
@ManagedBean

public class UsuariosBean {
private List<Passageiro> listaPassageiros;
	
	public List<Passageiro> getListaPassageiros() {
		Passageiro passageiro = new Passageiro();
		Client cliente=new Client();
		
		WebResource wr=cliente.resource("http://localhost:8080/IFVanServico/services/usuario/listar/");
		String json=wr.get(String.class);
		Gson gson=new Gson();
		
		return gson.fromJson(json, new TypeToken<List<Passageiro>>(){}.getType());
		
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
