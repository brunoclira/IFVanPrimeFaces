package br.edu.ifpb.domain;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Passageiro {
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String sexo;
	private String telefone;
	private String cidade;
	private String estado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
    
}
