package br.edu.ifpb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	
	public static void messagemSucesso(String menssagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, menssagem, menssagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
	public static void messagemError(String menssagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, menssagem, menssagem);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}

}
