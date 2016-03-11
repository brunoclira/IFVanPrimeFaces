package br.edu.ifpb.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.HashMap;
import java.util.Map;
 
 
@ManagedBean(name = "CadastrarPassageiroBEAN")
public class CadastrarPassageiroBEAN {
     
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String firstname;
    private String lastname;
    private String cpf;
    private String sexo;
    private Map<String,String> sexos;
    
    @PostConstruct
    public void init() {
        sexos  = new HashMap<String, String>();
        sexos.put("Feminino", "Feminino");
        sexos.put("Masculino", "Masculino");
    }
    
    public Map<String, String> getSexos() {
        return sexos;
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
    
    public void displayLocation() {
        FacesMessage msg;
        if(sexo != null)
            msg = new FacesMessage("Selected" + sexo);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Sexo is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
 
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + firstname + " " + lastname));
    }
    
}
