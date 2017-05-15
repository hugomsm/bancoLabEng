package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ContaDAO;
import dao.LoginDAO;
import entity.Conta;

@RequestScoped
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

		if (LoginDAO.validar(conta.getContaUsuario().getAgencia(), conta.getContaUsuario().getConta(),
				conta.getSenha())) {
			pagina = "conta?faces-redirect=true";
			conta = LoginDAO.getConta(conta.getContaUsuario());
		}

		return pagina;

	}
	
	public String salvar(){
		ContaDAO.adicionar(conta);
		return "login";
	}

}
