package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UsuarioDAO;
import entity.Usuario;

@RequestScoped
@ManagedBean
public class UsuarioMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 455655596091613948L;

	private Usuario novoUsuario = new Usuario();

	/**
	 * @return the novoUsuario
	 */
	public Usuario getNovoUsuario() {
		return novoUsuario;
	}

	/**
	 * @param novoUsuario
	 *            the novoUsuario to set
	 */
	public void setNovoUsuario(Usuario novoUsuario) {
		this.novoUsuario = novoUsuario;
	}

	public String salvar(){
		UsuarioDAO.adicionar(novoUsuario);
		return "login";
	}

}
