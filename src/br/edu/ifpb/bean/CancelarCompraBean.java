package br.edu.ifpb.bean;


import javax.faces.bean.ManagedBean;

import br.edu.ifpb.DAO.CadeiraVanDAO;
import br.edu.ifpb.domain.Passageiro;

@ManagedBean(name = "CancelarCompraBean")
public class CancelarCompraBean {

	private CadeiraVanDAO cadeira = new CadeiraVanDAO();
	private Passageiro pessoa = new Passageiro();

	public CadeiraVanDAO getCadeira() {
		return cadeira;
	}

	public void setCadeira(CadeiraVanDAO cadeira) {
		this.cadeira = cadeira;
	}

	public Passageiro getPessoa() {
		return pessoa;
	}

	public void setPessoa(Passageiro pessoa) {
		this.pessoa = pessoa;
	}

	
	public void cancelarCompra() {

		if (cadeira != null) {

			try {
				cadeira.cancelarPassagem(pessoa.getCpf());
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}

	}

}
