package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import dao.ContaDAO;
import entity.Conta;

@RequestScoped
@ManagedBean
public class EsqueciMB {

	private Conta conta;

	public EsqueciMB(){
		conta = new Conta();
		conta.getContaUsuario().setAgencia("");
		conta.getContaUsuario().setConta("");
	}
	
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

	public void procurar() {
		Conta achada= ContaDAO.procurarSenha(conta.getContaUsuario().getAgencia(), conta.getContaUsuario().getConta(),
				conta.getUsuario().getCpf(), conta.getUsuario().getRg(), conta.getUsuario().getTelefone());
		if (achada != null) {
			conta.setSenha(achada.getSenha());
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Conta não existe", "A conta informada não existe!");
			throw new ValidatorException(mensagem);
		}
	}

}
