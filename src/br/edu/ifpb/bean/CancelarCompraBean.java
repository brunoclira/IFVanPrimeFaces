package br.edu.ifpb.bean;


import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.DAO.CadeiraVanDAO;
import br.edu.ifpb.domain.Van;
import br.edu.ifpb.util.JSFUtil;
@ManagedBean
public class CancelarCompraBean {
		private List<Van> lugares;
		private Van van;
		private String cpfRemover;

		public String getCpfRemover() {
			return cpfRemover;
		}

		public void setCpfRemover(String cpfRemover) {
			this.cpfRemover = cpfRemover;
		}
		
		public List<Van> getLugares() {
	
			Van van = new Van();
			CadeiraVanDAO vanDao = new CadeiraVanDAO();

			try {
				lugares = (ArrayList<Van>) vanDao.getLugares();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return lugares;
		}

		public void setLugares(List<Van> lugares) {
			this.lugares = lugares;
		}
		public CancelarCompraBean(){
			this.van=new Van();
		}

		public Van getVan() {
			return van;
		}

		public void setVan(Van van) {
			this.van = van;
		}

public void cancelar(){
	CadeiraVanDAO vanDao=new CadeiraVanDAO();
	try {
		vanDao.cancelarPassagem(this.cpfRemover);
		JSFUtil.messagemSucesso(van.getCpf() + " Passagem Cancelada");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



}


