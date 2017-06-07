package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import dao.ContaDAO;
import entity.Conta;

@SessionScoped
@ManagedBean
public class ContaMB {

	private Conta conta = new Conta();

	/**
	 * @return the conta
	 */
	public Conta getConta() {
		return conta;
	}

	/**
	 * @param conta
	 *            the conta to set
	 */
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String logar() {
		String pagina = "login";
		conta = ContaDAO.validar(conta.getContaUsuario().getAgencia(), conta.getContaUsuario().getConta(),
				conta.getSenha());
		if (conta != null) {
			pagina = "conta?faces-redirect=true";
		} else {
			conta = new Conta();
			pagina = "login";
		}

		return pagina;

	}
	
	public String salvar(){
		ContaDAO.adicionar(conta);
		return "login";
	}
	
	public String atualizar(){
		ContaDAO.atualizar(conta);
		
		return "conta";
	}
	
	public void sair() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}

}
