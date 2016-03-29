package br.edu.ifpb.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.ifpb.domain.Passageiro;
import br.edu.ifpb.util.JSFUtil;
 
 
@ManagedBean(name = "CadastrarPassageiroBEAN")
public class CadastrarPassageiroBEAN {
     
	private Passageiro passageiro = new Passageiro();

	private Map<String,String> sexos,estados;

    @PostConstruct
    public void init() {
        sexos  = new HashMap<String, String>();
        sexos.put("Feminino", "Feminino");
        sexos.put("Masculino", "Masculino");
        
        estados = new HashMap<String, String>();
        estados.put("Acre - AC", "Acre - AC");
        estados.put("Alagoas - AL", "Alagoas - AL");
        estados.put("Amap� - AP", "Amap� - AP");
        estados.put("Amazonas - AM", "Amazonas - AM");
        estados.put("Bahia - BA", "Bahia - BA");
        estados.put("Cear� - CE", "Cear� - CE");
        estados.put("Distrito Federal - DF", "Distrito Federal - DF");
        estados.put("Esp�rito Santo - ES", "Esp�rito Santo - ES");
        estados.put("Goi�s - GO", "Goi�s - GO");
        estados.put("Maranh�o - MA", "Maranh�o - MA");
        estados.put("Mato Grosso - MT", "Mato Grosso - MT");
        estados.put("Mato Grosso do Sul - MS", "Mato Grosso do Sul - MS");
        estados.put("Minas Gerais - MG", "Minas Gerais - MG");
        estados.put("Par� - PA", "Par� - PA");
        estados.put("Para�ba - PB", "Para�ba - PB");
        estados.put("Paran� - PR", "Paran� - PR");
        estados.put("Pernambuco - PE", "Pernambuco - PE");
        estados.put("Piau� - PI", "Piau� - PI");
        estados.put("Rio de Janeiro - RJ", "Rio de Janeiro - RJ");
        estados.put("Rio Grande do Norte - RN", "Rio Grande do Norte - RN");
        estados.put("Rio Grande do Sul - RS", "Rio Grande do Sul - RS");
        estados.put("Rond�nia - RO", "Rond�nia - RO");
        estados.put("Roraima - RR", "Roraima - RR");
        estados.put("Santa Catarina - SC", "Santa Catarina - SC");
        estados.put("S�o Paulo - SP", "S�o Paulo - SP");
        estados.put("Sergipe - SE", "Sergipe - SE");
        estados.put("Tocantins - TO", "Tocantins - TO");
    }

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
    
    public Map<String, String> getSexos() {
        return sexos;
    }
    
    public Map<String, String> getEstados() {
        return estados;
    }
 
    public void save() {
  
		Gson gson=new Gson();
		System.out.println();

		
		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/IFVanServico/services/cadastrar");
		String input =gson.toJson(passageiro);

		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);
		
		JSFUtil.messagemSucesso(passageiro.getNome() + " salvo com Sucesso"); 
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
    
}
