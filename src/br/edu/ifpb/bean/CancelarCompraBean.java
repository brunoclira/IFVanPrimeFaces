package br.edu.ifpb.bean;


import javax.faces.bean.ManagedBean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.domain.Van;
import br.edu.ifpb.util.JSFUtil;
@ManagedBean
public class CancelarCompraBean {
		private List<Van> lugares;
		private Van van;
		private String cpfRemover;

		public String getCpfRemover() {
			return cpfRemover;
		}

		public void setCpfRemover(String cpfRemover) {
			this.cpfRemover = cpfRemover;
		}
		
		public List<Van> getLugares() {
	
			Van van = new Van();
			Client cliente = new Client();

			WebResource wr = cliente.resource("http://localhost:8080/IFVanServico/services/cadeira/listar/");
			String json = wr.get(String.class);
			Gson gson = new Gson();

			return gson.fromJson(json, new TypeToken<List<Van>>() {
			}.getType());
		}

		public void setLugares(List<Van> lugares) {
			this.lugares = lugares;
		}
		public CancelarCompraBean(){
			this.van=new Van();
		}

		public Van getVan() {
			return van;
		}

		public void setVan(Van van) {
			this.van = van;
		}

public void cancelar(){
	
	Gson gson = new Gson();
	System.out.println();

	Client client = Client.create();

	WebResource webResource = client.resource("http://localhost:8080/IFVanServico/services/cancelar");
	
	String input = cpfRemover;

	ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
	
	JSFUtil.messagemSucesso(van.getCpf() + " cancelado com Sucesso");
	
}



}


