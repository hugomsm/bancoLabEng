package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private List<Conta> contas = new ArrayList<Conta>();

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
	
	public void remover() throws IOException{
		ContaDAO.remover(conta);
		conta = new Conta();
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}
	
	public void sair() throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}
	
	public void buscaDev(){
		contas = ContaDAO.buscaDev();
	}

	/**
	 * @return the contas
	 */
	public List<Conta> getContas() {
		return contas;
	}

	/**
	 * @param contas the contas to set
	 */
	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

}
