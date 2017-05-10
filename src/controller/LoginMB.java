package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.LoginDAO;
import entity.Login;

@SessionScoped
@ManagedBean
public class LoginMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7719188177432584423L;
	
	private Login login = new Login();

	/**
	 * @return the login
	 */
	public Login getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String validarLogin(){
		boolean validado = LoginDAO.validar(login.getAgencia(), login.getConta(), login.getSenha());
		if (validado){
			return "conta";
		} else {
			return "erro";
		}
	}

	
}
