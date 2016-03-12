package br.edu.ifpb.bean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import br.edu.ifpb.domain.Passageiro;

public class ComprarPassagemBEAN {
	
	private Van van = new Van();

	private Map<String,String> poltronas,tipo_passagens;

    @PostConstruct
    public void init() {
        poltronas  = new HashMap<String, String>();
        poltronas.put("Cadeira 1", "Cadeira 1");
        poltronas.put("Cadeira 2", "Cadeira 2");
        poltronas.put("Cadeira 3", "Cadeira 3");
        poltronas.put("Cadeira 4", "Cadeira 4");
        poltronas.put("Cadeira 5", "Cadeira 5");
        poltronas.put("Cadeira 6", "Cadeira 6");
        poltronas.put("Cadeira 7", "Cadeira 7");
        poltronas.put("Cadeira 8", "Cadeira 8");
        poltronas.put("Cadeira 9", "Cadeira 9");
        poltronas.put("Cadeira 10", "Cadeira 10");
        
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
    
    public Map<String, String> getSexos() {
        return sexos;
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

}
