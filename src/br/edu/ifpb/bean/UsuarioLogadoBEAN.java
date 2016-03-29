/*package br.edu.ifpb.bean;

import java.io.Serializable;
import java.security.Security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.util.SessionUtil;

@ManagedBean(name = "UsuarioLogadoBEAN")
@SessionScoped
public class UsuarioLogadoBEAN implements Serializable {

	private Usuario usuario;
	private String nome;

	public String getNome() {
		Usuario usu = new Usuario();

		usu = (Usuario) SessionUtil.getParam("usuario");
		nome = usu.getUsername();

		System.out.println("nome " + nome);
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private static final long serialVersionUID = 1L;

	public UsuarioLogadoBEAN() {
		usuario = new Usuario();
	}
}*/
