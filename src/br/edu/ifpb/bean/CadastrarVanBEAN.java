package br.edu.ifpb.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.ifpb.domain.VanDados;
import br.edu.ifpb.util.JSFUtil;

@ManagedBean(name = "CadastrarVanBEAN")
public class CadastrarVanBEAN {
	
	private VanDados van_dados = new VanDados();
	private Map<String, String> destinos;
	
	@PostConstruct
	public void init() {
		destinos = new HashMap<String, String>();
		destinos.put("Campina Grande -> João Pessoa", "Campina Grande -> João Pessoa");
		destinos.put("João Pessoa -> Campina Grande", "João Pessoa -> Campina Grande");
		
		destinos.put("Soledade -> Campina Grande", "Soledade -> Campina Grande");
		destinos.put("Campina Grande -> Soledade", "Campina Grande -> Soledade");
		
		destinos.put("Queimadas -> Campina Grande", "Queimadas -> Campina Grande");
		destinos.put("Campina Grande -> Queimadas", "Campina Grande -> Queimadas");
		
		destinos.put("Natal -> Campina Grande", "Natal -> Campina Grande");
		destinos.put("Campina Grande -> Natal", "Campina Grande -> Natal");
		
		destinos.put("Recife -> Campina Grande", "Recife -> Campina Grande");
		destinos.put("Campina Grande -> Recife", "Campina Grande -> Recife");
	}
	
	public VanDados getVan_dados() {
		return van_dados;
	}

	public void setVan_dados(VanDados van_dados) {
		this.van_dados = van_dados;
	}

	public Map<String, String> getDestinos() {
		return destinos;
	}

	public void setDestinos(Map<String, String> destinos) {
		this.destinos = destinos;
	}
	
	public void save() {

		Gson gson = new Gson();

		System.out.println();

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/IFVanServico/services/cadastrar_van");
		String input = gson.toJson(van_dados);

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

		JSFUtil.messagemSucesso(van_dados.getPlaca() + " salvo com Sucesso");
	}

	public void delete() {
		
		Gson gson = new Gson();

		System.out.println();

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/IFVanServico/services/delete_van");
		String input = gson.toJson(van_dados);

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

		JSFUtil.messagemSucesso(van_dados.getPlaca() + " excluído com Sucesso");
	
	}

}
