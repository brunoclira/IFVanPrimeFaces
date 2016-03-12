package br.edu.ifpb.bean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import br.edu.ifpb.DAO.ComprarPassagemDAO;
import br.edu.ifpb.domain.Van;
import br.edu.ifpb.util.JSFUtil;

@ManagedBean(name = "ComprarPassagemBEAN")
public class ComprarPassagemBEAN {
	
	private Van van = new Van();

	private Map<String,String> poltronas,tipo_passagens;
	
    @PostConstruct
    public void init() {
    	
        poltronas  = new HashMap<String, String>();
        poltronas.put("Cadeira 1", "1");
        poltronas.put("Cadeira 2", "2");
        poltronas.put("Cadeira 3", "3");
        poltronas.put("Cadeira 4", "4");
        poltronas.put("Cadeira 5", "5");
        poltronas.put("Cadeira 6", "6");
        poltronas.put("Cadeira 7", "7");
        poltronas.put("Cadeira 8", "8");
        poltronas.put("Cadeira 9", "9");
        poltronas.put("Cadeira 10", "10");
        
        tipo_passagens = new HashMap<String, String>();
        tipo_passagens.put("Estudante", "Estudante");
        tipo_passagens.put("Idoso", "Idoso");
        tipo_passagens.put("Inteira", "Inteira");
    }
    
    public Van getVan() {
		return van;
	}
    
    public void setVan(Van van) {
		this.van = van;
	}
    
    public Map<String, String> getPoltronas() {
		return poltronas;
	}
    
    public void setPoltronas(Map<String, String> poltronas) {
		this.poltronas = poltronas;
	}
    
    public Map<String, String> getTipo_passagens() {
		return tipo_passagens;
	}
    
    public void setTipo_passagens(Map<String, String> tipo_passagens) {
		this.tipo_passagens = tipo_passagens;
	}
    
    public void save() {
    	try {
    		ComprarPassagemDAO dao = new ComprarPassagemDAO();
			dao.salvar(van);
			
			JSFUtil.messagemSucesso(van.getCpf() + " comprado com Sucesso");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
			JSFUtil.messagemError(e.getMessage());
		} 
    }
    
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }

}