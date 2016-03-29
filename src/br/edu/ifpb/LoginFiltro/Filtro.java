/*package br.edu.ifpb.LoginFiltro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtro
 */
/*@WebFilter("/*")
public class Filtro implements Filter {

	/**
	 * Default constructor.
	 */
	/*public Filtro() {

	}

	/**
	 * @see Filter#destroy()
	 */
	/*public void destroy() {

	}

	/**
	 * @throws ServletException
	 * @throws IOException
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/*public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		HttpSession sessao = rq.getSession();
		String reqURI = rq.getRequestURI();

		if (reqURI.equalsIgnoreCase("/bookmooch/") || sessao.getAttribute("usuario") != null
				|| (rq.getRequestURI().endsWith("index.xhtml"))) {
			System.out.println("fluxo");
			chain.doFilter(request, response);

		} else {
			String redirect = rq.getContextPath() + "/";
			rp.sendRedirect(redirect);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	/*public void init(FilterConfig fConfig) throws ServletException {

	}

}*/