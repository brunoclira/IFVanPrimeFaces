package br.edu.ifpb.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.DAO.UsuarioDAO;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.util.JSFUtil;

@ManagedBean(name = "CadastrarUsuarioBEAN")
@RequestScoped

public class CadastrarUsuarioBEAN {
	private Usuario usuario;

	public CadastrarUsuarioBEAN() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void cadastrar() throws IOException {
		UsuarioDAO usuarioDao = new UsuarioDAO();

		try {
			usuarioDao.cadastrarUsuario(usuario);
			JSFUtil.messagemSucesso(usuario.getNome() + " Cadastrado com Sucesso");
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (ClassNotFoundException e) {

		}

	}

}