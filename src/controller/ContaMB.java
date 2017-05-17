package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import dao.ContaDAO;
import dao.LoginDAO;
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
		conta = LoginDAO.validar(conta.getContaUsuario().getAgencia(), conta.getContaUsuario().getConta(),
				conta.getSenha());
		if (conta != null) {
			pagina = "conta?faces-redirect=true";
		} else {
			pagina = "login";
		}

		return pagina;

	}
	
	public String salvar(){
		ContaDAO.adicionar(conta);
		return "login";
	}
	
	public String sair(){
		conta = null;
		return "login";
		
	}

}
