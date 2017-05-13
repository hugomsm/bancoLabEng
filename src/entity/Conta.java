package entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Conta {

	private DadosConta contaUsuario = new DadosConta();
	private String senha;
	private String tipoConta;
	private double saldo;
	private Usuario usuario;

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the tipoConta
	 */
	public String getTipoConta() {
		return tipoConta;
	}

	/**
	 * @param tipoConta
	 *            the tipoConta to set
	 */
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo
	 *            the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the contaUsuario
	 */
	@EmbeddedId
	public DadosConta getContaUsuario() {
		return contaUsuario;
	}

	/**
	 * @param contaUsuario
	 *            the contaUsuario to set
	 */
	public void setContaUsuario(DadosConta contaUsuario) {
		this.contaUsuario = contaUsuario;
	}

	/**
	 * @return the usuario
	 */
	@OneToOne(cascade = CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}