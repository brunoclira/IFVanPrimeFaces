package br.edu.ifpb.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.omg.CORBA.Request;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.manegedBean.PathRedirect;
import br.edu.ifpb.DAO.UsuarioDAO;

import br.edu.ifpb.util.CookieHelper;
import br.edu.ifpb.util.SessionUtil;

@ManagedBean(name = "LoginBEAN")
@RequestScoped

public class LoginBEAN {
	private Usuario usuario;

	public LoginBEAN() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String login() {

		UsuarioDAO usuDao = new UsuarioDAO();

		try {
			if (usuDao.validarUsuario(usuario)) {
				SessionUtil.setParam("usuario", usuario);
				//System.out.println("cadastrado");
				return "/pages/index.xhtml?faces-redirect=true";
			} else {
				return "../login.xhtml?faces-redirect=true";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "../login.xhtml?faces-redirect=true";
		}

	}

	public void sair() {
		String sendRedirect = PathRedirect.index + "?faces-redirect=true&includeViewParams=true";
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();

		try {

			request.logout();

			// Finalizando sessão para o usuário logado.
			GenericBEAN.invalidateSession();

			CookieHelper cookieHelper = new CookieHelper();
			cookieHelper.eraseCookie();

		} catch (ServletException e) {

		} finally {
			// Redirecionar para a página de login.
			SessionUtil.sendRedirect(sendRedirect);
		}
	}

}