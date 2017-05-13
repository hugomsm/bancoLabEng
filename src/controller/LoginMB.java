package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.LoginDAO;
import entity.Usuario;

@SessionScoped
@ManagedBean
public class LoginMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7719188177432584423L;

	private Usuario usuarioAtual = new Usuario();

	/**
	 * @return the usuarioAtual
	 */
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}

	/**
	 * @param usuarioAtual
	 *            the usuarioAtual to set
	 */
	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

 
	public String sair() {
		usuarioAtual = null;
		return "login?faces-redirect=true";
	}

}
