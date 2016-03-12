package br.edu.ifpb.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.edu.ifpb.DAO.CadastrarPassageiroDAO;

import java.util.HashMap;
import java.util.Map;
 
 
@ManagedBean(name = "CadastrarPassageiroBEAN")
public class CadastrarPassageiroBEAN {
     
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String firstname;
    private String lastname;
    private String cpf;
    private String telefone;
	private String sexo;
    private String cidade;
    private String estado;

	private Map<String,String> sexos,estados;
    
    @PostConstruct
    public void init() {
        sexos  = new HashMap<String, String>();
        sexos.put("Feminino", "Feminino");
        sexos.put("Masculino", "Masculino");
        
        estados = new HashMap<String, String>();
        estados.put("Acre - AC", "Acre - AC");
        estados.put("Alagoas - AL", "Alagoas - AL");
        estados.put("Amapá - AP", "Amapá - AP");
        estados.put("Amazonas - AM", "Amazonas - AM");
        estados.put("Bahia - BA", "Bahia - BA");
        estados.put("Ceará - CE", "Ceará - CE");
        estados.put("Distrito Federal - DF", "Distrito Federal - DF");
        estados.put("Espírito Santo - ES", "Espírito Santo - ES");
        estados.put("Goiás - GO", "Goiás - GO");
        estados.put("Maranhão - MA", "Maranhão - MA");
        estados.put("Mato Grosso - MT", "Mato Grosso - MT");
        estados.put("Mato Grosso do Sul - MS", "Mato Grosso do Sul - MS");
        estados.put("Minas Gerais - MG", "Minas Gerais - MG");
        estados.put("Pará - PA", "Pará - PA");
        estados.put("Paraíba - PB", "Paraíba - PB");
        estados.put("Paraná - PR", "Paraná - PR");
        estados.put("Pernambuco - PE", "Pernambuco - PE");
        estados.put("Piauí - PI", "Piauí - PI");
        estados.put("Rio de Janeiro - RJ", "Rio de Janeiro - RJ");
        estados.put("Rio Grande do Norte - RN", "Rio Grande do Norte - RN");
        estados.put("Rio Grande do Sul - RS", "Rio Grande do Sul - RS");
        estados.put("Rondônia - RO", "Rondônia - RO");
        estados.put("Roraima - RR", "Roraima - RR");
        estados.put("Santa Catarina - SC", "Santa Catarina - SC");
        estados.put("São Paulo - SP", "São Paulo - SP");
        estados.put("Sergipe - SE", "Sergipe - SE");
        estados.put("Tocantins - TO", "Tocantins - TO");
    }
    
    public Map<String, String> getSexos() {
        return sexos;
    }
    
    public Map<String, String> getEstados() {
        return sexos;
    }
    
    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
    public String getEstado() {
  		return estado;
  	}

  	public void setEstado(String estado) {
  		this.estado = estado;
  	}
    
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
    
    public void displayLocation() {
        FacesMessage msg;
        
        if(sexo != null)
            msg = new FacesMessage("Selected" + sexo);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Sexo is not selected.");
        
        if(estado != null)
            msg = new FacesMessage("Selected" + estado);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Estado is not selected.");
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
 
    public void save() {
        ///FacesContext.getCurrentInstance().addMessage(null,
                //new FacesMessage("Welcome " + firstname + " " + lastname));
    }
    
}
